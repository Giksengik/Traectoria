package com.giksengik.vkservices.presentation.serviceslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giksengik.vkservices.domain.VkServicesRepository
import com.giksengik.vkservices.utils.runCatchingNonCancellation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @author e.a.vlasov
 */
class ServicesListViewModel(
    private val servicesRepository: VkServicesRepository,
) : ViewModel() {

    init {
        loadServices()
    }

    private val _servicesListFlow: MutableStateFlow<ServicesListState> =
        MutableStateFlow(ServicesListState.Loading)

    val servicesListFlow: StateFlow<ServicesListState> = _servicesListFlow.asStateFlow()

    fun loadServices(isReload: Boolean = false) {
        viewModelScope.launch {
            if (isReload) _servicesListFlow.emit(ServicesListState.Loading)
            val services = runCatchingNonCancellation {
                servicesRepository.getVkServices()
            }.onFailure {
                _servicesListFlow.emit(ServicesListState.Error(it))
            }.getOrNull()

            services?.let {
                _servicesListFlow.emit(
                    ServicesListState.Content(
                        ServicesUiItemsFactory.create(
                            services
                        )
                    )
                )
            }
        }
    }
}

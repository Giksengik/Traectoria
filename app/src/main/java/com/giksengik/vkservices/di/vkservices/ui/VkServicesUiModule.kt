package com.giksengik.vkservices.di.vkservices.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.giksengik.vkservices.presentation.serviceslist.ServicesListViewModel

/**
 * @author e.a.vlasov
 */
interface VkServicesUiModule {

    fun viewModelProviderFactory(): ViewModelProvider.Factory

    class Impl(private val dependencies: VkServicesUiDependencies = VkServicesUiDependencies.Impl) :
        VkServicesUiModule {

        override fun viewModelProviderFactory(): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                ServicesListViewModel(dependencies.repository())
            }
        }
    }

}

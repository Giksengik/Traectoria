package com.giksengik.vkservices.di.vkservices.ui

import androidx.lifecycle.ViewModelProvider
import com.giksengik.vkservices.di.common.DiComponent
import com.giksengik.vkservices.di.common.FeatureComponentHolder

/**
 * @author e.a.vlasov
 */
interface VkServicesUiComponent : DiComponent {

    fun viewModelProviderFactory(): ViewModelProvider.Factory
}

class VkServicesUiComponentImpl(
    module: VkServicesUiModule = VkServicesUiModule.Impl()
) : VkServicesUiComponent, VkServicesUiModule by module

object VkServicesUiComponentHolder : FeatureComponentHolder<VkServicesUiComponent>() {

    override fun build(): VkServicesUiComponent = VkServicesUiComponentImpl()
}

package com.giksengik.vkservices.di.vkservices.domain

import com.giksengik.vkservices.di.common.DiComponent
import com.giksengik.vkservices.di.common.FeatureComponentHolder
import com.giksengik.vkservices.domain.VkServicesRepository

/**
 * @author e.a.vlasov
 */
interface VkServicesDomainComponent : DiComponent {

    fun vkServicesRepository(): VkServicesRepository
}

private class VkServicesDomainComponentImpl(
    module: VkServicesDomainModule = VkServicesDomainModule.Impl(),
) : VkServicesDomainComponent, VkServicesDomainModule by module

object VkServicesDomainComponentHolder : FeatureComponentHolder<VkServicesDomainComponent>() {

    override fun build(): VkServicesDomainComponent = VkServicesDomainComponentImpl()
}

package com.giksengik.vkservices.di.vkservices.domain

import com.giksengik.vkservices.data.VkServicesRepositoryImpl
import com.giksengik.vkservices.domain.VkServicesRepository

/**
 * @author e.a.vlasov
 */
interface VkServicesDomainModule {

    fun vkServicesRepository(): VkServicesRepository

    class Impl(
        private val dependencies: VkServicesDomainDependencies = VkServicesDomainDependencies.Impl
    ) : VkServicesDomainModule {
        override fun vkServicesRepository(): VkServicesRepository =
            VkServicesRepositoryImpl(
                service = dependencies.service(),
                apiToDomainMapper = dependencies.vkServicesApiToDomainMapper(),
            )
    }
}

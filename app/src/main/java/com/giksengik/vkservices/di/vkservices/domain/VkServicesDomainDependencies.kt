package com.giksengik.vkservices.di.vkservices.domain

import com.giksengik.vkservices.data.VkServicesApiToDomainMapper
import com.giksengik.vkservices.data.api.Service
import com.giksengik.vkservices.di.api.ApiComponentHolder

/**
 * @author e.a.vlasov
 */
interface VkServicesDomainDependencies {

    fun service(): Service

    fun vkServicesApiToDomainMapper(): VkServicesApiToDomainMapper

    object Impl : VkServicesDomainDependencies {
        override fun service(): Service = ApiComponentHolder.get().service

        override fun vkServicesApiToDomainMapper(): VkServicesApiToDomainMapper =
            VkServicesApiToDomainMapper()
    }
}

package com.giksengik.vkservices.di.vkservices.ui

import com.giksengik.vkservices.di.vkservices.domain.VkServicesDomainComponentHolder
import com.giksengik.vkservices.domain.VkServicesRepository

/**
 * @author e.a.vlasov
 */
interface VkServicesUiDependencies {

    fun repository(): VkServicesRepository

    object Impl : VkServicesUiDependencies {
        override fun repository(): VkServicesRepository =
            VkServicesDomainComponentHolder.get().vkServicesRepository()
    }
}

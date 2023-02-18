package com.giksengik.vkservices.domain

import com.giksengik.vkservices.domain.entity.VkServiceInformation

/**
 * @author e.a.vlasov
 */
interface VkServicesRepository {

    // Не стал делать use case ради проксирования этого метода, думаю тестирвоанию не помешает
    suspend fun getVkServices(): List<VkServiceInformation>
}

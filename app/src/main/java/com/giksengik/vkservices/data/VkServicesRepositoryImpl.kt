package com.giksengik.vkservices.data

import com.giksengik.vkservices.data.api.Service
import com.giksengik.vkservices.domain.VkServicesRepository
import com.giksengik.vkservices.domain.entity.VkServiceInformation

/**
 * @author e.a.vlasov
 */
class VkServicesRepositoryImpl(
    private val service: Service,
    private val apiToDomainMapper: VkServicesApiToDomainMapper,
) : VkServicesRepository {

    override suspend fun getVkServices(): List<VkServiceInformation> {
        val servicesApi = service.getVkServices()

        return apiToDomainMapper(servicesApi)
    }
}

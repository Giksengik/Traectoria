package com.giksengik.vkservices.data

import com.giksengik.vkservices.data.api.VkServicesApi
import com.giksengik.vkservices.domain.entity.VkServiceInformation

/**
 * @author e.a.vlasov
 */
class VkServicesApiToDomainMapper {

    operator fun invoke(api: VkServicesApi): List<VkServiceInformation> {
        return api.services.map { service ->
            VkServiceInformation(
                name = service.name,
                description = service.description,
                iconUrl = service.iconUrl,
                serviceUrl = service.serviceUrl
            )
        }
    }
}

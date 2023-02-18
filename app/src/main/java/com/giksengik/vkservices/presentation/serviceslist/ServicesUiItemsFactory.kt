package com.giksengik.vkservices.presentation.serviceslist

import com.giksengik.vkservices.domain.entity.VkServiceInformation

/**
 * @author e.a.vlasov
 */
object ServicesUiItemsFactory {

    fun create(domain: List<VkServiceInformation>): List<ServiceInformationUI> = domain.map {
        ServiceInformationUI(
            name = it.name,
            description = it.description,
            iconUrl = it.iconUrl,
            serviceUrl = it.serviceUrl,
        )
    }
}

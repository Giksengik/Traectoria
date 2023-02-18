package com.giksengik.vkservices.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author e.a.vlasov
 */
@Serializable
class VkServicesApi(
    @SerialName("items")
    val services: List<ServiceInformationApi>
)

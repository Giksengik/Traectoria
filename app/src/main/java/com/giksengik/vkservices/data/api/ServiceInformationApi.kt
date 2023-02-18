package com.giksengik.vkservices.data.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author e.a.vlasov
 */
@Serializable
class ServiceInformationApi(
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("icon_url")
    val iconUrl: String,
    @SerialName("service_url")
    val serviceUrl: String,
)

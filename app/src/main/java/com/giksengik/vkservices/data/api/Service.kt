package com.giksengik.vkservices.data.api

import retrofit2.http.GET

/**
 * @author e.a.vlasov
 */
interface Service {

    @GET("semi-final-data.json")
    suspend fun getVkServices(): VkServicesApi
}

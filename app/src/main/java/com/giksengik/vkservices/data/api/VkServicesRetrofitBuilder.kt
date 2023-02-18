package com.giksengik.vkservices.data.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * @author e.a.vlasov
 */
object VkServicesRetrofitBuilder {

    private const val BASE_URL = "https://mobile-olympiad-trajectory.hb.bizmrg.com/"
    private const val JSON_MIME_TYPE = "application/json"

    @OptIn(kotlinx.serialization.ExperimentalSerializationApi::class)
    fun create(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                VkServicesJsonProvider.provide().asConverterFactory(JSON_MIME_TYPE.toMediaType())
            )
            .build()
    }
}

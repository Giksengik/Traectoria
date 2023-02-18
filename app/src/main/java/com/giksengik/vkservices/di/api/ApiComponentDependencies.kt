package com.giksengik.vkservices.di.api

import com.giksengik.vkservices.data.api.VkServicesRetrofitBuilder
import retrofit2.Retrofit

/**
 * @author e.a.vlasov
 */
interface ApiComponentDependencies {

    val retrofit: Retrofit

    object Impl : ApiComponentDependencies {
        override val retrofit: Retrofit = VkServicesRetrofitBuilder.create()
    }
}

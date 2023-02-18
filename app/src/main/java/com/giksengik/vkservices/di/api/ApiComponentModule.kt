package com.giksengik.vkservices.di.api

import com.giksengik.vkservices.data.api.Service

/**
 * @author e.a.vlasov
 */
interface ApiComponentModule {

    val service: Service

    class Impl(deps: ApiComponentDependencies = ApiComponentDependencies.Impl) :
        ApiComponentModule {
        override val service: Service = deps.retrofit.create(Service::class.java)
    }
}

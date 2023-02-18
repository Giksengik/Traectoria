package com.giksengik.vkservices.di.api

import com.giksengik.vkservices.di.common.DataComponentHolder

/**
 * @author e.a.vlasov
 */
private class ApiComponentImpl(
    module: ApiComponentModule = ApiComponentModule.Impl()
) : ApiComponent,
    ApiComponentModule by module

object ApiComponentHolder : DataComponentHolder<ApiComponent>() {
    override fun build(): ApiComponent = ApiComponentImpl()
}

package com.giksengik.vkservices.di.api

import com.giksengik.vkservices.data.api.Service
import com.giksengik.vkservices.di.common.DiComponent

/**
 * @author e.a.vlasov
 */
interface ApiComponent: DiComponent {

    val service: Service
}

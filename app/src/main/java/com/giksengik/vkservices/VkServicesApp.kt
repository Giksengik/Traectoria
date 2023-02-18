package com.giksengik.vkservices

import android.app.Application
import com.giksengik.vkservices.di.app.ApplicationComponentHolder
import com.giksengik.vkservices.di.app.ApplicationComponentImpl

/**
 * @author e.a.vlasov
 */
class VkServicesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationComponentHolder.set(ApplicationComponentImpl(this))
    }
}

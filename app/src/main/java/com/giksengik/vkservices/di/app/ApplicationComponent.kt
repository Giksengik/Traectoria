package com.giksengik.vkservices.di.app

import android.content.Context
import com.giksengik.vkservices.di.common.DiComponent
import com.giksengik.vkservices.di.common.LazyComponentHolder

/**
 * @author e.a.vlasov
 */
interface ApplicationComponent : DiComponent {

    val context: Context
}

class ApplicationComponentImpl(override val context: Context) : ApplicationComponent

object ApplicationComponentHolder: LazyComponentHolder<ApplicationComponent>()

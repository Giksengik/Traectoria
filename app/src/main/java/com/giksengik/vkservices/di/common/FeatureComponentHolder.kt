package com.giksengik.vkservices.di.common

import java.lang.ref.WeakReference

/**
 * @author e.a.vlasov
 */
abstract class FeatureComponentHolder<T : DiComponent> : ComponentHolder<T> {

    @Volatile
    private var component: WeakReference<T>? = null

    override fun get(): T {
        return component?.get() ?: synchronized(this) {
            component?.get() ?: build().also(::set)
        }
    }

    override fun set(component: T) {
        this.component = WeakReference(component)
    }

    protected abstract fun build(): T
}

package com.giksengik.vkservices.di.common

/**
 * @author e.a.vlasov
 */
abstract class LazyComponentHolder<T : DiComponent> : ComponentHolder<T> {

    @Volatile
    private var component: T? = null

    override fun get(): T {
        return component ?: error("Component not provided")
    }

    override fun set(component: T) {
        this.component = component
    }
}

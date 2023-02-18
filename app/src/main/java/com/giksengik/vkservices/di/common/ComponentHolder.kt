package com.giksengik.vkservices.di.common

/**
 * @author e.a.vlasov
 */
interface ComponentHolder<T : DiComponent> {

    fun get(): T

    fun set(component: T)
}

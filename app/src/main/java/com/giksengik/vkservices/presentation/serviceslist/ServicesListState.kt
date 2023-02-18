package com.giksengik.vkservices.presentation.serviceslist

/**
 * @author e.a.vlasov
 */
sealed class ServicesListState {

    object Loading : ServicesListState()

    class Error(val error: Throwable) : ServicesListState()

    class Content(val items: List<ServiceInformationUI>) : ServicesListState()
}

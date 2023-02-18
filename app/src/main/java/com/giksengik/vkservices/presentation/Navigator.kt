package com.giksengik.vkservices.presentation

import com.giksengik.vkservices.presentation.serviceslist.ServiceInformationUI

/**
 * @author e.a.vlasov
 */
interface Navigator {

    fun navigateToServiceDetails(serviceInformationUI: ServiceInformationUI)
}

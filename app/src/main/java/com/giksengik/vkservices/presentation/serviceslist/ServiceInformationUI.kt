package com.giksengik.vkservices.presentation.serviceslist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author e.a.vlasov
 */
@Parcelize
data class ServiceInformationUI(
    val name: String,
    val description: String,
    val iconUrl: String,
    val serviceUrl: String,
) : Parcelable


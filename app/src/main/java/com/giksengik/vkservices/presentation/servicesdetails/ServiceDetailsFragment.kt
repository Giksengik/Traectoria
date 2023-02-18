package com.giksengik.vkservices.presentation.servicesdetails

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.giksengik.vkservices.R
import com.giksengik.vkservices.databinding.FragmentServiceDetailsBinding
import com.giksengik.vkservices.presentation.ToolbarHolder
import com.giksengik.vkservices.presentation.ToolbarState
import com.giksengik.vkservices.presentation.serviceslist.ServiceInformationUI

/**
 * @author e.a.vlasov
 */
class ServiceDetailsFragment : Fragment() {

    private lateinit var binding: FragmentServiceDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServiceDetailsBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val serviceInfo = requireArguments().getParcelable<ServiceInformationUI>(KEY_SERVICE)!!
        (activity as? ToolbarHolder)?.setToolbarState(
            ToolbarState(
                text = serviceInfo.name,
                backButtonEnable = true,
            )
        )
        binding.apply {
            serviceName.text = serviceInfo.name
            serviceDescription.text = serviceInfo.description
            serviceLink.text = serviceInfo.serviceUrl
            serviceLink.movementMethod = LinkMovementMethod.getInstance()
            Glide.with(serviceIcon)
                .load(serviceInfo.iconUrl)
                .into(serviceIcon)
        }
    }

    companion object {
        private const val KEY_SERVICE = "ServiceDetailsFragment"

        fun newInstance(serviceInformation: ServiceInformationUI): ServiceDetailsFragment {
            val args = Bundle()
            args.putParcelable(KEY_SERVICE, serviceInformation)
            val fragment = ServiceDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}

package com.giksengik.vkservices.presentation.serviceslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.giksengik.vkservices.R
import com.giksengik.vkservices.databinding.FragmentServicesListBinding
import com.giksengik.vkservices.di.vkservices.ui.VkServicesUiComponentHolder
import com.giksengik.vkservices.presentation.Navigator
import com.giksengik.vkservices.presentation.ToolbarHolder
import com.giksengik.vkservices.presentation.ToolbarState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * @author e.a.vlasov
 */
class ServicesListFragment : Fragment() {

    private lateinit var binding: FragmentServicesListBinding

    private val viewModel: ServicesListViewModel by viewModels {
        VkServicesUiComponentHolder.get().viewModelProviderFactory()
    }

    private val listAdapter: ServicesListAdapter by lazy {
        ServicesListAdapter(::onServiceItemClick)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServicesListBinding.inflate(layoutInflater)

        binding.servicesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }

        binding.error.reloadButton.setOnClickListener {
            viewModel.loadServices(isReload = true)
        }

        (activity as? ToolbarHolder)?.setToolbarState(
            ToolbarState(getString(R.string.app_name))
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.servicesListFlow
            .onEach(::render)
            .launchIn(lifecycleScope)
    }

    private fun render(state: ServicesListState) = when (state) {
        is ServicesListState.Loading -> {
            binding.progressBar.isVisible = true
            binding.error.root.isVisible = false
        }
        is ServicesListState.Content -> {
            binding.progressBar.isVisible = false
            binding.error.root.isVisible = false
            listAdapter.submitList(state.items)
        }
        is ServicesListState.Error -> {
            binding.progressBar.isVisible = false
            binding.error.errorRoot.isVisible = true
        }
    }

    private fun onServiceItemClick(item: ServiceInformationUI) {
        (activity as? Navigator)?.navigateToServiceDetails(item)
    }

    companion object {
        const val TAG = "ServicesListFragment"

        fun newInstance(): ServicesListFragment {
            return ServicesListFragment()
        }
    }
}

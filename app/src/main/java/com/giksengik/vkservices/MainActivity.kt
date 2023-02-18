package com.giksengik.vkservices

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.giksengik.vkservices.databinding.ActivityMainBinding
import com.giksengik.vkservices.presentation.Navigator
import com.giksengik.vkservices.presentation.ToolbarHolder
import com.giksengik.vkservices.presentation.ToolbarState
import com.giksengik.vkservices.presentation.servicesdetails.ServiceDetailsFragment
import com.giksengik.vkservices.presentation.serviceslist.ServiceInformationUI
import com.giksengik.vkservices.presentation.serviceslist.ServicesListFragment

/**
 * @author e.a.vlasov
 */
class MainActivity : AppCompatActivity(), Navigator, ToolbarHolder {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.mainContainer,
                    ServicesListFragment.newInstance(),
                    ServicesListFragment.TAG
                ).commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun navigateToServiceDetails(serviceInformationUI: ServiceInformationUI) {
        supportFragmentManager.commit {
            setCustomAnimations(
                androidx.appcompat.R.anim.abc_slide_in_top,
                androidx.appcompat.R.anim.abc_fade_out,
                androidx.appcompat.R.anim.abc_slide_in_top,
                androidx.appcompat.R.anim.abc_fade_out,
            )
            replace(
                R.id.mainContainer,
                ServiceDetailsFragment.newInstance(serviceInformationUI)
            )
            addToBackStack(null)
        }
    }

    override fun setToolbarState(toolbarState: ToolbarState) {
        supportActionBar?.apply {
            title = toolbarState.text
            setDisplayHomeAsUpEnabled(toolbarState.backButtonEnable)
        }
    }
}

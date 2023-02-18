package com.giksengik.vkservices.presentation.serviceslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.giksengik.vkservices.domain.VkServicesRepository
import com.giksengik.vkservices.domain.entity.VkServiceInformation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * @author e.a.vlasov
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class ServicesListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        val testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun testContentStateWhenRepoReturnsServices() {
        val repository = mockRepository {
            listOf(VkServiceInformation("", "", "", ""))
        }
        val viewModel = ServicesListViewModel(repository)

        viewModel.loadServices()

        assert(viewModel.servicesListFlow.value is ServicesListState.Content)
    }

    @Test
    fun testErrorStateWhenErrorOccured() {
        val repository = mockRepository {
            error("error!")
        }
        val viewModel = ServicesListViewModel(repository)

        viewModel.loadServices()

        assert(viewModel.servicesListFlow.value is ServicesListState.Error)
    }


    private fun mockRepository(services: () -> List<VkServiceInformation>): VkServicesRepository =
        object : VkServicesRepository {
            override suspend fun getVkServices(): List<VkServiceInformation> = services()
        }
}

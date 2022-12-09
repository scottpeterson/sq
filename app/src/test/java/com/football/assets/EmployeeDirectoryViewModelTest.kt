package com.football.assets

import com.football.assets.dataLayer.api.DataSourceError
import com.football.assets.dataLayer.api.Employee
import com.football.assets.main.EmployeeDirectoryViewModel
import com.football.assets.main.SquareState
import com.football.assets.repository.Repository
import com.squareup.moshi.JsonDataException
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Feel free to make modifications to these unit tests! Remember, you have full technical control
 * over the project, so you can use any libraries and testing strategies that see fit.
 */
class EmployeeDirectoryViewModelTest {
    private lateinit var mockRepository: Repository
    private lateinit var employeeDirectoryViewModel: EmployeeDirectoryViewModel

    @Before
    fun setup() {
        mockRepository = mockk()
        employeeDirectoryViewModel = EmployeeDirectoryViewModel(mockRepository)
    }

    @ExperimentalCoroutinesApi
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @ExperimentalCoroutinesApi
    @Test
    fun testLoadEmployeesSuccess() = runTest {
        val mockEmployeesList = listOf(
            Employee(
                biography = "a",
                fullName = "b",
                phoneNumber = "1112223333",
                photoUrlSmall = "d",
                emailAddress = "e",
                employeeType = "FULL_TIME",
                team = "f",
                uuid = "asfjlkalfjskd"
            )
        )

        coEvery { mockRepository.getEmployees() } returns mockEmployeesList

        employeeDirectoryViewModel.loadEmployees()

        // We don't want to capture the initial state value, we want to wait until the state stream is idle
        advanceUntilIdle()

        Assert.assertEquals(employeeDirectoryViewModel.state.value, SquareState.Loaded)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testLoadEmployeesFailure() = runTest {
        coEvery { mockRepository.getEmployees() } throws DataSourceError.JsonDataException(exception = JsonDataException())

        employeeDirectoryViewModel.loadEmployees()

        // We don't want to capture the initial state value, we want to wait until the state stream is idle
        advanceUntilIdle()

        Assert.assertEquals(employeeDirectoryViewModel.state.value, SquareState.Error)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testLoadEmployeesEmpty() = runTest {
        val mockEmployeesList = emptyList<Employee>()

        coEvery { mockRepository.getEmployees() } returns mockEmployeesList

        employeeDirectoryViewModel.loadEmployees()

        // We don't want to capture the initial state value, we want to wait until the state stream is idle
        advanceUntilIdle()

        Assert.assertEquals(employeeDirectoryViewModel.state.value, SquareState.Empty)
    }
}

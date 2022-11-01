package com.square.takehome

import com.square.takehome.api.ApiService
import com.square.takehome.api.DataSourceError
import com.square.takehome.api.Employee
import com.square.takehome.api.EmployeeResponse
import com.square.takehome.repository.Repository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class EmployeeRepositoryTest {
    private lateinit var mockService: ApiService
    private lateinit var repository: Repository

    @Before
    fun setup() {
        mockService = mockk()
        repository = Repository(mockService)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testGetEmployees() = runTest {
        val mockEmployeesList = EmployeeResponse(
            listOf(
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
        )

        coEvery { mockService.getEmployees() } returns Response.success(mockEmployeesList)

        val response = mockService.getEmployees()

        coVerify { mockService.getEmployees() }
        Assert.assertEquals(response.body(), mockEmployeesList)
    }

    @Test(expected = DataSourceError.NullBody::class)
    fun testGetEmployeesNullBody() = runTest {

        coEvery { mockService.getEmployees() } returns Response.success(null)

        repository.getEmployees()

        coVerify { mockService.getEmployees() }
    }
}
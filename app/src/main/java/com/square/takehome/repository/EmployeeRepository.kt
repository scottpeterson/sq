package com.square.takehome.repository

import com.square.takehome.api.ApiService
import com.square.takehome.api.DataSourceError
import com.square.takehome.api.Employee

class Repository(private val apiService: ApiService) {

    suspend fun getEmployees(): List<Employee> {
        val response = apiService.getEmployees()

        return when {
            response.isSuccessful -> {
                when (val body = response.body()) {
                    null -> throw DataSourceError.NullBody
                    else -> {
                        body.employees
                    }
                }
            }
            else -> throw DataSourceError.RequestFailed(
                code = response.code(),
                error = response.errorBody().toString(),
                errorMessage = response.message()
            )
        }
    }
    suspend fun getEmployeesMalformedData() = apiService.getEmployeesMalformedData()
    suspend fun getEmployeesEmptyData() = apiService.getEmployeesEmptyData()

}
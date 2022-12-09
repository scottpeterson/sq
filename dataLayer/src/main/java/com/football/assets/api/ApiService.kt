package com.football.assets.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("employees.json")
    suspend fun getEmployees(): Response<EmployeeResponse>

    @GET("employees_malformed.json")
    suspend fun getEmployeesMalformedData(): Response<EmployeeResponse>

    @GET("employees_empty.json")
    suspend fun getEmployeesEmptyData(): Response<EmployeeResponse>
}
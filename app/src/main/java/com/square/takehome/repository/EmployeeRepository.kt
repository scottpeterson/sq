package com.square.takehome.repository

import android.telephony.PhoneNumberUtils
import com.square.takehome.api.ApiService
import com.square.takehome.api.DataSourceError
import com.square.takehome.api.Employee
import com.square.takehome.api.SquareError
import com.square.takehome.utils.convertAnyErrorToSquareError
import javax.inject.Inject

class Repository @Inject constructor (private val apiService: ApiService) {
    private fun toFormattedPhoneNumber(phoneNumber: String): String {
        return "(" + phoneNumber.substring(0,3) + ") " + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(7)
    }

    private fun toFormattedEmployeeType(employeeType: String): String {
        return when (employeeType) {
            "CONTRACTOR" -> "Contractor"
            "FULL_TIME" -> "Full Time"
            "PART_TIME" -> "Part Time"
            else -> employeeType
        }
    }

    suspend fun getEmployees(): List<Employee> {
        convertAnyErrorToSquareError {
            val response = apiService.getEmployees()

            return when {
                response.isSuccessful -> {
                    when (val body = response.body()) {
                        null -> throw DataSourceError.NullBody
                        else -> {
                            body.employees.map {
                                Employee(
                                    biography = it.biography,
                                    photoUrlSmall = it.photoUrlSmall,
                                    emailAddress = it.emailAddress,
                                    fullName = it.fullName,
                                    team = it.team,
                                    uuid = it.uuid,
                                    phoneNumber = toFormattedPhoneNumber(it.phoneNumber),
                                    employeeType = toFormattedEmployeeType(it.employeeType)
                                )
                            }.sortedBy { it.team }
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
    }

    suspend fun getEmployeesMalformedData(): List<Employee> {
        convertAnyErrorToSquareError {
            val response = apiService.getEmployeesMalformedData()

            return when {
                response.isSuccessful -> {
                    when (val body = response.body()) {
                        null -> throw DataSourceError.NullBody
                        else -> {
                            body.employees.map {
                                Employee(
                                    biography = it.biography,
                                    photoUrlSmall = it.photoUrlSmall,
                                    emailAddress = it.emailAddress,
                                    fullName = it.fullName,
                                    team = it.team,
                                    uuid = it.uuid,
                                    phoneNumber = toFormattedPhoneNumber(it.phoneNumber),
                                    employeeType = toFormattedEmployeeType(it.employeeType)
                                )
                            }.sortedBy { it.team }
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
    }
    suspend fun getEmployeesEmptyData(): List<Employee> {
        convertAnyErrorToSquareError {
            val response = apiService.getEmployeesEmptyData()

            return when {
                response.isSuccessful -> {
                    when (val body = response.body()) {
                        null -> throw DataSourceError.NullBody
                        else -> {
                            body.employees.map {
                                Employee(
                                    biography = it.biography,
                                    photoUrlSmall = it.photoUrlSmall,
                                    emailAddress = it.emailAddress,
                                    fullName = it.fullName,
                                    team = it.team,
                                    uuid = it.uuid,
                                    phoneNumber = toFormattedPhoneNumber(it.phoneNumber),
                                    employeeType = toFormattedEmployeeType(it.employeeType)
                                )
                            }.sortedBy { it.team }
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
    }
}
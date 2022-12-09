package com.football.assets.repository

import com.football.assets.api.ApiService
import com.football.assets.api.DataSourceError
import com.football.assets.api.Employee
import com.football.assets.model.SeahawkItem
import com.football.assets.utils.convertAnyErrorToSquareError
import java.text.NumberFormat
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    private fun toFormattedPhoneNumber(phoneNumber: String): String {
        return "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(
            3,
            6
        ) + "-" + phoneNumber.substring(7)
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

    fun getSeahawksData(): List<SeahawkItem> {
        return listOf(
            SeahawkItem(
                name = "Charles Cross",
                position = "OT",
                position_group = "OL",
                offense_defense = "O",
                position_group_depth = "OT-01",
                roster_asset_rank = 1,
                height = formatHeight(77),
                weight = 311,
                experience = "R",
                college = "Mississippi State",
                college_conference = "SEC",
                group_age = 26.536377473363775,
                roster_type = "53",
                birthdate = "11/25/00",
                age = 21.96,
                ability = 9,
                overall_statistic = 1084.9062926035347,
                cap_number = formatCapNumber(3887932),
                next_year_status = "Team Control"
            ),
            SeahawkItem(
                name = "Tariq Woolen",
                position = "CB",
                position_group = "DB",
                offense_defense = "D",
                position_group_depth = "CB-01",
                roster_asset_rank = 2,
                height = formatHeight(76),
                weight = 210,
                experience = "R",
                college = "Texas-San Antonio",
                college_conference = "USA",
                group_age = 26.589315068493153,
                roster_type = "53",
                birthdate = "5/2/99",
                age = 23.53,
                ability = 9,
                overall_statistic = 1043.2321328493751,
                cap_number = formatCapNumber(788054),
                next_year_status = "Team Control"
            ),
            SeahawkItem(
                name = "D.K. Metcalf",
                position = "WR",
                position_group = "WR",
                offense_defense = "O",
                position_group_depth = "WR-01",
                roster_asset_rank = 3,
                height = formatHeight(76),
                weight = 235,
                experience = "4",
                college = "Ole Miss",
                college_conference = "SEC",
                group_age = 27.079908675799086,
                roster_type = "53",
                birthdate = "12/14/97",
                age = 24.92,
                ability = 9,
                overall_statistic = 1004.2170172683767,
                cap_number = formatCapNumber(8838827),
                next_year_status = "Team Control"
            ),
            SeahawkItem(
                name = "Kenneth Walker III",
                position = "RB",
                position_group = "BACK",
                offense_defense = "O",
                position_group_depth = "BACK-01",
                roster_asset_rank = 4,
                height = formatHeight(69),
                weight = 211,
                experience = "R",
                college = "Michigan State",
                college_conference = "Big Ten",
                group_age = 25.794520547945204,
                roster_type = "53",
                birthdate = "10/20/00",
                age = 22.06,
                ability = 9,
                overall_statistic = 998.3508706675217,
                cap_number = formatCapNumber(1534833),
                next_year_status = "Team Control"
            ),
            SeahawkItem(
                name = "Abraham Lucas",
                position = "OT",
                position_group = "OL",
                offense_defense = "O",
                position_group_depth = "OT-02",
                roster_asset_rank = 5,
                height = formatHeight(78),
                weight = 322,
                experience = "R",
                college = "Washington State",
                college_conference = "Pac 12",
                group_age = 26.536377473363775,
                roster_type = "53",
                birthdate = "10/25/98",
                age = 24.05,
                ability = 8,
                overall_statistic = 955.7793336832029,
                cap_number = formatCapNumber(980304),
                next_year_status = "Team Control"
            )
        )
    }

    private fun formatCapNumber(capNumber: Int): String {
        val format = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 0
        return format.format(capNumber)
    }

    private fun formatHeight(height: Int): String {
        val feet = height/12
        val inches = height % 12
        return "$feet ft $inches in"
    }
}
package com.square.takehome.api

import android.content.Context
import com.square.takehome.R
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmployeeWrapper (
    @Json(name = "employees")
    val employees: List<Employee>
)

@JsonClass(generateAdapter = true)
data class Employee(
    @Json(name = "uuid")
    val uuid: String,

    @Json(name = "full_name")
    val fullName: String,

    @Json(name = "phone_number")
    val phoneNumber: String,

    @Json(name = "email_address")
    val emailAddress: String,

    @Json(name = "biography")
    val biography: String,

    @Json(name = "photo_url_small")
    val photoUrlSmall: String,

    @Json(name = "team")
    val team: String,

    @Json(name = "employee_type")
    val employeeType: String
)

sealed class DataSourceError: SquareError() {
    object IOException : DataSourceError()
    object SessionExpired : DataSourceError()
    object Timeout : DataSourceError()
    object NullBody : DataSourceError()
    object EndOfFileException : DataSourceError()

    data class JsonDataException(val exception: com.squareup.moshi.JsonDataException): DataSourceError()

    data class Unknown(val exception: Exception, val body: String? = null): DataSourceError()

    data class RequestFailed(
        val code: Int,
        val error: String?,
        val errorMessage: String?
    ): DataSourceError()

    override fun toAppetizerMessage(context: Context): String {
        return when (this) {
        IOException -> context.getString(R.string.error_api_ioexception)
        SessionExpired -> context.getString(R.string.error_api_session_expired)
        Timeout -> context.getString(R.string.error_api_timeout)
        NullBody -> context.getString(R.string.error_api_null_body)
        EndOfFileException -> context.getString(R.string.error_api_request_unexpected_end_of_file)
        is JsonDataException -> context.getString(R.string.error_api_json_data, exception.message)
        is Unknown -> context.getString(R.string.error_api_unknown)
        is RequestFailed -> this.errorMessage ?: context.getString(R.string.error_api_request_failed, this.code)
    }
}
}

abstract class SquareError: Exception() {
    abstract fun toAppetizerMessage(context: Context): String
}
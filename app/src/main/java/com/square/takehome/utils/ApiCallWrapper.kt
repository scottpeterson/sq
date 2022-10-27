package com.square.takehome.utils

import com.square.takehome.api.DataSourceError
import com.square.takehome.api.SquareError
import com.squareup.moshi.JsonDataException
import java.io.EOFException
import java.net.SocketTimeoutException

@Throws(SquareError::class)
inline fun <T> convertAnyErrorToSquareError(block: () -> T): T {
    return try {
        block()
    } catch (exception: Exception) {
        throw when (exception) {
            is SquareError -> exception
            is SocketTimeoutException -> DataSourceError.Timeout
            is EOFException -> DataSourceError.EndOfFileException
            is DataSourceError.IOException -> DataSourceError.IOException
            is JsonDataException -> DataSourceError.JsonDataException(exception)
            else -> DataSourceError.Unknown(exception)
        }
    }
}

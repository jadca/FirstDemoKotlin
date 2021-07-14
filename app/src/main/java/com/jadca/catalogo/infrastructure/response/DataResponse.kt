package com.jadca.catalogo.infrastructure.response

import java.util.concurrent.TimeoutException

sealed class DataResponse<out T : Any> {
    data class Success<T : Any>(val data: T?) : DataResponse<T>()
    data class ExceptionError(val errorCode: Exception) : DataResponse<Nothing>()
    data class TimeOutException(val errorCode: TimeoutException) : DataResponse<Nothing>()
    data class ServerError(val errorCode: ErrorServer) : DataResponse<Nothing>()
}

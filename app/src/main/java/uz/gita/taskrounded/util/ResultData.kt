package uz.gita.taskrounded.util

sealed class ResultData<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : ResultData<T>()
    class Loading<T>(data: T? = null) : ResultData<T>()
    class Error<T>(throwable: Throwable, data: T? = null) : ResultData<T>()
}
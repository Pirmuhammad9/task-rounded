package uz.gita.taskrounded.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import kotlinx.coroutines.flow.*
import uz.gita.taskrounded.data.local.room.entity.DataEntity


//fun <RequestType, ResultType> networkBoundService(
//    query: Flow<List<DataEntity>>,
//    fetch: suspend () -> RequestType,
//    saveFetchResult: suspend (RequestType) -> Unit,
//    shouldFetch: (Flow<List<DataEntity>>) -> Boolean = { true }
//) = flow {
////    val data = query.first()
////    val flow = if (shouldFetch(data)) {
////        emit(ResultData.Loading(data))
////        try {
////            saveFetchResult(fetch())
////            query().map { ResultData.Success(it) }
////        } catch (throwable: Throwable) {
////            query().map { ResultData.Error(throwable, data) }
////        }
////    } else {
////        query().map { ResultData.Success(it) }
////    }
////    emitAll(flow)
//}

fun isInternetAvailable(activity: Activity): Boolean {
    val conMgr = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val network = conMgr.activeNetwork
        val networkCapabilities = conMgr.getNetworkCapabilities(network)
        networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
    } else {
        (conMgr.activeNetworkInfo != null && conMgr.activeNetworkInfo!!.isAvailable
                && conMgr.activeNetworkInfo!!.isConnected)
    }
}
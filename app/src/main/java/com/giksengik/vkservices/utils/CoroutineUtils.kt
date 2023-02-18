package com.giksengik.vkservices.utils

import kotlinx.coroutines.CancellationException
import java.lang.Exception

/**
 * @author e.a.vlasov
 */
inline fun <R> runCatchingNonCancellation(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.failure(e)
    }
}

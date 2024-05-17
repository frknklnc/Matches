package com.example.matches.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


open class BaseRepository {

    protected fun <T> fetch(apiCall: suspend () -> T): Flow<T> {
        return flow {
            emit(apiCall())
        }
    }
}
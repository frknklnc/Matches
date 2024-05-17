package com.example.matches.base

abstract class BaseUseCase<in P, R> {

    protected abstract suspend fun build(params: P): R

    suspend fun execute(params: P) = build(params)
}
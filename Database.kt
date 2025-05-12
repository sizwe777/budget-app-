package com.example.budgettrackerapp

import kotlin.reflect.KClass

annotation class Database(
    val entities: Array<KClass<Expenses>>,
    val version: Int,
    val exportSchema: Boolean
)

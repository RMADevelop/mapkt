package com.example.admin.mapkt.domain

interface Mapper<From, To> {

    fun map(from: From): To

    fun map(list: List<From>): List<To>
}
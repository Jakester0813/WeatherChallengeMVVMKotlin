package com.example.weatherchallengemvvmkotlin.injection

interface ComponentObject<T : CoreComponent?> {
    val component: T
}
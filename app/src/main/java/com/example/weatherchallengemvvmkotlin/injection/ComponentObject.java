package com.example.weatherchallengemvvmkotlin.injection;

public interface ComponentObject<T extends CoreComponent> {
    T getComponent();
}

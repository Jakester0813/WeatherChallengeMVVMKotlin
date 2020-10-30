package com.example.weatherchallengemvvmkotlin.ui.main;

import android.app.Application;
import android.text.TextUtils;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import timber.log.Timber;

public abstract class BaseViewModel extends AndroidViewModel {

    protected MutableLiveData<ArrayList<Throwable>> errors = new MutableLiveData<>(new ArrayList<>());
    protected HashMap<String, MutableLiveData<Boolean>> loadingElements = new HashMap<>();
    protected HashMap<String, Boolean> loadingElementsBackstore = new HashMap<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
        loadingElements.put("global", new MutableLiveData<>(false));
        loadingElementsBackstore.put("global", false);
    }

    public void setGlobalLoading(boolean isLoading) {
        loadingElements.get("global").postValue(isLoading);
        loadingElementsBackstore.put("global", isLoading);
    }

    public LiveData<Boolean> getGlobalLoading() {
        return loadingElements.get("global");
    }

    public Boolean getGlobalLoadingValue() {
        return loadingElementsBackstore.get("global");
    }

    public void setLoading(String elementName, boolean isLoading) {
        if (!loadingElements.containsKey(elementName)) {
            loadingElements.put(elementName, new MutableLiveData<>(isLoading));
            loadingElementsBackstore.put(elementName, isLoading);
        }
        loadingElements.get(elementName).postValue(isLoading);
        loadingElementsBackstore.put(elementName, isLoading);
    }

    public LiveData<Boolean> getLoading(String elementName) {
        if (!loadingElements.containsKey(elementName)) {
            loadingElements.put(elementName, new MutableLiveData<>(false));
            loadingElementsBackstore.put(elementName, false);
        }
        return loadingElements.get(elementName);
    }

    public Boolean getLoadingValue(String elementName) {
        if (!loadingElements.containsKey(elementName)) {
            loadingElements.put(elementName, new MutableLiveData<>(false));
            loadingElementsBackstore.put(elementName, false);
        }
        return loadingElementsBackstore.get(elementName);
    }

    protected void defaultHandleError(@Nullable Throwable throwable) {
        ArrayList<Throwable> newErrors = new ArrayList<>();
        if (throwable != null) {
            newErrors.add(throwable);
        }
        errors.postValue(newErrors);
        Timber.d(throwable, "Network Error");
    }

    public void clearErrors() {
        errors.postValue(new ArrayList<>());
    }

    protected void setGqlErrors(@Nullable List<Error> gqlErrors) {
        ArrayList<Throwable> newErrors = new ArrayList<>();
        if (gqlErrors != null) {
            for (Error gqlError : gqlErrors) {
                newErrors.add(new Throwable(gqlError.toString()));
                Timber.d(new Throwable(gqlError.toString()), "GQL Error");
            }
        }
        errors.postValue(newErrors);
    }


}

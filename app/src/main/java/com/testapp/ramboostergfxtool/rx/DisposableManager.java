package com.testapp.ramboostergfxtool.rx;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class DisposableManager {
    private static CompositeDisposable a;

    private static CompositeDisposable a() {
        CompositeDisposable compositeDisposable = a;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            a = new CompositeDisposable();
        }
        return a;
    }

    public static void add(Disposable disposable) {
        a().add(disposable);
    }

    public static void dispose() {
        a().dispose();
    }
}

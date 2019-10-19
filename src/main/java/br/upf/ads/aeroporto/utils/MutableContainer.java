package br.upf.ads.aeroporto.utils;

public class MutableContainer<T> {
    private T t;

    public MutableContainer(T t) {
        this.t = t;
    }

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

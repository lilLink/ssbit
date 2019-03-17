package com.lillink.parsefourtype.service;

public abstract class Writer<T> {

    protected final String path;

    protected Writer(String path) {
        this.path = path;
    }

    public abstract void write(T instance);
}

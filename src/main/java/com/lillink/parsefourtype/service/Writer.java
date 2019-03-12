package com.lillink.parsefourtype.service;

import com.lillink.parsefourtype.model.Company;

public abstract class Writer<T> {

    protected final String path;

    protected Writer(String path) {
        this.path = path;
    }

    public abstract int write(T instance);
}

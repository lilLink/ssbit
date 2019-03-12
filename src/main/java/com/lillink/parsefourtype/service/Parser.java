package com.lillink.parsefourtype.service;

import java.util.Optional;

public abstract class Parser<T> {

    protected final String path;

    protected Parser(String path) {
        this.path = path;
    }

    public abstract Optional<T> parse();
}

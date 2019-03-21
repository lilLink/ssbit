package com.lillink.parsefourtype.service.dao;

import java.util.List;

public interface Service<T> {

    List<T> getAll();

    void remove(Long id);

    T getById(Long id);

    Long add(T name);

}

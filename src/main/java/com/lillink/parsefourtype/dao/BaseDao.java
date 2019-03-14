package com.lillink.parsefourtype.dao;

import java.util.List;

public interface BaseDao<T> {

    T findById(Long id);

    List<T> findAll();

    Long save(T job);

    void delete(Long id);
}

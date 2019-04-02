package com.lillink.parsefourtype.service.dao;

import java.util.List;

public interface Service<T> {

    List<T> getAll();

    void delete(Long id);

    T getByPersonId(Long id);

    T getById(Long id);

    Long save(T name,Long personId);

}

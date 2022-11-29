package com.example.model.repository;

import java.util.List;

import com.example.utils.Response;

public interface Repository<T> {
    Response<List> findAll();

    Response<T> findOne(Long id);

    Response<T> save(T object);

    Response<T> update(T object, Long id);

    Response<T> delete(Long id);
}

package com.shuaibu.interfaces;

public interface CrudInterface<T> {
    T create(T entity);
    T getById(Integer id);
    T updateById(Integer id, T entity);
    String deleteById(Integer id);
}

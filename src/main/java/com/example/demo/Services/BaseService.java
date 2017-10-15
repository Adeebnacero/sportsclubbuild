package com.example.demo.Services;

/**
 * Created by Adeebo on 2017/08/21.
 */
public interface BaseService<E, ID> {
    E save(E entity);
    E findById(ID id);
    E update(ID id);
}

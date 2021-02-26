package ru.itis.javalab.repositories.interfaces;


import java.util.List;

public interface CrudRepository<T, ID> {
    boolean save(T entity);

    void delete(T entity);

    T findById(ID id);

    List<T> findAll();

}

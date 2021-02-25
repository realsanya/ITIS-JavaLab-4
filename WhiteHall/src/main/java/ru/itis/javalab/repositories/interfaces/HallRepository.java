package ru.itis.javalab.repositories.interfaces;

import ru.itis.javalab.models.Hall;

import java.util.List;

public interface HallRepository extends CrudRepository<Hall, Integer> {
    List<Hall> findAllByCost(Integer cost);
}

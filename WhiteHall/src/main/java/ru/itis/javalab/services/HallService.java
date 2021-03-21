package ru.itis.javalab.services;

import ru.itis.javalab.dto.HallDto;
import ru.itis.javalab.models.Hall;

import java.util.List;

public interface HallService {
    List<HallDto> getAllHalls();

    List<HallDto> getAllHallsByCost(Integer cost);
}

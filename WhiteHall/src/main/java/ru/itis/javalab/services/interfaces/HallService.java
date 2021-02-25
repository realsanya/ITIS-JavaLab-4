package ru.itis.javalab.services.interfaces;

import ru.itis.javalab.dto.HallDto;
import ru.itis.javalab.models.Hall;

import java.util.List;

public interface HallService {
    List<HallDto> getAllHalls();

    List<HallDto> getAllHallsByCost(Integer cost);

    void addHall(Hall hall);

    HallDto getHall(Integer id);

}

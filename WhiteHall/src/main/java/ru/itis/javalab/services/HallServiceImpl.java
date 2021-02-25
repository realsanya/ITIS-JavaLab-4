package ru.itis.javalab.services;

import org.springframework.stereotype.Service;
import ru.itis.javalab.dto.HallDto;
import ru.itis.javalab.models.Hall;
import ru.itis.javalab.repositories.interfaces.HallRepository;
import ru.itis.javalab.services.interfaces.HallService;

import java.util.List;

@Service
public class HallServiceImpl implements HallService {

    private HallRepository hallRepository;

    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List<HallDto> getAllHalls() {
        return HallDto.from(hallRepository.findAll());
    }

    @Override
    public List<HallDto> getAllHallsByCost(Integer cost) {
        return HallDto.from(hallRepository.findAllByCost(cost));
    }

    @Override
    public void addHall(Hall hall) {
        hallRepository.save(
                Hall.builder()
                        .name(hall.getName())
                        .cost(hall.getCost())
                        .build()
        );
    }

    @Override
    public HallDto getHall(Integer id) {
        return HallDto.from(hallRepository.findById(id));
    }
}

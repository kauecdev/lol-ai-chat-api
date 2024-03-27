package me.dio.sdw24.application;

import me.dio.sdw24.domain.model.Champion;
import me.dio.sdw24.domain.ports.ChampionRepository;

import java.util.List;

public record ListChampionsUseCase(ChampionRepository repository) {

    public List<Champion> findAll() {
        return repository.findAll();
    }

}

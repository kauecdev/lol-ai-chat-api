package me.dio.sdw24.application;

import me.dio.sdw24.domain.exception.ChampionNotFoundException;
import me.dio.sdw24.domain.model.Champion;
import me.dio.sdw24.domain.ports.ChampionRepository;

import java.util.List;
import java.util.Optional;

public record AskChampionUseCase(ChampionRepository repository) {

    public String askChampion(Long championId, String question) {
        Champion champion = repository.findById(championId).orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generateContextByQuestion(question);

        return championContext;
    }

}

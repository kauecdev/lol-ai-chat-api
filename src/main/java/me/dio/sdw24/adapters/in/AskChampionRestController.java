package me.dio.sdw24.adapters.in;

import me.dio.sdw24.application.AskChampionUseCase;
import me.dio.sdw24.application.ListChampionsUseCase;
import me.dio.sdw24.domain.model.Champion;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/champion")
public record AskChampionRestController(AskChampionUseCase askChampionUseCase) {

    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request) {
        String answer = askChampionUseCase.askChampion(championId, request.question());

        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question) {}
    public record AskChampionResponse(String answer) {}
}

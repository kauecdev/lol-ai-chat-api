package me.dio.sdw24.adapters.in;

import me.dio.sdw24.application.ListChampionsUseCase;
import me.dio.sdw24.domain.model.Champion;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/champion")
public record ListChampionsRestController(ListChampionsUseCase listChampionsUseCase) {

    @CrossOrigin
    @GetMapping
    public List<Champion> findAllChampions() {
        return listChampionsUseCase.findAll();
    }

}

package me.dio.sdw24;

import me.dio.sdw24.application.AskChampionUseCase;
import me.dio.sdw24.application.ListChampionsUseCase;
import me.dio.sdw24.domain.ports.ChampionRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionRepository championRepository) {
		return new ListChampionsUseCase(championRepository);
	}

	@Bean
	public AskChampionUseCase provideAskChampionUseCase(ChampionRepository championRepository) {
		return new AskChampionUseCase(championRepository);
	}
}

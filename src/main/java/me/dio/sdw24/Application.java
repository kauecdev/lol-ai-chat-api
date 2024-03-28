package me.dio.sdw24;

import me.dio.sdw24.application.AskChampionUseCase;
import me.dio.sdw24.application.ListChampionsUseCase;
import me.dio.sdw24.domain.ports.ChampionRepository;
import me.dio.sdw24.domain.ports.GenerativeAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
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
	public AskChampionUseCase provideAskChampionUseCase(ChampionRepository championRepository, GenerativeAiService generativeAiService) {
		return new AskChampionUseCase(championRepository, generativeAiService);
	}
}

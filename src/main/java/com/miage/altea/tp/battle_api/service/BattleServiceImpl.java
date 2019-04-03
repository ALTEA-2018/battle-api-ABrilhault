package com.miage.altea.tp.battle_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.bo.BattleTrainer;

@Service
public class BattleServiceImpl implements BattleService {

	private RestTemplate restTemplate;
	private String trainerServiceUrl;

	@Autowired
	private PokemonTypeServiceImpl typeService;

	@Override
	public Battle createBattle(String trainer, String opponent) {
		var trainer1 = getTrainerByName(trainer);
		var opponent1 = getTrainerByName(opponent);

		return null;
	}


	private BattleTrainer getTrainerByName(String name) {
		var trainer = restTemplate.getForObject(trainerServiceUrl + "/trainers/{name}", BattleTrainer.class, name);
		trainer.getTeam()
				.parallelStream()
				.forEach(p -> {
					p.setPokemonType(typeService.getPokemonType(p.getPokemonType().getId()));
					p.initBattleStats(p.getBattleStats(), p.getLevel());
				});
		return trainer;
	}

	@Autowired
	void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Value("${trainers.service.url}")
	void setTrainerServiceUrl(String trainersServiceUrl) {
		this.trainerServiceUrl = trainersServiceUrl;
	}

}

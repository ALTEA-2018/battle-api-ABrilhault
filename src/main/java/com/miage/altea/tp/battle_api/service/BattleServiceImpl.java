package com.miage.altea.tp.battle_api.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.bo.BattleTrainer;
import com.miage.altea.tp.battle_api.repository.BattleRepository;

@Service
public class BattleServiceImpl implements BattleService {

	Logger logger = LoggerFactory.getLogger(BattleServiceImpl.class);

	private RestTemplate restTemplate;

	private String trainerServiceUrl;
	private BattleRepository battleRepository;

	@Autowired
	private PokemonTypeServiceImpl typeService;

	public BattleServiceImpl(BattleRepository battleRepository) {
		this.battleRepository = battleRepository;
	}

	@Override
	public Battle createBattle(String trainer, String opponent) {
		logger.info(">>> [BattleService] - createBattle ");

		var trainer1 = getTrainerByName(trainer);
		var opponent1 = getTrainerByName(opponent);
		Boolean trainerStarts = trainer1.getTeam().get(0).getBattleStats().getSpeed() > opponent1.getTeam().get(0).getBattleStats().getSpeed();
		trainer1.setNextTurn(trainerStarts);
		opponent1.setNextTurn(!trainerStarts);
		return battleRepository.save(new Battle(UUID.randomUUID(), trainer1, opponent1));
	}

	@Override
	public Battle getBattleById(UUID uuid) {
		return battleRepository.findOne(uuid);
	}

	private BattleTrainer getTrainerByName(String name) {
		var trainer = restTemplate.getForObject(trainerServiceUrl + "/trainers/{name}", BattleTrainer.class, name);
		trainer.getTeam()
				.parallelStream()
				.forEach(p -> {
					p.setType(typeService.getPokemonType(p.getPokemonType()));
					p.initBattleStats(p.getType().getStats(), p.getLevel());
				});
		return trainer;
	}

	@Autowired
	@Qualifier("trainerApiRestTemplate")
	void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Value("${trainers.service.url}")
	void setTrainerServiceUrl(String trainersServiceUrl) {
		this.trainerServiceUrl = trainersServiceUrl;
	}

}

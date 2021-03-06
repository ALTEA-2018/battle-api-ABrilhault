package com.miage.altea.tp.battle_api.contoller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.exceptions.TrainerException;
import com.miage.altea.tp.battle_api.service.BattleService;

@RestController
@RequestMapping("/battles")
public class BattleController {

	Logger logger = LoggerFactory.getLogger(BattleController.class);

	@Autowired
	private BattleService battleService;


	@PostMapping("")
	public Battle createBattle(@RequestParam("trainer") String trainer, @RequestParam("opponent") String opponent){
		logger.info(">>> [BattleController] - createBattle ");
		return battleService.createBattle(trainer, opponent);
	}

	@PostMapping("/{id}/{trainerName}/attack")
	public Battle attack(@PathVariable("id") UUID uuid, @PathVariable("trainerName") String trainerName) throws TrainerException {
		logger.info(">>> [BattleController] - attack from {}", trainerName);
		return battleService.attack(uuid, trainerName);
	}

	@GetMapping("/{id}")
	public Battle getBattle(@PathVariable("id") UUID uuid) {
		logger.info(">>> [BattleController] - getBattle ");
		return battleService.getBattleById(uuid);
	}

	@GetMapping("")
	public Iterable getAllBattle() {
		logger.info(">>> [BattleController] - getAllBattles ");
		return battleService.getBattles();
	}
}

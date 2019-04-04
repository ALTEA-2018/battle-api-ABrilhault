package com.miage.altea.tp.battle_api.service;

import java.util.UUID;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.exceptions.TrainerException;

public interface BattleService {

	Battle createBattle(String trainer, String opponent);

	Battle getBattleById(UUID uuid);

	Iterable<Battle> getBattles();

	Battle attack(UUID uuid, String trainerName) throws TrainerException;
}

package com.miage.altea.tp.battle_api.repository;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.miage.altea.tp.battle_api.bo.Battle;

@Repository
public class BattleRepositoryImpl implements BattleRepository {

	private HashMap<UUID, Battle> battles = new HashMap<>();

	@Override
	public Battle findOne(UUID id) {
		return battles.get(id);
	}

	@Override
	public Battle save(Battle battle) {
		battles.put(battle.getUuid(), battle);
		return battle;
	}
}

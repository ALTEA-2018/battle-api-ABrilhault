package com.miage.altea.tp.battle_api.repository;

import java.util.UUID;

import com.miage.altea.tp.battle_api.bo.Battle;

public interface BattleRepository {

	Battle findOne(UUID id);
	Battle save(Battle battle);
	Iterable<Battle> findAll();
}

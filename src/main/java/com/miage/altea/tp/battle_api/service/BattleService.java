package com.miage.altea.tp.battle_api.service;

import java.util.UUID;

import com.miage.altea.tp.battle_api.bo.Battle;

public interface BattleService {

	Battle createBattle(String trainer, String opponent);

	Battle getBattleById(UUID uuid);
}

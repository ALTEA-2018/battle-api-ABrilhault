package com.miage.altea.tp.battle_api.service;

import com.miage.altea.tp.battle_api.bo.Battle;

public interface BattleService {

	Battle createBattle(String trainer, String opponent);
}

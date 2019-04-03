package com.miage.altea.tp.battle_api.bo;

import java.util.UUID;

public class Battle {

	private UUID id;
	private BattleTrainer trainer;
	private BattleTrainer opponent;

	public Battle(BattleTrainer trainer, BattleTrainer opponent) {
		this.trainer = trainer;
		this.opponent = opponent;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public BattleTrainer getTrainer() {
		return trainer;
	}

	public void setTrainer(BattleTrainer trainer) {
		this.trainer = trainer;
	}

	public BattleTrainer getOpponent() {
		return opponent;
	}

	public void setOpponent(BattleTrainer opponent) {
		this.opponent = opponent;
	}
}

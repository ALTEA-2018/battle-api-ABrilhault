package com.miage.altea.tp.battle_api.bo;
import java.util.UUID;

public class Battle {

	private UUID uuid;
	private BattleTrainer trainer;
	private BattleTrainer opponent;

	public Battle(UUID uuid, BattleTrainer trainer, BattleTrainer opponent) {
		this.uuid = uuid;
		this.trainer = trainer;
		this.opponent = opponent;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
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

package com.miage.altea.tp.battle_api.bo;

import java.util.List;

public class BattleTrainer {

	private String name;

	private Boolean nextTurn;

	private List<BattlePokemon> team;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getNextTurn() {
		return nextTurn;
	}

	public void setNextTurn(Boolean nextTurn) {
		this.nextTurn = nextTurn;
	}

	public List<BattlePokemon> getTeam() {
		return team;
	}

	public void setTeam(List<BattlePokemon> team) {
		this.team = team;
	}
}

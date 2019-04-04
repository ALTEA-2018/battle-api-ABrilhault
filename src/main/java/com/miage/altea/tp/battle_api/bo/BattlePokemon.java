package com.miage.altea.tp.battle_api.bo;

import java.io.Serializable;

public class BattlePokemon implements Serializable {

	private int id;

	private int pokemonType;

	private PokemonType type;

	private int level;

	private Stats battleStats;

	public BattlePokemon() {
	}

	public BattlePokemon(int pokemonType, int level) {
		this.pokemonType = pokemonType;
		this.level = level;
	}

	public void initBattleStats(Stats baseStats, int level) {
		battleStats = new Stats();
		int attack = level <= 50 ? (5 + (baseStats.getAttack() * level / 50)) : (baseStats.getAttack() * 2 + 5);
		int defense = level <= 50 ? (5 + (baseStats.getDefense() * level / 50)) : (baseStats.getDefense() * 2 + 5);
		int speed = level <= 50 ? (5 + (baseStats.getSpeed() * level / 50)) : (baseStats.getSpeed() * 2 + 5);
		int hp = level <= 50 ? (10 + level + (baseStats.getHp() * level / 50)) : (baseStats.getHp() * 2 + 110);
		battleStats.setAttack(attack);
		battleStats.setDefense(defense);
		battleStats.setSpeed(speed);
		battleStats.setHp(hp);
	}

	public Stats getBattleStats() {
		return battleStats;
	}

	public void setBattleStats(Stats battleStats) {
		this.battleStats = battleStats;
	}

	public int getPokemonType() {
		return pokemonType;
	}

	public void setPokemonType(int pokemonType) {
		this.pokemonType = pokemonType;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}
}

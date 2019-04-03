package com.miage.altea.tp.battle_api.bo;

public class BattlePokemon {

	private int id;

	private PokemonType pokemonType;

	private int level;

	private Stats battleStats;

	public BattlePokemon() {
	}

	public BattlePokemon(PokemonType pokemonType, int level) {
		this.pokemonType = pokemonType;
		this.level = level;
	}

	public void initBattleStats(Stats battleStats, int level) {
		battleStats = new Stats();
		int attack = level <= 50 ? (5 + (battleStats.getAttack() * level / 50)) : (battleStats.getAttack() * 2 + 5);
		int defense = level <= 50 ? (5 + (battleStats.getDefense() * level / 50)) : (battleStats.getDefense() * 2 + 5);
		int speed = level <= 50 ? (5 + (battleStats.getSpeed() * level / 50)) : (battleStats.getSpeed() * 2 + 5);
		int hp = level <= 50 ? (10 + level + (battleStats.getHp() * level / 50)) : (battleStats.getHp() * 2 + 110);
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

	public PokemonType getPokemonType() {
		return pokemonType;
	}

	public void setPokemonType(PokemonType pokemonType) {
		this.pokemonType = pokemonType;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}

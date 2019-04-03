package com.miage.altea.tp.battle_api.service;

import org.springframework.web.client.RestTemplate;

import com.miage.altea.tp.battle_api.bo.PokemonType;

public interface PokemonTypeService {

	void setRestTemplate(RestTemplate restTemplate);
	PokemonType getPokemonType(int id);


}

package com.miage.altea.tp.battle_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.miage.altea.tp.battle_api.bo.PokemonType;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{


	private RestTemplate restTemplate;
	private String pokemonTypeServiceUrl;


	public PokemonType getPokemonType(int id){
						return restTemplate.getForObject(pokemonTypeServiceUrl + "/pokemon-types/{id}", PokemonType.class, id);
	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}


	@Value("${pokemonType.service.url}")
	void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
		this.pokemonTypeServiceUrl = pokemonServiceUrl;
	}

}

package com.miage.altea.tp.battle_api.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.miage.altea.tp.battle_api.bo.Battle;
import com.miage.altea.tp.battle_api.service.BattleService;

@RestController
@RequestMapping(value = "/battles")
public class BattleController {

	@Autowired
	private BattleService battleService;

	@PostMapping(value="/")
	public Battle createBattle(@RequestParam("trainer") String trainer, @RequestParam("opponent") String opponent){
		return battleService.createBattle(trainer, opponent);
	}

}

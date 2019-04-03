package com.miage.altea.tp.battle_api;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2
public class BattleApp {
	public static void main(String... args){
		SpringApplication.run(BattleApp.class, args);
	}

}

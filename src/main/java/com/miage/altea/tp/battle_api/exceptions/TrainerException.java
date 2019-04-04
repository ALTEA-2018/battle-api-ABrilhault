package com.miage.altea.tp.battle_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "This is not this trainer's turn to play")
public class TrainerException extends Exception {

	public TrainerException(String message) {
		super(message);
	}
}

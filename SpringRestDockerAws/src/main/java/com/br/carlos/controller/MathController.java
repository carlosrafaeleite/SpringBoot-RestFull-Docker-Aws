package com.br.carlos.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.carlos.converter.NumberConverter;
import com.br.carlos.converter.math.SimpleMath;
import com.br.carlos.exceptions.ResourseNotFoundException;

import jakarta.websocket.server.PathParam;

@RestController
public class MathController {

	

	private SimpleMath math = new SimpleMath();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!NumberConverter.isnumerico(numberOne) || !NumberConverter.isnumerico(numberTwo)) {
			throw new ResourseNotFoundException("Insira valores numericos.");
		}
		return math.sum(NumberConverter.converteNumber(numberOne), NumberConverter.converteNumber(numberTwo));
	}

	@RequestMapping(value = "/substrat/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double substrat(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!NumberConverter.isnumerico(numberOne) || !NumberConverter.isnumerico(numberTwo)) {
			throw new ResourseNotFoundException("Insira valores numericos.");
		}
		return math.substrat(NumberConverter.converteNumber(numberOne), NumberConverter.converteNumber(numberTwo));
	}

	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!NumberConverter.isnumerico(numberOne) || !NumberConverter.isnumerico(numberTwo)) {
			throw new ResourseNotFoundException("Insira valores numericos.");
		}
		return math.multiplication(NumberConverter.converteNumber(numberOne),NumberConverter.converteNumber(numberTwo));
	}

	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!NumberConverter.isnumerico(numberOne) || !NumberConverter.isnumerico(numberTwo)) {
			throw new ResourseNotFoundException("Insira valores numericos.");
		}
		return math.division(NumberConverter.converteNumber(numberOne), NumberConverter.converteNumber(numberTwo));
	}

	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!NumberConverter.isnumerico(numberOne) || !NumberConverter.isnumerico(numberTwo)) {
			throw new ResourseNotFoundException("Insira valores numericos.");
		}
		return math.media(NumberConverter.converteNumber(numberOne), NumberConverter.converteNumber(numberTwo));
	}

	@RequestMapping(value = "/square/{numbersquare}", method = RequestMethod.GET)
	public Double square(@PathVariable("numbersquare") String numbersquare) throws Exception {
		if (!NumberConverter.isnumerico(numbersquare)) {
			throw new ResourseNotFoundException("Insira valores numericos.");
		}
		return math.square(NumberConverter.converteNumber(numbersquare));
	}

}

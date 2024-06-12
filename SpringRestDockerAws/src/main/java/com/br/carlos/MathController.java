package com.br.carlos;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.carlos.exceptions.UnsuprortedMathOperationException;

import jakarta.websocket.server.PathParam;

@RestController
public class MathController {

	private final AtomicLong counter = new AtomicLong();

	 @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	    public Double sum(@PathVariable("numberOne") String numberOne,
	                      @PathVariable("numberTwo") String numberTwo) throws Exception {
	        if (!isnumerico(numberOne) || !isnumerico(numberTwo)) {
	            throw new UnsuprortedMathOperationException("Insira valores numericos.");
	        }
	        return (double) (converteNumber(numberOne) + converteNumber(numberTwo));
	    }    

	private int converteNumber(String strNumber) {

		if (strNumber == null)
			return (int) 0D;

		String number = strNumber.replaceAll(",", ".");
		if (isnumerico(strNumber))
			return (int) Double.parseDouble(number);
		return (int) 0D;
	}

	private boolean isnumerico(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");

	}

}

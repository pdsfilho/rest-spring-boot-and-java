package br.com.paulo.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulo.exceptions.UnsupportedMathOperationException;
import br.com.paulo.utils.*;

@RestController
public class MathController {
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double sum (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		Utils.checkNumbers(numberOne, numberTwo);
		Double n1 = Utils.convertToDouble(numberOne);
		Double n2 = Utils.convertToDouble(numberTwo);
		return n1 + n2;
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double subtraction (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		Utils.checkNumbers(numberOne, numberTwo);
		Double n1 = Utils.convertToDouble(numberOne);
		Double n2 = Utils.convertToDouble(numberTwo);
		return n1 - n2;	
	}
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double multiplication (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		Utils.checkNumbers(numberOne, numberTwo);
		Double n1 = Utils.convertToDouble(numberOne);
		Double n2 = Utils.convertToDouble(numberTwo);
		return n1 * n2;
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double division (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		Utils.checkNumbers(numberOne, numberTwo);
		Double n1 = Utils.convertToDouble(numberOne);
		Double n2 = Utils.convertToDouble(numberTwo);
		return n1 / n2;
		
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double mean (
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		Utils.checkNumbers(numberOne, numberTwo);
		Double n1 = Utils.convertToDouble(numberOne);
		Double n2 = Utils.convertToDouble(numberTwo);
		return (n1 + n2)/2;
	}
	
	@RequestMapping(value = "/squareRoot/{numberOne}",
			method = RequestMethod.GET)
	public Double squareRoot (
			@PathVariable(value = "numberOne") String numberOne
			) throws Exception {
		
		Utils.checkNumbers(numberOne, "0");
		Double n1 = Utils.convertToDouble(numberOne);
		return Math.sqrt(n1);
	}
	
	
}

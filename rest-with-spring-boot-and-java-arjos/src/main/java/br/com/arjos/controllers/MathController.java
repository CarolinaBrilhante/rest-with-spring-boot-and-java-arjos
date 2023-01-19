package br.com.arjos.controllers;

import br.com.arjos.converters.NumberConverter;
import br.com.arjos.exceptions.UnsupportedMathOperationException;
import br.com.arjos.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();
    @RequestMapping(value= "/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
        ) throws Exception {
        
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

    }
    @RequestMapping(value= "/sub/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sub (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
    ) throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

    }
    @RequestMapping(value= "/div/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double div (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
    )
            throws Exception {
        if(numberOne.equals("0") || numberTwo.equals("0") ){
            throw new UnsupportedOperationException("Não existe divisão com 0!");
        }

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    @RequestMapping(value= "/mult/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double mult (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
    )
            throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    @RequestMapping(value= "/ave/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double ave (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
    ) throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.ave(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
    @RequestMapping(value= "/sro/{numberOne}", method= RequestMethod.GET)
    public Double sro (
            @PathVariable(value="numberOne") String numberOne) throws Exception {

        if(!NumberConverter.isNumeric(numberOne) ) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sro(NumberConverter.convertToDouble(numberOne));
    }
}

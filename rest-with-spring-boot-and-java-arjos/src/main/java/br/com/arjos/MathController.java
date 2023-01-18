package br.com.arjos;

import br.com.arjos.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(value= "/sum/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sum (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
        ) throws Exception {
        
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);


    }

    @RequestMapping(value= "/sub/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double sub (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);


    }

    @RequestMapping(value= "/div/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double div (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
    )
            throws Exception {
        if(numberOne != "0" & numberTwo != "0"){
            throw new UnsupportedOperationException("Não existe divisão com 0!");
        }

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }


    @RequestMapping(value= "/ave/{numberOne}/{numberTwo}", method= RequestMethod.GET)
    public Double ave (
            @PathVariable(value="numberOne") String numberOne,
            @PathVariable(value="numberTwo") String numberTwo
    ) throws Exception {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;


    }

    @RequestMapping(value= "/sro/{numberOne}", method= RequestMethod.GET)
    public Double sro (
            @PathVariable(value="numberOne") String numberOne) throws Exception {

        if(!isNumeric(numberOne) ) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        double numero = convertToDouble(numberOne);
        return Math.sqrt(numero);


    }
    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}

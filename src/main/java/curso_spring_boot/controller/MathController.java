package curso_spring_boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso_spring_boot.exceptions.UnsupportedMathOperationException;
import curso_spring_boot.service.MathService;

@RestController 
@RequestMapping("/math")
public class MathController {
    
    public final MathService mathService;

    
    public MathController(MathService mathService) {
        this.mathService = mathService;
    }


    //Soma
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){

        return mathService.sum(numberOne, numberTwo);
    }


    //Subtração
    @RequestMapping("/subtracao/{numberOne}/{numberTwo}")
    public Double subtracao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set value numeric");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
        
    }

    //Divisao
    @RequestMapping("/divisao/{numberOne}/{numberTwo}")
    public Double divisao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set value numeric");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    //Media
    @RequestMapping("/media/{numberOne}/{numberTwo}")
    public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set value numeric");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    //Raiz quadrada
    @RequestMapping("/raiz/{numberOne}")
    public Double raiz(@PathVariable("numberOne") String numberOne){

        if(!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Set value numeric");
        return Math.sqrt(convertToDouble(numberOne));
    }




    //Converter String para double
    private Double convertToDouble(String strNumber) {
        
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Set value numeric");
        String number =strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }


    //Verificar se é numerico
    private boolean isNumeric(String strNumber){
        
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number =strNumber.replace(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}

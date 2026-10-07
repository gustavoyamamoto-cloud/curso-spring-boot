package curso_spring_boot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import curso_spring_boot.exceptions.UnsupportedMathOperationException;

@Service 
public class MathService {
 
    //Soma
    public Double sum(String numberOne, String numberTwo) throws UnsupportedMathOperationException{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Set value numeric");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }


    //Subtração
    public Double subtracao(String numberOne, String numberTwo){

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

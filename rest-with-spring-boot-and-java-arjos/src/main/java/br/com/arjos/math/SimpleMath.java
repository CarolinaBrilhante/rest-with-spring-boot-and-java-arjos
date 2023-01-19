package br.com.arjos.math;

public class SimpleMath {
    public Double sum ( Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }
    public Double sub ( Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }
    public Double div (Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }
    public Double mult ( Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }
    public Double ave (Double numberOne, Double numberTwo){
        return (numberOne + numberTwo) / 2;
    }
    public Double sro (Double number){
        return Math.sqrt(number);
    }
}

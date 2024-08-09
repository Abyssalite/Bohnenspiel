package bS;

public class BohnenModel {
    double result;

    double add(double a, double b){
        result = a + b;
        System.out.println(result);
        return result;
    }

    double mul(double a, double b){
        result = a * b;
        System.out.println(result);
        return result;
    }

    double getResult(){
        return result;
    }
    
}

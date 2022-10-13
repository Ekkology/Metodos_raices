package Metodos;

import java.util.Scanner;

public class Secante {

    double Xo=1, X1=5;
    int iteraciones=10;
    double tolerancia=0.0000001,funcion, error;
    
    public  Secante(Scanner s) {
        
     
        double Yo = evaluarFuncion(Xo);
        
        if(Yo==0) System.out.println("Xo "+Xo+" es una raiz");
        else {
         
            double Y1 = evaluarFuncion(X1);
            double denominador = Y1-Yo;
            error = tolerancia+1;
            int contador = 0; 
            System.out.println("La funcion es x^3 - 2x^2 + 3x -8 ");
            System.out.println(" X0 = 1 y X1 = 5");
            while((contador<iteraciones)&&(error>tolerancia)&&(Y1!=0)&&(denominador!=0)){
                double X2 = X1 - (Y1*(X1-Xo)/denominador);
                Xo = X1;
                Yo = Y1;
                X1 = X2;
                Y1 = evaluarFuncion(X2);
                denominador = Y1-Yo;
                error = Math.abs(X1-Xo);
                contador++;
                System.out.println("Iteracion                        Xr                        Error");
                System.out.println(contador+"                       "+Y1+"            "+error);
                
            }
           
           
            if(denominador==0) System.out.println("Excepcion en el denominador, division por cero");
            else{
                if(Y1 == 0) System.out.println("X1 "+X1+" es una raiz");
                else if (error<=tolerancia) System.out.println("X1 "+X1+" es una raiz y tiene un error absoluto de "+error);
                else System.out.println("Fallo la ejecucion del metodo");
            }
        }
    }
    
    public double evaluarFuncion(double x){
        funcion = x*x + 3*x -2;
        
        return funcion;
    }
    
   

}
package Metodos;
import java.math.BigDecimal;

public class Regla_falsa {
    
    public  Regla_falsa(){}
    
    /**
     * Función a resolver
     * @param x valor de incognita
     * @return double
     */
    public double fx(double x){
               //x^3 - 2x^2 + 3x -8        
        return Math.pow(x, 3) - 2*Math.pow(x, 2) + 3*x - 8; 
    }
    
    /**
     * @param x1 Limite inferior
     * @param x2 Limite superior
     * @param iterations numero de iteraciones
     * @param err Error permitido
     * @return String resultado encontrado
     *                NULL en caso de encontrar algun error
     *                EMPTY en caso de no hallar convergencia al limite de iteraciones permitidas
     */
    public String resolver(double x1, double x2, int iterations, double err){
        
        int numDec=5;
        
        double x3, y3;
        double xp=x1;
        double y1=fx(x1);
        double y2=fx(x2);   
        
        //Valores iniciales
        System.out.println( " x1 = " + round(x1,numDec));
        System.out.println( " x2 = " + round(x2,numDec));
        System.out.println( " y1: fx("+x1+")= " + round(y1,numDec));
        System.out.println( " y2: fx("+x2+")= " + round(y2,numDec));
        
        for(int i=1; i<=iterations;i++){            
            System.out.println("Iteración #"+i);
            if ( (y2-y1) == 0 ){
               System.err.println("Error: no converge x=NaN; iteración="+i);
               return null;
            }
            
            x3=(y2*x1-y1*x2)/(y2-y1);
            System.out.println(" x3 = (y2*x1-y1*x2)/(y2-y1)");
            System.out.println(" x3 = ((" + round(y2,numDec)+")*("+round(x1,numDec)+")-("+round(y1,numDec)+")*("+round(x2,numDec)+"))/(("+round(y2,numDec)+")-("+round(y1,numDec)+")) = " + round(x3,numDec) );
            
            System.out.println("Error |"+round(xp,numDec)+"/"+round(x3,numDec)+"-1|<"+round(err,numDec)  + "  " + (Math.abs(xp/x3-1)<err));
            if (Math.abs(xp/x3-1)<err){                
                System.out.println(round(Math.abs(xp/x3-1),numDec)+"<"+round(err,numDec) + " -> termina programa");
                return "Iteración:" + i + " Valor x=" + String.valueOf(x3);
            }
            
            y3 = fx(x3); 
            
            System.out.println(" y1 = " + round(y1,numDec));
            System.out.println(" y3 = fx(x3) = fx("+round(x3,numDec)+") = " + round(y3,numDec));
            System.out.println(" y1*y3 < 0 " + (y1*y3 < 0));
            if (y1*y3<0) {
                System.out.println("   x2=x3=" + round(x3,numDec));
                System.out.println("   y2=y3=" + round(y3,numDec));
                x2=x3;
                y2=y3;
            } else {
                System.out.println("   x1=x3=" + round(x3,numDec));
                System.out.println("   y1=y3=" + round(y3,numDec));
                x1=x3;
                y1=y3;
            }
            xp=x3;
        }
        return "";
        
    }
    
    /**
     * Redondea un numero al inmediato superior
     * @param valor numero a redondear
     * @param decimales cantidad de decimales a mostrar
     * @return double numero redondeado
     */
    private double round(double valor, int decimales){
        BigDecimal valueBD = new BigDecimal(valor);
        valueBD = valueBD.setScale(decimales, BigDecimal.ROUND_HALF_UP);
        return valueBD.doubleValue();
    }
        
    public static void main(String[] args){
        Regla_falsa regula_Falsi = new  Regla_falsa();        
        //String res = regula_Falsi.resolver(2.2, 6.5, 20, 0.0003);
        String res = regula_Falsi.resolver(2.2, 2.5, 20, 0.0003);
        System.out.println(res);
    }
}

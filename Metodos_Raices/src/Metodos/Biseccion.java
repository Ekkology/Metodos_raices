package Metodos;

public class Biseccion {
	
	      double a  , b, tol, p;
	      int ni;
	   
	 
	       public Biseccion(double a1, double b1, double tol1,
	            int ni1)
	      {
	         a = a1; b = b1; tol = tol1; ni = ni1;
	      }
	 
	       private double f(double x){
	         double r = x*x + 3*x -2;
	         return r;
	      }
	
	       public double calcularRaiz(){
	         double p=a; 
	         int i=1; 
	         double eps=1;
	      
	         while(f(p)!=0 & i<=ni & eps>tol){
	            double pa = p;
	            p = (a+b)/2;
	            if(f(p)*f(a)>0)
	               a=p;
	            else 
	               if(f(p)*f(b)>0)
	                  b=p;
	            i = i + 1;
	            eps = Math.abs(p-pa)/p;
	            System.out.println("Iteracion                  Xr                   Error");
                System.out.printf("%-10d               %f               %f",i,p,eps);
                System.out.print("\n");
	         }
	         return p;
	      }

}

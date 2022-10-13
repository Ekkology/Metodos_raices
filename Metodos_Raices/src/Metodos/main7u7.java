package Metodos;

import java.util.Scanner;

public class main7u7 {

	public static void main(String[] args) {
		
		
		System.out.println("Elige que método que deseas probar\n 1.Bisección \n 2.Regla Falsa \n 3.Secante ");
		int opcion = 0;
		Scanner leer = new Scanner(System.in);
		opcion = leer.nextInt();
		switch(opcion)
		{
		case 1:
			Biseccion c = new Biseccion(0,1,1e-5,20);
			System.out.println("La funcion es x^2 + 3*x -2;");
            System.out.println(" A = 0 y B = 1");
			double raiz = c.calcularRaiz();
			System.out.println("La raíz es: "+raiz);
			break;
		case 2:
			System.out.println("La funcion es x^2 + 3*x -2;");
            System.out.println(" A = 2.2 y B = 2.5");
			Regla_falsa regula_Falsi = new  Regla_falsa();        
	        String res = regula_Falsi.resolver(2.2, 2.5, 20, 0.0003);
	        System.out.println(res);
			break;
		case 3:
			Scanner s = new Scanner(System.in);
	        Secante MS = new Secante(s);
			break;
		}
       
    }
}

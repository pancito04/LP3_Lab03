package Actividad02;

public class ContadorTest {
	public static void main(String[] args) { 
		Contador c1, c2;
		c1 = new Contador (3); c2= new Contador (10);
		c1.inc();
		System.out.println(Contador.acumulador()); System.out.println(Contador.acumulador);
		c1.inc(); c2.inc();
		System.out.println(c1.getValor()); 
		System.out.println(c2.getValor());
	}
}

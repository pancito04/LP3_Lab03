package Ejercicio1;

public class Principal {

	public static void main(String[] args) {
		Coordenada coorE1R1 = new Coordenada(1,1);
		Coordenada coorE2R1 = new Coordenada(4,5);
		Rectangulo rectangulo1 = new Rectangulo(coorE1R1, coorE2R1);
		System.out.println(rectangulo1);
		Rectangulo rectangulo2 = new Rectangulo(coorE2R1, coorE1R1);
		System.out.println(rectangulo2);
		Rectangulo rectangulo3 = new Rectangulo(coorE1R1.getX(), coorE1R1.getY());
		System.out.println(rectangulo3);
	}
}

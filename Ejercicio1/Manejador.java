package Ejercicio1;

public class Manejador {
	public static int calcularArea(Rectangulo a) {
		return (a.getEsquina2().getX() - a.getEsquina1().getX()) * (a.getEsquina2().getY() - a.getEsquina1().getX());
		// La base del rectangulon es (a.getEsquina2().getX() - a.getEsquina1().getX()).
		// La altura del rectangulo es (a.getEsquina2().getY() - a.getEsquina1().getX()).
	}
	public static int calcularPerimetro(Rectangulo a) {
		return 2 * (a.getEsquina2().getX() - a.getEsquina1().getX()) + 2 * (a.getEsquina2().getY() - a.getEsquina1().getY()); 
		// La base del rectangulon es (a.getEsquina2().getX() - a.getEsquina1().getX()).
		// La altura del rectangulo es (a.getEsquina2().getY() - a.getEsquina1().getX()).
	}
	public static Rectangulo moverX(Rectangulo a, int x_) {
		int Ax1 = a.getEsquina1().getX();
		int Ax2 = a.getEsquina2().getX();
		a.getEsquina1().setX(Ax1 + x_);
		a.getEsquina2().setX(Ax2 + x_);
		return a;
	}
	public static Rectangulo moverY(Rectangulo a, int y_) {
		int Ay1 = a.getEsquina1().getY();
		int Ay2 = a.getEsquina2().getY();
		a.getEsquina1().setY(Ay1 + y_);
		a.getEsquina2().setY(Ay2 + y_);
		return a;
	}
}
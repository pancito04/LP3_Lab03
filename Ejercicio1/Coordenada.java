package Ejercicio1;

public class Coordenada {
	private int x;
	private int y;
	public Coordenada() {
		x = 0;
		y = 0;
	}
	public Coordenada(int x_, int y_) {
		x = x_;
		y = y_;
	}
	public Coordenada(Coordenada a) {
		x = a.x;
		y = a.y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x_) {
		x = x_;
	}
	public int getY() {
		return y;
	}
	public void setY(int y_) {
		y = y_;
	}
	public static double distancia(Coordenada a, Coordenada b) {
		return Math.sqrt(((a.y-a.x)*(a.y-a.x))+((b.y-b.x)*(b.y-b.x)));
	}
	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}
}

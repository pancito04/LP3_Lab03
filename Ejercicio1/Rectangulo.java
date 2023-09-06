package Ejercicio1;

public class Rectangulo {
	private Coordenada esquina1;
	private Coordenada esquina2;
	private String colorInstancia;
	private static String color = "verde";
	public Rectangulo(Coordenada a, Coordenada b) {
		esquina1=a;
		esquina2=b;
		colorInstancia=color;
		cambiarColor();
	}
	public Rectangulo(int base, int altura) {
		this.esquina1 = new Coordenada (0,0);
		this.esquina2 = new Coordenada(base, altura);
		colorInstancia=color;
		cambiarColor();
	}
	public Coordenada getEsquina1() {
		return esquina1;
	}
	public void setEsquina1(Coordenada esquina1) {
		this.esquina1 = esquina1;
	}
	public Coordenada getEsquina2() {
		return esquina2;
	}
	public void setEsquina2(Coordenada esquina2) {
		this.esquina2 = esquina2;
	}
	public static void cambiarColor() {
        if (color.equals("verde")) {
            color = "amarillo";
        } else if (color.equals("amarillo")) {
            color = "rojo";
        } else {
            color = "verde";
        }
    }
	public static String ultimoColor() {
		if (color.equals("verde")) {
			return "rojo";
		}else if (color.equals("amarillo")){
			return "verde";
		} else {
			return "amarillo";
		}
	}
	@Override
	public String toString() {
		return "Rectangulo [esquina1=" + esquina1 + ", esquina2=" + esquina2 + ", color de la Instancia= "+ colorInstancia + ", color de la Clase= " + color + " y ultimo color usado: " + ultimoColor() + "]";
	}
}

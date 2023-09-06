package Actividad02;

public class ContadorTest2 {
    public static void main(String[] args) {
        // Crear una instancia de Contador utilizando el constructor sin argumentos
        Contador contador1 = new Contador(10);
        System.out.println("Valor del contador 1: " + contador1.getValor()); // Debería imprimir 10
        
        // Crear una instancia de Contador utilizando el constructor con argumento
        Contador contador2 = new Contador(5);
        System.out.println("Valor del contador 2: " + contador2.getValor()); // Debería imprimir 5
        
        // Incrementar ambos contadores
        contador1.inc();
        contador2.inc();
        
        System.out.println("Valor del contador 1 después del incremento: " + contador1.getValor()); // Debería imprimir 11
        System.out.println("Valor del contador 2 después del incremento: " + contador2.getValor()); // Debería imprimir 6
        
        // Obtener el valor del acumulador estático
        int acumuladorStatic = Contador.acumulador();
        System.out.println("Valor del acumulador estático: " + acumuladorStatic); // Debería imprimir 17
    }
}

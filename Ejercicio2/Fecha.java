package Ejercicio2;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	// Primer constructor
	public Fecha() {
		dia = 1;
		mes = 1;
		anio = 1900;
		valida();
	}
	// Segundo constructor
	public Fecha(int dia_, int mes_, int anio_) {
		dia = dia_;
		mes = mes_;
		anio = anio_;
		valida();
	}
	// Metodo leer
    public void leer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el día (1-31): ");
        this.dia = scanner.nextInt();
        System.out.print("Ingrese el mes (1-12): ");
        this.mes = scanner.nextInt();
        System.out.print("Ingrese el año (1900-2050): ");
        this.anio = scanner.nextInt();
    }
    // Metodo bisiesto
    public boolean bisiesto() {
        return (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
    }
    // Metodo para retornar los dias de un mes
    public int diasMes(int mes) {
        int[] diasPorMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (mes == 2 && bisiesto()) {
            return 29;
        }
        return diasPorMes[mes - 1];
    }
    // Metodo para validar
    private void valida() {
        if (anio < 1900 || anio > 2050) {
            anio = 1900;
        }
        if (mes < 1 || mes > 12) {
            mes = 1;
        }
        int maxDias = diasMes(mes);
        if (dia < 1 || dia > maxDias) {
            dia = 1;
        }
    }
    // Metodos setters y getters o como se menciona en el ejercicio acceessors y mutators.
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
        valida();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
        valida();
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
        valida();
    }
    // Metodo para mostrar la fecha de forma corta (01-01-2000)
    public String corta() {
        // Utilizamos String.format() para formatear la fecha en formato corto
        return String.format("%02d-%02d-%04d", dia, mes, anio);
    }
    // Metodo para saber cuantos dias pasaron desde (1-1-1900) 
    // Se usa la libreria java.time.temporal.ChronoUnit y el metodo ChronoUnit.DAYS.between()
    public long diasTranscurridos() {
    	LocalDate fecha = LocalDate.of(anio, mes, dia);
        LocalDate fechaInicio = LocalDate.of(1900, 1, 1);
        return ChronoUnit.DAYS.between(fechaInicio, fecha);
    }
    // Metodo diaSemana()
    public int diaSemana() {
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        // DayOfWeek.LUNES tiene valor 1, DayOfWeek.MARTES tiene valor 2, y así sucesivamente
        return diaSemana.getValue() - 1;
    }
    public String larga() {
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy");
        return fecha.format(formatoLargo);
    }
    public void fechaTras(long dias) {
        LocalDate fechaActual = LocalDate.of(anio, mes, dia);
        LocalDate fechaNueva = fechaActual.plusDays(dias);
        this.dia = fechaNueva.getDayOfMonth();
        this.mes = fechaNueva.getMonthValue();
        this.anio = fechaNueva.getYear();
    }
    public long diasEntre(Fecha otraFecha) {
        LocalDate fecha1 = LocalDate.of(anio, mes, dia);
        LocalDate fecha2 = LocalDate.of(otraFecha.getAnio(), otraFecha.getMes(), otraFecha.getDia());
        return ChronoUnit.DAYS.between(fecha1, fecha2);
    }
    public void siguiente() {
        // Crear un objeto LocalDate a partir de la fecha actual
        LocalDate fechaActual = LocalDate.of(anio, mes, dia);
        
        // Calcular la fecha siguiente
        LocalDate fechaSiguiente = fechaActual.plusDays(1);
        
        // Actualizar los atributos de la clase con la nueva fecha
        this.dia = fechaSiguiente.getDayOfMonth();
        this.mes = fechaSiguiente.getMonthValue();
        this.anio = fechaSiguiente.getYear();
    }
    public void anterior() {
        // Crear un objeto LocalDate a partir de la fecha actual
        LocalDate fechaActual = LocalDate.of(anio, mes, dia);
        
        // Calcular la fecha anterior
        LocalDate fechaAnterior = fechaActual.minusDays(1);
        
        // Actualizar los atributos de la clase con la nueva fecha
        this.dia = fechaAnterior.getDayOfMonth();
        this.mes = fechaAnterior.getMonthValue();
        this.anio = fechaAnterior.getYear();
    }
    public void fechaFutura(long dias) {
        // Crear un objeto LocalDate a partir de la fecha actual
        LocalDate fechaActual = LocalDate.of(anio, mes, dia);
        
        // Calcular la fecha futura
        LocalDate fechaFutura = fechaActual.plusDays(dias);
        
        // Actualizar los atributos de la clase con la nueva fecha
        this.dia = fechaFutura.getDayOfMonth();
        this.mes = fechaFutura.getMonthValue();
        this.anio = fechaFutura.getYear();
    }
    public Fecha copia() {
        return new Fecha(dia, mes, anio);
    }
    public static boolean igualQue(Fecha fecha1, Fecha fecha2) {
        return fecha1.getDia() == fecha2.getDia() &&
               fecha1.getMes() == fecha2.getMes() &&
               fecha1.getAnio() == fecha2.getAnio();
    }
    public static boolean menorQue(Fecha fecha1, Fecha fecha2) {
        if (fecha1.getAnio() < fecha2.getAnio()) {
            return true;
        } else if (fecha1.getAnio() == fecha2.getAnio()) {
            if (fecha1.getMes() < fecha2.getMes()) {
                return true;
            } else if (fecha1.getMes() == fecha2.getMes()) {
                return fecha1.getDia() < fecha2.getDia();
            }
        }
        return false;
    }
    public static boolean mayorQue(Fecha fecha1, Fecha fecha2) {
        if (fecha1.getAnio() > fecha2.getAnio()) {
            return true;
        } else if (fecha1.getAnio() == fecha2.getAnio()) {
            if (fecha1.getMes() > fecha2.getMes()) {
                return true;
            } else if (fecha1.getMes() == fecha2.getMes()) {
                return fecha1.getDia() > fecha2.getDia();
            }
        }
        return false;
    }

	@Override
	public String toString() {
		return "Fecha [" + dia + "-" + mes + "-" + anio + "]";
	}   
}
package aplicacion.modelo.pojo;

public class TimeData {
	private int segundos = 0;
	private int minutos = 0;
	private int horas = 0;
	private int dias = 0;
	private int meses = 0;
	private int years = 0;

	public TimeData(int segundos, int minutos, int horas, int dias, int meses, int years) {
		this.segundos = segundos;
		this.minutos = minutos;
		this.horas = horas;
		this.dias = dias;
		this.meses = meses;
		this.years = years;
	}

	public int getSegundos() {
		return segundos;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getHoras() {
		return horas;
	}

	public int getDias() {
		return dias;
	}

	public int getYears() {
		return years;
	}

	public int getMeses() {
		return meses;
	}

	/***
	 * Muestra los datos
	 */
	@Override
	public String toString() {
		return years + " años, " + meses + " meses, " + dias + " dias, " + horas + " horas, " + minutos + " minutos y "
				+ segundos + " segundos";

	}
}

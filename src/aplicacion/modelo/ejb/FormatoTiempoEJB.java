package aplicacion.modelo.ejb;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.pojo.TimeData;

@Stateless
@LocalBean
public class FormatoTiempoEJB {

	private TimeData timeData;

	/***
	 * Formatea los segundos en años, meses, días, horas, minutos y segundos y los
	 * guarda en el objeto timeData
	 * 
	 * @param s Segundos que tardaría
	 */
	public void setTiempo(BigDecimal s) {
		BigDecimal segundosTotal = s;
		int segundos = segundosTotal.remainder(new BigDecimal(60)).intValue();
		segundosTotal = segundosTotal.divide(new BigDecimal(60), RoundingMode.HALF_UP);
		int minutos = segundosTotal.remainder(new BigDecimal(60)).intValue();
		segundosTotal = segundosTotal.divide(new BigDecimal(60), RoundingMode.HALF_UP);
		int horas = segundosTotal.remainder(new BigDecimal(24)).intValue();
		segundosTotal = segundosTotal.divide(new BigDecimal(24), RoundingMode.HALF_UP);
		int dias = segundosTotal.remainder(new BigDecimal(30)).intValue();
		segundosTotal = segundosTotal.divide(new BigDecimal(30), RoundingMode.HALF_UP);
		int meses = segundosTotal.remainder(new BigDecimal(12)).intValue();
		int years = segundosTotal.divide(new BigDecimal(12), RoundingMode.HALF_UP).intValue();

		this.timeData = new TimeData(segundos, minutos, horas, dias, meses, years);
	}

	/***
	 * Obtiene el objeto timeData
	 * 
	 * @return timeData
	 */
	public TimeData getTimeData() {
		return timeData;
	}

}

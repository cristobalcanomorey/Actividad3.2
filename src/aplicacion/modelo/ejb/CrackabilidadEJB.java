package aplicacion.modelo.ejb;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Hashtable;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless(mappedName = "CrackabilidadEJB")
@LocalBean
public class CrackabilidadEJB {

	@EJB
	private FormatoTiempoEJB tiempoQTarda;
	private Hashtable<String, Integer> procesadores = new Hashtable<String, Integer>() {
		private static final long serialVersionUID = 1L;
		{
			put("cpu", 1000);
			put("gpu", 12000);
			put("grid", 1500000);
		}
	};
	private String tipoDeProcesador = "";

	/***
	 * Calcula el tiempo que se tardaría en forzar la contraseña con ese tipo de
	 * procesador
	 * 
	 * @param password       Contraseña que escribe el usuario
	 * @param tipoProcesador Procesador que selecciona el usuario
	 * @return String con el tiempo que tardaría
	 */
	public String calcularTiempo(String password, String tipoProcesador) {
		Set<String> keys = procesadores.keySet();

		for (String key : keys) {
			if (key.equals(tipoProcesador)) {
				this.tipoDeProcesador = tipoProcesador;
				break;
			}
		}
		this.tiempoQTarda.setTiempo(calculo(password.length()));
		return this.tiempoQTarda.getTimeData().toString();
	}

	/***
	 * Calcula lo que tardaría el procesador en forzar la contraseña
	 * 
	 * @param longitudPassword Tamaño de la contraseña
	 * @return Los segundos que tardaría
	 */
	public BigDecimal calculo(int longitudPassword) {
		BigDecimal combinaciones = new BigDecimal(Math.pow(256, longitudPassword));
		int div = procesadores.get(tipoDeProcesador);
		BigDecimal segundos = combinaciones.divide(new BigDecimal(div), RoundingMode.HALF_UP);
		return segundos;
	}
}

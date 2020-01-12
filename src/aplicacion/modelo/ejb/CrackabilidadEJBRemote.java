package aplicacion.modelo.ejb;

import java.math.BigDecimal;

import javax.ejb.Remote;

@Remote
public interface CrackabilidadEJBRemote {
	public String calcularTiempo(String password, String tipoProcesador);

	public BigDecimal calculo(int longitudPassword);
}

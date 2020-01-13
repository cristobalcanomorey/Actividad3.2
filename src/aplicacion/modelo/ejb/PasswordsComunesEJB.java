package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless(mappedName = "PasswordsComunesEJB")
@LocalBean
public class PasswordsComunesEJB {

	private ArrayList<String> passwordsComunes = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("123456");
			add("123456789");
			add("qwerty");
			add("password");
			add("111111");
			add("12345678");
			add("abc123");
			add("1234567");
			add("password1");
		}
	};

	/***
	 * Busca la contraseña en el array de passwords comunes.
	 * 
	 * @param password Contraseña del usuario
	 * @return True si es comun, false si no lo es
	 */
	public boolean esComun(String password) {
		for (String pas : passwordsComunes) {
			if (pas.equals(password)) {
				return true;
			}
		}
		return false;
	}
}

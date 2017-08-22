package me.joezwet.gameapis.mc.exceptions;

/**
 * 
 * @author JoeZwet
 *
 */
public class QueryDisabledException extends Exception {

	private static final long serialVersionUID = 1211910561652855381L;

	public QueryDisabledException() {
	}

	public QueryDisabledException(String message) {
		super(message);
	}

}

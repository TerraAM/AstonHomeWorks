package main.java.lesson12.custom.errors;

public class MyArraySizeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8851668214364540548L;

	public MyArraySizeException(String message) {
        super(message);
	}
	
}
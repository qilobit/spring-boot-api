package controller;

public class HeadphoneNotFoundException extends RuntimeException{
	public HeadphoneNotFoundException(Long id) {
	    super("Could not find headphone " + id);
	  }
}

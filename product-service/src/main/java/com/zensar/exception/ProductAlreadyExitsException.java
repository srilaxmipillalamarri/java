package com.zensar.exception;

public class ProductAlreadyExitsException extends RuntimeException {
	private String message;
	public ProductAlreadyExitsException() {
	}
	
		public ProductAlreadyExitsException(String msg) {
			super(msg);
	        this.message = msg;
	    }
		
	}



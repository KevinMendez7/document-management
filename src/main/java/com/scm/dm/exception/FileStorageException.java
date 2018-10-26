package com.scm.dm.exception;

public class FileStorageException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8080978816931003466L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }

}

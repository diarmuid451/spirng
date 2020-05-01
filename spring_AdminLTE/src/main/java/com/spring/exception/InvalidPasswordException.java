package com.spring.exception;

public class InvalidPasswordException extends Exception {
	
	public InvalidPasswordException() {
		super("비밀번호가 맞지 않습니다.");
	}
}

package br.com.ideiasaleatorias.eleicaoonline.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static String hash(String password){
		return new BCryptPasswordEncoder().encode(password);
	}
}

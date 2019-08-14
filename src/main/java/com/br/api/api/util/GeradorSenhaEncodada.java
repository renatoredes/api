package com.br.api.api.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenhaEncodada {

	public static void main(String[] args) {
		BCryptPasswordEncoder geraSenhaEncodada = new BCryptPasswordEncoder();
		System.out.println(geraSenhaEncodada.encode("admin"));
		
	}

}

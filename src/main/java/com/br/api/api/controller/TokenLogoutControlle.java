package com.br.api.api.controller;
/*
 * @author Renato Ferreira
 * 
 * Classe responsavel pelo logaut do token, remover o valor do refreshToken 
 * 
 */

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.api.config.cookie.property.ApiProperty;

@RestController
@RequestMapping("/tokens")
public class TokenLogoutControlle {

	@Autowired
	private ApiProperty apiproperty;
	
		@DeleteMapping("/revoke")
		private void revoke(HttpServletRequest req, HttpServletResponse resp) {
			Cookie cookie = new Cookie("refreshToken", null);
			cookie.setHttpOnly(true);
			cookie.setSecure(apiproperty.getSeguranca().isEnableHttps()); // Em produção será true
			cookie.setPath(req.getContextPath() + "/oauth/token");
			/*valor zero faz com que o cookie seja excluído. */
			cookie.setMaxAge(0);
			
			resp.addCookie(cookie);
			resp.setStatus(HttpStatus.NO_CONTENT.value());
			
		}
	
}

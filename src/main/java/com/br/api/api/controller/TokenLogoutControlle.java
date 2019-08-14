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

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tokens")
public class TokenLogoutControlle {

		@DeleteMapping("/revoke")
		private void revoke(HttpServletRequest req, HttpServletResponse resp) {
			Cookie cookie = new Cookie("refreshToken", null);
			cookie.setHttpOnly(true);
			cookie.setSecure(false); //TODO : Em produção será true
			cookie.setPath(req.getContextPath() + "/oauth/token");
			/*valor zero faz com que o cookie seja excluído. */
			cookie.setMaxAge(0);
			
			resp.addCookie(cookie);
			resp.setStatus(HttpStatus.NO_CONTENT.value());
			
		}
	
}

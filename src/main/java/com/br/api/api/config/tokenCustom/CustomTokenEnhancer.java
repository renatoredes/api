package com.br.api.api.config.tokenCustom;


import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.br.api.api.util.UsuarioSistema;



/*Customiza o token para pegar usuario logado no sistema*/
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        /*getPrincipal pega usuario logado*/
            UsuarioSistema usuarioSistema = (UsuarioSistema) authentication.getPrincipal();
            
            Map<String, Object> addInfo = new HashMap<>();
            addInfo.put("nome", usuarioSistema.getUsuario().getNome());
            
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
            return accessToken;
    }

}
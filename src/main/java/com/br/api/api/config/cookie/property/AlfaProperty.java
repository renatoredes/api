package com.br.api.api.config.cookie.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*Classe responsável pelas configurações de propriedades, Profiles Spring
 * Habilita a segurança do refresh token para true ou seja em produção será https e em teste será false*/

@ConfigurationProperties("alfa") // apialfa é o nome para essa configuração
public class AlfaProperty {

	private String originPermitida = "http://localhost:8000";

	private final Seguranca seguranca = new Seguranca();

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

	public static class Seguranca {

		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}

	}
}

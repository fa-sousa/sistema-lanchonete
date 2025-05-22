package com.lanchonete.config;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MercadoPagoConfig {

    @Value("${mercadopago.access.token}")
    private String accessToken;

    @PostConstruct
    public void init() {
        try {
			MercadoPago.SDK.setAccessToken(accessToken);
		} catch (MPConfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

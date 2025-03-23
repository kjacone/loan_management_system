package com.credable.app.middleware_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;


@Configuration
public class SoapConfig {



    @Value("${transaction.api.url}")  // wsdl endpoint for transactions
    private String transactionApiUrl;


    @Bean
    public Jaxb2Marshaller transactionMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.credable.app.middleware_service.generated");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate transactionWebServiceTemplate(Jaxb2Marshaller transactionMarshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(transactionMarshaller);
        webServiceTemplate.setUnmarshaller(transactionMarshaller);
        webServiceTemplate.setDefaultUri(transactionApiUrl);
        return webServiceTemplate;
    }


}

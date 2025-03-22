package com.credable.app.lms_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;


@Configuration
public class SoapConfig {

    @Value("${kyc.api.url}") //wsdl endpoint to core-kyc service
    private String kycApiUrl;

    @Bean
    public Jaxb2Marshaller kycMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.credable.app.shared.generated.customer");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate kycWebServiceTemplate(Jaxb2Marshaller kycMarshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(kycMarshaller);
        webServiceTemplate.setUnmarshaller(kycMarshaller);
        webServiceTemplate.setDefaultUri(kycApiUrl);
        return webServiceTemplate;
    }


}

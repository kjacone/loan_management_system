package com.credable.app.lms_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HttpContext;

@Configuration
public class SoapConfig {

    @Value("${kyc.api.url}") //wsdl endpoint to core-kyc service
    private String kycApiUrl;

    // Add values for credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "pwd123";

    @Bean
    public Jaxb2Marshaller kycMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.credable.app.lms_service.generated");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate kycWebServiceTemplate(Jaxb2Marshaller kycMarshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(kycMarshaller);
        webServiceTemplate.setUnmarshaller(kycMarshaller);
        webServiceTemplate.setDefaultUri(kycApiUrl);

        // Configure message sender with authentication
        webServiceTemplate.setMessageSender(httpComponentsMessageSender());

        return webServiceTemplate;
    }

    @Bean
    public HttpComponentsMessageSender httpComponentsMessageSender() {
        HttpComponentsMessageSender messageSender = new HttpComponentsMessageSender();

        HttpClientBuilder clientBuilder = HttpClientBuilder.create();

        // Add authentication interceptor
        clientBuilder.addInterceptorFirst(new HttpRequestInterceptor() {
            @Override
            public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(USERNAME, PASSWORD);
                request.addHeader(BasicScheme.authenticate(credentials, "UTF-8", false));
            }
        });

        messageSender.setHttpClient(clientBuilder.build());
        return messageSender;
    }
}
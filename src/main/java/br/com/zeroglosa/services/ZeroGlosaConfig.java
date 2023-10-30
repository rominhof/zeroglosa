package br.com.zeroglosa.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ZeroGlosaConfig {

    @Value("${amigo.url}")
    private String getUrlAmigo;

    @Value("${amigo.login}")
    private String getLoginAmigo;

    @Value("${amigo.passwd}")
    private String getSenhaAmigo;

}


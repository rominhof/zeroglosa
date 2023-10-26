package br.com.zeroglosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"br.com.zeroglosa.zeroglosa.controllers.*", "br.com.zeroglosa.zeroglosa.services.*", "br.com.zeroglosa.zeroglosa.repositories.*"})
public class ZeroglosaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeroglosaApplication.class, args);
    }

}

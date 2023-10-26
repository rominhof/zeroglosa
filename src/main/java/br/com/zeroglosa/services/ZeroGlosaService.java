package br.com.zeroglosa.services;

import br.com.zeroglosa.repositories.ZeroGlosaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZeroGlosaService {

    @Autowired
    private ZeroGlosaRepository zeroGlosaRepository;


    public String teste(){
        zeroGlosaRepository.findAll();
        return "teste";
    }
}

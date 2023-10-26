package br.com.zeroglosa.controllers;

import br.com.zeroglosa.services.ZeroGlosaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zeroglosa")
public class ZeroGlosaController {

    @Autowired
    private ZeroGlosaService zeroGlosaService;

    @GetMapping
    public String test(){
        return zeroGlosaService.teste();
    }

}

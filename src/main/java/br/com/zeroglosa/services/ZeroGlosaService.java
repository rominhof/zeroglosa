package br.com.zeroglosa.services;

import br.com.zeroglosa.component.ZeroGlosaSelenium;
import br.com.zeroglosa.repositories.ZeroGlosaRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.time.Duration;

@Service
public class ZeroGlosaService {

    @Autowired
    private ZeroGlosaRepository zeroGlosaRepository;

    @Autowired
    private ZeroGlosaConfig zeroGlosaConfig;

    @Autowired
    private ZeroGlosaSelenium zeroGlosaSelenium;

    public String teste(){
        String email_xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div/div[1]/input";
        String pass_xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div/div[2]/div/input";
        String xpathTelaInicial = "/html/body/div[1]/div/div/div[1]/div[1]/h2";

        String submit_xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div/div[3]/button";

        zeroGlosaSelenium.openUrl(zeroGlosaConfig.getGetUrlAmigo());
        String telaInicial = zeroGlosaSelenium.getCurrentWindow();
        zeroGlosaSelenium.goToTab(telaInicial);

        zeroGlosaSelenium.waitScreenSeconds(30,email_xpath);
        zeroGlosaSelenium.clickElementXpath(email_xpath);
        zeroGlosaSelenium.textElementXpath(email_xpath, zeroGlosaConfig.getGetLoginAmigo());
        zeroGlosaSelenium.clickElementXpath(pass_xpath);
        zeroGlosaSelenium.textElementXpath(pass_xpath, zeroGlosaConfig.getGetSenhaAmigo());

//        zeroGlosaSelenium.clickElementXpath(, submit_xpath);
//        zeroGlosaSelenium.waitScreenSeconds(, 30,xpathTelaInicial);


        return "OK";
    }

}

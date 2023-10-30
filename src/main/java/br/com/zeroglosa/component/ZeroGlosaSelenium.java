package br.com.zeroglosa.component;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

@Component
public class ZeroGlosaSelenium {

    private static final String CHROMEDRIVER_EXE = "chromedriver.exe";
    protected WebDriver driver;

    @PostConstruct
    public void init() {
        if (driver == null) {
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(findFile()))
                    .build();
            ChromeOptions options = getChromeOptions();
            driver = new ChromeDriver(service, options);
        }
    }

    private String findFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(CHROMEDRIVER_EXE);
        return url.getFile();
    }

    public void openUrl(String url) {
        this.driver.get(url);
        ((JavascriptExecutor) driver).executeScript("window.focus();");
    }

    public String getCurrentWindow() {
        return this.driver.getWindowHandle();
    }

    public String openTab() {
        return String.valueOf(this.driver.switchTo().newWindow(WindowType.TAB));
    }

    public void goToTab(String tab) {
        this.driver.switchTo().window(tab);
    }

    public void clickElementXpath(String element) {
        this.driver.findElement(By.xpath(element)).click();
    }

    public void textElementXpath(String element, String text) {
        this.driver.findElement(By.xpath(element)).sendKeys(text);
    }

    public void waitScreenSeconds(int secods, String element){
        WebDriverWait wait = new WebDriverWait (this.driver, Duration.ofSeconds(secods));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
//        options.addArguments("--headless");
        options.setExperimentalOption("detach", true);
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        return options;
    }
}


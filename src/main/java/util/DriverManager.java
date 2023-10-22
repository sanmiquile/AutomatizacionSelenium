package util;

import org.openqa.selenium.WebDriver;

public enum DriverManager {
    INSTANCE;

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}

package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {
    private RemoteWebDriver driver;
    private Properties properties;

    public RemoteWebDriver setup() throws MalformedURLException {
        properties = PropertyReader.getProperties();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking"); // Move from caps to options
        options.addArguments("--start-maximized"); // Optional, but useful

        // Set capabilities directly in ChromeOptions
        options.setCapability("unexpectedAlertBehaviour", "accept");
        options.setCapability("ignoreProtectedModeSettings", true);
        options.setCapability("enablePersistentHover", true);
        options.setCapability("ignoreZoomSetting", true);
        options.setCapability("nativeEvents", false);

        // Pass ChromeOptions directly to RemoteWebDriver
        driver = new RemoteWebDriver(new URL(properties.getProperty(PropertyEnum.APP_URL.toString())), options);
        return driver;
    }
}
//
//public class WebDriverFactory {
//
//    RemoteWebDriver driver;
//    Properties properties = new Properties();
//
//    public RemoteWebDriver setup() throws MalformedURLException {
//
//            properties = PropertyReader.getProperties();
//            new DesiredCapabilities();
//            DesiredCapabilities caps = DesiredCapabilities.chrome();
//
//            caps.setCapability("nativeEvents", false);
//            caps.setCapability("unexpectedAlertBehaviour", "accept");
//            caps.setCapability("ignoreProtectedModeSettings", true);
//            caps.setCapability("disable-popup-blocking", true);
//            caps.setCapability("enablePersistentHover", true);
//            caps.setCapability("ignoreZoomSetting", true);
//
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--lang=en");
//            options.addArguments("--ignore-certificate-errors");
//            caps.setCapability(ChromeOptions.CAPABILITY, options);
//            driver = new RemoteWebDriver(caps);
//            driver.get(properties.getProperty(PropertyEnum.APP_URL.toString()));
//            return driver;
//
//
//    }
//
//
//}

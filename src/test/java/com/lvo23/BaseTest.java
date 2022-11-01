package com.lvo23;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.lvo23.helpers.AllureAttachments;

import io.qameta.allure.selenide.AllureSelenide;

/**
 * @author Vlad Litvinov
 */
public class BaseTest {

    /**
     * метод сет-ап, который выполнится перед всеми тестами
     */
    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";

        // определеяем property – берём из командной строки или дефолт
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browser = System.getProperty("browserVersion", "100");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        if (System.getProperty("remote") != null) {
            Configuration.remote = System.getProperty("remote");
        }
    }

    @AfterEach
    void addAttachments() {

        AllureAttachments.screenshotAs("Последний скриншот");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
    }

}

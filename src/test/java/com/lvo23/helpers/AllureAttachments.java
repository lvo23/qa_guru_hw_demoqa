package com.lvo23.helpers;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.codeborne.selenide.Selenide;

import io.qameta.allure.Attachment;

/**
 * @author Vlad Litvinov вспомогательный класс для аттачей в аллюре (картинка, видео итд)
 */
public class AllureAttachments {

    /**
     * базовый урл для генерации видео
     */
    private static final String VIDEO_URL = "https://selenoid.autotests.cloud/video/";

    /**
     * формат для генерации видео
     */
    private static final String VIDEO_FORMAT = ".mp4";

    /**
     * cделать скриншот
     * 
     * @param attachName
     *            имя для аттача
     * @return скрин в виде массива байт
     */
    @Attachment(value = "{attachName}",
            type = "image/png")
    public static byte[] screenshotAs(String attachName) {

        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * сделать исходный код страницы
     * 
     * @return исходный код страницы в виде массива байт
     */
    @Attachment(value = "Page source",
            type = "text/plain")
    public static byte[] pageSource() {

        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    /**
     * сделать аттач в виде текста
     * 
     * @param attachName
     *            название аттача
     * @param message
     *            само сообщение аттача
     * @return строка с текстом аттача
     */
    @Attachment(value = "{attachName}",
            type = "text/plain")
    public static String attachAsText(String attachName, String message) {

        return message;
    }

    /**
     * сделать аттач с логами из консоли
     */
    public static void browserConsoleLogs() {

        attachAsText("Browser console logs",
                String.join("\n", Selenide.getWebDriverLogs(BROWSER)));
    }

    /**
     * сделать аттач видео
     * 
     * @return строка с html, в которой будет содержаться урл с видео
     */
    @Attachment(value = "Video",
            type = "text/html",
            fileExtension = ".html")
    public static String addVideo() {

        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getVideoUrl() + "' type='video/mp4'></video></body></html>";
    }

    /**
     * сгенерировать урл видео
     * 
     * @return
     */
    public static URL getVideoUrl() {

        String videoUrl = VIDEO_URL + getSessionId() + ".mp4";

        try {
            return new URL(videoUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * получить сессию тестов
     * 
     * @return строка с сессией тестов в виде uuid
     */
    public static String getSessionId() {

        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }

}

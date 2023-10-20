package jiraui.utils;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.screenshot;

public class AllureScreenshoter {
    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] attachScreenshotPNG() {
            return screenshot(OutputType.BYTES);
    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public static byte[] attachElemScreenshotPNG(SelenideElement elem) {
        return elem.getScreenshotAs(OutputType.BYTES);
    }
}

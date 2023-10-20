package jiraui.steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import jiraui.config.Properties;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static jiraui.utils.AllureScreenshoter.attachScreenshotPNG;

public class DashboardSteps {
    private static Properties properties = Properties.properties;
    @Step("Открыть главную страницу")
    public static void openMainPage() {
        Selenide.open(properties.baseUrl());
        getWebDriver().manage().window().maximize();
        attachScreenshotPNG();
    }
}

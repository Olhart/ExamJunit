package jiraui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import jiraui.config.Properties;
import jiraui.elements.MainPanelElements;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static jiraui.utils.AllureScreenshoter.attachElemScreenshotPNG;
import static jiraui.utils.AllureScreenshoter.attachScreenshotPNG;

public class MainPanelSteps extends MainPanelElements {
    private static Properties properties = Properties.properties;

    @Step("Проверить, что доступен пользовательский профиль")
    public static void checkVisibleUserProfile() {
        Selenide.sleep(3000);
        Assertions.assertTrue(profileMenuLink.exists());
        attachElemScreenshotPNG(profileMenuLink);
    }

    @Step("Перейти в проект {projectName} через поиск на главной панели")
    public static void goToTestProject(String projectName) {
        searchInput.shouldBe(Condition.enabled).click();
        searchInput.sendKeys(projectName);
        testProjectLinkInQuickSearchResult.shouldBe(Condition.enabled).click();
        String resultUrl = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(resultUrl.contains(properties.testProjectUrl()));
        attachScreenshotPNG();
    }

    @Step("Перейти в на страницу задачи {targetTaskName} через поиск на главной панели")
    public static void goToTeslSeleniumBugTask(String targetTaskName, String targetTaskCode) {
        searchInput.shouldBe(Condition.enabled).click();
        searchInput.sendKeys(targetTaskName);
        testSeleniumBugLinkInQuickSearchResult.shouldBe(Condition.enabled).click();
        String resultUrl = getWebDriver().getCurrentUrl();
        Assertions.assertTrue(resultUrl.contains(properties.cardTaskPrefixUrl() + targetTaskCode));
        attachScreenshotPNG();
    }

    @Step("На панели меню нажать кнопку \"Создать\"")
    public static void clickOnCreateButton() {
        createButton.shouldBe(Condition.enabled).click();
        attachScreenshotPNG();
    }

    @Step("Выйти из профиля через меню профиля")
    public static void logout() {
        profileMenuLink.shouldBe(Condition.enabled).click();
        logoutLink.shouldBe(Condition.enabled).click();
        attachScreenshotPNG();
    }
}

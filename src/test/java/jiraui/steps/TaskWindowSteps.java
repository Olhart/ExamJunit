package jiraui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;
import jiraui.elements.TaskWindowElements;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static jiraui.utils.AllureScreenshoter.attachScreenshotPNG;

public class TaskWindowSteps extends TaskWindowElements {

    static void _setTaskStatus(SelenideElement StatusLink) {
        StatusLink.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        Selenide.sleep(3000);
    }

    @Step("Нажать кнопку \"В работе\"")
    public static void setInWorkTaskStatus() {
        _setTaskStatus(inWorkStatusLink);
        checkTaskStatus("В работе");
        attachScreenshotPNG();
    }

    @Step("Нажать кнопку \"Сделать\"")
    public static void setNeedToDoTaskStatus() {
        _setTaskStatus(needToDoStatusLink);
        checkTaskStatus("Сделать");
        attachScreenshotPNG();
    }

    @Step("Нажать кнопку \"Бизнес-процесс\", далее нажать \"Готово\"")
    public static void setResolvedStatusLinkTaskStatus() {
        workFlowBarLink.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        _setTaskStatus(resolvedStatusLink);
        checkTaskStatus("Готово");
        attachScreenshotPNG();
    }

    @Step("Считать статус задачи")
    private static String getTaskStatus() {
        return taskStatus.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText().trim();
    }

    @Step("Проверить, что статус задачи \"{expectedStatus}\"")
    public static void checkTaskStatus(String expectedStatus) {
        String status = getTaskStatus();
        Assertions.assertEquals(status.toLowerCase(), expectedStatus.toLowerCase());
    }

    @Step("Считать статус значения поля \"Исправить в версиях\"")
    private static String getFixVersion() {
        return fixVersionLink.shouldBe(Condition.visible, Duration.ofSeconds(10)).getText().trim();
    }

    @Step("Проверить, что статус значения поля равен \"{expectedVersion}\"")
    public static void checkFixVersion(String expectedVersion) {
        String fixVersion = getFixVersion();
        Assertions.assertEquals(fixVersion.toLowerCase(), expectedVersion.toLowerCase());
    }
}
package jiraui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import jiraui.config.Properties;
import jiraui.elements.IssuesListElements;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static jiraui.utils.AllureScreenshoter.attachElemScreenshotPNG;
import static jiraui.utils.AllureScreenshoter.attachScreenshotPNG;

public class IssuesListSteps extends IssuesListElements {
    private static Properties properties = Properties.properties;
    @Step("Получить число задач")
    public static void getNumberOfTasks() {
        String strWithNumberOfTask = numbersOfTasks.shouldBe(Condition.visible).getText();
        String[] arrayWithNumberOfTask = strWithNumberOfTask.trim().split(" ");
        String strNumberOfTask = arrayWithNumberOfTask[arrayWithNumberOfTask.length - 1];
        checkNumberOfTask(strNumberOfTask);
        attachElemScreenshotPNG(numbersOfTasks);
    }

    @Step("Проверить , что это целое положительное число")
    public static void checkNumberOfTask(String strNumberOfTask) {
        int numberOfTask = Integer.parseInt(strNumberOfTask);
        Assertions.assertTrue(numberOfTask >= 0);
    }

    @Step("Открыть страницу моей последней открытой задачи")
    public static void goToMyLastOpenTask() {
        Selenide.open(properties.testProjectUrl() + "?filter=reportedbyme");
        myFirstOpenTaskLink.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
        attachScreenshotPNG();
    }
}

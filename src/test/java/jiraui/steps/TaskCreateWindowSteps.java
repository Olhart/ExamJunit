package jiraui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import jiraui.elements.TaskCreateWindowElements;
import jiraui.utils.FormData;
import org.junit.jupiter.api.Assertions;

import static jiraui.utils.AllureScreenshoter.attachElemScreenshotPNG;
import static jiraui.utils.AllureScreenshoter.attachScreenshotPNG;

public class TaskCreateWindowSteps extends TaskCreateWindowElements {
    @Step("Кликнуть в поле ввода и напечатать {value}")
    private static void _setValueInInput(SelenideElement element, String value) {
        element.shouldBe(Condition.enabled).doubleClick().sendKeys(value);
        Assertions.assertEquals(element.shouldBe(Condition.enabled).getValue(), value);
    }

    @Step("Кликнуть в поле ввода и напечатать {value}")
    private static void _setTextAreaByText(SelenideElement buttonText, SelenideElement textArea, String value) {
        buttonText.shouldBe(Condition.enabled).click();
        textArea.shouldBe(Condition.enabled).click();
        textArea.sendKeys(value);
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Установить тип задачи \"{taskType}\"")
    private static void setTaskType(String taskType) {
        _setValueInInput(taskTypeInput, taskType);
    }

    @Step("Установить приоритет \"{taskPriority}\"")
    private static void setTaskPriority(String taskPriority) {
        _setValueInInput(taskPriorityInput, taskPriority);
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Ввести тег(и) \"{tag}\"")
    private static void setTags(String tag) {
        tagsInput.sendKeys(tag + " ");
    }


    private static void setTags(String[] tags) {
        tagsInput.shouldBe(Condition.enabled).click();
        for (String tag : tags) {
            setTags(tag);
        }
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Выбрать Исправить в версиях \"Version2.0\"")
    private static void clickFixVersionAsVersion_2_0() {
        fixVersionsOptVersion_2_0.shouldBe(Condition.visible).click();
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Выбрать Затронуты версии \"Version2.0\"")
    private static void clickAffectedVersionAsVersion_2_0() {
        affectedVersionsOptVersion_2_0.shouldBe(Condition.visible).click();
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Ввести название задачи {topicName}")
    private static void setTopicInput(String topicName) {
        _setValueInInput(topicNameInput, topicName);
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Ввести описание: \n{description}")
    private static void setDescriptionAsText(String description) {
        _setTextAreaByText(descriptionButtonText, descriptionTextArea, description);
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Ввести описание окружения: \n{description}")
    private static void setEnvAsText(String description) {
        _setTextAreaByText(envButtonText, envTextArea, description);
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Исполнителем выбрать себя")
    private static void clickAssignMeAsAssignee() {
        assignMeButton.shouldBe(Condition.enabled).click();
        attachElemScreenshotPNG(taskFrame);
    }

    @Step("Нажать кнопку \"Создать\"")
    public static void clickSubmit() {
        submitInput.shouldBe(Condition.enabled).click();
        attachScreenshotPNG();
    }

    @Step("Заполнить форму создания задачи")
    public static void fillOutFormOfTaskWithVer2(FormData formData) {
        setTaskType(formData.getField("Тип задачи"));
        setTopicInput(formData.getField("Тема"));
        clickFixVersionAsVersion_2_0();
        clickAffectedVersionAsVersion_2_0();
        setTaskPriority(formData.getField("Приоритет"));
        setTags(formData.getField("Метки").split(" "));
        setDescriptionAsText(formData.getField("Описание"));
        setEnvAsText(formData.getField("Окружение"));
        clickAssignMeAsAssignee();
    }
}

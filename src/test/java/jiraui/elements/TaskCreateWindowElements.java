package jiraui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskCreateWindowElements {
    public static SelenideElement taskTypeInput = $x("//input[@id='issuetype-field']");
    public static SelenideElement submitInput = $x("//input[@id='create-issue-submit']");
    public static SelenideElement topicNameInput = $x("//input[@id='summary']");
    public static SelenideElement tagsInput = $x("//textarea[@id='labels-textarea']");
    public static SelenideElement fixVersionsOptVersion_2_0 = $x("//select[@id='fixVersions']//child::optgroup//child"
            + "::option[normalize-space(text()) = 'Version 2.0']");
    public static SelenideElement affectedVersionsOptVersion_2_0 = $x("//select[@id='versions']//child::optgroup" +
            "//child::option[normalize-space(text()) = 'Version 2.0']");
    public static SelenideElement taskPriorityInput = $x("//input[@id='priority-field']");
    public static SelenideElement descriptionTextArea = $x("//textarea[@id='description']");
    public static SelenideElement envTextArea = $x("//textarea[@id='environment']");
    public static SelenideElement descriptionButtonText = $x("//div[@class='field-group']//child::label[normalize" +
            "-space(text()) = 'Описание']//following-sibling::div//nav[@class='aui-navgroup aui-navgroup-horizontal " + "editor-toggle-tabs']//child::button[normalize-space(text()) = 'Текст']");
    public static SelenideElement envButtonText =
            $x("//div[@class='field-group']//child::label[normalize-space(text" + "()) = 'Окружение']//following" +
                    "-sibling::div//nav[@class='aui-navgroup aui-navgroup-horizontal " + "editor-toggle-tabs']//child" +
                    "::button[normalize-space(text()) = 'Текст']");
    public static SelenideElement assignMeButton = $x("//button[@id='assign-to-me-trigger']");
    public static SelenideElement taskFrame = $x("//section[@id='create-issue-dialog']");
}

package jiraui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskWindowElements {
    public static SelenideElement taskStatus = $x("//span[@id='status-val']//child::span");
    public static SelenideElement fixVersionLink = $x("//span[@id='fixVersions-field']//child::a");
    public static SelenideElement needToDoStatusLink = $x("//a[@id='action_id_11']");
    public static SelenideElement inWorkStatusLink = $x("//a[@id='action_id_21']");
    public static SelenideElement workFlowBarLink = $x("//a[@id='opsbar-transitions_more']");
    public static SelenideElement resolvedStatusLink = $x("//aui-item-link[@id='action_id_31']");
}

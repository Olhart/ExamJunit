package jiraui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardLoginElements {
    public static SelenideElement loginInput = $x("//input[@id='login-form-username']");
    public static SelenideElement passwordsInput = $x("//input[@id='login-form-password']");
    public static SelenideElement loginButtonInput = $x("//input[@id='login']");
}

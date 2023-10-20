package jiraui.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import jiraui.elements.DashboardLoginElements;

import static jiraui.utils.AllureScreenshoter.attachScreenshotPNG;

public class DashboardLoginSteps extends DashboardLoginElements {
    @Step("Выполнить вход в профиль {login} с паролем {password}")
    public static void login(String login, String password) {
        loginInput.shouldBe(Condition.visible).setValue(login);
        passwordsInput.shouldBe(Condition.visible).setValue(password);
        attachScreenshotPNG();
        loginButtonInput.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
    }
}

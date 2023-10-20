package jiraui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IssuesListElements {
    public static SelenideElement numbersOfTasks = $x("//div[@class='showing']//ancestor::span");
    public static SelenideElement myFirstOpenTaskLink = $x("//div[@class='search-results']//child::a");
}

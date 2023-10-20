package jiraui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPanelElements {
    public static SelenideElement searchInput = $x("//input[@id='quickSearchInput']");
    public static SelenideElement testProjectLinkInQuickSearchResult = $x("//div[@class='quick-search-section-heading" +
            "' and" + " normalize-space(text()) = 'Проекты']//following-sibling::ul//ancestor::li[@original-title" +
            "='Test (TEST)" + "']//ancestor::a");
    public static SelenideElement testSeleniumBugLinkInQuickSearchResult = $x("//div[@class='quick-search-section" +
            "-heading' and normalize-space(text()) = 'Запросы']//following-sibling::ul//ancestor::li[@original" +
            "-title='TestSelenium_bug" + "']//ancestor::a");
    public static SelenideElement createButton = $x("//a[@id='create_link']");
    public static SelenideElement profileMenuLink = $x("//li[@id='user-options']//child::a[@id='header-details-user-fullname']");
    public static SelenideElement logoutLink = $x("//a[@id='log_out']");
}

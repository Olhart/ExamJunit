package jiraui.hooks;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class AllureListenerSetup {
    @BeforeAll
    public static void allureSubTreadParallel() {
        String listenerName = "AllureSelenide";

        if (!(SelenideLogger.hasListener(listenerName))) {
            SelenideLogger.addListener(listenerName,
                    (new AllureSelenide().screenshots(true).savePageSource(false)));
        }
    }
}

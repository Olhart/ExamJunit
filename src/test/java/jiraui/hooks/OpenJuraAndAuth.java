package jiraui.hooks;

import jiraui.config.Properties;
import jiraui.steps.DashboardLoginSteps;
import jiraui.steps.DashboardSteps;
import jiraui.steps.MainPanelSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class OpenJuraAndAuth extends AllureListenerSetup {
    private static Properties properties = Properties.properties;

    @BeforeEach
    public void auth() {
        DashboardSteps.openMainPage();
        DashboardLoginSteps.login(properties.login(), properties.password());
        MainPanelSteps.checkVisibleUserProfile();
    }
    @AfterEach
    public void logout(){
        MainPanelSteps.logout();
    }
}

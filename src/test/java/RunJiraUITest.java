import io.qameta.allure.*;

import jiraui.hooks.OpenJuraAndAuth;
import jiraui.steps.MainPanelSteps;
import jiraui.steps.TaskWindowSteps;
import jiraui.steps.TaskCreateWindowSteps;
import jiraui.steps.IssuesListSteps;
import jiraui.utils.FormData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



@Epic("UI тесты")
@Feature("Тестирование веб-ресурса edujira.ifellow.ru")
@Owner("Ольхов Артем")
public class RunJiraUITest extends OpenJuraAndAuth {
    static FormData formData;
    final static String expectedStatusOfTask = "Сделать";
    final static String expectedVersion = "Version 2.0";
    final static String projectName = "Test";
    final static String taskName =  "TestSelenium bug";
    final static String taskID = "TEST-21967";

    @BeforeAll
    public static void getFormFillData() {
        formData = FormData.create()
                .withField("Тип задачи", "Ошибка")
                .withField("Тема", "Live is bug")
                .withField("Приоритет", "Highest")
                .withField("Метки", "QA_practice QA_school")
                .withField("Описание", "Задача создана автоматически")
                .withField("Окружение", "OS: Debian GNU/Linux 11 (bullseye)\nBrowser: Chrome ver. 117");
    }


    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Информация проекта")
    @Description("Число активных задач должно отображатся и является целым положительным числом")
    @DisplayName("Проверка отображения активных задач в проекте \"Test\"")
    public void numberOfActiveTaskInProjectTestTest() {
        MainPanelSteps.goToTestProject(projectName);
        IssuesListSteps.getNumberOfTasks();
    }

    @Test
    @Severity(SeverityLevel.MINOR)
    @Story("Информация задачи")
    @Description("Статус задачи \"TestSelenium bug\" должен отображаться как \"Сделать\", а \"Исправить в версиях\" - \"Version 2.0\"")
    @DisplayName("Проверка статуса и \"Исправить в версиях\" задачи \"TestSelenium bug\"")
    public void TaskStatusAndVersionTest() {
        MainPanelSteps.goToTeslSeleniumBugTask(taskName, taskID);
        TaskWindowSteps.checkTaskStatus(expectedStatusOfTask);
        TaskWindowSteps.checkFixVersion(expectedVersion);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Создание задач")
    @Description("Создание новой задачи в проекте \"Test\" путем нажатия кнопки \"создать\" заполнения формы")
    @DisplayName("Создание новой задачи в проекте \"Test\"")
    public void createNewTaskTest() {
        MainPanelSteps.goToTestProject(projectName);
        MainPanelSteps.clickOnCreateButton();
        TaskCreateWindowSteps.fillOutFormOfTaskWithVer2(formData);
        TaskCreateWindowSteps.clickSubmit();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Информация задачи")
    @Description("Изменеие статуса задачи путем нажатия кнопок рабочего процесса (\"В работе \", \"Сделать\", \"Бизнес-процесс -> Готово\"")
    @DisplayName("Изменеие статуса задачи")
    public void changeTaskStatusTest() {
        IssuesListSteps.goToMyLastOpenTask();
        TaskWindowSteps.setNeedToDoTaskStatus();
        TaskWindowSteps.setResolvedStatusLinkTaskStatus();
        TaskWindowSteps.setInWorkTaskStatus();
    }
}

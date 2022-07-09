package guru.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.steps.StepsWithAnnotation;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchOnGithubWithAnnotationSteps extends BaseTest {
    private SelenideElement searchLine = $(".form-control [type=text]"),
            searchTextInUnderline = $("li.d-inline-flex [id=issues-tab]"),
            searchTextInIssues = $("#issue_1817_link");
    private ElementsCollection repositoryResult = $$("a.v-align-middle");
    private String textInSearchEngine = "selenide",
            desiredTextInIssue = "Add methods to copy and paste content";
    StepsWithAnnotation stepsWithAnnotation = new StepsWithAnnotation();

    @Test
    @Owner("loarlam")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("Поиск названия Issue в github.com/selenide/selenide/issues. Отчёт в Allure, включающий степы с аннотациями")
    void searchingIssueOnGithubWithAnnotionSteps() {
        stepsWithAnnotation.searchingInSearchEngine(searchLine, textInSearchEngine)
                .selectingFirstElementOnPage(repositoryResult)
                .jumpingToIssuesList(searchTextInUnderline)
                .checkingTheDesiredValue(searchTextInIssues, desiredTextInIssue);
    }
}
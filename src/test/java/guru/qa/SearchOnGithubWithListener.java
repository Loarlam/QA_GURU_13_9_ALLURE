package guru.qa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchOnGithubWithListener extends BaseTest {
    private SelenideElement searchLine = $(".form-control [type=text]"),
            searchTextInUnderline = $("li.d-inline-flex [id=issues-tab]"),
            searchTextInIssues = $("#issue_1817_link");
    private ElementsCollection repositoryResult = $$("a.v-align-middle");

    @Test
    @DisplayName("Поиск названия Issue в github.com/selenide/selenide/issues. Отчёт в Allure")
    void SearchingIssueOnGithubWithListener() {
        searchLine.setValue("selenide").pressEnter();
        repositoryResult.first().click();
        searchTextInUnderline.click();
        searchTextInIssues.shouldHave(text("Add methods to copy and paste content"));
    }
}
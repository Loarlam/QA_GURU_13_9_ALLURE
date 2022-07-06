package guru.qa;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchOnGithubWithSelenideListener extends BaseTest {
    private SelenideElement searchTextInUnderline = $("li.d-inline-flex [id=issues-tab]"),
            searchTextInIssues = $("#issue_1817_link");

    @Test
    @DisplayName("Поиск названия Issue в https://github.com/selenide/selenide/issues")
    void SearchingIssueOnGithubWithListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open("/selenide");
        searchTextInUnderline.click();
        searchTextInIssues.shouldHave(text("Add methods to copy and paste content"));
    }
}
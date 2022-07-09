package guru.qa.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class StepsWithAnnotation {
    @Step("На главной странице github вводим в поисковой строке \"{desiredText}\" и нажимаем Enter")
    public StepsWithAnnotation SearchingInSearchEngine(SelenideElement searchLine, String desiredText) {
        searchLine.setValue(desiredText).pressEnter();
        return this;
    }

    @Step("В поисковой выдаче выбираем кликом первый элемент")
    public StepsWithAnnotation SelectingFirstElementOnPage(ElementsCollection repositoryResult) {
        repositoryResult.first().click();
        return this;
    }

    @Step("Совершаем клик по кнопке \"Issue\"")
    public StepsWithAnnotation JumpingToIssuesList(SelenideElement searchTextInUnderline) {
        searchTextInUnderline.click();
        return this;
    }

    @Step("Проверяем наличие текста \"{desiredText}\" для выбранного решения")
    public StepsWithAnnotation CheckingTheDesiredValue(SelenideElement searchTextInIssues, String desiredText) {
        searchTextInIssues.shouldHave(text(desiredText));
        return this;
    }
}

package guru.qa.steps;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;

public class StepsWithAnnotation {
    @Step("На главной странице github вводим в поисковой строке \"{desiredText}\" и нажимаем Enter")
    public StepsWithAnnotation searchingInSearchEngine(SelenideElement searchLine, String desiredText) {
        searchLine.setValue(desiredText).pressEnter();
        attachScreenshot();
        return this;
    }

    @Step("В поисковой выдаче выбираем кликом первый элемент")
    public StepsWithAnnotation selectingFirstElementOnPage(ElementsCollection repositoryResult) {
        repositoryResult.first().click();
        attachScreenshot();
        return this;
    }

    @Step("Совершаем клик по кнопке \"Issue\"")
    public StepsWithAnnotation jumpingToIssuesList(SelenideElement searchTextInUnderline) {
        searchTextInUnderline.click();
        attachScreenshot();
        return this;
    }

    @Step("Проверяем наличие текста \"{desiredText}\" для выбранного решения")
    public StepsWithAnnotation checkingTheDesiredValue(SelenideElement searchTextInIssues, String desiredText) {
        searchTextInIssues.shouldHave(text(desiredText));
        attachScreenshot();
        return this;
    }

    @Attachment(value = "Мой любимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

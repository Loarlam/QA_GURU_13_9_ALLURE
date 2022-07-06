package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void beforeAllTests() {
        Configuration.baseUrl = "https://github.com/selenide";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }
}
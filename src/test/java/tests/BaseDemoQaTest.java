package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseDemoQaTest {



    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demo-qa-app.azurewebsites.net/";
        Configuration.browser = "chrome";
    }
}

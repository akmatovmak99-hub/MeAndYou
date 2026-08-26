package tests;

import com.codeborne.selenide.Configuration;
import demoQa.ui.page.elements.CheckBoxPage;
import demoQa.ui.page.elements.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseDemoQaTest {

    protected static TextBoxPage textBoxPage;
    protected static CheckBoxPage checkBoxPage;


    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://demo-qa-app.azurewebsites.net";
        Configuration.browser = "chrome";

        textBoxPage = new TextBoxPage();
        checkBoxPage = new CheckBoxPage();
    }
}

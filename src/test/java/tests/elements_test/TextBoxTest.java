package tests.elements_test;

import org.junit.jupiter.api.Test;
import tests.BaseDemoQaTest;

public class TextBoxTest extends BaseDemoQaTest {

    @Test
    void input(){
     textBoxPage.openPage()
             .verifyOpened()
             .inputFullName("zarina")
             .inputEmail("zzz@gmail.com")
             .inputCurrentAddress("Bishkek")
             .inputPermanentAddress("Tsum")
             .clickSubmit();
    }


}

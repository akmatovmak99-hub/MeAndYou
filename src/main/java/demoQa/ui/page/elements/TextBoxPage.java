package demoQa.ui.page.elements;

import com.codeborne.selenide.SelenideElement;
import demoQa.ui.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPage extends BasePage<TextBoxPage> {

   private SelenideElement fullName = $("#userName");
   private SelenideElement email = $("#userEmail");
   private SelenideElement currentAddress = $("#currentAddress");
   private SelenideElement permanentAddress = $("#permanentAddress");
   private SelenideElement submit = $("#submit");

   @Step("заполняет поля FullName")
   public TextBoxPage inputFullName(String fullName){
       elementAction.input(this.fullName, fullName);
       return this;
   }

   @Step("Заполняет поля  Email")
    public TextBoxPage inputEmail(String email){
        elementAction.input(this.email, email);
        return this;
    }

    @Step("Заполняет поля CurrentAddress")
    public TextBoxPage inputCurrentAddress(String text){
        elementAction.input(currentAddress, text);
        return this;
    }

    @Step("Заполняет поля PermanentAddress")
    public TextBoxPage inputPermanentAddress(String permanentAddress){
        elementAction.input(this.permanentAddress, permanentAddress);
        return this;
    }

    @Step("Нажимаем на кнопку submit")
    public TextBoxPage clickSubmit(){
        elementAction.click(submit);
        return this;
    }

    @Override
    protected String getPath() {
        return "text-box";
    }
}

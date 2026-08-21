package demoQa.ui.helper;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

public class ElementAction {

    public ElementAction click(SelenideElement element) {
        element.shouldBe(visible).shouldBe(Condition.clickable).click();
        return this;
    }

    public ElementAction input(SelenideElement element, String text) {
        element.shouldBe(visible).sendKeys(text);
        return this;
    }

    public ElementAction doubleClick(SelenideElement element) {
        element.shouldBe(visible).shouldBe(clickable).doubleClick();
        return this;
    }

    public ElementAction rightClick(SelenideElement element) {
        element.shouldBe(visible).shouldBe(clickable).contextClick();
        return this;
    }
}

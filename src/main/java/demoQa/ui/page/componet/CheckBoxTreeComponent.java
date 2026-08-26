package demoQa.ui.page.componet;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBoxTreeComponent {
    private static final String NODE = ".rct-text"; // родительский класс

    private static final String CHECK_BOX = ".rct-checkbox"; // окно выбора
    private static final String CHECK_BOX_ICON = ".rct-checkbox .rct-icon"; // иконка состояния чекбокса
    private static final String EXPANDED_BOX = ".rct-collapse-btn"; // свернуть окно

    private static final String CHECKED_BOX = "rct-icon-check"; // выбранный ящик
    private static final String HALF_CHECKED = "rct-icon-half-check"; // полу-выбранный ящик
    private static final String BOX_EXPAND = ".rct-icon-expand-open"; // открытый ящик

    private SelenideElement box(String title) {
        return $$(NODE).findBy(Condition.text(title));
    }

    public CheckBoxTreeComponent toggleElement(String title) {
        box(title).$(CHECK_BOX).click();
        return this;
    }

    public CheckBoxTreeComponent switcherBoxes(String title) {
        SelenideElement switcher = box(title).$(EXPANDED_BOX);
        if (!switcher.has(cssClass(BOX_EXPAND))) {
            switcher.click();
        }
        return this;
    }

    public CheckBoxTreeComponent closesBoxes(String title) {
        SelenideElement switcher = box(title).$(EXPANDED_BOX);
        if (switcher.has(cssClass(BOX_EXPAND))) {
            switcher.click();
        }
        return this;
    }

    public CheckBoxTreeComponent boxShouldBeChecked(String title) {
        box(title).$(CHECK_BOX_ICON).shouldHave(cssClass(CHECKED_BOX));
        return this;
    }

    public CheckBoxTreeComponent boxShouldBeUnChecked(String title) {
        box(title).$(CHECK_BOX_ICON)
                .shouldNotHave(cssClass(HALF_CHECKED))
                .shouldNotHave(cssClass(CHECKED_BOX));
        return this;
    }

    public CheckBoxTreeComponent boxShouldBeIndeterminate(String title) {
        box(title).$(CHECK_BOX_ICON).shouldHave(cssClass(HALF_CHECKED));
        return this;
    }

    public CheckBoxTreeComponent boxShouldBeVisible(String title) {
        box(title).shouldBe(visible);
        return this;
    }

    public CheckBoxTreeComponent shouldHaveVisibleNodes(int expectedCount) {
        $$(NODE).filterBy(visible).shouldHave(size(expectedCount));
        return this;
    }

}

package demoQa.ui.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverConditions;
import io.qameta.allure.Step;

//<T> это generic (generic = )
public abstract class BasePage<T extends BasePage<T>> {

    protected abstract String getPath();

    @Step("Открывает страницу")
    public T openPage() {
        //Мы импортируем метод open() из Класса Selenide передаем параметр getPath() для обозначения end_point
        Selenide.open(getPath());
        return (T) this;
    }

    @Step("Проверка нужной страницы")
    public T verifyOpened() {
        //Мы импортируем метод webDriver() из класса Selenide используем метод shouldHave() для проверки содержания URL
        Selenide.webdriver().shouldHave(WebDriverConditions.urlContaining(getPath()));
        return (T) this;
    }

    @Step("Обновить страницу")
    public T refresh() {
        //Мы импортируем метод refresh() из класса Selenide для того обновить страницу
        Selenide.refresh();
        return (T) this;
    }


}

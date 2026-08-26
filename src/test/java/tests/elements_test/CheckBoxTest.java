package tests.elements_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseDemoQaTest;

public class CheckBoxTest extends BaseDemoQaTest {
    @Test
    @DisplayName("Выбор одного ребенка делает родителей частично отмеченными")
    void checkLeafMakesParentsIndeterminateTest() {
        checkBoxPage.openPage()
                .verifyOpened()
                .expandNode("Home")
                .expandNode("Desktop")
                .checkNode("Notes")
                .tree()
                .boxShouldBeChecked("Notes")
                .boxShouldBeUnChecked("Commands")
                .boxShouldBeIndeterminate("Desktop")
                .boxShouldBeIndeterminate("Home");
    }
}
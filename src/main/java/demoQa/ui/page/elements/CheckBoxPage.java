package demoQa.ui.page.elements;

import demoQa.ui.page.BasePage;
import demoQa.ui.page.componet.CheckBoxTreeComponent;

public class CheckBoxPage extends BasePage<CheckBoxPage> {


    private final CheckBoxTreeComponent tree = new CheckBoxTreeComponent();

    public CheckBoxTreeComponent tree() {
        return tree;
    }

    public CheckBoxPage checkNode(String title) {
        tree.toggleElement(title);
        return this;
    }

    public CheckBoxPage expandNode(String title) {
        tree.switcherBoxes(title);
        return this;
    }

    public CheckBoxPage closedNode(String title) {
        tree.closesBoxes(title);
        return this;
    }

    protected String getPath() {
        return "/checkbox";
    }

}

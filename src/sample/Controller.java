package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTreeCell;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private ComboBox cb;
    @FXML
    private ListView<CheckBox> lv;
    @FXML
    private TreeView tree;
    @FXML
    private TextArea ta;

    private List<CheckBoxTreeItem> checkBoxTreeCellList = new ArrayList<>();

    @FXML
    private void initialize() {
        for (String name : CarFabric.keys()) {
            cb.getItems().add(name);
        }
        for (String name : CarDecoratorFabric.keys()) {
            CheckBoxTreeItem checkBox = new CheckBoxTreeItem(name);
            checkBoxTreeCellList.add(checkBox);
        }
        initiateCheckBoxList();
    }

    private void initiateCheckBoxList() {
        CheckBoxTreeItem<String> root = new CheckBoxTreeItem<>();
        root.setExpanded(true);

        tree.setCellFactory(CheckBoxTreeCell./*<String>*/forTreeView());
        for (CheckBoxTreeItem cb : checkBoxTreeCellList) {
            root.getChildren().add(cb);
        }

        tree.setRoot(root);
        tree.setShowRoot(false);
    }

    @FXML
    private void makeCar() {
        Car car = CarFabric.makeCar(cb.getValue().toString());
        for (CheckBoxTreeItem cb : checkBoxTreeCellList)
        {
            if (cb.isSelected()) {
                car = CarDecoratorFabric.makeCar(car, cb.getValue().toString());
            }
        }
        final String text = String.format("%s => %.0f",
                car.info(), car.price());
        ta.appendText(text + System.lineSeparator());
    }
}

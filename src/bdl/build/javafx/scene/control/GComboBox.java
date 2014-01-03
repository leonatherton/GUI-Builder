package bdl.build.javafx.scene.control;

import bdl.build.GObject;
import javafx.scene.control.ComboBox;

public class GComboBox extends ComboBox implements GObject{
    private String fieldName;

    @Override
    public String getFieldName() {
        return fieldName;
    }

    @Override
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
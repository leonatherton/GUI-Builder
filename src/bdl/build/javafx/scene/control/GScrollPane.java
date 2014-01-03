package bdl.build.javafx.scene.control;

import bdl.build.GObject;
import javafx.scene.control.ScrollPane;

public class GScrollPane extends ScrollPane implements GObject {
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
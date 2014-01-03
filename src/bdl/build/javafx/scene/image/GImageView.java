package bdl.build.javafx.scene.image;

import bdl.build.GObject;
import javafx.scene.image.ImageView;

public class GImageView extends ImageView implements GObject {
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

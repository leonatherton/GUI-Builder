package bdl;

import bdl.controller.Controller;
import bdl.model.ComponentSettings;
import bdl.view.View;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class.
 */
public class Main extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setMinWidth(800);
        stage.setMinHeight(500);

        //Allow user to specify their own file
        String componentSettingsLocation = System.getProperty("bdl.guibuilder.componentSettings");
        if (componentSettingsLocation == null) {
            componentSettingsLocation = "src/bdl/model/component-options.xml";//Default file
        }

        ComponentSettings model = null;
        try {
             model = new ComponentSettings(componentSettingsLocation);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        final View view = new View(model);
        Controller controller = new Controller(view);

        Scene scene = new Scene(view, 1024, 600);

        stage.setTitle("GUI Builder");
        stage.setScene(scene);

        //Handlers that require access to the Stage
        view.topPanel.mItmClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });
        view.topPanel.mItmFullScreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (stage.isFullScreen()) {
                    stage.setFullScreen(false);
                    view.topPanel.mItmFullScreen.setText("Make Full Screen");
                } else {
                    stage.setFullScreen(true);
                    view.topPanel.mItmFullScreen.setText("Exit Full Screen");
                }
            }
        });

        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

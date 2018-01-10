import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class Control extends Application {
    @Override
    public void start(Stage main_stage) throws Exception {
        ClientControler client_control=new ClientControler();
        client_control.start();

        VBox root = new VBox();
        Button button = new Button("Play");
        Button button1 = new Button("Forward");
        Button button2 = new Button("Backward");
        root.getChildren().addAll(button,button1,button2);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client_control.setPlayOrPause();
            }
        });

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client_control.setScrolBackward();
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                client_control.setScrolForward();
            }
        });




        Scene scene = new Scene(root);
        main_stage.setTitle("Controller");
        main_stage.setScene(scene);
        main_stage.show();
        main_stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    client_control.setExit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

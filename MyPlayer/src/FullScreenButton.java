import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FullScreenButton extends Button {
    private Stage stage;
    private BorderPane core;
    private Menu menu;

    public FullScreenButton(final Stage stage, final BorderPane core){
        super();
        this.stage=stage;
        this.core=core;
        setPrefSize(40,30);
        setLayoutX(40);
        setLayoutY(0);
        setStyle("-fx-focus-color: transparent;");
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FullScreen();
            }
        });
    }
    public void FullScreen(){
        if(!stage.isFullScreen()){
            core.setRight(null);}
            else{
            core.setRight(menu);
        }
        stage.setFullScreen(!stage.isFullScreen());
    }
}

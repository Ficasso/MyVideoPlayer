import javafx.geometry.Insets;
import javafx.scene.layout.HBox;


public class Menu extends HBox {
    public Menu(){
        setStyle("-fx-back_color: #000000;");
        setMaxWidth(100);
        setMaxHeight(100);
        setPadding(new Insets(20,10,20,10));
        setSpacing(6);
    }
}

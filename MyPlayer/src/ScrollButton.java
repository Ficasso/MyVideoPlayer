import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ScrollButton extends Button {
    MediaPlayer media_player;
    private int ms;
    Video video;
    public ScrollButton(Video video, final int _ms){
        ms=_ms;
        this.video=video;
        if(ms>0){
            setLayoutX(100);
            setLayoutY(0);
        }
        else{
            setLayoutX(0);
            setLayoutY(0);
        }
        setPrefSize(40,30);
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { scroll(); }
        });

    }

    public void scroll(){
        if(video.media_player!=null){
            Duration current_time = video.media_player.getCurrentTime();
            current_time=current_time.add(new Duration(ms));
            video.media_player.seek(current_time);
        }
    }
    public void reset(MediaPlayer media_player){ this.media_player =media_player;}
}

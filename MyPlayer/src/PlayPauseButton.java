import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class PlayPauseButton extends Button {
    MediaPlayer media_player;
    Video video;
    public PlayPauseButton(final MediaPlayer _media_player, Video video){
        super();
        media_player=_media_player;
        this.video=video;
        setPrefSize(40,30);
        setLayoutX(30);
        setLayoutY(5);
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                swap();
            }
        });
    }

    public void swap(){
        Platform.runLater(new Runnable(){
            @Override
            public  void run() {
                if (video.media_player != null) {
                    if (video.isPlaing) {
                        video.media_player.pause();
                        video.isPlaing=false;
                    } else {
                        video.media_player.play();
                        video.isPlaing=true;
                    }
                }
            }
        });
    }
    public void reset(MediaPlayer media_player){
        this.media_player = media_player;
    }
}

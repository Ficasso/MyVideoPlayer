
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import javafx.scene.media.Media;
import java.io.File;

public class Video extends Application {

    boolean isPlaing = true;

//    private boolean full_screen=true;
//    private boolean is_running=true;
//    private int mouse_click = 0;
//    private long current_time=0;
    private Stage stage;
    private Scene scene;
    private DoubleProperty width;
    private DoubleProperty height;
    private BorderPane core;
    private File file;
    private String MEDIA_URL;
    private Media media;
    MediaPlayer media_player;
    private MediaView media_view;
    //  private MainMenu menu;
    public PlayPauseButton play_pause_button;
    ScrollButton scroll_fwd_button;
    ScrollButton scroll_bkw_button;
    FullScreenButton full_screen_button= new FullScreenButton(stage,core);
    Server server;


    @Override
    public void start(Stage main_stage) throws Exception {
        stage=main_stage;
        width=new SimpleDoubleProperty();
        height=new SimpleDoubleProperty();
        core=new BorderPane();
        play_pause_button = new PlayPauseButton(media_player,this);
        scroll_bkw_button = new ScrollButton(this, 5000);
        scroll_fwd_button = new ScrollButton(this, -5000);

        server = new Server(this);
        new Thread(server).start();


        file = new File("C:\\Users\\Pałeł\\Desktop\\1.mp4");
        MEDIA_URL = file.toURI().toString();
        media = new Media(MEDIA_URL);
        media_player = new MediaPlayer(media);
        media_view = new MediaView(media_player);
        media_player.play();
        core.setCenter(media_view);
        scene = new Scene(core, width.doubleValue(),height.doubleValue());
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.SPACE){
                    play_pause_button.swap();
                }
                if(event.getCode()==KeyCode.RIGHT){
                    scroll_bkw_button.scroll();
                }
                if(event.getCode()==KeyCode.LEFT){
                    scroll_fwd_button.scroll();
                }
            }
        });

        main_stage.setTitle("Media Player");
        main_stage.setMinWidth(600);
        main_stage.setMinHeight(400);
        main_stage.setScene(scene);
        main_stage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void run(){
        Application.launch();
    }







}

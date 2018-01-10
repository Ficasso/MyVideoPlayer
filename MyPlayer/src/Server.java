
import javafx.concurrent.Task;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private boolean isWorking=true;
    private PlayPauseButton playOrPauseButton;
    private ScrollButton scrolForwardButton;
    private ScrollButton scrolBackwardButton;
    private Video videoPlayer;

    //server
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;

    public Server(Video videoPlayer){
        super();
        this.videoPlayer = videoPlayer;
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        try {
            //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            String inputLine;

            while (isWorking) {
                inputLine = in.readLine();
                if(inputLine.equals("1")){
                    videoPlayer.play_pause_button.swap();
                }
                if(inputLine.equals("2")){
                    videoPlayer.scroll_fwd_button.scroll();
                }
                if(inputLine.equals("3")){
                    videoPlayer.scroll_bkw_button.scroll();
                }

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setExit() throws IOException {
        isWorking=false;
        serverSocket.close();
        if(clientSocket!=null){
            clientSocket.close();
        }
        if(in!=null){
            in.close();
        }
    }



}

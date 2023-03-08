import java.io.File;
/*
 * NEEDS TO BE UPLOADED TO GITHUB EVENTUALLY
 */

/**
 * FOR VSCODE:
 * Make sure to add javafx folder to "JAVA PROJECTS -> Reference Libraries -> javafx-sdk-11.0.2 -> lib -> highlight all -> enter"
 * 
 * Also make sure that when you go to "File -> Preferences -> Settings" and search for "vmargs"
 * that the bar has --module-path <Your JavaFX lib> --add-modules javafx.controls,javafx.fxml filled in with the FULL source path
 * 
 * FOR INTELLIJ: 1 or 2
 * 1) Apply path:
 *      Edit run configurations, and in the VM options add your path: --module-path <Your JavaFX lib> --add-modules javafx.controls,javafx.fxml
 * 2) Add the environment variable:
 *      Go to "Intellij -> File -> Settings -> Appearance & Behavior -> Path Variables" and add "PATH_TO_FX", with the path to the lib folder:
 *
 *  Example of path to lib folder: C:/User/Users/Documents/Folder/javafx-sdk-11.0.2/lib
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * Class that creates a MediaPlayerGUI filled with 5 preset songs.
 * 
 * EXCLAIMER: This GUI does not work if you hit the play button first. In order
 * to play a song, you must select which song you wish to play first, and all
 * the buttons
 * will work towards the selected song.
 * 
 * @author Joshua Ross
 */

public class Song extends Application {
    /**
     * Songpaths
     */
    private static final String SONGPATH1 = "musicfolder/Anakin's Betrayal.mp3";
    private static final String SONGPATH2 = "musicfolder/Caravan.mp3";
    private static final String SONGPATH3 = "musicfolder/Ocean Man.mp3";
    private static final String SONGPATH4 = "musicfolder/SUPER AMAZING AWESOME SONG.mp3";
    private static final String SONGPATH5 = "musicfolder/Whiplash.mp3";

    /**
     * Images
     */
    private static final Image BLANK = new Image("images/blank.png");
    private static final Image WEEN = new Image("images/Ween.png");
    private static final Image JOHN_WILLIAMS = new Image("images/John Williams.png");
    private static final Image RICK_ASTLEY = new Image("images/Rick Astley.png");
    private static final Image TERENCE = new Image("images/Terence Fletcher.png");

    private String path;
    private String description;
    private Image cover;
    private MediaPlayer player;

    /**
     * Default song at start.
     * Can be changed by clicking other song button.
     */

    public Song() {
        path = "";
        description = "";
    }

    public Song makeSong(String path, String description, Image cover) {
        Song song = new Song();
        song.setPath(path);
        song.setDesc(description);
        song.setCover(cover);

        String uri = new File(path).toURI().toString();
        Media media = new Media(uri);
        this.player = new MediaPlayer(media);
        return song;
    }

    public void setPath(String filePath) {
        path = filePath;
    }

    public void setDesc(String desc) {
        description = desc;
    }

    public void setCover(Image image) {
        cover = image;
    }

    public Image getImage() {
        return cover;
    }

    public String getDescription() {
        return description;
    }

    public void play() {
        player.play();
    }

    public void stop() {
        player.stop();
    }

    public void rewind() {
        player.seek(player.getCurrentTime().add(Duration.seconds(-10)));
    }

    public void ffwd() {
        player.seek(player.getCurrentTime().add(Duration.seconds(10)));
    }

    public void toggle_pause() {
        if (player.getStatus().equals(Status.PAUSED)) {
            player.play();
        } else {
            player.pause();
        }
    }

    private static Label makeLabel(String text) {
        Label label = new Label(text);
        label.setFont(new Font("Ariel", 14));
        label.setTextFill(Color.BLACK);
        label.setPadding(new Insets(8));
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(
                new BackgroundFill(Color.LIGHTSTEELBLUE,
                        CornerRadii.EMPTY, Insets.EMPTY)));
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return label;
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox songsBox = new VBox();

        ImageView image = new ImageView(BLANK);

        Label label = makeLabel("No Song Playing");

        /**
         * Song #1 in list of songs in mediaplayer
         */
        Button songButton1 = new Button("Anakin's Betrayal");
        songButton1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        songButton1.setPadding(new Insets(20));
        songButton1.setOnAction((e) -> {
            Song song1 = makeSong(SONGPATH1, "Song by John Williams", JOHN_WILLIAMS);
            label.setText("Song by John Williams");
            stop();
            play();
            image.setImage(JOHN_WILLIAMS);
        });

        /**
         * Song #2 in list of songs in mediaplayer
         */
        Button songButton2 = new Button("Caravan");
        songButton2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        songButton2.setPadding(new Insets(20));
        songButton2.setOnAction((e) -> {
            Song song2 = makeSong(SONGPATH2, "Song by Whiplash", TERENCE);
            label.setText("Song by Whiplash");
            stop();
            play();
            image.setImage(TERENCE);
        });

        /**
         * Song #3 in list of songs in mediaplayer
         */
        Button songButton3 = new Button("Ocean Man");
        songButton3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        songButton3.setPadding(new Insets(20));
        songButton3.setOnAction((e) -> {
            Song song3 = makeSong(SONGPATH3, "Song by Ween", WEEN);
            label.setText("Song by Ween");
            stop();
            play();
            image.setImage(WEEN);
        });

        /**
         * Song #4 in list of songs in mediaplayer
         */
        Button songButton4 = new Button("SUPER AMAZING AWESOME SONG");
        songButton4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        songButton4.setPadding(new Insets(20));
        songButton4.setOnAction((e) -> {
            Song song4 = makeSong(SONGPATH4, "Song by Rick Astley", RICK_ASTLEY);
            label.setText("Song by Gotem");
            stop();
            play();
            image.setImage(RICK_ASTLEY);
        });

        /**
         * Song #5 in list of songs in mediaplayer
         */
        Button songButton5 = new Button("Whiplash");
        songButton5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        songButton5.setPadding(new Insets(20));
        songButton5.setOnAction((e) -> {
            Song song5 = makeSong(SONGPATH5, "Song by Whiplash", TERENCE);
            label.setText("Song by Whiplash");
            stop();
            play();
            image.setImage(TERENCE);
        });

        // adding all of the songs into a VBox created before song#1
        songsBox.getChildren().addAll(songButton1, songButton2, songButton3, songButton4, songButton5);

        HBox optionsBox = new HBox();

        /**
         * Backwards button. Skips 10 seconds backwards in song.
         */
        Button back = new Button("<<");
        back.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        back.setPadding(new Insets(15));
        back.setMinWidth(57);
        back.setOnAction((e) -> {
            rewind();
        });

        /**
         * Pause button. Pauses music when music is playing, but if pressed again will
         * start music from where it was paused.
         */
        Button pause = new Button("||");
        pause.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        pause.setPadding(new Insets(20));
        pause.setMinWidth(58);
        pause.setOnAction((e) -> {
            toggle_pause();
        });

        /**
         * Play button. Plays the music when music is paused. If used when no song is
         * playing, first song should play (doesn't yet, needs to be fixed)
         */
        Button play = new Button("Play");
        play.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        play.setPadding(new Insets(15));
        play.setMinWidth(58);
        play.setOnAction((e) -> {
            if (player.getStatus().equals(Status.PAUSED) || player.getStatus().equals(Status.STOPPED)
                    || player.getStatus().equals(Status.HALTED) || player.getStatus().equals(Status.STALLED)) {
                play();
                
            } else {
                Song firstSong = makeSong(SONGPATH1, "Song by John Williams", JOHN_WILLIAMS);
                label.setText("Song by John Williams");
                image.setImage(JOHN_WILLIAMS);
                play();
            }

        });

        /**
         * Stop button. Stops music player from playing music. Does not terminate music
         * player.
         */
        Button stop = new Button("[]");
        stop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        stop.setPadding(new Insets(20));
        stop.setMinWidth(58);
        stop.setOnAction((e) -> {
            stop();
            // image.setImage(BLANK);
        });

        /**
         * Forward button. Skips 10 seconds forwards in song.
         */
        Button forward = new Button(">>");
        forward.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        forward.setPadding(new Insets(15));
        forward.setMinWidth(57);
        forward.setOnAction((e) -> {
            ffwd();
        });

        // TO STOP SONG ONCE AT END
        optionsBox.getChildren().addAll(back, pause, play, stop, forward);

        HBox imageBox = new HBox();

        // image goes here
        imageBox.getChildren().addAll(image, songsBox);

        VBox box = new VBox();
        box.getChildren().addAll(imageBox, optionsBox, label);

        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.setTitle("Media Player");
        stage.show();
    }

    /**
     * Used to launch the mediaplayer as a whole.
     */
    public static void main(String[] args) {
        launch(args);
    }
}

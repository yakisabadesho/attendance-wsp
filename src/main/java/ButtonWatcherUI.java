import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.application.Platform;


import static javafx.application.Application.launch;

public class ButtonWatcherUI extends Application {
    @Override
    public void start(Stage stage) {

        var iconStream = getClass().getResourceAsStream("/favicon.png");
        if (iconStream != null) {
            Image icon = new Image(iconStream);
            stage.getIcons().add(icon);
        } else {
            System.out.println("Could not find favicon.png!");
        }

        Label title = new Label("Credentials⤵");

        TextField input1 = new TextField();
        input1.setPromptText("Login:");

        PasswordField input2 = new PasswordField();
        input2.setPromptText("Password:");

        TextField input3 = new TextField("20");
        input3.setPromptText("Refresh Rate:");

        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        stopButton.setDisable(true);

        Label status = new Label("Inactive");

        Label desc2 = new Label("REQUIRES CHROME. Don't panic if chrome doesn't start, it needs some time to download " +
                "the driver on the initial launch. Restart the program/End the task if needed and try again.");
        desc2.setWrapText(true);
        desc2.setTextAlignment(TextAlignment.CENTER);

        startButton.setOnAction(event -> {
            String[] args = {input1.getText(), input2.getText(), input3.getText()};

            status.setText("Working");
            startButton.setDisable(true);
            stopButton.setDisable(false);

            new Thread(() -> {
                try {
                    ButtonWatcher.main(args);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Platform.runLater(() -> {
                        status.setText("Stopped");
                        startButton.setDisable(false);
                        stopButton.setDisable(true);
                    });
                }
            }).start();
        });
        stopButton.setOnAction(event -> {
            ButtonWatcher.running = false;
            status.setText("Stopping...");
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                title,
                input1,
                input2,
                input3,
                startButton,
                new Region(),
                stopButton,
                status,
                new Region(),
                new Region(),
                desc2
        );
        layout.setAlignment(Pos.CENTER);
        input1.setPrefWidth(200);
        input1.setMaxWidth(200);
        input2.setPrefWidth(200);
        input2.setMaxWidth(200);
        input3.setPrefWidth(50);
        input3.setMaxWidth(200);
        title.setScaleY(2);
        title.setScaleX(2);
        startButton.setScaleX(1.5);
        startButton.setScaleY(1.5);
        startButton.setAlignment(Pos.CENTER);
        stopButton.setScaleX(1.5);
        stopButton.setScaleY(1.5);
        stopButton.setAlignment(Pos.CENTER);



        Scene scene = new Scene(layout, 400, 400);

        stage.setTitle("att");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

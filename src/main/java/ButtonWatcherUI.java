import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Border;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.application.Platform;


import static javafx.application.Application.launch;

public class ButtonWatcherUI extends Application {
    @Override
    public void start(Stage stage) {

        Label title = new Label("Credentials⤵");

        TextField input1 = new TextField();
        input1.setPromptText("Login:");

        PasswordField input2 = new PasswordField();
        input2.setPromptText("Password:");

        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        stopButton.setDisable(true);

        Label status = new Label("Inactive");

        Label desc = new Label("Refreshes every 20 seconds.");

        startButton.setOnAction(event -> {
            String[] args = {input1.getText(), input2.getText()};

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
                startButton,
                new Region(),
                stopButton,
                status,
                new Region(),
                new Region(),
                desc
        );
        layout.setAlignment(Pos.CENTER);
        input1.setPrefWidth(200);
        input1.setMaxWidth(200);
        input2.setPrefWidth(200);
        input2.setMaxWidth(200);
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

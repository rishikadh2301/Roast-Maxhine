import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class RoastMe extends Application {
    private TextField nameField;
    private Label roastLabel;

    private final String[] roasts = {
        "Hey [name], even your WiFi signal runs away from you!",
        "[name], you bring everyone so much joy… when you leave the room.",
        "You're like a cloud, [name]—when you disappear, it's a beautiful day.",
        "[name], even Google doesn’t have all the answers about you.",
        "If I had a dollar for every smart thing you said, [name], I'd be broke.",
        "Your jokes are like your WiFi, [name]—weak and disconnected.",
        "[name], I’d agree with you, but then we’d both be wrong!",
        "[name], you're proof that even bad ideas can become reality."
    };

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Roast Machine");

        
        nameField = new TextField();
        nameField.setPromptText("Enter your name...");

        
        Button roastButton = new Button("ROAST ME!");
        roastButton.setOnAction(e -> generateRoast());

        
        roastLabel = new Label();
        roastLabel.setWrapText(true);

  
        VBox layout = new VBox(10, nameField, roastButton, roastLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px; -fx-font-size: 14px;");

        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateRoast() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            roastLabel.setText("Please enter your name first!");
            return;
        }

        Random random = new Random();
        String roast = roasts[random.nextInt(roasts.length)];
        roast = roast.replace("[name]", name);
        roastLabel.setText(roast);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

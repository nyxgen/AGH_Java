import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Main extends Application implements EventHandler<ActionEvent>
{
    Stage window;

    ClockFX clock = new ClockFX();

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ClockFX");

        window = primaryStage;
        BorderPane layout = new BorderPane();
        Canvas myCanvas = new Canvas(800, 800);
        GraphicsContext graphicsContext =  myCanvas.getGraphicsContext2D();
        layout.getChildren().addAll(myCanvas);
        Scene scene = new Scene(layout, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            @Override public void handle(long currentNanoTime) {
                graphicsContext.clearRect(0, 0, 400, 400);
                clock.updateTime();
                clock.updateHands(graphicsContext);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }
}


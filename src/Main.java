import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
    Stage window;
    private static final int windowWidth = 300, windowHeight = 450;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        final int displayHeight = 85, hGap = 25, vGap = 5;
        final int buttonWidth = windowWidth / 3 - hGap;
        final int buttonHeight = (windowHeight - displayHeight) / 6 - vGap;

        window = stage;
        window.setTitle("Calculator");

        VBox vBox = new VBox();
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setPadding(new Insets(5, 10, 5, 10));
        displayArea.setPrefHeight(displayHeight);
        vBox.getChildren().add(displayArea);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 0, 10, 12.5));
        grid.setHgap(hGap);
        grid.setVgap(vGap);
        Button plusBtn = new Button("+");
        plusBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(plusBtn, 0, 0);
        Button minusBtn = new Button("-");
        minusBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(minusBtn, 1, 0);
        Button multBtn = new Button("x");
        multBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(multBtn, 2, 0);
        Button divideBtn = new Button("/");
        divideBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(divideBtn, 0, 1);
        Button clearBtn = new Button("Clr");
        clearBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(clearBtn, 1, 1);
        Button equalsBtn = new Button("=");
        equalsBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(equalsBtn, 2, 1);
        Button nineBtn = new Button("9");
        nineBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(nineBtn, 0, 2);
        Button eightBtn = new Button("8");
        eightBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(eightBtn, 1, 2);
        Button sevenBtn = new Button("7");
        sevenBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(sevenBtn, 2, 2);
        Button sixBtn = new Button("6");
        sixBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(sixBtn, 0, 3);
        Button fiveBtn = new Button("5");
        fiveBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(fiveBtn, 1, 3);
        Button fourBtn = new Button("4");
        fourBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(fourBtn, 2, 3);
        Button threeBtn = new Button("3");
        threeBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(threeBtn, 0, 4);
        Button twoBtn = new Button("2");
        twoBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(twoBtn, 1, 4);
        Button oneBtn = new Button("1");
        oneBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(oneBtn, 2, 4);
        Button plsMinBtn = new Button("+/-");
        plsMinBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(plsMinBtn, 0, 5);
        Button zeroBtn = new Button("0");
        zeroBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(zeroBtn, 1, 5);
        Button decPtBtn = new Button(".");
        decPtBtn.setPrefSize(buttonWidth, buttonHeight);
        grid.add(decPtBtn, 2, 5);

        vBox.getChildren().add(grid);

        Scene scene = new Scene(vBox, windowWidth, windowHeight);
        stage.setScene(scene);
        stage.show();
    }
}

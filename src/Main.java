import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<ActionEvent>
{
    Stage window;
    private static final int windowWidth = 300, windowHeight = 450;
    private static double operandOneD, operandTwoD;
    private static int operatorI = 0;
    private static String operandOneS, operandTwoS, displayText;
    private static boolean opOneIsSet = false, opTwoIsSet = false,
            operatorIsSet = false;
    private static TextArea displayArea;
    private Font displayFont;
    private static Button plusBtn, minusBtn, multBtn, divideBtn, clearBtn,
        equalsBtn, nineBtn, eightBtn, sevenBtn, sixBtn, fiveBtn, fourBtn,
        threeBtn, twoBtn, oneBtn, plsMinBtn, zeroBtn, decPtBtn;

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
        operandOneS = "";
        operandTwoS = "";
        displayText = "";

        VBox vBox = new VBox();
        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayFont = new Font(32);
        displayArea.setFont(displayFont);
        displayArea.setPadding(new Insets(5, 10, 5, 10));
        displayArea.setPrefHeight(displayHeight);
        vBox.getChildren().add(displayArea);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 0, 10, 12.5));
        grid.setHgap(hGap);
        grid.setVgap(vGap);
        plusBtn = new Button("+");
        plusBtn.setPrefSize(buttonWidth, buttonHeight);
        plusBtn.setOnAction(this);
        grid.add(plusBtn, 0, 0);
        minusBtn = new Button("-");
        minusBtn.setPrefSize(buttonWidth, buttonHeight);
        minusBtn.setOnAction(this);
        grid.add(minusBtn, 1, 0);
        multBtn = new Button("x");
        multBtn.setPrefSize(buttonWidth, buttonHeight);
        multBtn.setOnAction(this);
        grid.add(multBtn, 2, 0);
        divideBtn = new Button("/");
        divideBtn.setPrefSize(buttonWidth, buttonHeight);
        divideBtn.setOnAction(this);
        grid.add(divideBtn, 0, 1);
        clearBtn = new Button("Clr");
        clearBtn.setPrefSize(buttonWidth, buttonHeight);
        clearBtn.setOnAction(this);
        grid.add(clearBtn, 1, 1);
        equalsBtn = new Button("=");
        equalsBtn.setPrefSize(buttonWidth, buttonHeight);
        equalsBtn.setOnAction(this);
        grid.add(equalsBtn, 2, 1);
        nineBtn = new Button("9");
        nineBtn.setPrefSize(buttonWidth, buttonHeight);
        nineBtn.setOnAction(this);
        grid.add(nineBtn, 0, 2);
        eightBtn = new Button("8");
        eightBtn.setPrefSize(buttonWidth, buttonHeight);
        eightBtn.setOnAction(this);
        grid.add(eightBtn, 1, 2);
        sevenBtn = new Button("7");
        sevenBtn.setPrefSize(buttonWidth, buttonHeight);
        sevenBtn.setOnAction(this);
        grid.add(sevenBtn, 2, 2);
        sixBtn = new Button("6");
        sixBtn.setPrefSize(buttonWidth, buttonHeight);
        sixBtn.setOnAction(this);
        grid.add(sixBtn, 0, 3);
        fiveBtn = new Button("5");
        fiveBtn.setPrefSize(buttonWidth, buttonHeight);
        fiveBtn.setOnAction(this);
        grid.add(fiveBtn, 1, 3);
        fourBtn = new Button("4");
        fourBtn.setPrefSize(buttonWidth, buttonHeight);
        fourBtn.setOnAction(this);
        grid.add(fourBtn, 2, 3);
        threeBtn = new Button("3");
        threeBtn.setPrefSize(buttonWidth, buttonHeight);
        threeBtn.setOnAction(this);
        grid.add(threeBtn, 0, 4);
        twoBtn = new Button("2");
        twoBtn.setPrefSize(buttonWidth, buttonHeight);
        twoBtn.setOnAction(this);
        grid.add(twoBtn, 1, 4);
        oneBtn = new Button("1");
        oneBtn.setPrefSize(buttonWidth, buttonHeight);
        oneBtn.setOnAction(this);
        grid.add(oneBtn, 2, 4);
        plsMinBtn = new Button("+/-");
        plsMinBtn.setPrefSize(buttonWidth, buttonHeight);
        plsMinBtn.setOnAction(this);
        grid.add(plsMinBtn, 0, 5);
        zeroBtn = new Button("0");
        zeroBtn.setPrefSize(buttonWidth, buttonHeight);
        zeroBtn.setOnAction(this);
        grid.add(zeroBtn, 1, 5);
        decPtBtn = new Button(".");
        decPtBtn.setPrefSize(buttonWidth, buttonHeight);
        decPtBtn.setOnAction(this);
        grid.add(decPtBtn, 2, 5);

        vBox.getChildren().add(grid);

        Scene scene = new Scene(vBox, windowWidth, windowHeight);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handle(ActionEvent event)
    {
        Object source = event.getSource();

        if(source == plusBtn)
        {
            opOneIsSet = true;
            operatorI = 1;
            operatorIsSet = true;
            displayText += " + ";
            displayArea.setText(displayText);
        }
        else if(source == minusBtn)
        {
            opOneIsSet = true;
            operatorI = 2;
            operatorIsSet = true;
            displayText += " - ";
            displayArea.setText(displayText);
        }
        else if(source == multBtn)
        {
            opOneIsSet = true;
            operatorI = 3;
            operatorIsSet = true;
            displayText += " x ";
            displayArea.setText(displayText);
        }
        else if(source == divideBtn)
        {
            opOneIsSet = true;
            operatorI = 4;
            operatorIsSet = true;
            displayText += " / ";
            displayArea.setText(displayText);
        }
        else if(source == clearBtn)
        {
            displayArea.clear();
            displayText = "";
            operandOneS = "";
            operandTwoS = "";
        }
        else if(source == equalsBtn)
        {
            if(opOneIsSet)
            {
                if(operatorIsSet && opTwoIsSet)
                {
                    operandOneD = Double.parseDouble(operandOneS);
                    operandTwoD = Double.parseDouble(operandTwoS);
                    double resultD = 0;

                    if(operatorI == 1)
                    {
                        resultD = operandOneD + operandTwoD;
                    }
                    else if(operatorI == 2)
                    {
                        resultD = operandOneD - operandTwoD;
                    }
                    else if(operatorI == 3)
                    {
                        resultD = operandOneD * operandTwoD;
                    }
                    else if(operatorI == 4)
                    {
                        resultD = operandOneD / operandTwoD;
                    }

                    operandOneS = Double.toString(resultD);
                    displayText += " = " + operandOneS;
                    displayArea.setText(displayText);
                    displayText = operandOneS;
                    operandTwoS = "";
                    opTwoIsSet = false;
                    operatorIsSet = false;
                }
                else
                {
                    displayArea.setText(operandOneS);
                }
            }
        }
        else if(source == nineBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "9";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "9";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == eightBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "8";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "8";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == sevenBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "7";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "7";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == sixBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "6";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "6";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == fiveBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "5";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "5";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == fourBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "4";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "4";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == threeBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "3";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "3";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == twoBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "2";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "2";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == oneBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "1";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "1";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == plsMinBtn)
        {
            if(!opOneIsSet)
            {
                if(operandOneS.contains("-"))
                {
                    displayText = displayText.substring(0, displayText.length() - operandOneS.length());
                    operandOneS = operandOneS.substring(1);
                }
                else
                {
                    displayText = displayText.substring(0, displayText.length() - operandOneS.length());
                    operandOneS = "-" + operandOneS;
                }

                displayText += operandOneS;
            }
            else
            {
                if(operandTwoS.contains("-"))
                {
                    displayText = displayText.substring(0, displayText.length() - operandTwoS.length());
                    operandTwoS = operandTwoS.substring(1);
                }
                else
                {
                    displayText = displayText.substring(0, displayText.length() - operandTwoS.length());
                    operandTwoS = "-" + operandTwoS;
                }

                displayText += operandTwoS;
            }

            displayArea.setText(displayText);
        }
        else if(source == zeroBtn)
        {
            if(!opOneIsSet)
            {
                operandOneS += "0";
                displayText = operandOneS;
                displayArea.setText(displayText);
            }
            else
            {
                operandTwoS += "0";
                displayArea.setText(displayText + operandTwoS);
                opTwoIsSet = true;
            }
        }
        else if(source == decPtBtn)
        {
            if(!opOneIsSet)
            {
                if(!operandOneS.contains("."))
                {
                    operandOneS += ".";
                    displayText = operandOneS;
                    displayArea.setText(displayText);
                }
            }
            else
            {
                if(!operandTwoS.contains("."))
                {
                    operandTwoS += ".";
                    displayArea.setText(displayText + operandTwoS);
                }
            }
        }
    }
}

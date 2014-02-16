/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */

package championselect;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
 
/**
 * An example of  a BorderPane layout, with placement of children in the top,
 * left, center, right, and bottom positions.
 *
 * @see javafx.scene.layout.BorderPane
 * @related controls/text/SimpleLabel
 * @related graphics/images/ImageCreationSample
 * @resource icon-48x48.png
 */
public class BorderPaneSample extends Application {
    private static final Image ICON_48 = new Image(BorderPaneSample.class.getResourceAsStream("icon-48x48.png"));
    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 400,400));
        BorderPane borderPane = new BorderPane();
 
        //Top content
        Rectangle topRectangle = new Rectangle(400, 23, Color.DARKSEAGREEN);
        topRectangle.setStroke(Color.BLACK);
        borderPane.setTop(topRectangle);
 
        //Left content
        Label label1 = new Label("Left hand");
        Label label2 = new Label("Choice One");
        Label label3 = new Label("Choice Two");
        Label label4 = new Label("Choice Three");
        VBox leftVbox = new VBox();
        leftVbox.getChildren().addAll(label1, label2, label3, label4);
        borderPane.setLeft(leftVbox);
 
        //Right content
        Label rightlabel1 = new Label("Right hand");
        Label rightlabel2 = new Label("Thing A");
        Label rightlabel3 = new Label("Thing B");
        VBox rightVbox = new VBox();
        rightVbox.getChildren().addAll(rightlabel1, rightlabel2, rightlabel3);
        borderPane.setRight(rightVbox);
 
        //Center content
        Label centerLabel = new Label("We're in the center area.");
        ImageView imageView = new ImageView(ICON_48);
 
        //Using AnchorPane only to position items in the center
        AnchorPane centerAP = new AnchorPane();
        AnchorPane.setTopAnchor(centerLabel, Double.valueOf(5));
        AnchorPane.setLeftAnchor(centerLabel, Double.valueOf(20));
        AnchorPane.setTopAnchor(imageView, Double.valueOf(40));
        AnchorPane.setLeftAnchor(imageView, Double.valueOf(30));
        centerAP.getChildren().addAll(centerLabel, imageView);
        borderPane.setCenter(centerAP);
 
        //Bottom content
        Label bottomLabel = new Label("I am a status message, and I am at the bottom.");
        borderPane.setBottom(bottomLabel);
 
        root.getChildren().add(borderPane);
    }
 
    public double getSampleWidth() { return 400; }
 
    public double getSampleHeight() { return 400; }
 
    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}
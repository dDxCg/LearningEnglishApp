package lea.lea;

import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private Label Menu;

    @FXML
    private Label MenuBack;

    @FXML
    private AnchorPane slider;

    @FXML AnchorPane mainPane;

    public static final double MENU_SLIDER_WITDH = 170;
    public static final double MENU_SLIDE_DURATION = 0.2;

    public void mainPaneSlide(boolean flag) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(MENU_SLIDE_DURATION));
        slide.setNode(mainPane);
        if (flag) {
            slide.setToX(-MENU_SLIDER_WITDH);
            slide.play();
        } else {
            slide.setToX(0);
            slide.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (slider.getTranslateX() != -MENU_SLIDER_WITDH) {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(MENU_SLIDE_DURATION));
            slide.setNode(slider);
            slide.setToX(-MENU_SLIDER_WITDH);
            slide.play();
            mainPaneSlide(true);
        }
        MenuBack.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(MENU_SLIDE_DURATION));
            slide.setNode(slider);
            slide.setToX(0);
            slide.play();
            mainPaneSlide(false);
            slider.setTranslateX(-MENU_SLIDER_WITDH);
            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(true);
                MenuBack.setVisible(false);
            });
        });

        Menu.setOnMouseClicked(mouseEvent -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(MENU_SLIDE_DURATION));
            slide.setNode(slider);
            slide.setToX(-MENU_SLIDER_WITDH);
            slide.play();
            mainPaneSlide(true);
            slider.setTranslateX(0);
            slide.setOnFinished((ActionEvent e) -> {
                Menu.setVisible(false);
                MenuBack.setVisible(true);
            });
        });
    }

    @FXML
    public void homeButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void dictionaryButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Dictionary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void practiceButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Practice.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void profileButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void helpButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Help.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
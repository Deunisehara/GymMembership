package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    TableView table = new TableView();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Primary Scene.
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("Table View Sample");
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);

        //Gym Membership Banner.
        final Label label = new Label("Gym Members");
        label.setStyle("-fx-font-style: oblique");
        label.setFont(new Font("Bebas", 38));

        //Columns of the table and width.
        TableColumn default_member = new TableColumn("Default Member");
        default_member.setMinWidth(200);
        TableColumn student_member = new TableColumn("Student Member");
        student_member.setMinWidth(200);
        TableColumn over_member = new TableColumn("Over 60 Member");
        over_member.setMinWidth(200);

        //Table formatting.
        table.setEditable(true);
        table.setStyle("-fx-background-color: antiquewhite");
        table.setMinWidth(600);
        table.getColumns().addAll(default_member, student_member, over_member);

        final VBox vbox = new VBox();
        final HBox hb = new HBox();

        //Text field for the search bar.
        TextField search = new TextField();
        search.setPromptText("Search Member");
        search.setMinWidth(100);
        search.setMaxWidth(default_member.getPrefWidth());

        //Search Button.
        Button searchButton = new Button("Search");
        searchButton.setMinWidth(100);
        searchButton.setLayoutX(265);
        searchButton.setLayoutY(70);
        //Search button on action.
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            }
        });

        hb.getChildren().addAll(search, searchButton);
        hb.setSpacing(3);

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(40, 0, 0, 50));
        vbox.getChildren().addAll(label, table,hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


/*
Take any OOP language and create mini graphs (charts) library that is able to 
draw basic bar chart on X, Y axes. Create another chart type - line as just 
different visual representation for distinct values. 
Notes:
Demonstrate usage of OOP with classes, inheritance etc
Use any library for image drawing and generation that works with your language 
of choice. Result of your program might be JPG, PNG... image. 
Do not use existing graph libraries 
*/

package bioclinica.chart;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ChartApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		HBox topHBox = new HBox();
		ObservableList<Node> hboxList = topHBox.getChildren();
		
		Label input = new Label("insert array");
		input.setPrefWidth(70);
		TextField text = new TextField("insert positive numbers separated with space. example: <<3 5 22 3 56>>");
		text.setPrefWidth(400);
		Button button = new Button("press to start");
		Button button2 = new Button("clear data");
		
		hboxList.addAll(input, text, button, button2);

		TabPane tabPane = new TabPane();
		Tab tab1 = new Tab("line chart");
		Tab tab2 = new Tab("bar chart");
		tabPane.getTabs().addAll(tab1, tab2);
		
		LineCharte lineChart = new LineCharte();
		TilePane tilePane1 = new TilePane();
		tilePane1.setPadding(new Insets(20, 20, 20, 20));
		tab1.setContent(tilePane1);
		
		BarCharte barChart = new BarCharte();
		TilePane tilePane2 = new TilePane();
		tilePane2.setPadding(new Insets(20, 20, 20, 20));
		tab2.setContent(tilePane2);
		
		ArrayList<Integer> inputList = new ArrayList<>();
		button.setOnMouseClicked(e -> {
			String text2 = text.getText();
			for (String word : text2.split(" ")) {
				int num = Integer.parseInt(word);
				inputList.add(num);
			}
			Group lineGroup = lineChart.display(inputList);
			tilePane1.getChildren().add(lineGroup);
			Group barGroup = barChart.display(inputList);
			tilePane2.getChildren().add(barGroup);
		});

		button2.setOnMouseClicked (e -> {
            inputList.clear();
			tilePane1.getChildren().clear();
			tilePane2.getChildren().clear();
		});
		
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(topHBox);
		borderPane.setCenter(tabPane);
		
		Scene scene = new Scene(borderPane, 800, 400);

		primaryStage.setTitle("charts");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
//        Application.launch(args);
	}

}

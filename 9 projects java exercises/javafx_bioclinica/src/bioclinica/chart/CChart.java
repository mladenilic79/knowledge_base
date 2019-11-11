
package bioclinica.chart;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.layout.Region;
import javafx.scene.shape.Line;

public abstract class CChart extends Region {

	int totalHeight;
	int totalLength;
	int jumpLength;
	int dataLength;
	
	public Group display(ArrayList<Integer> arr) {

		Group group = new Group();
		
		Line xx = new Line(0, 0, 760, 0);
		Line yy = new Line(0, 0, 0, -300);
		
		group.getChildren().addAll(xx, yy);
		
		return group;
		
	}

}

package bioclinica.chart;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class BarCharte extends CChart {

	@Override
	public Group display(ArrayList<Integer> arr) {

		Group group = super.display(arr);
		
		super.totalHeight = Collections.max(arr);
		super.totalLength = arr.size();
		super.jumpLength = 760/totalLength;
		super.dataLength = 0;

		for(int i=0; i<arr.size(); i++) {
			int xy = arr.get(i);
			int dataHeight = (-300*xy)/totalHeight;
			dataLength = dataLength + jumpLength;
			
			Line line = new Line(dataLength, 0, dataLength, dataHeight);
			group.getChildren().add(line);

		}
		
		return group;
		
	}

}

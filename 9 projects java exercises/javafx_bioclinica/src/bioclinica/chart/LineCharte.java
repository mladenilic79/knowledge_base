package bioclinica.chart;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class LineCharte extends CChart {

	@Override
	public Group display(ArrayList<Integer> arr) {
		
		Group group = super.display(arr);
		
		super.totalHeight = Collections.max(arr);
		super.totalLength = arr.size();
		super.jumpLength = 760/totalLength;
		super.dataLength = 0;
		
		int tempx = 0;
		int tempy = 0;

		for(int i=0; i<arr.size(); i++) {
			int xy = arr.get(i);
			int dataHeight = (-300*xy)/totalHeight;
			dataLength = dataLength + jumpLength;
			
			Line line = new Line(tempx, tempy, dataLength, dataHeight);
			group.getChildren().add(line);
			
			tempx = dataLength;
			tempy = dataHeight;
		}
		
		return group;
		
	}

}

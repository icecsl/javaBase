package designMode.simpleFactory;

import designMode.simpleFactory.impl.Rectangle;
import designMode.simpleFactory.impl.Square;

/**
 * Created by huangbingjing on 18/2/5.
 */
public class ShapeFactory {

	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}
		if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle();
		} else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
		return null;
	}
}

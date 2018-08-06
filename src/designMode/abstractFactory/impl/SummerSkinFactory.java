package designMode.abstractFactory.impl;

import designMode.abstractFactory.Button;
import designMode.abstractFactory.SkinFactory;
import designMode.abstractFactory.TextField;

/**
 * Created by huangbingjing on 18/2/6.
 */
public class SummerSkinFactory implements SkinFactory {

	@Override
	public Button createButton() {
		return new SummerButton();
	}

	@Override
	public TextField createTextField() {
		return new SummerTextField();
	}
}

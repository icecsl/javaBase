package designMode.observer.impl;

import designMode.observer.Observer;
import designMode.observer.Observerable;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 * Created by huangbingjing on 18/4/26.
 */
public class WechatServer implements Observerable {

	List<Observer> observers = new ArrayList<>();

	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
		notyfy();
	}

	@Override
	public void register(Observer o) {
		observers.add(o);
	}

	@Override
	public void remove(Observer o) {
		if(!observers.isEmpty()){
			observers.remove(o);
		}
	}

	@Override
	public void notyfy() {
		for (Observer o: observers ) {
			o.update(msg);
		}
	}
}

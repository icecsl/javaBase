package designMode.observer;

/**
 * 被观察者接口
 * Created by huangbingjing on 18/4/26.
 */
public interface Observerable {

	void register(Observer o);
	void remove(Observer o);
	void notyfy();

}

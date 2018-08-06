package designMode.observer.impl;

import designMode.observer.Observer;

/**
 * Created by huangbingjing on 18/4/26.
 */
public class WechatUser implements Observer {

	private String name;
	private String message;

	public WechatUser(String name) {
		this.name = name;
	}

	@Override
	public void update(String msg) {
		this.message=msg;
		read();
	}

	public void read(){
		System.out.println(name+"收到消息: "+message);
	}
}

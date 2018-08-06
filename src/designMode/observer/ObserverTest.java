package designMode.observer;

import designMode.observer.impl.WechatServer;
import designMode.observer.impl.WechatUser;

/**
 * Created by huangbingjing on 18/4/26.
 */
public class ObserverTest {
	public static void main(String[] args) {
		WechatServer server = new WechatServer();

		Observer userZhang = new WechatUser("ZhangSan");
		Observer userLi = new WechatUser("LiSi");
		Observer userWang = new WechatUser("WangWu");

		server.register(userZhang);
		server.register(userLi);
		server.register(userWang);
		server.setMsg("PHP是世界上最好用的语言！");

		System.out.println("----------------------------------------------");
		server.remove(userZhang);
		server.setMsg("JAVA是世界上最好用的语言！");
	}
}

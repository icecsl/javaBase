package designMode.adapter.impl;

import designMode.adapter.AdvancedMediaPlayer;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/8/10
 */
public class VlcPlayer implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing vlc file. Name: "+ fileName);
	}

	@Override
	public void playMp4(String fileName) {
		//什么也不做
	}
}

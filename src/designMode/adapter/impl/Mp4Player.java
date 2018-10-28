package designMode.adapter.impl;

import designMode.adapter.AdvancedMediaPlayer;

/**
 * @Description:
 * @author: huangbingjing
 * @date: 18/8/10
 */
public class Mp4Player implements AdvancedMediaPlayer {
	@Override
	public void playVlc(String fileName) {
		//什么也不做
	}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: "+ fileName);
	}
}

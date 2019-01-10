package com.hbj.variableparam;

/**
 * @Description: param[i]获取第i个参数
 * @author: huangbingjing
 * @date: 18/11/8
 */
public class Validator {

	public static void validate(Object... param){

		if(param!=null){
			for(int i=0;i<param.length;i++){
				System.out.println("第"+i+": "+ param[i]);
			}
			System.out.println("总个数： "+param.length);
		}

		System.out.println("=========结束==========");
	}
}

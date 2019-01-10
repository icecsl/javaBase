package com.hbj.collection.arraylist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by huangbingjing on 18/1/25.
 */
public class ArrayListTest {
	public static void main(String[] args) throws InterruptedException {

		normalTest();

//		arrayListCollectionTest();

//		threadTest();





	}

	public static void normalTest(){
		List<String> list = new ArrayList<>(0);
//		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add(null);
		list.add(null);
		list.add(null);

		System.out.println(list);




		List<String> strings = list.subList(0,3);
		list.add("e");
		System.out.println("==========");
		System.out.println(list);
//		System.out.println(strings.size());

		System.out.println(strings == list);

		List<Integer> list1 = new ArrayList<Integer> ();
		list1.add(1);
		list1.add(2);

		//通过构造函数新建一个包含list1的列表 list2
		List<Integer> list2 = new ArrayList<Integer>(list1);

		//通过subList生成一个与list1一样的列表 list3
		List<Integer> list3 = list1.subList(0, list1.size());

		//修改list3
		list3.add(3);

		System.out.println("list1 == list2：" + list1.equals(list2));
		System.out.println("list1 == list3：" + list1.equals(list3));

	}





	public static void arrayListCollectionTest(){
		Collection a = new ArrayList();
		((ArrayList) a).add(1);
		((ArrayList) a).add("v");

		List<String> list = new ArrayList<>(a);

		System.out.println(list);


	}

	public static void threadTest() throws InterruptedException {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						list.add(1);// 多执行几次会出现ArrayIndexOutOfBoundsException异常
					}
				}
			}).start();
		}
		Thread.sleep(100);// 等待子线程完全执行完毕
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null) {
				System.out.println("i:" + i + ",数据：" + list.get(i));
			}
		}
		System.out.println("list.size():" + list.size());

	}
}

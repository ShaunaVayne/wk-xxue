package com.wk.test.ch2;

import java.util.LinkedList;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/2/25 11:13 PM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class Test {
	private static LinkedList<Integer> danjia = new LinkedList<Integer>();
	private static Integer max = 10;
	private static class ZhuangDan extends Thread{
		@Override
		public void run() {
			synchronized (danjia){
				while (danjia.size() < max){
					 danjia.addLast(1);
					System.out.println("装弹后的容量:"+danjia.size());
				}
				danjia.notifyAll();
			}
		}
	}
	private static class SheDan extends Thread{
		@Override
		public void run() {
			synchronized (danjia){
				while (danjia.isEmpty()){
					try {
						danjia.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				danjia.removeFirst();
				System.out.println("射弹后的容量:"+danjia.size());
			}
		}
	}

	public void start(){
		Thread[] zhaungdanRun = new Thread[10];
		Thread[] shedanRun = new Thread[10];
		for (int i = 0; i < shedanRun.length; i++) {
			zhaungdanRun[i] = new Thread(new ZhuangDan());
			shedanRun[i] = new Thread(new SheDan());
		}
		for (int i = 0; i < shedanRun.length; i++) {
			zhaungdanRun[i].start();
			shedanRun[i].start();
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new SheDan().start();
		}
		new ZhuangDan().start();
	}
}

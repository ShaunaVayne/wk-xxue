package com.wk.test.ch2;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/4 9:26 PM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class SleepSort extends Thread {

	private int num;

	public SleepSort(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(num);
			System.out.println(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int[] arr = {8,39,900,289,2,1};
		Thread[] threads = new Thread[arr.length];
		for (int i = 0; i < arr.length; i++) {
			threads[i] = new Thread(new SleepSort(arr[i]));
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}

	}
}

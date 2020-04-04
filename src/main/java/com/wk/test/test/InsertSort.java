package com.wk.test.test;

import com.alibaba.fastjson.JSON;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/15 10:19 PM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class InsertSort {

	private static int[] arr = {12,3,5,2,5,1,4,90};

	public static int[] sort(int[] arr) {
		int current;
		for (int i = 0; i < arr.length - 1; i++) {
			current = arr[i + 1];
			while (i >= 0 && arr[i] > current) {
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = current;
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(JSON.toJSONString(sort(arr)));
	}
}

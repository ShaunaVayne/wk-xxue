package com.wk.test.ch2;

import com.alibaba.fastjson.JSON;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/4 9:35 PM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class InsertionSort {

	public static int[] sort(int[] arr) {
		int current;
		for(int i = 0; i < arr.length - 1; i++){
			current = arr[i + 1];
			while (i >= 0 && current < arr[i]){
				arr[i + 1] = arr[i];
				i--;
			}
			arr[i + 1] = current;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {8,39,900,289,2,1};
		System.out.println(JSON.toJSONString(sort(arr)));
	}
}

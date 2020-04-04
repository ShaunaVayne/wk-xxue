package com.wk.test.ch2;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/3 10:06 PM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class BinarySearch {

	public static int serch(int[] arr, int val) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end){
			int mid = (start + end) >>> 1;
			if(arr[mid] == val){
				return val;
			}else if(arr[mid] > val){
				start = mid  + 1;
			}else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {9,8,7,4,3,2};
		System.out.println(serch(arr,5));
	}
}

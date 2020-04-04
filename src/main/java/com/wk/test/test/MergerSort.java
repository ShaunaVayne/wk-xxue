package com.wk.test.test;

import com.alibaba.fastjson.JSON;
import com.wk.test.tools.MakeArray;

import java.util.Arrays;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/15 10:33 PM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class MergerSort {

	private static final int DEFAULT_LENGTH = 10;

	public static int[] mergerSort(int[] arr) {
		if(arr.length <= DEFAULT_LENGTH) {
			return InsertSort.sort(arr);
		}else {
			int mid = arr.length >>> 1;
			int[] left = Arrays.copyOfRange(arr, 0, mid);
			int[] right = Arrays.copyOfRange(arr, mid, arr.length);
			return merger(mergerSort(left),mergerSort(right));
		}
	}

	public static int[] merger(int[] left, int[] right) {
		int[] resultArr = new int[left.length + right.length];
		for (int i = 0, j = 0, index = 0; index < resultArr.length; index++) {
			if (i >= left.length) {
				resultArr[index] = right[j++];
			} else if (j >= right.length) {
				resultArr[index] = left[i++];
			} else if (left[i] > right[j]) {
				resultArr[index] = right[j++];
			} else {
				resultArr[index] = left[i++];
			}
		}
		return resultArr;
	}

	public static void main(String[] args) {
		int[] array = MakeArray.makeArray();
		System.out.println(JSON.toJSONString(mergerSort(array)));
	}
}

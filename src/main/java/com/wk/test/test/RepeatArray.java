package com.wk.test.test;

import com.alibaba.fastjson.JSON;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/15 10:09 AM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class RepeatArray {

	private static int[] arr = {1,1,1,1};

	public static int[] qc(int[] arr) {
		int[] tempArr = new int[arr.length];
		int tempIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean flag = true;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				tempArr[tempIdx] = arr[i];
				tempIdx++;
			}
		}
		int[] resultArr = new int[tempIdx];
		System.arraycopy(tempArr, 0, resultArr, 0, tempIdx);
		return resultArr;
	}

	public static void main(String[] args) {
		int[] result = qc(arr);
		System.out.println(JSON.toJSONString(result));
	}

}

package com.wk.test.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/15 10:42 AM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class RepeatList {

	private static List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,1,1,1,1));

	public static List<Integer> qc(List<Integer> list) {
		int current;
		List<Integer> indexList = new ArrayList<Integer>();
		for (int i = 0; i < list.size() - 1; i++) {
			int tempIdx = i;
			current = list.get(i + 1);
			while (tempIdx >= 0) {
				if (current == list.get(tempIdx)) {
					indexList.add(i + 1);
					break;
				}
				tempIdx--;
			}
		}
		for (int i = indexList.size() - 1; i >= 0; i--) {
			list.remove(indexList.get(i).intValue());
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(JSON.toJSONString(qc(list)));
	}
}

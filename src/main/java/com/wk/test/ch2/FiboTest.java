package com.wk.test.ch2;

import java.util.LinkedList;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/3 10:11 PM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class FiboTest {

	private static final LinkedList<Integer> res = new LinkedList<Integer>();;

	public static int f1(int n) {
		if (n < 2){
			return n;
		}else {
			return f1(n - 1) + f1(n -2);
		}
	}

	public static int f2(int n) {
		if(n == 0){
			return 0;
		}
		if(n == 1 || n == 2) {
			return 1;
		}
		int first = 1;
		res.add(first);
		int second = 1;
		res.add(second);
		while (n-- > 1){
			second = second + first;
			first = second - first;
			res.add(second);
		}
		return second;
	}

	// 1,1,2,3,5,8
	public static void main(String[] args) {
		System.out.println(f1(2));
		System.out.println(f2(2));
		System.out.println(res);
	}
}

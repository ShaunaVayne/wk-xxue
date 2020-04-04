package com.wk.test.test;

import com.alibaba.fastjson.JSON;
import com.wk.test.tools.MakeArray;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2020/3/15 11:32 PM
 * @ProjectName: wk-xxue
 * @Version: 1.0.0
 */
public class FkSort {

	private static class FkTask extends RecursiveTask<int[]> {

		private int[] src;

		private static final int DEFAULT_LENGTH = 10;

		public FkTask(int[] src) {
			this.src = src;
		}

		@Override
		protected int[] compute() {
			if(src.length <= DEFAULT_LENGTH) {
				return InsertSort.sort(src);
			}else {
				int mid = src.length >>> 1;
				int[] left = Arrays.copyOfRange(src, 0, mid);
				int[] right = Arrays.copyOfRange(src, mid, src.length);
				FkTask leftTask = new FkTask(left);
				FkTask rightTask = new FkTask(right);
				invokeAll(leftTask,rightTask);
				return MergerSort.merger(leftTask.join(),rightTask.join());
			}
		}
	}

	public static void main(String[] args) {
		// 测试提交
		ForkJoinPool pool = new ForkJoinPool();
		int[] src = MakeArray.makeArray();
		FkTask fkTask = new FkTask(src);
		System.out.println(JSON.toJSONString(pool.invoke(fkTask)));
	}
}

package cn.hutool.core.collection;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 集合索引环形获取工具类测试类
 *
 * @author ZhouChuGang
 * @version 1.0
 * @project hutool
 * @date 2021/10/13 18:47
 */
public class RingIndexUtilTest {

	private final List<String> strList = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

	/**
	 * 观察输出的打印为不重复的
	 */
	@Test
	public void ringNextLongByObjTest() {
		final AtomicLong atomicLong = new AtomicLong();
		// 开启并发测试，每个线程获取到的元素都是唯一的
		ThreadUtil.concurrencyTest(strList.size(), () -> {
			final long index = RingIndexUtil.ringNextLongByObj(strList, atomicLong);
			final String s = strList.get((int) index);
			System.out.println(s);
		});
	}

	/**
	 * 观察输出的打印为不重复的
	 */
	@Test
	public void ringNextIntByObjTest() {
		final AtomicInteger atomicInteger = new AtomicInteger();
		// 开启并发测试，每个线程获取到的元素都是唯一的
		ThreadUtil.concurrencyTest(strList.size(), () -> {
			final int index = RingIndexUtil.ringNextIntByObj(strList, atomicInteger);
			final String s = strList.get(index);
			System.out.println(s);
		});
	}

}

package com.cqupt.collections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Map<K,V> 接口
 * @author Mauger
 * @date 2019年7月5日 下午5:03:48
 * @version V1.0
 */
public class MapInterface
{
	public static void main(String[] args)
	{
		/**
		 * HashMap 初始容量大小为：16；负载因子为：0.75；Key-Value 可以为 null。
		 * 	当存储容量大于初始容量大小的 3/4（x>12） 时，会自动扩容为原来的 2 倍（32），扩容后会重新存储（比如最开始是 x 对 16 取余，经过一次扩容后会对 32 取余重新存储）
		 * 	键为 null 的存储下标为：0；HashMap 是无序的。在调用 keySet() 方法时会从下标为 0 处开始输出。如：0，1，2，3...
		 * 
		 * HashTable 初始容量大小为：11；负载因子为：0.75；Key-Value 不能为 null。
		 * 	当存储容量大于初始容量大小的 3/4（x>8） 时，会自动扩容为原来的 2 倍（23）。
		 * 	HashTable 也是无序的。在调用 keySet() 方法时会从下标为 (size() - 1) 处开始输出。如：7，6，5，4...
		 * 	// Hashtable 继承 Dictionary 抽象类，是 Dictionary 的具体实现，Dictionary 已过时。
		 */
		mapTest();
//		printHashMapKey();
//		printHashTableKey();
//		HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
//		hashMap.put(1, null);
//		hashMap.put(2, 2);
//		System.out.println(hashMap.get(1));
//		System.out.println(hashMap.get(2));
//		System.out.println(hashMap.containsKey(11));
		
	}

	static void mapTest()
	{
		Map<Object, Object> hashMap = new HashMap<Object, Object>();
		Map<Object, Object> hashTable = new Hashtable<Object, Object>();
		
		hashMap.put(null, null);
		hashMap.put(0, null);
		hashMap.put(1, null);
		hashMap.put(1, 1);
		hashMap.put(2, 1);
		hashMap.put(3, 1);
		hashMap.put(4, 1);
		hashMap.put(5, 1);
		hashMap.put(6, 1);
		hashMap.put(7, 1);
		hashMap.put(8, 1);
		hashMap.put(9, 1);
		hashMap.put(10, 1);
		hashMap.put(11, 1);
		hashMap.put(12, 1);
		hashMap.put(13, 1);
		hashMap.put(14, 1);
		hashMap.put(15, 1);
		hashMap.put(16, 1);
		hashMap.put(17, 1);
		hashMap.put(18, 1);
		
		hashMap.put("a", 1);
		hashMap.put("b", 1);
		hashMap.put("c", 1);
		hashMap.put("d", 1);
		hashMap.put("e", 1);
		hashMap.put("f", 1);
		hashMap.put("g", 1);
		hashMap.put("h", 1);
		hashMap.put("i", 1);
		hashMap.put("j", 1);
		hashMap.put("k", 1);
		hashMap.put("l", 1);
		hashMap.put("m", 1);
		hashMap.put("n", 1);
		hashMap.put("o", 1);
		
		// HashTable
		hashTable.put(0, 1);
		hashTable.put(1, 1);
		hashTable.put(2, 1);
		hashTable.put(3, 1);
		hashTable.put(4, 1);
		hashTable.put(5, 1);
		hashTable.put(6, 1);
		hashTable.put(7, 1);
		hashTable.put(8, 1);
		hashTable.put(9, 1);
		hashTable.put(10, 1);
		hashTable.put(11, 1);
		hashTable.put(12, 1);
		
		for (Object object : hashMap.keySet())
		{
			System.out.print(object + ", ");
		}
		
		System.out.println();
		for (Object object : hashTable.keySet())
		{
			System.out.print(object + ", ");
		}
	}
	
	static void printHashMapKey()
	{
		HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
		for (int i = 0; i < 20; i++)
		{
			hashMap.put((int) (Math.random() * 100), Math.random() * 10);
		}
		
		for (Object object : hashMap.keySet())
		{
			System.out.println(object);
		}
	}
	
	static void printHashTableKey()
	{
		Map<Object, Object> hashTable = new Hashtable<Object, Object>();
		for (int i = 0; i < 15; i++)
		{
			hashTable.put((int) (Math.random() * 100), Math.random() * 10);
		}
		
		for (Object object : hashTable.keySet())
		{
			System.out.println(object);
		}
	}
}

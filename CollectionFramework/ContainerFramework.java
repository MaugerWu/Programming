package com.cqupt.interview.offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 容器的打印
 * @author Mauger
 * @date 2019年7月11日 下午9:39:50
 * @version V1.0
 */
public class ContainerFramework
{
	static Collection<String> fill (Collection<String> collection)
	{
		collection.add("pig");
		collection.add("dog");
		collection.add("cat");
		collection.add("dog");
		collection.add("duck");
		return collection;
	}
	
	static Map<String, String> fill (Map<String, String> map)
	{
		map.put("pig", "White");
		map.put("dog", "Black");
		map.put("cat", "Gray");
		map.put("dog", "White");
		map.put("duck", "Yellow");
		return map;
	}
	
	public static void main(String[] args)
	{
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new LinkedList<String>()));
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new TreeSet<String>()));
		System.out.println(fill(new LinkedHashSet<String>()));
		System.out.println(fill(new HashMap<String, String>()));
		System.out.println(fill(new TreeMap<String, String>()));
		System.out.println(fill(new LinkedHashMap<String, String>()));
	}
}

// 打印结果
[pig, dog, cat, dog, duck]
[pig, dog, cat, dog, duck]
[duck, cat, dog, pig]
[cat, dog, duck, pig]
[pig, dog, cat, duck]
{duck=Yellow, cat=Gray, dog=White, pig=White}
{cat=Gray, dog=White, duck=Yellow, pig=White}
{pig=White, dog=White, cat=Gray, duck=Yellow}

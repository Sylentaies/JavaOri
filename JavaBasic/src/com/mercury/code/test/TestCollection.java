package com.mercury.code.test;

import java.util.*;

import org.junit.Test;

public class TestCollection {

	@Test
	public void testList() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		//First way to traverse a list
		System.out.println("**********First way for list**********");
		for(int i= 0;i<list.size();i++){
			System.out.println(list.get(i)+" ");
		}
		System.out.println();
		
		//Second way to traverse a list
		System.out.println("**********Second way for list**********");
		for (String str:list){
			System.out.println(str+" ");
		}
		System.out.println();
		//Third way to traverse a list
		System.out.println("**********Third way for list**********");
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next()+" ");
		}
		System.out.println();
	}
	
	
	@Test
	public void testSet(){
		Set<Integer> set = new HashSet<Integer>();

		set.add(100);
		set.add(200);
		set.add(300);
		
		//First way to traverse a set
		System.out.println("**********First way for set**********");
		for(int x:set){
			System.out.println(x+" ");
		}
		System.out.println();
		
		//Second way to traverse a set
		System.out.println("**********Second way for set**********");
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next()+" ");
		}
		System.out.println();
	}
	@Test
	public void testMap(){
		Map <String,String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		//Use keySet function
		Set<String> keys = map.keySet();
		
		//First way to traverse a map
		System.out.println("**********First way for map**********");
		for (String key:keys){
			System.out.println(key+ ": "+map.get(key));
		}
		//Second way to traverse a map
		System.out.println("**********Second way for map**********");		
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + ": "+ map.get(key));
		}
		
		//Use Map.Entry
		Set <Map.Entry<String,String>> entries = map.entrySet();
		
		////Third way to traverse a map
		System.out.println("**********Third way for map**********");		
		for (Map.Entry <String, String>entry:entries){
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		System.out.println();
		//Fourth way to traverse a map
		System.out.println("**********Fourth way for map**********");
		Iterator<Map.Entry<String, String>> entryIt = entries.iterator();
		while (entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
}

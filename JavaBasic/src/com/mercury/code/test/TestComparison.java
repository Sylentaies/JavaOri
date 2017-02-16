package com.mercury.code.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.mercury.code.BeanA;
import com.mercury.code.BeanB;

public class TestComparison {

	@Test
	public void testComparable() {
		List<BeanA> list = new ArrayList<BeanA>();
		list.add(new BeanA(5));
		list.add(new BeanA(7));
		list.add(new BeanA(3));
		assertEquals(5, list.get(0).getX());
		assertEquals(7, list.get(1).getX());
		assertEquals(3, list.get(2).getX());
		Collections.sort(list);
		assertEquals(3, list.get(0).getX());
		assertEquals(5, list.get(1).getX());
		assertEquals(7, list.get(2).getX());
	}
	
	@Test
	public void testComparator() {
		List<BeanB> list = new ArrayList<BeanB>();
		list.add(new BeanB(5));
		list.add(new BeanB(7));
		list.add(new BeanB(3));
		assertEquals(5, list.get(0).getX());
		assertEquals(7, list.get(1).getX());
		assertEquals(3, list.get(2).getX());
		Collections.sort(list,new Comparator<BeanB>(){

			@Override
			public int compare(BeanB first, BeanB second) {
				// TODO Auto-generated method stub
				return first.getX()- second.getX();
			}
			
		});
		assertEquals(3, list.get(0).getX());
		assertEquals(5, list.get(1).getX());
		assertEquals(7, list.get(2).getX());
	}
	@Test(expected = ConcurrentModificationException.class)
	public void testFailFastIterator(){
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		Iterator<String> it = list.iterator();
		list.add("D");list.remove("D");
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}

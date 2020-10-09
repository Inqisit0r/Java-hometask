package com.company;

public class List
{

	class Item {
		private int value;
		private Item next;
//		private Item before;
		public Item(int value) {
			this.value = value;
			this.next = null;
//			this.before = null;

		}

		public boolean hasNext() {
			if (this.next != null){
				return true;
			}
			else {
				return false;
			}
		}

//		public boolean hasBefore() {
//			if (this.before != null) {
//				return true;
//			}
//			else {
//				return false;
//			}
//		}

		public String toString() {
			return Long.toString(this.value);
		}

		public int getValue() {
			return value;
		}

		public Item getNext() {
			return next;
		}

		public void setNext(Item next) {
			this.next = next;
		}
//
//		public Item getBefore() {
//			return before;
//		}
//
//		public void setBefore(Item before) {
//			this.before = before;
//		}
	}
	private Item begin;
	private long counter;

	public List() {
		this.begin = null;
		this.counter = 0;
	}

	public void add(int value){
		Item item = new Item(value);
		if (this.begin == null){
			this.begin = item;
		}
		else {
			end().setNext(item);
		}
		this.counter ++;
	}

	public Item end(){
		if (this.begin == null)
			return null;
		Item iter = this.begin;
		while (iter.hasNext()) {
			iter = iter.getNext();
		}
		return iter;
	}

	public String toString() {
		String result = "[ ";
		if (this.begin == null) {
			return null;
		}
		else {
			Item iter = this.begin;
			while (iter.hasNext()) {
				result += iter.toString() + ", ";
				iter = iter.getNext();
			}
			result += iter.toString();
		}
		result += " ]";
		return result;
	}

	public void swap (int firstPoth, int secondPoth) {
		Item preFirst = indexAt(firstPoth - 1);
		Item first = indexAt(firstPoth);
		Item aftFirst = indexAt(firstPoth + 1);
		Item preSecond = indexAt(secondPoth - 1);
		Item second = indexAt(secondPoth);
		Item aftSecond = indexAt(secondPoth + 1);

		if (preFirst != null) {
			preFirst.setNext(second);
		}
		else {
			this.begin = second;
		}
		first.setNext(aftSecond);
		if (preSecond == first) {
			second.setNext(first);
		}
		else {
			second.setNext(aftFirst);
			preSecond.setNext(first);
		}
	}

	public Item indexAt (int index) {
		if (index <= this.counter - 1 && index >= 0) {
			Item iter = this.begin;
			for (; index > 0; --index) {
				iter = iter.getNext();
			}
			return iter;
		}
		else
			return null;
	}
}
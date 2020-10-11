package com.company;

public class List
{

	class Item {
		private int value;
		private Item next;
		public Item(int value) {
			this.value = value;
			this.next = null;

		}

		public boolean hasNext() {
			if (this.next != null){
				return true;
			}
			else {
				return false;
			}
		}

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

	public void swap (int firstPos, int secondPos) {
		Item preFirst = indexAt(firstPos - 1);
		Item first = indexAt(firstPos);
		Item aftFirst = indexAt(firstPos + 1);
		Item preSecond = indexAt(secondPos - 1);
		Item second = indexAt(secondPos);
		Item aftSecond = indexAt(secondPos + 1);

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

	public void sort () {
		long count = this.counter;
		int i;
		Item a;
		Item b;
		while (count > 0) {
			i = 0;
			a = indexAt(i);
			b = indexAt(i + 1);
			while (i + 1 < count) {
				if (a.getValue() > b.getValue()) {
					swap(i, i + 1);
					i += 1;
					a = indexAt(i);
					b = indexAt(i + 1);
				}
				else if(a.getValue() <=  b.getValue()) {
					++i;
					a = a.getNext();
					b = b.getNext();
				}
			}
			--count;
		}
	}
}
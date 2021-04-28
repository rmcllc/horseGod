package com.ryan.horsegod.nodes;

public class Node2 {
	public Double value;
	public Node2 previous;
	public Node2 next;
	
	public Node2(Double val) {
		this.value = val;
		this.previous = null;
		this.next = null;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Node2 getPrevious() {
		return previous;
	}

	public void setPrevious(Node2 previous) {
		this.previous = previous;
	}

	public Node2 getNext() {
		return next;
	}

	public void setNext(Node2 next) {
		this.next = next;
	}
}

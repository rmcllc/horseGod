package com.ryan.horsegod.nodes;

public class Node {
	public Double value;
	public Node previous;
	public Node next;
	
	public Node(Double val) {
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

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

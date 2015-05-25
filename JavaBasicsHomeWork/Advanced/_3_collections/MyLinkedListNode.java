package _3_collections;

public class MyLinkedListNode <T> {
	T data;
	MyLinkedListNode <T> link;
	
	public MyLinkedListNode(T data) {
		this.data = data;
		this.link = null;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}
	
	
	
}

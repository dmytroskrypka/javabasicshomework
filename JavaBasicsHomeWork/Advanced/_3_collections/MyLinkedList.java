package _3_collections;



public class MyLinkedList <T>{
	
	int size;
	MyLinkedListNode <T> firstLink;
	//MyLinkedListNode <T> lastLink;

	public MyLinkedList() {
		this.size = 0;
		this.firstLink = null;
	}
	
	public void add(T data) {
		if (this.firstLink == null){
			MyLinkedListNode <T> node = new MyLinkedListNode<T>(data);
			this.firstLink = node;
		} else {
			this.getLastNode().link = new MyLinkedListNode<T>(data);
		}
	}
	
	public MyLinkedListNode<T> getLastNode(){
		MyLinkedListNode <T> node = this.firstLink;
		if(!(node==null)){
			while (!(node.link==null)){
				node = node.link;
			}
		}
		return node;
	}
	
	public void deleteNode(T data){
		MyLinkedListNode <T> node = this.firstLink;
		
		if(!(node==null)){
			while (!(node.link==null)){
				if(node.data == data){
					
				}
				node = node.link;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		MyLinkedListNode <T> node = this.firstLink;
		while(!(node==null)){
			sb.append(node.toString());
			node = node.link;
		}
		sb.append("}");
		return sb.toString();
	}
	
	
	

}

package _3_collections;



/*Implement an algorithm to delete a node in the middle of a single linked list, given only access to
that node.
EXAMPLE
Input: the node ‘c’ from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a->b->d->e*/

public class DeleteNodeTask {

	public static void main(String[] args) {
		MyLinkedList<Character> list = new MyLinkedList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		list.add('e');
		
		System.out.println(list.toString());
	}

}

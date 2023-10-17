
public class Node<T>  {
public T data;
public Node <T> next;
public Node()//total=2   bigO(1)
{
	next=null;//1
	data=null;//1
	
}
public Node(T val) {//total=2  bigO(1)
	data=val;//1
	next=null;//1
}
public T getData() {//1 bigO(1)
	return data;//1
}
public void setData(T data) {//1   bigO(1)
	this.data = data;//1
}
public Node<T> getNext() {//1 bigO(1)
	return next;//1
}
public void setNext(Node<T> next) {//1 bigO(1)
	this.next = next;//1
}

}
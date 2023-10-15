public class linkedlist <T extends Comparable<T>> implements list <T>{
public Node<T> head;
public Node<T> current;
public linkedlist() {
	head=current=null;
}
@Override
public void findfirst() {
	current=head;
	
}
@Override
public void findnext() {
	current=current.next;
	
}
@Override
public T retreive() {
	
	return current.data;
}
@Override
public void update(T e) {
	current.data=e;
	
}


@Override
public void remove() {
	Node<T> tmp=head;
	if(head==current) {
		head=head.next;
	}else {
		while(tmp.next!=current) {
			tmp=tmp.next;
		}
		tmp.next=current.next;
	}
	if(current.next==null)
		current=head;
	else
		current=current.next;
}
@Override
public boolean full() {
	return false;
}
@Override
public boolean last() {
	return current.next==null;
}
@Override
public boolean empty() {
	return head==null;
}
@Override
public boolean search(T e) { // make search please
	// TODO Auto-generated method stub
	return false;
}



public void InsertE(Event data) {
    Node<T> tmp=new Node(data);
    if(head==null) {
        head=current=tmp;
    return;}
    if(((Event)tmp.getData()).compareTo(((Event)head.getData()))<0){
            tmp.setNext(head);
            head=tmp;
            return;
            }
    else {
        Node<T>pre=head;
        current=head.getNext();
        while(current!=null) {
            if(((Event)tmp.getData()).compareTo(((Event)current.getData()))<0) {
            tmp.setNext(current);
            pre.setNext(tmp);
            current=tmp;
            return;}
        pre=current;
        current=current.next;

        }
        if(current==null) {//check
            pre.setNext(tmp);
            current=tmp;
        }return;
    }
}
public void InsertC(Contact data) {
    Node<T> tmp=new Node(data);
    if(head==null) {
        head=current=tmp;
        return;}
    if(((Contact)tmp.getData()).compareTo(((Contact)head.getData()))>0){
            tmp.setNext(head);
            head=tmp;
            return;
            }
    else {
        Node<T>pre=head;
        current=head.next;
        while(current!=null) {
            if(((Contact)tmp.getData()).compareTo(((Contact)current.getData()))>0) {
            tmp.setNext(current);
            pre.setNext(tmp);
            current=tmp;return;}
        pre=current;
        current=current.next;

        }
        if(current==null) {//check
            pre.setNext(tmp);
            current=tmp;
        }return;
    }
}




}
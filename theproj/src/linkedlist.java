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
	if(head==current) {
		head=head.next;
	}
	else {
		Node<T> tmp=head;
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

public void Insert(T data) {
    Node<T> tmp=new Node<T>(data);
    if(head==null) {
        head=current=tmp;
    return;
    }
    if((tmp.getData()).compareTo((head.getData())) <0){
            tmp.setNext(head);
            head=tmp;
            return;
            }
    else {
        Node<T>pre=head;
        current=head.getNext();
        while(current!=null) {
            if((tmp.getData()).compareTo((current.getData())) <0) {
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

}
public class linkedlist <T extends Comparable<T>> implements list <T>{
public Node<T> head;
public Node<T> current;
public linkedlist() {//1 bigO(1)
	head=current=null;//1
}
@Override
public void findfirst() {//1  bigO(1)
	current=head;//1
	
}
@Override
public void findnext() {//1 bigO(1)
	current=current.next;//1
	
}
@Override
public T retreive() {//1 bigO(1)
	
	return current.data;//1
}
@Override
public void update(T e) {//1 bigO(1)
	current.data=e;//1
	
}


@Override
public void remove() {//2n+10 bigO(n)
	if(head==current)//1 
		{head=head.next;//1
	}
	else {//1
		Node<T> tmp=head;//1
		while(tmp.next!=current)//n+1
		{
			tmp=tmp.next;//n
		}//for this while 2n+1
		tmp.next=current.next;//1
	}
	if(current.next==null)//1
		current=head;//1
	else//1
		current=current.next;//1
}
@Override
public boolean full() {//1 bigO(1)
	return false;//1
}
@Override
public boolean last() {//1 BigO(1)
	return current.next==null;//1
}
@Override
public boolean empty() {//1 BigO(1)
	return head==null;//1
}

public void Insert(T data) //4n+20 ->bigO(n) 
{
    Node<T> tmp=new Node<T>(data);//1
    if(head==null) //1
    {
        head=current=tmp;//1
    return;//1
    }
    if((tmp.getData()).compareTo((head.getData())) <0)//1
    {
            tmp.setNext(head);//1
            head=tmp;//1
            return;//1
            }
    else //1
    {
        Node<T>pre=head;//1
        current=head.getNext();//1
        while(current!=null) //n+1
        {
            if((tmp.getData()).compareTo((current.getData())) <0) //n
            {
            tmp.setNext(current);//1
            pre.setNext(tmp);//1
            current=tmp;//1
            return;//1
            }
        pre=current;//n
        current=current.next;//n

        }// for this loop it's will be equals to 4n+4   check pls<<<<<<<<----------
        if(current==null) //1
        {
            pre.setNext(tmp);//1
            current=tmp;//1
        }return;//1
    }
}

}
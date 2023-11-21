import java.util.Scanner;

public class BST {
BSTNode root, current;
boolean found;
public Scanner input=new Scanner(System.in); //check


    public BST() {
        root = current = null;
    }

    public boolean empty() {
        return root == null;
    }

    public boolean full() {
        return false;
    }

    public Contact retrieve () {
        return current.getData();
    }
    

    public boolean findkey(String tkey) {
        BSTNode p=root , q=root;;

        if(empty())
            return false;

        while(p!=null) {
            q=p;
            if(p.key.compareTo(tkey) == 0) {
                current=p;
                return true;
            }
            else if(tkey.compareTo(p.key) < 0)
                p=p.left;
            else
                p=p.right;
        }
        current=q;
        return false;
    }

    public void insert(Contact c) {
        root = insertRec(root, c.getContactName() ,c);
        System.out.print(root.getData().getContactName());
    }

    // A recursive function to insert a new key and data into the BST
    private BSTNode insertRec(BSTNode root, String key, Contact data) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new BSTNode(key, data);
            return root;
        }

        // Otherwise, recur down the tree
        int compareResult = key.compareTo(root.key);
        
        if (compareResult < 0) {
            root.left = insertRec(root.left, key, data);
        } else if (compareResult > 0) {
            root.right = insertRec(root.right, key, data);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    public Contact search_name(String key)  { 
        if (search_Rec_name( key) != null)
            return search_Rec_name( key); 
        else
            return null;
    }
   
    private Contact search_Rec_name(String key)  { 
    	BSTNode p=root , q=root;;

        if(empty())
            return null;

        while(p!=null) {
            q=p;
            if(p.key.compareTo(key) == 0) {
                current=p;
                return p.getData();
            }
            else if(key.compareTo(p.key) < 0)
                p=p.left;
            else
                p=p.right;
        }
        current=q;
        return null;
    } 
    
    public Contact search_phone(String num)  { 
    	int x = 0;
    	return inorder(num, x);
    }
    
    public void search_email(String email) {
    	int x = 1;
    	inorder(email, x);
    }
    
    public void search_address(String address) {
    	int x = 2;
    	inorder(address, x);
    }
    
    public void search_birthday(String birthday) {
    	int x = 3;
    	inorder(birthday, x);
    }
    
    private Contact inorder(String data, int x) { 
    	if(x == 0)
    		return inorder_phone(root, data); 
    	else {
    		inorder_Recursive(root, data, x);
    		return null;
    	}
    	
    } 
    
    private Contact inorder_phone(BSTNode root, String data) { 
    		if (root != null) { 
    			inorder_phone(root.left, data); 
    			if(data.compareTo(root.getData().getPhoneNumber()) == 0 ) {
    				return root.getData();
    			}
    			inorder_phone(root.right, data); 
    		} 
    		return null;
    	}
    // recursively traverse the BST  
    private void inorder_Recursive(BSTNode root, String data, int select) { 
    	found = false;
    	
    	switch(select) {
    	case 1:
    		if (root != null) { 
    			inorder_Recursive(root.left, data, select); 
    			if(data.compareTo(root.getData().getEmailAddress()) == 0 ) {
    				System.out.println(root.getData().toString());
    				if(!found) {
    					System.out.println("Contacts found");
    				}
    				found = true;
    			}
    			inorder_Recursive(root.right, data, select); 
    		} 
    		
    	case 2:
    		if (root != null) { 
    			inorder_Recursive(root.left, data, select); 
    			if(data.compareTo(root.getData().getAddress()) == 0 ) {
    				System.out.println(root.getData().toString());
    				if(!found) {
    					System.out.println("Contacts found");
    				}
    				found = true;
    			}
    			inorder_Recursive(root.right, data, select); 
    		} 
    		
    	case 3:
    		if (root != null) { 
    			inorder_Recursive(root.left, data, select); 
    			if(data.compareTo(root.getData().getBirthday()) == 0 ) {
    				System.out.println(root.getData().toString());
    				if(!found) {
    					System.out.println("Contacts found");
    				}
    				found = true;
    			}
    			inorder_Recursive(root.right, data, select); 
    		}
    		
    	}
    	if(!found) {
    		System.out.println("there is no email with this :"+data);//1
    	}
    } 
    
    public String extractfirst(String fullname) //    bigO(n) total=5n+5
    { // this method is to extract each first name form the list of contact
    	
    	int index = 0;//1
        char currentChar = fullname.charAt(index);//1
        String firstname = "";//1

        while (currentChar != ' ' && index < fullname.length())//n+1
        {
            firstname += currentChar;//n
            index++;//n
            if (index < fullname.length())//n
            {
                currentChar = fullname.charAt(index);//n
            }
        }

        return firstname;//1
    	
    }
    
    public void search_firstname(String first)  { 
    	found = false;
    	search_Rec_firstname(root, first);
    	if(found) {
			System.out.println("Contacts found");
    	}
    	else
    		System.out.println("there is no contact with this first name: "+first);//1
    }
   
    private void search_Rec_firstname(BSTNode root, String data)  {
    	if (root != null) { 
    		search_Rec_firstname(root.left, data); 
			if(extractfirst(root.getData().getContactName()).equalsIgnoreCase(data) ) {
				System.out.println(root.getData().toString());	
				found = true;
			}
			search_Rec_firstname(root.right, data); 
		} 
    } 
    

    public boolean removeKey(String k) {
    	String k1 = k;
    	BSTNode p = root;
    	BSTNode q = null;
    	while (p != null) {
    		if (k1.compareTo(p.key) < 0) {
    			q = p;
    			p = p.left;
    			}
    		else if (k1.compareTo(p.key) > 0) {
    		q = p;
    		p = p.right;
    			}
    		else { // Found the key, Check the three cases 
    			if ((p.left != null) && (p.right != null)) { 
    		
    		      // Case 3: search for min in the right subtree
    			BSTNode min = p.right;
    			q = p;
    			while (min.left != null) {
    				q = min;
    				min = min.left;
    				}
    			p.key = min.key;
    			p.data = min.data;
    			k1 = min.key;
    			p = min;
    			}
    			if (p.left != null) // One child
    				p = p.left;
    			else // One or no children
    				p = p.right;
    			if (q == null)//No parent for p, root must change
    				root = p;
    			else 
    				if (k1.compareTo(q.key) < 0)
    					q.left = p;
    				else
    					q.right = p;
    			current = root;
    			return true;
    	    } 
    	}
    	return false;
    }
    
}

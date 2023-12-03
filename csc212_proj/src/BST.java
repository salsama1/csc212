
public class BST {
BSTNode root, current;
 boolean found;
 Contact found_phone;


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
    	if(found) {
			System.out.println("Contacts found");
    	}
    	else
    		System.out.println("there is no contact with this email : "+ email);//1
    }
    
    public void search_address(String address) {
    	int x = 2;
    	inorder(address, x);
    	if(found) {
			System.out.println("Contacts found");
    	}
    	else
    		System.out.println("there is no contact with this address : "+ address);//1
    }
    
    public void search_birthday(String birthday) {
    	int x = 3;
    	inorder(birthday, x);
    	if(found) {
			System.out.println("Contacts found");
    	}
    	else
    		System.out.println("there is no contact with this phbirthday : "+ birthday);//1
    }
    
    private Contact inorder(String data, int x) {
    	found = false;
    	if(x == 0) {
    		inorder_phone(root, data); 
    		if(found) 
    			return found_phone;
    		else
    			return null;
    		}
    		
    	else {
    		inorder_Recursive(root, data, x);
    		return null;
    	}
    	
    } 
    
    private void inorder_phone(BSTNode root, String data) { 
    		if (root != null) { 
    			inorder_phone(root.left, data); 
    			if(data.equalsIgnoreCase(root.getData().getPhoneNumber())) {
    				found_phone = root.getData();
    				found = true;
    			}
    			inorder_phone(root.right, data); 
    		} 
    	}
    // recursively traverse the BST  
    private void inorder_Recursive(BSTNode root, String data, int select) { 
    	
    	switch(select) {
    	case 1:
    		if (root != null) { 
    			inorder_Recursive(root.left, data, select); 
    			if(data.equalsIgnoreCase(root.getData().getEmailAddress())) {
    				System.out.println(root.getData().toString());
    				found = true;
    			}
    			inorder_Recursive(root.right, data, select); 
    		} 
    		break;
    		
    	case 2:
    		if (root != null) { 
    			inorder_Recursive(root.left, data, select); 
    			if(data.equalsIgnoreCase(root.getData().getAddress())) {
    				System.out.println(root.getData().toString());
    				found = true;
    			}
    			inorder_Recursive(root.right, data, select); 
    		}
    		break;
    		
    	case 3:
    		if (root != null) { 
    			inorder_Recursive(root.left, data, select); 
    			if(data.equalsIgnoreCase(root.getData().getBirthday())) {
    				System.out.println(root.getData().toString());
    				found = true;
    			}
    			inorder_Recursive(root.right, data, select); 
    		}
    		break;
    		
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

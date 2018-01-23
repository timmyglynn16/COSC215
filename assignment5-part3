public class TwoKeyMethods <K1 extends Comparable, K2 extends Comparable, D> {
	  
	// create two trees t1, t2
	// creates tree objects from Tree class
	  Tree<K1, TwoKeyDB<K1, K2, D>> t1=new Tree<>();
	  Tree<K2, TwoKeyDB <K1, K2, D>> t2=new Tree<>();
	  
	  
	  // "adds a record to the database"
	  void add (K1 key1, K2 key2, D data){
		  
		// pass add method to both trees with its associated tree/key/data
		// create record constructor for key1, key2, data parameters from TwoKeyDb
	    TwoKeyDB<K1, K2, D> record = new TwoKeyDB<K1, K2, D>(key1, key2, data);
	    
	    // add the record of key1 into t1
	    t1.add (key1,record);
	    // add the record of key2 into t2
	    t2.add (key2,record);
	  }
	  
	  
	 // "finds and returns the data associated with key1"
	  D find1(K1 key1){
		  
		// call find method from Tree class for:
		// create record constructor for t1 object and key1 parameter from TwoKeyDB
	    TwoKeyDB<K1, K2, D> record = t1.find (key1);
	    if(record == null) // if the record is empty
	      return null;	// null return
	    else
	      return record.data; // if not, return the record of the data
	  }
	  
	  
	  // "finds and returns the data associated with key2"
	  D find2(K2 key2) {
		  
	    // call find method from Tree class for:
		// create record constructor for t2 object and key2 parameter from TwoKeyDb
	    TwoKeyDB<K1, K2, D> record = t2.find (key2);
	    if(record == null) // if the record is empty
	      return null;	// null return
	    else
	      return record.data; // if not, return the record of the data
	  }
	  
	  
	  // "modifies the record associated with key 1 to contain the new data"
	  void modify1(K1 key1, D data){
		  
		// find key of first tree
		// create record constructor for t1 object and key1 parameter from TwoKeyDB
	    TwoKeyDB<K1, K2, D> record = t1.find (key1);
	    if(record == null) { // if record is empty
	      System.err.println("Error: key not found: "+key1); // error
	    }
	    else{
	    	
	    	  // create newRecord to replace record.key2
	      TwoKeyDB<K1, K2, D> newRecord = new TwoKeyDB<K1, K2, D>(key1, record.key2, data);
	      // call modify on key 1 and the new record
	      t1.modify(key1, newRecord);
	      // then call modify for the new record of key2
	      t2.modify (newRecord.key2, newRecord);
	    }
	  }
	  
	  
	  // "modifies the record associated with key2 to contain the new data"
	  void modify2(K2 key2, D data){
		  
		// find key of second tree
		// create record constructor for t2 object and key2 parameter from TwoKeyDB
	    TwoKeyDB<K1, K2, D> record = t2.find (key2);
	    if(record == null) { // if record is empty
	      System.err.println("Error: key not found: "+key2); // error
	    }
	    else{
	    	
	    	  // create newRecord to replace record of key2
	      TwoKeyDB<K1, K2, D> newRecord = new TwoKeyDB<K1, K2, D>(record.key1, key2, data);
	      // call modify on key2 and the new record
	      t2.modify (key2, newRecord);
	      // then call modify for the new record
	      t1.modify (newRecord.key1, newRecord);
	    }
	  }
	  
	  
	// "changes the second key of the record associated with key1 to be key2"
	void change1(K1 key1, K2 key2){
	  TwoKeyDB<K1, K2, D> record = t1.find (key1);
	  if(record == null) { // if record is empty
	    System.err.println("Error: key not found: "+key1); // error - return key1
	  }
	  else{
		// create newRecord constructor to replace record of key2
	    TwoKeyDB<K1, K2, D> newRecord = new TwoKeyDB<K1, K2, D>(key1, key2, record.data);
	    // call modify method from Tree class for key1 and newRecord
	    t1.modify (key1, newRecord);
	    // delete record of key2
	    t2.delete (record.key2);
	    // replace it with the new record
	    t2.add (key2, newRecord);
	  }
	}
	  // "changes the first key of record associated with key1 to be key2"
	  void change2(K2 key2, K1 key1){
	    TwoKeyDB<K1, K2, D> record = t2.find (key2);
	    if(record == null) { // if record is empty
	      System.err.println("Error: key not found: "+key2); // error - return key2
	    }
	    else{
	    	  // create newRecord constructor to replace the record of key1
	      TwoKeyDB<K1, K2, D> newRecord = new TwoKeyDB<K1, K2, D>(key1, key2, record.data);
	      // call modify method from Tree class for key2 and newRecord
	      t2.modify (key2, newRecord);
	      // delete the record of key1
	      t1.delete (record.key1);
	      // replace it with the new record
	      t1.add (key1, newRecord);
	    }
	  }
	    // "returns the list(key,data) in order by key1 as a string"
	    String list1(){
	    	// call toString from Tree for t1
	      return t1.toString();
	    }
	    // "returns the list (key,data) in order by key2 as a string"
	    String list2(){
	    	// call toString from Treefor t2
	      return t2.toString();
	    }
	    
	  }

	      
	      



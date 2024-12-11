// HW  add a delete method to class MyNameQueue !!!!
// demonstrate that it works !!!!
//CIT242 Data Structures
//BHCC


public class AddOnBotomQueue {

    public static void main(String[] args) {
        MyNameQueue myQueue = new MyNameQueue();

        System.out.println("Welcome to my Queue.\n");
        
        //populating the queue
        myQueue.push("Jack", "Haley");
        myQueue.push("A", "A");
        myQueue.push("John", "Smith");
        myQueue.push("Winston", "Churchill");
        myQueue.push("Nelson", "Mandela");
        myQueue.push("Mary", "Jones");

        System.out.println("before Add  :");
        myQueue.printQueue();
        System.out.println("");


        
        myQueue.addOnBotomQueues("Anatolie ", " Jentimir"); 
        System.out.println("After  Add on Bottom   :");
        myQueue.printQueue();
        System.out.println("");



    }
}

class Entry {

    String first;
    String last;

    public Entry(String first, String last) {
        this.first = first;
        this.last = last;
    }

   
  @Override
    public String toString() {
        return "first name =" + first + ", last name =" + last + " ";
    }


}

class NODE {

    Entry info;
    NODE link;

    public NODE(Entry info) {
        this.info = info;
    }

    public NODE() {
        info = new Entry("\0", "\0");
    }

}

class MyNameQueue {

    NODE top;
    NODE last;

    public MyNameQueue() {
        top = null;
		//System.out.println(top);

    }

    public void push(String firstName, String lastName) {
        Entry newEntry = new Entry(firstName, lastName);

        NODE newRecord = new NODE();
        newRecord.info = newEntry;
        newRecord.link = null;

        if (top == null) {
            top = last = newRecord;
        } else {
            last.link = newRecord; //why?
            last = newRecord;
        }

    }


    public void addOnTopQueues(String firstName, String lastName) {

        Entry newEntry = new Entry(firstName, lastName); //format the data 

        NODE newRecord = new NODE();  // make a new  node 

        newRecord.info = newEntry;   // wpload data in the new node 

        newRecord.link = null;    // set the next element to noll

        if (top == null) {
            top = last = newRecord;
        } else {

          //  last.link = newRecord; //why?  original code 
           // last = newRecord;    // original code 

           newRecord.link = top;     // link the new node to the current top node
           top = newRecord;       // set the new node as the top node


        }

    }



    public void addOnBotomQueues(String firstName, String lastName) {

        Entry newEntry = new Entry(firstName, lastName); //format the data 

        NODE newRecord = new NODE();  // make a new  node 

        newRecord.info = newEntry;   // wpload data in the new node 

        newRecord.link = null;    // set the next element to noll

        if (top == null) {         // If the queue is empty 
            top = last = newRecord;   // The new node is both the first and last node in the queue
        } else {
            last.link = newRecord;  // If the queue is not empty, link the current last node to the new node
            last = newRecord;      // And then set the new node as the last node in the queue
        }

    }






    public void printQueue() {
        NODE newTop = top;
System.out.println(top);
        while (newTop != null) {
            System.out.println(newTop.info.toString());
            newTop = newTop.link;

        }

    }

    public NODE pop() {

        if (top == null) {
            System.out.println("the queue is empty.");
            return new NODE(); //return null;
        } else {
            NODE p = top;
            top = top.link;
            System.out.println(p.info.toString());
			//p.link = null;  //is this necessary????
            return p;
        }

    }




   public void countQueue() {
        int i = 0;
        NODE p = top;

        while (p != null) {
            i++;
            p = p.link;
        }

        System.out.printf("Total items in queue: %d", i);
    }

    public void listInsert(String firstName, String lastName) {

        Entry newEntry = new Entry(firstName, lastName);
        NODE last, next;
        next = top;
        last = null; // is this necessary???? Yes, you might insert a new NODE before the top

        while ((newEntry.last.compareTo(next.info.last) > 0) && (next.link != null)) {
            last = next;
            next = next.link;
            System.out.println("here");
        }

        if (newEntry.last.compareTo(next.info.last) == 0) {
            next.info = newEntry; //update
			
			
        } 
		else
		if (newEntry.last.compareTo(next.info.last) < 0) {
            if (last == null) { //if the new entry should be insert before the top
                NODE p = new NODE(newEntry);
                p.link = top;
                top = p;

            } else {
                last.link = new NODE();
                last.link.info = newEntry;
                last.link.link = next;
            }
        } 
else {
          //  NODE temp = next.link; //store the link after next node before insert the new node after the next node
            next.link = new NODE();
            next.link.info = newEntry;
           // next.link.link = temp;
		   next.link.link = null;
        }

    }

}

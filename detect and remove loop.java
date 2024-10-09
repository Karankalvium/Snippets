// Java code to detect and remove loop in linked
// list using hashing

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {

    static void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    // Function to detect and remove 
      // loop from linked list
    static void removeLoop(Node head) {
        HashSet<Node> st = new HashSet<Node>();
        Node prev = null;
        while (head != null) {
            
              // If we have already seen this node in 
              // hash set, it means there is a cycle.
            // Set the next of the previous pointer 
              // to null to remove the cycle.
            if (st.contains(head)) {
                prev.next = null;
                return;
            }
            // If we are seeing the node for the first time,
              // insert it in hash set.
            else {
                st.add(head);
                prev = head;
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
      
        Node head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);
      
        head.next.next.next.next.next = head.next.next;

        removeLoop(head);
        printList(head);
    }
}

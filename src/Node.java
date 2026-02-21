public class Node {
    int key;
    Node next;

    public Node(int key){
        this.key = key;
        this.next = null;
    }

    // inserting a node at the head, returns new head
    public static Node listInsert(Node head, int x){
        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;
    }

    // search for a node at key, returns position of value
    public static int listSearch(Node head, int key){
        Node curr = head;
        int pos = 1;

        while(curr != null){
            if(curr.key == key){
                return pos;
            }
            curr = curr.next;
            pos++;
        }

        return -1; // not found
    }

    // delete node at position x from the list
    public static Node listDelete(Node head, int x){

        // error bounds, empty or invalid
        if(head == null || x <= 0){
            return head;
        }

        // x is the head
        if(x == 1){ 
            return head.next;
        }

        Node prev = head;
        for(int i = 1; i < x - 1; i++){
            if(prev == null || prev.next == null) {
                return head; // out of bounds
            }
            prev = prev.next;
        }

        // out of bounds
        if(prev.next == null){
            return head;
        }
        prev.next = prev.next.next;
        return head;
    }
}

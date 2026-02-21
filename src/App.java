public class App {
    public static void main(String[] args) throws Exception {
        Node test = null;
        test = Node.listInsert(test, 5);
        test = Node.listInsert(test, 7);
        test = Node.listInsert(test, 10);

        System.out.println("Original list");
        print(test);

        // test searching
        int result = Node.listSearch(test, 1);

        System.out.println("Searching for invalid node 1");
        if(result < 0){
            System.out.println("Did not find");
        } else {
            System.out.println("found at ");
        }

        System.out.println("searching for valid node 7");
        result = test.listSearch(test, 7);
        if(result < 0){
            System.out.println("Did not find");
        } else {
            System.out.println("found at position: " + result);
        }

        // deleteing node
        System.out.println("Before deleting...");
        print(test);
        System.out.println("After deleting...");
        test = Node.listDelete(test, 2);
        print(test);
        



    }

    public static class Node {
        int key;
        Node next;

        public Node(int key){
            this.key = key;
            this.next = null;
        }

        // inserting a node at the head, returns new head
        static Node listInsert(Node head, int x){
            Node newNode = new Node(x);
            newNode.next = head;
            return newNode;
        }

        // search for a node at key, returns value or null
        static int listSearch(Node head, int key){
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

        // delete x from the list and return head
        static Node listDelete(Node head, int x){

            // error bounds, empty or invalid
            if(head == null || x <= 0){
                return head;
            }

            // x is the head
            if(x == 1){ 
                return head.next;
            }

            Node prev = head;
            for(int i = 1; i < x - 1 && prev.next != null; i++){
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

    // to print out list
    static void print(Node head){
        Node curr = head;

        while(curr != null){
            System.out.print(curr.key);
            if(curr.next != null){
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}

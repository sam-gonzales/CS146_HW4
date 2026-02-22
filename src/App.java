public class App {
    
    public static void main(String[] args) throws Exception {
        System.out.println("--- Testing linked list ---");
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
            System.out.println("found at " + result);
        }

        System.out.println("searching for valid node 7");
        result = Node.listSearch(test, 7);
        if(result < 0){
            System.out.println("Did not find");
        } else {
            System.out.println("found at position: " + result);
        }

        // deleting node
        System.out.println("Before deleting...");
        print(test);
        System.out.println("After deleting...");
        test = Node.listDelete(test, 2);
        print(test);
        
        // test palindrome
        System.out.println("--- Testing palindrome ---");
        Node pal = null;
        pal = Node.listInsert(pal, 1);
        pal = Node.listInsert(pal, 2);
        pal = Node.listInsert(pal, 3);
        pal = Node.listInsert(pal, 2);
        pal = Node.listInsert(pal, 1);

        // run palindrome function
        System.out.print("Here is the list: ");
        print(pal);
        System.out.println("Checking for palindrome...");
        // valid palindrome
        boolean isPal = Palindrome.isPalindrome(pal);
        if(isPal){
            System.out.println("It is a palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
        
        // invalid palindrome
        Node invalidPal = null;
        invalidPal = Node.listInsert(invalidPal, 1);
        invalidPal = Node.listInsert(invalidPal, 4);
        invalidPal = Node.listInsert(invalidPal, 5);
        invalidPal = Node.listInsert(invalidPal, 7);
        invalidPal = Node.listInsert(invalidPal, 10);
        
        System.out.print("Here is the list: ");
        print(invalidPal);
        System.out.println("Checking for palindrome...");

        isPal = Palindrome.isPalindrome(invalidPal);
        if(isPal){
            System.out.println("It is a palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
        
        // rainwater problem
        System.out.println("--- Rainwater problem ---");
        int [] elevationMap = {1, 2, 1, 4, 1, 2, 1, 5, 0, 0, 2, 1, 5};
        int ans = Rainwater.trap(elevationMap);
        
        System.out.println("Answer: " + ans + " units");
        
        
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

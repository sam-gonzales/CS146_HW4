public class Palindrome {
    // to hold the reference to the left node
    static class leftSide {
      Node left;

      leftSide(Node node){
        this.left = node;
      }
    }
    
    public static boolean isPalindrome(Node head) {
        leftSide left = new leftSide(head);
        // recursively checking if linked list is a palindrome
        return isPalindromeRec(left, head);
    }
    
    public static boolean isPalindromeRec(leftSide left, Node right){
        // base case when we reach the end 
        if(right == null){
            return true;
        }
        //traverse list from the end to the start of the list
        if(!isPalindromeRec(left, right.next)){
            return false;
        }
        // compare left and right keys
        if(left.left.key != right.key){
            return false;
        }
        // move left one
        left.left = left.left.next;
        
        return true;
    }
}

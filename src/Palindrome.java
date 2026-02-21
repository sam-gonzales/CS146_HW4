public class Palindrome {
    static class leftSide {
      Node left;

      leftSide(Node node){
        this.left = node;
      }
    }
    
    public static boolean isPalindrome(Node head) {
        leftSide left = new leftSide(head);
        return isPalindromeRec(left, head);
    }
    
    public static boolean isPalindromeRec(leftSide left, Node right){
        if(right == null){
            return true;
        }
        
        if(!isPalindromeRec(left, right.next)){
            return false;
        }
        
        if(left.left.key != right.key){
            return false;
        }
        
        left.left = left.left.next;
        
        return true;
    }
}

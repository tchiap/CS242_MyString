
/**
 * Tom Chiapete
 * TestMyString Class
 * A class that is the test class for the MyString class.
 * This test each method to see if it works or not.
 * 
 * @author Tom Chiapete 
 * @version 04/05/2005
 */

public class TestMyString
{

    public static void main(String[] args)
    {
        // Set up a character array and create a MyString object 
        // out of it.
        System.out.println("This program will test methods in the "+
            "MyString Class");
        char [] charArr1 = {'k','a','y','a','k'};
        MyString myString1 = new MyString(charArr1);    
    
        // Test the toString() method.
        System.out.println("Testing toString()");
        String string1 = myString1.toString();
        System.out.println("Outputted String: "+string1);
        System.out.println();
        
        // Test the reverse() method.
        System.out.println("Testing reverse()");
        String string2 = myString1.reverse().toString();
        System.out.println("Outputted String: "+string2); 
        System.out.println();

        // Test the replaceChar() method.
        System.out.println("Testing replaceChar('a','A')");
        String string3 = myString1.replaceChar('a','A').toString();
        System.out.println("Outputted String: "+string3); 
        System.out.println();

        // Test the substring() method.
        System.out.println("Testing substring(1,3)");
        String string4 = myString1.substring(1,3).toString();
        System.out.println("Outputted String: "+string4); 
        System.out.println();
        
        // Test the palindrome() method.
        System.out.println("Testing palindrome() on original");
        boolean isPalindrome1 = myString1.palindrome();
        System.out.println("isPalindrome: "+isPalindrome1); 
        System.out.println();
        
        // Create a new character array and create a new
        // MyString object from it.
        System.out.println("Now Testing characters: ");
        System.out.println("'$',' ','A','b','B','a','!'");
        char [] charArr2 = {'$',' ','A','b','B','a','!'};
        MyString myString2 = new MyString(charArr2); 
        
        // Test the substring() method on this new object.
        System.out.println("Testing substring(1,3)");
        String string5 = myString2.substring(1,3).toString();
        System.out.println("Outputted String: "+string5); 
        System.out.println(); 
        
        // Test the palindrome() method again.
        System.out.println("Testing palindrome() on this.");
        boolean isPalindrome2 = myString2.palindrome();
        System.out.println("isPalindrome: "+isPalindrome2); 
        System.out.println();
        
        // Again create a new character array and create a new 
        // MyString object from it.
        System.out.println("Now Testing characters: ");
        System.out.println("'a','p','p','l','e'");
        char [] charArr3 = {'a','p','p','l','e'};
        MyString myString3 = new MyString(charArr3);        
        
        // Test the palindrome() method on this.
        System.out.println("Testing palindrome() on this.");
        System.out.println("Obviously not.");
        boolean isPalindrome3 = myString3.palindrome();
        System.out.println("isPalindrome: "+isPalindrome3); 
        System.out.println();
        
        // Test the reverse() method on this.
        System.out.println("Testing reverse()");
        String string7 = myString3.reverse().toString();
        System.out.println("Outputted String: "+string7); 
        System.out.println();
        
        // Test equals() to see if two MyString objects are the same.
        System.out.println("Testing equals()");
        System.out.println("Checking to see if ");
        System.out.println("'a','p','p','l','e' equals");
        System.out.println("'a','p','p','l','e'");
        boolean isEqual1 = myString3.equals(myString3);
        System.out.println("Result: "+isEqual1); 
        System.out.println();  
    }
        
    public TestMyString()
    {

    }
}

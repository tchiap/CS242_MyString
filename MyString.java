/**
 * Tom Chiapete
 * MyString Class
 * A class that manipulates a character array by providing a variety 
 * of recursive methods.
 * 
 * @author Tom Chiapete 
 * @version 04/05/2005
 */

public class MyString
{
    private char [] myArr; // The character array instance variable.

    /**
     * MyString() default constructor.
     */
    public MyString()
    {
        myArr = new char [0];
    }
    
    /**
     * MyString alternate constructor.  This will set the character 
     * array in the parameter to the instance variable myArr.
     */
    public MyString(char [] myArr)
    {
        this.myArr = myArr;
    }
    
    /**
     * public int length()
     * This returns the length of myArr in this class.
     */
    public int length()
    {
        return myArr.length;   
    }
    
    /**
     * public String toString()
     * This will call a helper method that will create a string 
     * from characters.
     * This will return that string.
     */
    public String toString()
    {

        String myString = charToString(0,"");
        return myString;
    }
    
    /** 
     * public MyString reverse()
     * This will call a helper method and reverse the contents 
     * in the character array of this class.
     * This will return a myString object.
     */
    public MyString reverse()
    {
    
        MyString reversedMyString = new MyString(myArr);
        reverseChars(0,length()-1);   
        return reversedMyString; 
    }
    
    /**
     * public boolean palindrome()
     * This will call a helper method to check to see if the characters 
     * in the myArr character array are a palindrome.  If so, return true.
     * This will create a temporary string that removes the whitespace and 
     * weird punctuation marks to make our life easier.
     */
    public boolean palindrome()
    {
        boolean isPalindrome = false;
        String string1 = new String(myArr);
        String string2 = removeWhitespace(string1);
        String string3 = new String(string2.toLowerCase());
        String string4 = removeNonLetters(string3);
        char [] newArr = string4.toCharArray();       

        isPalindrome = detectPalindrome(0,newArr.length-1,newArr);
        return isPalindrome;
    }
    
    /**
     * public boolean equals(MyString mystring)
     * This checks to see if two MyString objects are identical.
     * Check to see if it's an instance of MyString.
     * Check to see if they are the same length first.
     * Check the contents of the array.
     * If they are identical, return true.
     */
    public boolean equals(MyString myString)
    {
        if (myString instanceof MyString)
        {
            MyString otherString = (MyString) myString;
            String otherString2 = otherString.toString();
            char [] otherArr = otherString2.toCharArray();
            if (myString.length() != otherString.length())
            {
                return false;   
            }
            boolean isEqual = checkEquals(myArr,otherArr,0);
            if (isEqual)
            {
                return true;
            }
        }
        else
        {
            return false;   
        }
        return true;
    }
    
    /**
     * public MyString replaceChar(char char1,char char2)
     * This will call a helper method that will recursively 
     * replace all occurances of a curtain character.
     * Return the new MyString object.
     */
    public MyString replaceChar(char char1,char char2)
    {
        char [] replacerArr = new char [length()-1];
        replacerArr = charReplacer(0,char1,char2);
        MyString myString = new MyString(replacerArr);
        return myString;
    }
    
    /**
     * public substring(int pos1,int pos2)
     * This will attempt to take the substring of a myString object.
     * To make things easier, this will eliminate punctuation.
     * Return the new MyString when done.
     * Throw exception when out of range.
     */
    public MyString substring(int pos1, int pos2)
    {
        try
        {
            MyString myString = new MyString(myArr);
            if (pos1 <= pos2)
            {
                String string1 = new String(myArr);
                String string2 = removeWhitespace(string1);
                String string3 = new String(string2.toLowerCase());
                String string4 = removeNonLetters(string3);
                char [] charArr = string4.toCharArray();
                char [] newCharArr = new char [pos2-pos1+1];
                char [] charSubString = searchLetters(pos1,pos2,0,charArr,newCharArr);
                myString = new MyString(charSubString);
            }
            return myString;
        }        
        catch (RuntimeException e)
        {
            System.err.println("Runtime Exception: " +e.getMessage());
            throw new RuntimeException(e);
        }

    }
    
    /**
     * private boolean checkEquals()
     * A helper method that recursively goes through the two arrays
     * and sees if everything is equal.
     */
    private boolean checkEquals(char [] charArr1, char [] charArr2, int pos)
    {
        if (pos <= charArr1.length-1)
        {
            char char1 = charArr1[pos];
            char char2 = charArr2[pos];
            if (char1 == char2)
            {
                checkEquals(charArr1,charArr2,++pos);   
            }
            else
                return false;
        }
        return true;
    }
    
    /** private char [] searchLetters()
     */
    private char [] searchLetters(int pos1,int pos2, 
            int newArrPos, char [] charArr, char [] newCharArr)
    {
        if (pos1 <= pos2)
        {
            newCharArr[newArrPos] = charArr[pos1-1];
            newArrPos++;
            pos1++;
            searchLetters(pos1,pos2,newArrPos,charArr,newCharArr);
        }
        return newCharArr;
    }
    
    /** 
     * private char [] charReplacer()
     * A helper method that replaces characters in the myArr array.
     */
    private char [] charReplacer(int pos, char char1, char char2)
    {
        char [] tempArr = new char [length()-1];
        tempArr = myArr;
        if (pos <= length()-1)
        
        {
            char temp = myArr[pos];
            if (temp == char1)
            {
                tempArr[pos] = char2;
            }
            pos++;
                 charReplacer(pos,char1,char2);
        }

        return tempArr;
    }
    
    /** 
     * private boolean detectPalindrome()
     * This helper method will detect the existance of a palindrome.
     * Return true or false.
     */
    private boolean detectPalindrome(int pos1,int pos2,char [] arr)
    {
        if (pos1 <= (arr.length-1)/2)
        {
            char char1 = arr[pos1];
            char char2 = arr[pos2];
            if ((char1 == char2))
            {
                pos1++;
                pos2--;   
                detectPalindrome(pos1,pos2,arr);
            }
            else
            {
                return false;
            }
        }
        return true;
    }
    
    /** 
     * reverseChars()
     * A helper method that recursively reverses the order or the 
     * characters in the array.
     */
    private void reverseChars(int pos1, int pos2)
    {
        if (pos1 <= (length()-1)/2)
        {
            char temp1 = myArr[pos1];
            char temp2 = myArr[pos2];
            myArr[pos1++] = temp2;
            myArr[pos2--] = temp1;
            reverseChars(pos1,pos2);
        }
        else
            return;
    }
    
    /**
     * private String charToString()
     * A helper method for the toString() method.
     */
    private String charToString(int pos,String currString)
    {
        while (pos <= (length()-1))
        {
            currString = currString + myArr[pos++];            
            charToString(pos,currString);
        }
        return currString;
    }
    
    /**
     * private String revoveWhitespace()
     * A method I created to remove Whitespace using regular 
     * expressions.
     */
    private String removeWhitespace(String checkString)
    {
        String noSpaceString = checkString.replaceAll("\\s{1,}","");        
        return noSpaceString;
    }
    
    /** 
     * private String removeNonLetters()
     * A method I created to remove all non-letter characters from a 
     * string.
     */
    private String removeNonLetters(String checkString)
    {
        String noNonLettersString = checkString.replaceAll("\\W{1,}|[0-9]{1,}","");         
        return noNonLettersString;                  
    }


}

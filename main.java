import java.util.Scanner;

/*

Is parse an online algorithm? Why or why not?
Parse is an online algorithm because when you put in an input, more can be added
after the input as long as it is valid and is added and removed from the stack properly.

Given N tags. What is the runtime of parse? Why?
The runtime of parse would be n because it needs to go through ONE loop to search through 
the string to find the right symbols and put them into substrings. All the other code
has a constant runtime
*/


// THIS PROGRAM TAKES IS A PARSER AND PUTS A STRING ON A STACK
// EXAMPLES: <key> someSubString </key> 
// <key> something <key2> hello </key2> goodbye </key>
public class main {
	
	public static void main (String [] args) {
	
		Scanner scan = new Scanner(System.in);
		
		String html = scan.nextLine();
		
		if (parse(html) == true) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public static boolean parse(String html) {
		
		if (html.contains("<") == false && html.contains(">")== false) return true;

		Stack n = new Stack();
		
		int p = html.indexOf("<");
		
		while (p != -1) {
	
			int p2 = html.indexOf(">",p +1);
		
			//creates a substring inbetween the < and > symbols
			if (p2 != -1) {
				String word = html.substring(p+1,p2);
				word = word.toLowerCase();
				System.out.println(word);
				
				//removes from the stack if the word is equal to the top of the stack
				if (word.charAt(0) == '/') 
					{
					word = word.substring(1); 
					word = word.toLowerCase();
					
					// checks if the list is empty in case someone tries to close without opening
					if (n.isEmpty()) return false;
					
					else if (word.equals(n.peek())) 
					{
						System.out.println("pop");
						n.pop();
					} 
					else 
					{
						return false;
					}
				}
				else 
				{
					System.out.println("push");
					n.push(word);
				}
			}
			
			p = html.indexOf("<",p2+1);
		} // end while
		
		if (n.isEmpty()) return true;
		
		return false;
		
	}
}

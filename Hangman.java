//package ProjectHangman;
/*

Project Hangman:
Team Members: Matthew Rutherford, Maggie Lee

*/

import java.util.*;

public class Hangman

{
	public static void main(String [] args)

	{	
		//Maggie's code
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		String phraseList[] = {"Wild Goose Chase!", "Jaws of Life.", "Lovey Dovey!", "Fit as a Fiddle!", "Right Out of the Gate.",
								"Two Down, One to Go.", "Jumping the Gun?", "Go For Broke!", "Throw In the Towel.", "Burst Your Bubble!"}; // List of 10 phrases
        int guesses = 0;
		int i = rand.nextInt(10);
		String randPhrase = phraseList[i]; //random phrase from the list

        StringBuilder hidden = new StringBuilder(randPhrase);	
		
		System.out.println("Welcome to the Game Hangman!"); // instructions
		System.out.println("You will be given a random phrase hidden by asterisks."); 
		System.out.println("Each time you guess a single character.");
		System.out.println("If correct, the character will replace the asterisk(s)");
		System.out.println("If incorrect, you will be penalized a miss.");
		System.out.println("If you guess a previously correct/incorrect guess again,");
		System.out.println("it will NOT be penalized a miss.");
		System.out.println("If you guess all correctly within 8 misses, you WIN!");
		System.out.println("Or else you LOSE! Good Luck!"); 
		System.out.println();
		System.out.println("Here's the word: ");

		//Matthew's code

		for (int j = 0, n = randPhrase.length(); j < n; j++) { //replaces digits in phrase for asterisks, ignores spaces. 
			char c = randPhrase.charAt(j);
			if ((c > 64 && c < 91) || (c > 96 && c < 123)) 
				hidden.setCharAt(j, '*');
			else continue;
		}
        System.out.println(hidden.toString());
		boolean flag;
		char g;
		
		ArrayList<Character> duplicateGuesses = new ArrayList<>();//Will add accepted guesses to this array
		
	while ((!randPhrase.toString().equals(hidden.toString())) && (guesses<8)){ //Once reaches 8 guesses, exits loop. This loop is essentially the entire game.
			
			System.out.println("Guess a digit.");
			g = input.next().charAt(0); 

			flag = false;

			while (flag == false)	{	//while loop to only accept letters and deny duplicate guesses
				if ((g > 64 && g < 91) || (g > 96 && g < 123) && !(duplicateGuesses.contains(Character.toUpperCase(g)))) {
					duplicateGuesses.add(Character.toUpperCase(g));
					flag = true;
				}
				else if (duplicateGuesses.contains(Character.toUpperCase(g))){
					System.out.print("You have already entered that character. Try again:");
					g = input.next().charAt(0);
				}
				else{
				System.out.println("Please enter a valid character. ");
				g = input.next().charAt(0); 
				
				}
			}
				
			if (((randPhrase.indexOf(g) == -1)) && (randPhrase.indexOf(Character.toUpperCase(g)) == -1)){
					guesses +=1;
					System.out.println("That was incorrect.");
			}
			else{
           		for (int k = 0, n = randPhrase.length(); k < n; k++){             
                	if (Character.toUpperCase(g) == Character.toUpperCase(randPhrase.charAt(k))) //will accept upper or lowercase
						hidden.setCharAt(k, randPhrase.charAt(k));
					   }	
			}
			
			System.out.println("You have " + (8-guesses) + " guesses remaining. ");
			System.out.println(hidden.toString());
            
		}
		if (guesses == 8)
			System.out.println("You lose. The correct answer is " + randPhrase);
		else 
			System.out.println("You win! ");
	}
    
}
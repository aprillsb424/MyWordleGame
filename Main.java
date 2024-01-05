import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static final Scanner userInput = new Scanner(System.in);

  public static final String TEXT_RESET = "\u001B[0m";
  public static final String TEXT_BLACK = "\u001B[30m";
  public static final String TEXT_RED = "\u001B[31m";
  public static final String TEXT_GREEN = "\u001B[32m";
  public static final String TEXT_YELLOW = "\u001B[33m";
  public static final String TEXT_BLUE = "\u001B[34m";
  public static final String TEXT_PURPLE = "\u001B[35m";
  public static final String TEXT_CYAN = "\u001B[36m";
  public static final String TEXT_WHITE = "\u001B[37m";

  public static void main(String[] args) {

    boolean runAgain = true; 

    System.out.println("Welcome to my WORDLE program!\n\n");
    System.out.println("Your goal in this program is to guess a random computer-generated 5-letter word. You will have 6 tries to do so.\n\n");
    System.out.println("Below are the rules:\n\n");
System.out.print(TEXT_GREEN + "Green = The letter you've guessed is the word and in its right position! Congrats!" + TEXT_RESET + "\n\n");
System.out.println(TEXT_YELLOW + "Yellow = The letter you've guessed is in the word, but not quite in the right position. Try again!" + TEXT_RESET + "\n\n");
    System.out.println("White = The letter you've guessed is not in the word at all. Better luck next time!\n");
List<String> wordleWords = new ArrayList<>();
try {
    wordleWords = Files.readAllLines(new File("WordleWords.txt").toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.print("error happens on reading file");;
        }

    String g1 = "";

while (runAgain==true) {
  String pickedWord = wordleWords.get((int) (Math.random() * (wordleWords.size() - 1)));
char[] arrayGoalword = pickedWord.toCharArray();
  System.out.println("New word selected. Input 5-letter guess when ready.");
  checkingwords(g1,pickedWord,arrayGoalword);
  System.out.println("\nWould you like to play again? (y/n)");
  String playAgain = (userInput.nextLine()).toLowerCase();

  if (playAgain.equals("y"))
  {
runAgain=true;
  }

  else if (playAgain.equals("n"))
  {
runAgain=false;
    }

else 
  {
    boolean smthing = true;
    while (smthing=true)
    {System.out.println("Invalid Input. Try again.");
    playAgain = (userInput.nextLine()).toLowerCase();
     if (playAgain.equals("y"))
  {
runAgain=true;
smthing=false; 
break;
  }

  else if (playAgain.equals("n"))
  {
runAgain=false; 
smthing=false; 
break;
  }

  else 
  {
    smthing=true;
  }
    }
  }
  }
  }


public static void checkingwords(String g1, String pickedWord, char[] arrayGoalword){

int j = 0;
while (j<6)  {
    g1 = (userInput.nextLine()).toLowerCase();
    char[] arrayG1 = g1.toCharArray();
  while (arrayG1.length!=5)
    {
      System.out.print("Invalid Input. Please try again.\n");
      g1 = (userInput.nextLine()).toLowerCase();
      arrayG1 = g1.toCharArray();
    }

    for (int i = 0; i < g1.length(); i++) {
      if (!Character.isLetter(arrayG1[i])) {
        System.out.print("Invalid Input. Please try again. \n");
        g1 = (userInput.nextLine()).toLowerCase();
        arrayG1 = g1.toCharArray();
        break;
      }

if (new String (arrayG1).equals(new String (arrayGoalword)))
{
  System.out.print(TEXT_GREEN + pickedWord + TEXT_RESET);
  System.out.println("\nGood job! You've guessed the word!");
  return; 
}



if (arrayG1[i]==arrayGoalword[i])
{
  System.out.print(TEXT_GREEN + arrayG1[i] + TEXT_RESET);
}

else if (new String (arrayGoalword).indexOf(arrayG1[i])==-1)
{
  System.out.print(TEXT_WHITE + arrayG1[i] + TEXT_RESET);
}

else 
{
  for (int x=0;x<5;x++)
    {
      if (arrayG1[i]==arrayGoalword[x])
      {
         System.out.print(TEXT_YELLOW + arrayG1[i] + 
         TEXT_RESET);
      break;
      }
    }

}

if (i==g1.length()-1)
{
  System.out.print("\n\n");
}

  }
  if (j==5&&!new String (arrayG1).equals(new String (arrayGoalword)))
  {
    System.out.print("You did not guess the word. The correct answer was " + pickedWord + ".");
  }
  j++;
      }
}
  }
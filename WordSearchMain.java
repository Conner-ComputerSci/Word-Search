//Name: Conner Havlicek
//File-Name: WordSearchMain
//A program that allows the user to create a word search and to see the solution.
//Date: 10/15/24
//Uses randonly generated words with ASCII

import java.util.Random;
import java.util.Scanner;

public class WordSearchMain {

    public static void main(String args[]){
        
        Scanner console = new Scanner(System.in);
        String userInput = "";
        boolean userExit = false;

        //References WordSearchContainer
        WordSearchContainer masterWordSearch = new WordSearchContainer();
        //masterWordSearch = null;

        do{
            System.out.println("Welcome to your Word Search Generator!\nPlease input your command\ng to generate your word search\ns to show solution\nq to quit");
            userInput = console.next();
            switch (userInput) {
                case "q":
                    userExit = true;
                    break;
                case "g":
                    crossWordRandomGenerator(masterWordSearch);
                    break;
                case "s":
                    crossWordSolution(masterWordSearch);
                    break;
                
                default:
                    break;
            }

        }while(!userExit);

        

    }// close main method


    public static void crossWordRandomGenerator(WordSearchContainer masterWordSearch){
        Scanner console = new Scanner(System.in);
        char[][] localWordSearch = new char[12][12];
        Random rand = new Random();
        String[] chosenWords = new String[3];
        boolean spotFound = false;


        //Resets the Word Search
        masterWordSearch.ResetMasterContainer();


        //Word Selection
        System.out.println("Please choose 3 words\nLess then 12 characters long please.");
        for(int i = 0; i < chosenWords.length; i++){
            System.out.println("Word " + (i + 1) + ": ");
            chosenWords[i] = console.next();
            
        }

        //Searches for a spot to place current word in array
        for(int i = 0; i < chosenWords.length; i++){
            spotFound = false;
            while(spotFound == false){
                //Picks a random spot
                int ypos = rand.nextInt(masterWordSearch.wordSearch.length);
                int xpos = rand.nextInt(masterWordSearch.wordSearch.length);
                //System.out.println("Word " + (i + 1) + " was at ("+ xpos +","+ypos+")"); DEBUG

                //Picks which direction the word goes. Currently locked to 1
                int direction = 1;//rand.nextInt(8);
    
                switch (direction) {
                    case 1: //Word moves Down
                        if((ypos + chosenWords[i].length()) < masterWordSearch.wordSearch.length){ //Checks if the word goes outside the bounds
                            System.out.println("Spot Found");
                            for(int x = 0; x < chosenWords[i].length(); x++){
                                masterWordSearch.wordSearch[x + ypos][xpos] = chosenWords[i].toUpperCase().charAt(x); //Changes the aray[][] spot to the current character
                                masterWordSearch.spotFilled[x + ypos][xpos] = 1;                                      //Sets this spot to 1, which communicates that this spot is assigned, 
                                                                                                                      //so the random character and the Xs don't overwrite each other
                                //System.out.println("Character added: " + chosenWords[i].charAt(x)); DEBUG
                            }
                            spotFound = true;
                        }
                        break;
                    case 2: //Word moves Up
                        if((ypos - chosenWords[i].length()) > chosenWords[i].length()){
                            System.out.println("Spot Found");
                            for(int x = chosenWords[i].length() + 1; x >= 0; x--){
                                masterWordSearch.wordSearch[x + ypos][xpos] = chosenWords[i].toUpperCase().charAt(x);
                                masterWordSearch.spotFilled[x + ypos][xpos] = 1;
                                System.out.println("Character added: " + chosenWords[i].charAt(x)); //DEBUG
                            }
                            spotFound = true;
                        }
                        break;
                    case 3: //Word moves Right
                        break;
                    case 4: // Word moves Left
                        break;
                    case 5: // Word moves Up-Right
                        break;
                    case 6: // Word moves Up-Left
                        break;
                    case 7: // Word moves Down-Right
                        break;
                    case 8: // Word moves Down-Left
                        break;
                    default:
                        break;
                }
            }
        }
        localWordSearch = masterWordSearch.wordSearch; //Pulls the assigned word locations from the container class and applys it to a local 2D array
        for(int i = 0; i < localWordSearch.length; i++){
            for(int j = 0; j < localWordSearch[i].length; j++){

                if(localWordSearch[i][j] == 0 || masterWordSearch.spotFilled[i][j] != 1){ //Assigns the random letters
                    int randomLetter = rand.nextInt(91-65) + 65;
                    localWordSearch[i][j] = (char)randomLetter;
                    System.out.print(localWordSearch[i][j] + "  ");
    
                }else{
                    System.out.print(localWordSearch[i][j] + "  "); //Prints the word characters
                }

            }
            System.out.println();
        }
    }// close crossWordGenerator method

    public static void crossWordSolution(WordSearchContainer masterWordSearch){
        char[][] localWordSearch = new char[12][12];
        localWordSearch = masterWordSearch.wordSearch;
        for(int i = 0; i < localWordSearch.length; i++){
            for(int j = 0; j < localWordSearch[i].length; j++){

                if(localWordSearch[i][j] == 0 || masterWordSearch.spotFilled[i][j] != 1){ //Assigns Xs
                    localWordSearch[i][j] = 'X';
                    System.out.print(localWordSearch[i][j] + "  ");
    
                }else{
                    System.out.print(localWordSearch[i][j] + "  "); //Prints word characters
                }

            }
            System.out.println();
        }
    }

}// close class
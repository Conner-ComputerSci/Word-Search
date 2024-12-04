//Name: Conner Havlicek
//Date: 10/21/24
//Filename: WordSearchContainer.java
//Description: This file contains the wordsearch and is called to return both the complete puzzle and the solution.

public class WordSearchContainer {
    char[][] wordSearch = new char[12][12];
    int[][] spotFilled = new int[12][12];

    public void ResetMasterContainer(){
        for(int i = 0; i < wordSearch.length; i++){
            for(int j = 0; j < wordSearch[i].length; j++){

                wordSearch[i][j] = 0;
                spotFilled[i][j] = 0;

            }
        }
    }

}
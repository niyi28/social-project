package com.company.Games.Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordsGenerator{
    private final ArrayList <String > listOfWords = new ArrayList <> ();
    private final HashMap <Integer, String> languageOptions = new HashMap <> ();
    private final ScannerInitiator scannerInitiator = new ScannerInitiator();

    public WordsGenerator (){
        try{
            addGameLanguages();
            int languageNumber = chooseGameLanguages();
            if (languageNumber == 1){
                File myObj = new File( "src/com/company/Games/Hangman/WordsStore/EnglishWords.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine().toUpperCase();
                    listOfWords.add(data);
                }
            }else if(languageNumber == 2){
                File myObj = new File( "src/com/company/Games/Hangman/WordsStore/GermanWords.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine().toUpperCase();
                    listOfWords.add(data);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getListOfWords(){
        return listOfWords;
    }

    private void addGameLanguages(){
        languageOptions.put(1, "English");
        languageOptions.put(2, "German");
    }


    private int chooseGameLanguages(){
        int languageNumber = 0;
        System.out.println(languageOptions);
        System.out.print("Please choose from the options above: ");
        String languageNumberString = scannerInitiator.getScannerString();
        while(!(languageNumberString.equals("1") || languageNumberString.equals("2"))){
            System.out.println("Not Valid! Choose 1 or 2, please!");
            languageNumberString = scannerInitiator.getScannerString();
        }
        languageNumber = Integer.parseInt(languageNumberString);
        return languageNumber;
    }
}
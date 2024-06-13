package com.ahmed.aventurier.main.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.ahmed.aventurier.main.model.Card;

public class CardReader {

  /**
   * Extract Card from Text file
   * 
   * @param filePath
   * @return
   */
  public Card readCardFromFile(String filePath) {
    Card card = new Card();
    try {
      File myObj = new File(filePath);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        card.getCardAsList().add(Arrays.asList(data.split("")));
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred while reading the Card file.");
      e.printStackTrace();
    }
    return card;

  }
}

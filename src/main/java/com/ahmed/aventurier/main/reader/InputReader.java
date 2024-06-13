package com.ahmed.aventurier.main.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.ahmed.aventurier.main.model.Aventurier;

public class InputReader {

  /**
   * extract aventurier Object from file
   * 
   * @param filePath
   * @return
   */
  public Aventurier readAventurierFromFile(String filePath) {
    {
      Aventurier aventurier = new Aventurier();

      try {
        File myObj = new File(filePath);
        Scanner myReader = new Scanner(myObj);
        int line = 0;
        while (myReader.hasNextLine() && line < 2) {
          String data = myReader.nextLine();

          if (line == 0) {
            String[] line1 = data.split(",");
            aventurier.setX(Integer.valueOf(line1[0]));
            aventurier.setY(Integer.valueOf(line1[1]));

          } else if (line == 1) {
            String[] line2 = data.split("");
            aventurier.setMoves(Arrays.asList(line2));
          }
          line++;
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred while reading the Input file.");
        e.printStackTrace();
      }
      return aventurier;
    }
  }
}

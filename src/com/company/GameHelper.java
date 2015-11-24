package com.company;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by brynhild on 11/23/15.
 */
public class GameHelper {
  private static final String alphabet = "abcdefg";
  private int gridLength = 7;
  private int gridSize = 49;
  private int[] grid = new int[gridSize];
  private int comCount = 0;

  public String getUserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + " ");
    try {
      BufferedReader is = new BufferedReader(
          new InputStreamReader(System.in));
      inputLine = is.readLine();
      if (inputLine.length() == 0) return null;
    } catch (IOException e) {
      System.out.println("IOException: " + e);
    }
    return inputLine.toLowerCase();
  }

  public ArrayList<String> placeDotCom(int comSize) {
    ArrayList<String> alphaCells = new ArrayList<>(); // hold "f6" type coords
    String temp = null;
    int [] coords = new int[comSize];                 //current candidate coords
    int attempts = 0;
    boolean success = false;                          //found good location?
    int location = 0;                                 //current starting position

    comCount++;
    int incr = 1;
    if((comCount % 2) == 1) {
      incr = gridLength;
    }

    while ( !success & attempts ++ < 200) {          //main search loop
      location = (int) (Math.random() * gridSize);   //get random starting point

      int x = 0;
        success = true;
        while (success && x < comSize) {

        }
    }
  }


}

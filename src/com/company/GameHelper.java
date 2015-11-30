package com.company;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by brynhild on 11/23/15.
 */
public class GameHelper {
  private static final String alphabet = "abcdefg";
  private int gridLength = 7;
  private int gridSize = 49;
  int[] grid = new int[gridSize];
  public int comCount = 0;

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

    while (!success & attempts++ < 200) {          //main search loop
      // One attempt with a random start position

      location = (int) (Math.random() * gridSize);   //get random starting point

      success = placeDotComOnce(comSize, coords, location, incr);

    }

    int x = 0;
    int row = 0;
    int column = 0;

    while (x < comSize) {
      grid[coords[x]] = 1;

      row = (int)(coords[x]/gridLength);        //get row value   ////exchange row with column
      column = coords[x] % gridLength;                //get numeric column value
      temp = String.valueOf(alphabet.charAt(row)); //covert to alpha

      alphaCells.add(temp.concat(Integer.toString(column)));
      x++;
    }
    return alphaCells;
  }

  boolean placeDotComOnce(int comSize, int[] coords, int location, int incr) {
    if (incr == 1 && location % gridLength > gridLength - comSize) {
      return false;
    }

    for (int index = 0; index < comSize; ++index, location += incr) {
      if (location >= gridSize || grid[location] != 0) {
        return false;
      }
      coords[index] = location;
    }
    return true;
  }

  ArrayList<String> covertToAlphaCells(int[] coords) {
    int x = 0;
    int row = 0;
    int column = 0;

    ArrayList<String> alphaCells = new ArrayList<>();
    String temp;
    while (x < coords.length) {
      grid[coords[x]] = 1;

      row = coords[x] / gridLength; //get row value   ////exchange row with column
      column = coords[x] % gridLength; //get numeric column value
      temp = String.valueOf(alphabet.charAt(row)); //covert to alpha

      alphaCells.add(temp.concat(Integer.toString(column)));
      x++;
    }
    return alphaCells;
  }
}

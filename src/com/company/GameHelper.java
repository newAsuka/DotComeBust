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


//  /**
//   * ...
//   * @param comSize size of the dotCom
//   * @return coordinates like a0 a1 b0 ...
//   */
//  public ArrayList<String> placeDotComByBalon(int comSize) {
//    int[] coords = new int[comSize];
//    pickCoordinates(coords);
//    return convertToCoordinates(coords);
//  }
//
//  private void pickCoordinates(int[] coords) {
//    for(int attempts = 0; attempts < 100; ++attempts) {
//      if (tryPickRandomCoordinates(coords)) {
//        break;
//      }
//    }
//  }
//
//  private boolean tryPickRandomCoordinates(int[] coords) {
//    return false;
//  }
//
//  private ArrayList<String> convertToCoordinates(int[] coords) {
//    return null;
//  }


  public ArrayList<String> placeDotCom(int comSize) {
    ArrayList<String> alphaCells = new ArrayList<>(); // hold "f6" type coords
    String temp = null;
    int [] coords = new int[comSize];                 //current candidate coords
    int attempts = 0;
    boolean success = false;                          //found good location?
    int location = 0;                                 //current starting position

    comCount++;

//    System.out.println("comCount = "+ Integer.toString(comCount));
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
//      System.out.print(" cord "+x+" = "+alphaCells.get(x-1));
    }

//    System.out.println();

//    for (int index = 0; index < gridLength; index++) {
//      for (int j = 0; j < gridLength; j++) {
//        System.out.print(grid[index * 7 + j]);
//      }
//      System.out.println();
//    }
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

//  boolean placeDotComOnce(int comSize, int[] coords, int location, int incr) {
//    boolean success;
//    int x = 0;
//    success = true;
//    while (success && x < comSize) {
//      if (grid[location] == 0) {                 //if not already used
//        coords[x++] = location;                  //save location
//        location += incr;                        //try "next" adjacent
//        if (location > gridSize) {
//          success = false;
//        }
//        if (x > 0 && (location % gridLength == 0)) {
//          success = false;
//        }
//      } else {
//        success = false;
//      }
//    }
//    return success;
//  }


}

package com.company;

import java.util.ArrayList;

/**
 * Created by brynhild on 11/23/15.
 */
public class DotCom {
  private ArrayList<String> locationCells;
  private String name;

  public void setName(String n) {
    name = n;
  }

  public void setLocationCells(ArrayList<String> loc) {
    locationCells = loc;
  }

  public String checkYourself(String userInput) {
    String result = "miss";
    int index = locationCells.indexOf(userInput);
    if(index >= 0) {
      locationCells.remove(index);

      if(locationCells.isEmpty()) {
        result = "kill";
        System.out.println("you sunk the DotCom " + name);
      } else {
        result = "hit";
      } //close if
    } //close if
    return result;
  } //close method


//  public String checkYourselfGoogleStyle(String userInput) {
//    // Preconditions check
//    int index = locationCells.indexOf(userInput);
//    if (index < 0) {
//      return "miss";
//    }
//
//    locationCells.remove(index);
//    if (locationCells.isEmpty()) {
//      return "kill";
//    }
//
//    return "hit";
//  }



//  public boolean checkYourselfMicrosoftStyle(String userInput, ArrayList<String> result) {
//    boolean succ = true;
//
//    int index = locationCells.indexOf(userInput);
//    succ = succ && (index >= 0);
//    if (succ) {
//      locationCells.remove(index);
//    }
//
//    if (succ && (locationCells.isEmpty())) {
//      result.add("kill");
//      succ = true;
//    }
//
//    if (succ && (!locationCells.isEmpty())) {
//      result.add("hit");
//      succ = true;
//    }
//
//    if (!succ) {
//      result.add("miss");
//    }
//
//    return succ;
//  }



} //close class


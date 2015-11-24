package com.company;

import java.util.ArrayList;

/**
 * Created by brynhild on 11/23/15.
 */
public class DotCome {
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
} //close class


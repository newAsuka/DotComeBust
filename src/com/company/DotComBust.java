package com.company;

import java.util.ArrayList;

public class DotComBust {

  private GameHelper helper = new GameHelper();
  private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
  private int numOfGuesses = 0;

  private void setUpGame() {
    DotCom one = new DotCom();
    one.setName("facebook.com");
    DotCom two = new DotCom();
    two.setName("google.com");
    DotCom three = new DotCom();
    three.setName("blizzard.com");
    dotComsList.add(one);
    dotComsList.add(two);
    dotComsList.add(three);

    System.out.println("your goal is to sink three dot coms.");
    System.out.println("facebook,google,blizzard");

    for (DotCom dotComToSet : dotComsList) {
      ArrayList<String> newLocation = helper.placeDotCom(3);
      dotComToSet.setLocationCells(newLocation);
    }
  }

  private void startPlaying() {
    while(!dotComsList.isEmpty()) {
      String userGuess = helper.getUserInput("enter a guess");
      checkUserGuess(userGuess);
    }
    finishGame();
  }

  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss";
    for(int x=0; x<dotComsList.size(); x++){
      result = dotComsList.get(x).checkYourself(userGuess);
      if(result.equals("hit")){
        break;
      }
      if(result.equals("kill")){
        dotComsList.remove(x);
        break;
      }
    }
    System.out.println(result);
  }

  private void finishGame() {
    System.out.println("all dot come are dead!");
    System.out.println("numberofGuess = "+Integer.toString(numOfGuesses));
  }


  public static void main(String[] args) {
//    int numOfHelper = 3;
//    GameHelper[] helpers = new GameHelper[numOfHelper];
//    for (int i = 0; i < numOfHelper; i++) {
//      helpers[i] = new GameHelper();
//      helpers[i].placeDotCom(3);
//    }
//
//    for (int i = 0; i < 3; i++) {
//      System.out.println(helpers[i].comCount);
//    }
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
  }
}


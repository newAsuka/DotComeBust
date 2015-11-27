package com.company;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class GameHelperTest {
  GameHelper helper;

  @Before
  public void setUp() {
    helper = new GameHelper();
  }

  @Test
  public void placeDotCom_shouldReturnProvidedSize() {
    ArrayList<String> result = helper.placeDotCom(3);
    assertEquals(3, result.size());
  }

  @Test
  public void placeDotCom_shouldReturnVerticalSequence_forOddCall() {
    boolean isHorizontal = helper.comCount % 2 == 0;
    assertTrue(helper.comCount % 2 == 0);
    ArrayList<String> result = helper.placeDotCom(3);

    String r0 = result.get(0);
    String r1 = result.get(1);
    String r2 = result.get(2);

    // Same column
    assertEquals(r0.charAt(1) - '0', r1.charAt(1) - '0');
    assertEquals(r1.charAt(1) - '0', r2.charAt(1) - '0');

    // Adjacent rows
    assertIsAdjacent(r0.charAt(0), r1.charAt(0));
    assertIsAdjacent(r1.charAt(0), r2.charAt(0));
  }

  @Test
  public void placeDotCom_shouldReturnHorizontalSequence_forEvenCalls() {
    helper.placeDotCom(3);

    assertTrue(helper.comCount % 2 == 1);
    ArrayList<String> result = helper.placeDotCom(3);

    String r0 = result.get(0);
    String r1 = result.get(1);
    String r2 = result.get(2);

    // Same rows
    assertEquals(r0.charAt(0), r1.charAt(0));
    assertEquals(r1.charAt(0), r2.charAt(0));

    // Adjacent column
    assertIsAdjacent(r0.charAt(1), r1.charAt(1));
    assertIsAdjacent(r1.charAt(1), r2.charAt(1));
  }

  private void assertIsAdjacent(char c1, char c2) {
    assertEquals(1, Math.abs(c2 - c1));
  }
}
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
  public void placeDotComOnce_horizontal_shouldSuccess() {
    int[] coords = new int[3];
    boolean success = helper.placeDotComOnce(3, coords, 46, 1);

    assertTrue(success);
    assertEquals(46, coords[0]);
    assertEquals(47, coords[1]);
    assertEquals(48, coords[2]);
  }

  @Test
  public void placeDotComOnce_vertical_shouldSuccess() {
    int[] coords = new int[3];
    boolean success = helper.placeDotComOnce(3, coords, 34, 7);

    assertTrue(success);
    assertEquals(34, coords[0]);
    assertEquals(41, coords[1]);
    assertEquals(48, coords[2]);
  }

  @Test
  public void placeDotComOnce_shouldFail_ifOutOfRange_whenHorizontal() {
    assertFalse(helper.placeDotComOnce(3, new int[3], 47, 1));
  }

  @Test
  public void placeDotComOnce_shouldFail_ifOutOfRange_whenVertical() {
    assertFalse(helper.placeDotComOnce(3, new int[3], 35, 7));
  }

  @Test
  public void placeDotComOnce_shouldNotBreakLine_whenHorizontal() {
    assertFalse(helper.placeDotComOnce(3, new int[3], 5, 1));
  }

  @Test
  public void placeDotComOnce_shouldBeAbleToPutAtFirstColumn() {
    assertTrue(helper.placeDotComOnce(3, new int[3], 0, 7));
  }

  @Test
  public void placeDotComeOnce_shouldNotOverlapping() {
    helper.grid[3] = 1;
    assertFalse(helper.placeDotComOnce(3, new int[3], 3, 1));
  }
}
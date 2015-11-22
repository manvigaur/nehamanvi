package com.sort.bubble;


import java.awt.Color;

class BarBox
{
  private int height;
  private Color color;
  private int value;
  
  public Color getColor()
  {
    return this.color;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  
  public int getValue()
  {
    return this.value;
  }
  
  
  public BarBox(int value ,int paramInt, Color paramColor)
  {
    this.height = paramInt;
    this.color = paramColor;
    this.value =value;
  }
}

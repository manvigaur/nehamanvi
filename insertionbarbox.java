package com.sort.insertion;

import java.awt.Color;

public class BarBox {

	private int height;
	private int value;
	private Color color;

	public Color getColor() {
		return this.color;
	}

	public int getHeight() {
		return this.height;
	}

	public int getValue() {
		return this.value;
	}

	public BarBox(int value, int paramInt, Color paramColor) {
		this.height = paramInt;
		this.color = paramColor;
		this.value = value;
	}
}

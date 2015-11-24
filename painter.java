package com.sort.bubble;

import java.awt.Color;
import java.awt.Graphics;

class Painter {
	private final int appletWidth = 1000;
	private final int appletHeight = 800;
	private final int maxHeight = 200;
	private final int topMargin = 30;
	private final int leftMargin = 10;
	private final int barLeftMargin = 35;
	private final int textHeight = 13;
	private int aSize;
	private BarBox[] barboxex;
	private int barWidth = 25;
	private int barSeparation;
	private int outer;
	private int inner;
	private int innerOld;
	private boolean swapFlag;
	private boolean doneFlag;
	private int comps;
	private int swaps;
	private int initOrder;
	Color barcolor = Color.gray;
	private int drawMode;

	public Painter(int paramInt1, int paramInt2) {
		this.aSize = paramInt1;
		this.initOrder = paramInt2;
		this.barboxex = new BarBox[this.aSize];
		this.barWidth = 25;
		this.barSeparation = 10;

		this.outer = (this.aSize - 1);
		this.inner = 0;
		this.comps = 0;
		this.swaps = 0;
		this.swapFlag = false;
		this.doneFlag = false;
		this.drawMode = 2;
		int i;
		int j;

		if (this.initOrder == 1) {
			for (i = 0; i < this.aSize; i++) {
				j = (int) (Math.random() * 190.0D);
				this.barboxex[i] = new BarBox(j, j, this.barcolor);
			}
		} else {
			for (i = 0; i < this.aSize; i++) {
				j = 199 - 199 * i / this.aSize;

				this.barboxex[i] = new BarBox(j, j, this.barcolor);
			}
		}
	}

	public void setDrawMode(int paramInt) {
		this.drawMode = paramInt;
	}

	public int getAppletWidth() {
		return 1000;
	}

	public int getAppletHeight() {
		return 800;
	}

	public boolean getDone() {
		return this.doneFlag;
	}

	public void arrowText(Graphics paramGraphics, Color paramColor,
			String paramString, int paramInt1, int paramInt2,
			boolean paramBoolean1, boolean paramBoolean2) {
		int x_cord = 35 + paramInt1 * (this.barWidth + this.barSeparation);
		int y_cord = 230 + (paramInt2 + 1) * 13;
		paramGraphics.setColor(paramColor);
		if (paramBoolean2) {
			paramGraphics.drawString(paramString, x_cord, y_cord);
		}
		if (paramBoolean1) {
			paramGraphics.drawLine(x_cord + this.barWidth / 2, 232, x_cord
					+ this.barWidth / 2, y_cord - 13);

			paramGraphics.drawLine(x_cord + this.barWidth / 2, 232, x_cord
					+ this.barWidth / 2 - 3, 237);
			paramGraphics.drawLine(x_cord + this.barWidth / 2, 232, x_cord
					+ this.barWidth / 2 + 3, 237);
		}
	}

	public void drawOneBar(Graphics paramGraphics, int paramInt) {
		int height = this.barboxex[paramInt].getHeight();
		int value = this.barboxex[paramInt].getValue();
		int x_cord = 35 + paramInt * (this.barWidth + this.barSeparation);
		int y_cord = 230 - height;
		Color localColor = Color.gray;

		paramGraphics.setColor(Color.pink);
		paramGraphics.fillRect(x_cord, 0, this.barWidth, 235);
		paramGraphics.setColor(localColor);
		paramGraphics.fill3DRect(x_cord, y_cord, this.barWidth, height, true);
		paramGraphics.setColor(Color.blue);
		paramGraphics.drawString(" " + value, x_cord + 2, y_cord - 5);
		paramGraphics.setColor(localColor);
	}

	public void draw(Graphics paramGraphics) {
		if (this.drawMode != 2) {
			if (this.swapFlag == true) {
				drawOneBar(paramGraphics, this.innerOld);
				drawOneBar(paramGraphics, this.innerOld + 1);
				this.swapFlag = false;
			}
		} else {
			paramGraphics.setColor(Color.pink);
			paramGraphics.fillRect(0, 0, 800, 800);
			for (int i = 0; i < this.aSize; i++) {
				drawOneBar(paramGraphics, i);
			}
		}
		paramGraphics.setColor(Color.pink);
		paramGraphics.fillRect(0, 0, 150, 32);
		paramGraphics.setColor(Color.black);
		paramGraphics.drawString("Comparisons = " + this.comps, 10, 28);
		paramGraphics.drawString("Swaps = " + this.swaps, 10, 15);

		paramGraphics.setColor(Color.pink);
		paramGraphics.fillRect(0, 230, 800, 65);
		if (this.aSize == 10) {
			arrowText(paramGraphics, Color.red, "outer", this.outer, 3, true,
					true);
			arrowText(paramGraphics, Color.blue, "inner", this.inner, 1, true,
					true);
			arrowText(paramGraphics, Color.blue, "inner+1", this.inner + 1, 1,
					true, true);
			if (this.doneFlag == true) {
				arrowText(paramGraphics, Color.black, "Sort is complete",
						this.inner, 2, false, true);
			} else if (this.barboxex[this.inner].getHeight() > this.barboxex[(this.inner + 1)]
					.getHeight()) {
				arrowText(paramGraphics, Color.blue, "Will be swapped",
						this.inner, 2, false, true);
			} else {
				arrowText(paramGraphics, Color.blue, "Will not be swapped",
						this.inner, 2, false, true);
			}
		} else {
			arrowText(paramGraphics, Color.red, "xxx", this.outer, 3, true,
					false);
			arrowText(paramGraphics, Color.blue, "xxx", this.inner, 1, true,
					false);
			arrowText(paramGraphics, Color.blue, "xxx", this.inner + 1, 1,
					true, false);
		}
		this.drawMode = 2;
	}

	public void sortStep() {
		if (this.doneFlag == true) {
			return;
		}
		this.comps += 1;
		if (this.barboxex[this.inner].getHeight() > this.barboxex[(this.inner + 1)]
				.getHeight()) {
			swap(this.inner, this.inner + 1);
			this.swapFlag = true;
			this.swaps += 1;
		}
		this.innerOld = this.inner;
		this.inner += 1;
		if (this.inner > this.outer - 1) {
			this.inner = 0;
			this.outer -= 1;
			if (this.outer == 0) {
				this.doneFlag = true;
			}
		}
	}

	public void swap(int paramInt1, int paramInt2) {
		BarBox localpersonBS = this.barboxex[paramInt1];
		this.barboxex[paramInt1] = this.barboxex[paramInt2];
		this.barboxex[paramInt2] = localpersonBS;
	}
}

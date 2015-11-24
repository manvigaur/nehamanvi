package com.stack;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StackApplet extends Applet implements ActionListener {
	Button bu1 = new Button("Reset");
	Button bu2 = new Button("Push");
	Button bu3 = new Button("Pop");
	Button bu4 = new Button("Top");
	int top = -1; // stack top
	int option = 0;
	int[] stack ; // Stack with max 15 elements
	Graphics h;
	Font fon1 = new Font("TimesRoman", 1, 20);
	Font fon2 = new Font("TimesRoman", 1, 12);
	Font fonsig = new Font("TimesRoman", 2, 10);

	public void init() {
		add(bu1);
		add(bu2);
		add(bu3);
		add(bu4);
		stack = new int[15];
		bu1.addActionListener(this);
		bu2.addActionListener(this);
		bu3.addActionListener(this);
		bu4.addActionListener(this);
	}

	public void paint(Graphics paramGraphics) {
		h = paramGraphics;
		paramGraphics.setColor(Color.pink);
		paramGraphics.fillRect(0, 0, 800, 800);
		paramGraphics.setColor(Color.blue);
		paramGraphics.drawLine(175, 400, 275, 400);
		h.fillRect(175, 400, 100, 10);
		paramGraphics.setFont(fon2);
		int value;
		int y_cord;
		for (int m = 0; m <= top; m++) { // this is used to display the
												// data in stack
			value = stack[m];
			y_cord = 380 - m * 20;
			h.setColor(Color.lightGray);
			h.fillRect(195, y_cord, 60, 20);
			h.setColor(Color.black);
			h.drawRect(195, y_cord, 60, 20);
			h.drawString(" " + value, 215, y_cord + 15);
		}
		if (top >= 0) { // this is used to draw TOP with arrow
			y_cord = 390 - top * 20;
			h.setColor(Color.black);
			h.drawLine(285, y_cord, 315, y_cord);
			h.drawLine(298, y_cord - 5, 285, y_cord);
			h.drawLine(298, y_cord + 5, 285, y_cord);
			h.drawString("TOP", 320, y_cord + 3);
		}
		paramGraphics.setColor(Color.black);
		paramGraphics.setFont(fon1);
		if (option == 1) {
			option = 0;
			paramGraphics.drawString("New empty stack is created", 160, 60);
			return;
		}

		else if (option == 2) {
			option = 0;
			if (top == 14) {
				paramGraphics.drawString("Stack is full!", 160, 60);
				return;
			}
			value = (int) (Math.random() * 100.0D);
			stack[(++top)] = value; // this is push value
			insertVal();
		} else if (option == 3) { // this is pop value
			option = 0;
			if (top == -1) {
				paramGraphics.drawString("Stack is empty!", 150, 60);
				return;
			}
			deleteVal();
			top -= 1;
		} else if (option == 4) { // this is used to display top value
			if (top == -1) {
				paramGraphics.drawString("Stack is empty!", 150, 60);
				return;
			}
			value = stack[top];
			paramGraphics.drawString("Top the stack is : " + value, 120, 60);
			option = 0;
			return;
		}
	}

	public void insertVal() {
		int k = 380 - top * 20;
		int j = k - 40;
		h.setFont(fon2);

		int i1 = stack[top];
		int m = top % 9;
		for (int i2 = j; i2 <= k; i2 += 5) {
			h.setColor(Color.pink);
			h.fillRect(193, i2 - 6, 64, 22);
			h.setColor(Color.lightGray);
			h.fillRect(195, i2, 60, 20);
			h.setColor(Color.black);
			h.drawRect(195, i2, 60, 20);
			h.drawString(" " + i1, 215, i2 + 15);
			slow();
		}
		int i = 390 - top * 20;
		h.setColor(Color.pink);
		h.fillRect(283, i + 10, 70, 30);
		h.setColor(Color.black);
		h.drawLine(285, i, 315, i);
		h.drawLine(298, i - 5, 285, i);
		h.drawLine(298, i + 5, 285, i);
		h.drawString("TOP", 320, i + 3);
	}

	public void deleteVal() {
		int k = 380 - top * 20;
		int j = k - 40;
		h.setFont(fon2);

		int i1 = stack[top];
		int m = top % 9;
		for (int i2 = k; i2 > j; i2 -= 5) {
			h.setColor(Color.pink);
			if (i2 == k) {
				h.fillRect(193, i2, 64, 20);
			} else {
				h.fillRect(193, i2 - 2, 64, 24);
			}
			h.setColor(Color.lightGray);
			h.fillRect(195, i2 - 5, 60, 20);
			h.setColor(Color.black);
			h.drawRect(195, i2 - 5, 60, 20);
			h.drawString(" " + i1, 215, i2 + 10);
			slow();
		}
		h.setColor(Color.pink);
		h.fillRect(193, j - 2, 64, 24);
		int i = 390 - top * 20;
		h.fillRect(283, i - 10, 70, 30);
		i += 20;
		if (top > 0) {
			h.setColor(Color.black);
			h.drawLine(285, i, 315, i);
			h.drawLine(298, i - 5, 285, i);
			h.drawLine(298, i + 5, 285, i);
			h.drawString("TOP", 320, i + 3);
		}
	}

	public void actionPerformed(ActionEvent paramActionEvent) {
		if (paramActionEvent.getSource() == bu1) {
			top=-1;
			int arr[] = new int[15];
			stack = arr;
			option = 1;
		} else if (paramActionEvent.getSource() == bu2) {
			option = 2;
		} else if (paramActionEvent.getSource() == bu3) {
			option = 3;
		} else if (paramActionEvent.getSource() == bu4) {
			option = 4;
		}
		repaint();
	}

	public void slow() {
		try {
			Thread.sleep(100L);
		} catch (InterruptedException localInterruptedException) {
		}
	}

	public void update(Graphics paramGraphics) {
		paint(paramGraphics);
	}
}

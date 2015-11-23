package com.list;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkListApplet extends Applet implements ActionListener {
	Button bu1 = new Button("New_List");
	Button bu2 = new Button("Ins_First");
	Button bu3 = new Button("Ins_Last");
	Button bu4 = new Button("Del_First");
	int val;
	int n;
	int indx;
	LinkList l;
	int option = 0;
	Font fon1 = new Font("TimesRoman", 1, 20);
	Font fon2 = new Font("TimesRoman", 0, 12);
	Font fonsig = new Font("TimesRoman", 2, 10);
	Graphics graphic;

	public void init() {
		l = new LinkList();
		add(bu1);
		add(bu2);
		add(bu3);
		add(bu4);
		bu1.addActionListener(this);
		bu2.addActionListener(this);
		bu3.addActionListener(this);
		bu4.addActionListener(this);
	}

	public void paint(Graphics paramGraphics) {
		graphic = paramGraphics;

		paramGraphics.setColor(Color.pink);
		paramGraphics.fillRect(80, 20, 350, 50);
		paramGraphics.setColor(Color.black);
		paramGraphics.setFont(fon1);
		if (option == 1) {
			option = 0;
			paramGraphics.drawString("Created new empty List", 100, 60);
		}

		else if (option == 2) {
			option = 0;
			if (l.isFull()) {
				paramGraphics.drawString("Maximum node limit is reached!", 100,
						60);
				return;
			}
			val = ((int) (Math.random() * 100.0D));
			l.insertBegin(val);
		} else if (option == 3) {
			option = 0;
			if (l.isFull()) {
				paramGraphics.drawString("Maximum node limit is reached!", 100,
						60);
				return;
			}
			val = ((int) (Math.random() * 100.0D));
			l.insertEnd(val);
		} else if (option == 4) {
			option = 0;
			if (l.isEmpty()) {
				paramGraphics.drawString("List is empty!", 150, 60);
				return;
			}
			l.deleteBegin();
		}
		paramGraphics.setColor(Color.pink);
		paramGraphics.fillRect(0, 0, 800, 800);
		paramGraphics.setFont(fon2);
		n = l.size();
		paramGraphics.setColor(Color.black);
		paramGraphics.drawString("First", 3, 155);
		Arrow(paramGraphics, 5, 160);
		if (n == 0) {
			paramGraphics.drawString("null", 38, 163);
			return;
		}
		int j = 35;
		int k = 150;
		Node localNode = l.first;
		for (int i = 1; i <= n; i++) {
			if (j > 380) {
				paramGraphics.drawLine(385, k + 10, 385, k + 50);
				paramGraphics.drawLine(385, k + 50, 5, k + 50);
				paramGraphics.drawLine(5, k + 50, 5, k + 70);
				k += 60;
				Arrow(paramGraphics, 5, k + 10);
				j = 35;
			}
			paramGraphics.setColor(Color.gray);
			paramGraphics.fillRect(j, k, 40, 20);
			paramGraphics.setColor(Color.black);
			paramGraphics.drawRect(j, k, 40, 20);
			val = localNode.data;
			paramGraphics.drawString(" " + val, j + 10, k + 15);
			paramGraphics.drawString(" " + i, j + 15, k + 35);
			if (i == n) {
				paramGraphics.drawLine(j, k + 20, j - 10, k + 20);
				paramGraphics.drawLine(j - 3, k + 17, j, k + 20);
				paramGraphics.drawLine(j - 3, k + 23, j, k + 20);
				paramGraphics.drawLine(j - 10, k + 20, j - 10, k + 30);
				paramGraphics.drawString("Last", j - 15, k + 45);
			}
			j += 40;
			Arrow(paramGraphics, j, k + 10);
			j += 30;
			localNode = localNode.next;
		}
		paramGraphics.drawString("null", j + 3, k + 13);
	}

	public void Arrow(Graphics paramGraphics, int paramInt1, int paramInt2) {
		paramGraphics.drawLine(paramInt1, paramInt2, paramInt1 + 30, paramInt2);
		paramGraphics.drawLine(paramInt1 + 23, paramInt2 - 5, paramInt1 + 30,
				paramInt2);
		paramGraphics.drawLine(paramInt1 + 23, paramInt2 + 5, paramInt1 + 30,
				paramInt2);
	}

	public void actionPerformed(ActionEvent paramActionEvent) {
		if (paramActionEvent.getSource() == bu1) {

			option = 1;
			l = new LinkList();
			l.first = l.last = null;
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
			Thread.sleep(500L);
		} catch (InterruptedException localInterruptedException) {
		}
	}

	public void update(Graphics paramGraphics) {
		paint(paramGraphics);
	}
}

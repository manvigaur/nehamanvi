package com.queue;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueApplet extends Applet implements ActionListener {
	Button bu1 = new Button("New");
	Button bu2 = new Button("Insert");
	Button bu3 = new Button("Delete");
	Button bu4 = new Button("Front");
	int rear = -1;
	int option = 0;
	int count = -1;
	Color boxcolor = Color.gray;
	int[] queue ;
	Graphics graphics;
	Font fon1 = new Font("TimesRoman", 1, 20);
	Font fon2 = new Font("TimesRoman", 1, 12);
	Font fonsig = new Font("TimesRoman", 2, 10);
	public void init() {
		queue=new int[15];
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
		graphics = paramGraphics;
		paramGraphics.setColor(Color.pink);
		paramGraphics.fillRect(0, 0, 800, 800);
		paramGraphics.setColor(Color.blue);
		paramGraphics.fillRect(185, 100, 5, 300);
		paramGraphics.fillRect(260, 100, 5, 300);
		paramGraphics.setFont(fon2);
		int value;
		int y_cord;
		for (int k = 0; k <= rear; k++) {
			value = queue[k];
			y_cord = 100 + k * 20;
			graphics.setColor(boxcolor);
			graphics.fillRect(195, y_cord, 60, 20);
			graphics.setColor(Color.black);
			graphics.drawRect(195, y_cord, 60, 20);
			graphics.drawString(" " + value, 215, y_cord + 15);
		}
		if (rear >= 0) {
			y_cord = 110 + rear * 20;
			graphics.setColor(Color.black);
			graphics.drawLine(285, y_cord, 315, y_cord);
			graphics.drawLine(298, y_cord - 5, 285, y_cord);
			graphics.drawLine(298, y_cord + 5, 285, y_cord);
			graphics.drawString("REAR", 320, y_cord + 3);
			graphics.drawLine(135, 110, 165, 110);
			graphics.drawLine(165, 110, 152, 105);
			graphics.drawLine(165, 110, 152, 115);
			graphics.drawString("FRONT", 93, 113);
		}
		paramGraphics.setColor(Color.black);
		paramGraphics.setFont(fon1);
		if (option == 1) {
			option = 0;
			paramGraphics.drawString("New Empty  Queue  is created .", 160, 60);
			return;
		}
		
		else if (option == 2) {
			option = 0;
			if (rear == 14) {
				paramGraphics.drawString("Queue is full .No more elements can be added in Queue untill removed.", 160, 60);
				return;
			}
			value = (int) (Math.random() * 100.0D);
			queue[(++rear)] = value;
			count += 1;
			insertVal();
		} else if (option == 3) {
			option = 0;
			if (rear == -1) {
				paramGraphics.drawString("Queue is empty!", 150, 60);
				return;
			}
			deleteVal();
			rear -= 1;
			repaint();
		} else if (option == 4) {
			if (rear == -1) {
				paramGraphics.drawString("Queue is empty!", 150, 60);
				return;
			}
			value = queue[0];
			paramGraphics.drawString("Value at the front of queue: " + value, 120,
					60);
			option = 0;
		}
	}

	public void insertVal() {
		int k = 100 + rear * 20;
		int j = k + 40;
		graphics.setFont(fon2);

		int m = queue[rear];
		
		for (int i1 = j; i1 >= k; i1 -= 5) {
			graphics.setColor(Color.pink);
			graphics.fillRect(193, i1 + 4, 64, 22);
			graphics.setColor(boxcolor);
			graphics.fillRect(195, i1, 60, 20);
			graphics.setColor(Color.black);
			graphics.drawRect(195, i1, 60, 20);
			graphics.drawString(" " + m, 215, i1 + 15);
			slow();
		}
		int i = 110 + rear * 20;
		graphics.setColor(Color.pink);
		graphics.fillRect(283, i - 27, 70, 30);
		graphics.setColor(Color.black);
		graphics.drawLine(285, i, 315, i);
		graphics.drawLine(298, i - 5, 285, i);
		graphics.drawLine(298, i + 5, 285, i);
		graphics.drawString("REAR", 320, i + 3);
	}

	public void deleteVal() {
		graphics.setFont(fon2);

		int i = queue[0];
		for (int j = 100; j > 50; j -= 5) {
			graphics.setColor(Color.pink);
			if (j == 100) {
				graphics.fillRect(193, j, 64, 20);
			} else {
				graphics.fillRect(193, j - 2, 64, 24);
			}
			graphics.setColor(boxcolor);
			graphics.fillRect(195, j - 5, 60, 20);
			graphics.setColor(Color.black);
			graphics.drawRect(195, j - 5, 60, 20);
			graphics.drawString(" " + i, 215, j + 10);
			slow();
		}
		for (int j = 1; j <= rear; j++) {
			queue[(j - 1)] = queue[j];
		}
	}

	public void actionPerformed(ActionEvent paramActionEvent) {
		if (paramActionEvent.getSource() == bu1) {
			option = 1;
			rear=-1;
			count=-1;
			int arr[] = new int[15];
			queue =new int[15];
		}else if (paramActionEvent.getSource() == bu2) {
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
			Thread.sleep(50L);
		} catch (InterruptedException localInterruptedException) {
		}
	}

	public void update(Graphics paramGraphics) {
		paint(paramGraphics);
	}
}

package com.sort.bubble;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

public class BubbleSortApplet extends Applet implements Runnable,
		ActionListener {
	private Image offscreenImage;
	private Graphics offscreenGraphics;
	private int aWidth;
	private int aHeight;
	private Thread runner;
	private int maxBar = 10;
	private Painter painter;
	private boolean runFlag;
	private int order = 1;
	private Button newButton;
	private Button runButton;
	private Button stepButton;

	public void init() {
		this.painter = new Painter(this.maxBar, this.order);
		setLayout(new FlowLayout());

		this.newButton = new Button("New");
		add(this.newButton);
		this.newButton.addActionListener(this);

		this.runButton = new Button("Run");
		add(this.runButton);
		this.runButton.addActionListener(this);

		this.stepButton = new Button("Step");
		add(this.stepButton);
		this.stepButton.addActionListener(this);

		this.aWidth = this.painter.getAppletWidth();
		this.aHeight = this.painter.getAppletHeight();
		this.offscreenImage = createImage(this.aWidth, this.aHeight);
		this.offscreenGraphics = this.offscreenImage.getGraphics();

		this.painter.setDrawMode(2);
		this.runFlag = false;
	}

	public void paint(Graphics paramGraphics) {
		this.painter.draw(this.offscreenGraphics);
		paramGraphics.drawImage(this.offscreenImage, 0, 0, this);
	}

	public void update(Graphics paramGraphics) {
		paint(paramGraphics);
	}

	public void actionPerformed(ActionEvent paramActionEvent) {
		if (paramActionEvent.getSource() == this.newButton) {
			this.runFlag = false;
			this.order = 1;
			this.painter = new Painter(this.maxBar, this.order);

		}

		else if (paramActionEvent.getSource() == this.runButton) {
			this.runFlag = true;
		} else if (paramActionEvent.getSource() == this.stepButton) {
			this.runFlag = false;
			this.painter.sortStep();
			this.painter.setDrawMode(1);
		}
		repaint();
	}

	public void run() {
		Thread thread = Thread.currentThread();
		while (this.runner == thread) {
			if ((this.runFlag == true) && (this.painter.getDone() == false)) {
				this.painter.sortStep();
				repaint();
				this.painter.setDrawMode(1);

				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
				}
			}
		}
	}

	public void start() {
		if (this.runner == null) {
			this.runner = new Thread(this);
			this.runner.start();
		}
	}

	public void stop() {
		this.runner = null;
	}
}

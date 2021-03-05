package week5;

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;

public class BoxDiagram extends GraphicsProgram {
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	private double cx;
	private double cy;
	private JButton butA;
	private JButton butR;
	private JButton butC;
	private JTextField txtF;
	private HashMap<String, GObject> figures = new HashMap<String, GObject>();
	private GObject pickedC;
	private GPoint mouse;

	public void init() {
		add(new JLabel("Name  "), SOUTH);
		txtF = new JTextField(20);
		txtF.addActionListener(this);
		add(txtF, SOUTH);
		butA = new JButton("Add");
		add(butA, SOUTH);
		butR = new JButton("Remove");
		add(butR, SOUTH);
		butC = new JButton("Clear");
		add(butC, SOUTH);
		addActionListeners();
		
		addMouseListeners();

	}// init

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == txtF) {
			drawRect(txtF.getText());
		} else if (e.getSource() == butA) {
			drawRect(txtF.getText());
		} else if (e.getSource() == butR) {
			removeNameRect(txtF.getText());
		} else if (e.getSource() == butC) {
			clearAll();
		}
	}// actionPerformed

	private void drawRect(String name) {
		cx = getWidth() / 2;
		cy = getHeight() / 2;
		println(name);
		GCompound comp = new GCompound();
		GLabel label = new GLabel(name);
		GRect rect = new GRect(label.getWidth()*4, label.getHeight()*4);
		comp.add(rect,0,0);
		comp.add(label,comp.getWidth()/2 - label.getWidth()/2,
					comp.getHeight()/2 + label.getHeight()/4);
		add(comp, cx - comp.getWidth()/2, cy - comp.getHeight()/2);
		
		figures.put(name, comp);
		
	}

	private void removeNameRect(String name) {
		if (figures.get(name) != null) {
		remove(figures.get(name));
		figures.remove(name);
		}
}

	private void clearAll() {
		
		Iterator <String> iter = figures.keySet().iterator();
			while (iter.hasNext()) {
				String k = iter.next();
				remove(figures.get(k));
			}
			
		figures.clear();
	}
	
	
	public void mousePressed(MouseEvent e) {
		mouse = new GPoint(e.getX(), e.getY());
		pickedC = getElementAt(mouse);
		if (pickedC != null) {
			pickedC.sendToFront();
		}
		
	}
	
	public void mouseDragged(MouseEvent e) {
		if (pickedC != null) {
		pickedC.move(e.getX()-mouse.getX(), e.getY()-mouse.getY());
		mouse = new GPoint(e.getX(), e.getY());
		}
	}
	
}// class
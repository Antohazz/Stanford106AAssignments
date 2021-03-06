package week5;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

import acm.program.*;
import acm.graphics.*;
// import java.util.ArrayList;
import acm.gui.TableLayout;

public class MyButtons extends GraphicsProgram {
	
	private JCheckBox checkbox;
	private JRadioButton r1;
	private JRadioButton r2;
	private JRadioButton r3;
	private JComboBox pick;
	private JButton hi;
	private TextField tf;
	
	
	public void init() {
	//	ArrayList<String> myArrayList = new ArrayList<String>();
		
		
		//setLayout(new GridLayout(2,3));
		//setLayout(new TableLayout(2,3));
		//IntField if = new IntField(5);
		//DoubleField if = new DoubleField(5);
		tf = new TextField(10);
		tf.addActionListener(this);
		add(new JLabel("Input   "), NORTH);
		add(tf, NORTH);
		
		pick = new JComboBox();
		pick.addItem("one");
		pick.addItem("two");
		pick.addItem("three");
		pick.setEditable(false);
		pick.setSelectedItem("two");
		add(new JLabel("   Choise"), SOUTH);
		add(pick, SOUTH);
		
		r1 = new JRadioButton("1");
		r2 = new JRadioButton("2");
		r3 = new JRadioButton("3");
		
		ButtonGroup rButton = new ButtonGroup();
		rButton.add(r1);
		rButton.add(r2);
		rButton.add(r3);
		r1.setSelected(true);
		
		add(r1, SOUTH);
		add(r2, SOUTH);
		add(r3, SOUTH);
		
		checkbox = new JCheckBox("Checkbox");
		checkbox.setSelected(false);
		add(checkbox, SOUTH);
				
		hi = new JButton("Hi");
		add(hi, SOUTH);
		//add(new JButton("Hi"), SOUTH);
		
		addActionListeners();
		
	}
	
	
	public void actionPerformed (ActionEvent e) {
		
		//e.getSource(); gives reference to button
		// if (e.getSource() == hi){};
		
		//String command = e.getActionCommand();
		if(e.getActionCommand().equals("Hi") && checkbox.isSelected() && r1.isSelected()) {
			println("Button Hi pushed");

		}
		if(e.getSource() == tf ) {
			println("Hi " + tf.getText());
		}

	}
	
	
}

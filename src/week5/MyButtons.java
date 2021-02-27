package week5;

import java.awt.event.*;

import javax.swing.*;

import acm.program.*;

public class MyButtons extends ConsoleProgram {
	
	private JCheckBox checkbox;
	private JRadioButton r1;
	private JRadioButton r2;
	private JRadioButton r3;
	private JComboBox pick;
	
	public void init() {
		
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
				
		add(new JButton("Hi"), SOUTH);
		
		addActionListeners();
		
	}
	
	
	public void actionPerformed (ActionEvent e) {
		//String command = e.getActionCommand();
		if(e.getActionCommand().equals("Hi") && checkbox.isSelected() && r1.isSelected()) {
			println("Button Hi pushed");

		}
		

	}
	
	
}

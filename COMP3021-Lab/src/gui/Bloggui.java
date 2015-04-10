package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Date;

import base.*;
import blog.*;

import javax.swing.*;


public class Bloggui implements ActionListener {

	private Blog blog;
	private JFrame microFrame ;
	private JPanel upper;
	private JPanel lower;
	private JLabel numCharLeft;
	private int numChar = 140;
	private JTextArea postTextArea;
	private JButton postBut;
	private JButton refreshBut;
	private JTextField postContent;
	private JPanel buttonPanel;

	public Bloggui() {
		// TODO Auto-generated constructor stub
	}

	public void setGUI(){
	}
	
	class postListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			blog.post(new Post(new Date(),postTextArea.getText()));

			blog.save("./blog");

			postTextArea.setText("What's on your mind?");
		}

	}
	class refreshListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			blog.load("./blog");

		}

	}



	public void setWindow() {
		microFrame = new JFrame (" Micro Blog Demo");
		microFrame.setSize (300,700);
		upper = new JPanel();
		lower = new JPanel();
		buttonPanel = new JPanel();
		microFrame.setLayout(new BorderLayout());
		upper.setLayout(new BorderLayout());
		lower.setLayout(new BorderLayout());
		buttonPanel.setLayout(new GridLayout());

		numCharLeft = new JLabel ("You can still input " + numChar + " characters.");
		postTextArea = new JTextArea ("What's on your mind?");
		postTextArea.setLineWrap(true);
		postTextArea.setWrapStyleWord(true);
		postTextArea.setPreferredSize(new Dimension (400,300));
		JScrollPane scrollPane = new JScrollPane(postTextArea);
		
		postTextArea.addKeyListener(new KeyListener(){
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				int wordleft = numChar-postTextArea.getText().length();
				if (wordleft< 0){
					arg0.consume();
				}
				
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int wordleft = numChar-postTextArea.getText().length();
				if (wordleft< 0){
					e.consume();
					numCharLeft.setText("Your post length has exceeded 140!");
				}else{
					numCharLeft.setText("You can still input " + wordleft + " characters.");
				}
			}
		});

		postBut = new JButton("Post");
		refreshBut = new JButton ("Refresh");
		postBut.addActionListener( new postListener());
		refreshBut.addActionListener(new refreshListener());

		buttonPanel.add(refreshBut);
		buttonPanel.add(postBut);
		upper.add(numCharLeft, BorderLayout.NORTH);
		upper.add(scrollPane,BorderLayout.CENTER);
		upper.add(buttonPanel,BorderLayout.SOUTH);

		microFrame.add(upper, BorderLayout.CENTER);

		postContent= new JTextField("Here is my post!",JTextField.CENTER); 
		postContent.setPreferredSize(new Dimension (400,300));
		postContent.setEditable(false);
		postContent.setHorizontalAlignment(JTextField.CENTER);
		lower.add(postContent, BorderLayout.CENTER);

		microFrame.add(lower, BorderLayout.SOUTH);

		microFrame.setVisible(true);
		microFrame.pack();
		microFrame.setLocationRelativeTo(null);


	}

	public static void main (String []args){
		Bloggui blog = new Bloggui();
		blog.setWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

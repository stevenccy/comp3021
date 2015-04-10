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
	private User user;
	private JFrame microFrame ;
	private JPanel upper;
	private JPanel lower;
	private JLabel numCharLeft;
	private int numChar = 140;
	private JTextArea postTextArea;
	private JButton postBut;
	private JButton refreshBut;
	private JTextArea postContent;
	private JPanel buttonPanel;

	public Bloggui() {
		// TODO Auto-generated constructor stub
	}

	public void setGUI(){
	}
	
	class postListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (blog == null){
				blog = new Blog (new User(1, "User", "User"));
			}
			blog.post(new Post(new Date(),postTextArea.getText()));

			blog.save((System.getProperty("user.dir")+"\blog"));

			postTextArea.setText("What's on your mind?");
		}

	}
	class refreshListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			blog.load(System.getProperty("user.dir")+"\blog");
			postContent.setText(blog.toString());
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
		postTextArea.setPreferredSize(new Dimension (200,200));
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
		upper.setMinimumSize(new Dimension(400,300));
		
		upper.add(buttonPanel,BorderLayout.SOUTH);

		microFrame.add(upper, BorderLayout.CENTER);

		postContent= new JTextArea("Here is my post!"); 
		postContent.setPreferredSize(new Dimension (400,300));
		postContent.setEditable(false);
		//postContent.setHorizontalAlignment(JTextField.CENTER);
		JScrollPane postScrollPane = new JScrollPane(postContent);
		//postScrollPane.setBounds(200,200,200,200);
		lower.add(postScrollPane, BorderLayout.CENTER);
		lower.setMinimumSize(new Dimension(400,300));
		microFrame.add(lower, BorderLayout.SOUTH);
		
		microFrame.setVisible(true);
		//microFrame.pack();
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

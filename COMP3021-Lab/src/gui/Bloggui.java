package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class Bloggui implements ActionListener {


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
		super();
		// TODO Auto-generated constructor stub
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
		postTextArea.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				postTextArea.selectAll();;				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		postTextArea.addKeyListener(new KeyListener(){
			@Override
		    public void keyTyped(KeyEvent arg0) {
				numCharLeft.setText("You can still input " + (numChar-postTextArea.getText().length()) + " characters.");
		    }

			@Override
			public void keyPressed(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		postBut = new JButton("Post");
		refreshBut = new JButton ("Refresh");
		postBut.addActionListener(this);
		refreshBut.addActionListener(this);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == postBut) {
			postContent.setText("you click POST!");
		}
		else if (e.getSource() == refreshBut){
			postContent.setText("you click REFRESH!");
		}
	}

	public static void main (String []args){
		Bloggui blog = new Bloggui();
		blog.setWindow();
	}

}
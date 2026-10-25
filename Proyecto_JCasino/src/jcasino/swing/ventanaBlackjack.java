package jcasino.swing;

import javax.swing.JFrame;

public class ventanaBlackjack extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public ventanaBlackjack(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(640, 480);
		setTitle("Mesa de Blackjack");
		
		
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ventanaBlackjack();
	}

}

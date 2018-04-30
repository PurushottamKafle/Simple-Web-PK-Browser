package pksoft;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class first extends JFrame { 
	private JTextField address;
	private JEditorPane display;
	// making constractor
	
	public first() {
		super("PK Browser");
		address = new JTextField("http://www.");
		address.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						loadURL(e.getActionCommand());
					}
				}
				
				);
		
		add(address, BorderLayout.NORTH);
		// making next main display
		display = new JEditorPane();
		display.setEditable(false);
		// making event listener as HyperLink
		display.addHyperlinkListener(
				new HyperlinkListener() {
					public void hyperlinkUpdate(HyperlinkEvent e) {
						if(e.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
							loadURL(e.getURL().toString());
						}
					}
				}
				);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500, 300);
		setVisible(true);
	}
	
	private void loadURL(String userText) {
		try {
			// this is main 
			display.setPage(userText);
			address.setText(userText);
		}catch(Exception e) {
			System.out.println("You really SUCKS!");
		}
	}
}


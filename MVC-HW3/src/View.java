import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View { //The View
	JButton addButton;
	public static ActionListener listener;
	JTextArea textArea;
	JTextArea editText;
	
	View () {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		
		textArea = new JTextArea(20, 20);
		frame.add(textArea, BorderLayout.CENTER);
		editText = new JTextArea(5, 20);
		JPanel editPanel = new JPanel();
		editPanel.add(editText);
		
		JPanel panel = new JPanel();
		addButton = new JButton("ADD");
		panel.add(addButton);
			
		frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(editPanel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public void setActionListenerToAddbutton (ActionListener listen) {
		addButton.addActionListener(listen);
	}
	public void updateView (String text) {
		text = text + editText.getText() + "\n";
		textArea.setText(text);
	}
	public String getText() {
		return editText.getText();
	}
}

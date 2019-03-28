import java.awt.event.*;

public class MVCTester {  //The Controller in this case

	public static void main(String[] args) {
		View view = new View();
		Model model = new Model();
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = "";
				for(String str : model.getData()) {
					  text = text + str +"\n";
				}
				view.updateView(text);
				model.addToModel(view.getText());		
			}
		};
		
		view.setActionListenerToAddbutton(listener);
	}
}

import java.util.ArrayList;
public class Model { //The Model

	private ArrayList<String> text; //data structure
	
	public Model() {
		text = new ArrayList<String>();
	}
	
	public void addToModel(String s){ //mutator
		text.add(s);
	}
	
	public ArrayList<String> getData() { //accessor
		return text;
	}
}

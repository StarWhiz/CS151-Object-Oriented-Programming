import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
   A class for testing an implementation of the Observer pattern.
*/
public class ObserverTester //This is the controller....
{
	static DataModel model;
	static TextFrame frame;
   /**
      Creates a DataModel and attaches barchart and textfield listeners
      @param args unused
   */
   public static void main(String[] args)
   {
      ArrayList<Double> data = new ArrayList<Double>();

      data.add(new Double(25));
      data.add(new Double(100));
      data.add(new Double(50));
      data.add(new Double(75));

      model = new DataModel(data);

      frame = new TextFrame(model);

      BarFrame barFrame = new BarFrame(model);
      
      MouseAdapter mListener = new MouseAdapter() {
    	  @Override
    	  public void mouseClicked(MouseEvent e) {
    		  	changeInBarFrameView(e);
    	  }
      };
      
      barFrame.attach(mListener);   
      model.attach(barFrame);
   }
   public static void changeInBarFrameView(MouseEvent e) {

		int x = e.getX()/2; // value to accept
		int y = e.getY(); // to determine which bar location to use
		
		System.out.println("value of x:" + x);
		System.out.println("value of y:" + y);
		
		if (y >= 0 && y <= 50) {
			model.update(0, x);
			frame.stateChanged();
		}
		else if (y > 50 && y <= 100) {
			model.update(1, x);
			frame.stateChanged();
		}
		else if (y > 100 && y <= 150) {
			model.update(2, x);
			frame.stateChanged();
		}
		else if (y > 150 && y <= 200) {	
			model.update(3, x);
			frame.stateChanged();
		}
   }
}

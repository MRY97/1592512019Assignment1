package nz.ac.massey.assignment1;

import junit.framework.TestCase;

public class SearchTest extends TestCase {

	public void testIndexNum() {
		GUI gui = new GUI();
		gui.jta.setText("This is the testing string");
		Search search = new Search(gui.frmte,gui.jta);
		search.findEdit.setText("This");
		search.IndexNum(search.text.getText().indexOf(search.findEdit.getText(),0));
	}


}
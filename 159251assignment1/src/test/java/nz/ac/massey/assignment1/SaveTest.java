package nz.ac.massey.assignment1;

import java.awt.FileDialog;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

public class SaveTest extends TestCase {

	@SuppressWarnings("resource")
	public void testSave() throws Exception{
		GUI gui = new GUI();
		gui.jta.setText("This is the testing string");
		FileDialog saveDia = new FileDialog(gui.frmte, "Save", FileDialog.SAVE);
		Save save = new Save();
		save.save(gui.jta, saveDia);
		FileReader fr=null;
		char[] chars = new char[1024];
		String test = "";
		int ch = 0;
		try
		{
			fr=new FileReader(saveDia.getDirectory()+saveDia.getFile());
			while((ch=fr.read())!=-1) 
			{
				test = test+(char)ch;
			}

		}
		catch(IOException e) 
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				if(fr!=null) 
				{
					fr.close();
				}
			}
			catch(IOException e) 
			{
				System.out.println(e.toString());
			}
		}

        assertEquals(test,"This is the testing string");
	}

}

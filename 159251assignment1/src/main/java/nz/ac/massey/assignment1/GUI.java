package nz.ac.massey.assignment1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.itextpdf.text.DocumentException;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
public class GUI {
	public JFrame frmte;
	//create new frame
	JMenuBar jmb;	
	JMenu menu1, menu2, menu3, menu4, menu5;
	JMenuItem item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12;
	JMenu open;	
	JMenuItem txtfile, odtfile;
	//create the whole menu
	JTextArea jta;
	//create a text area for writing text 
	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private FileDialog openDia, saveDia;
	public GUI() {
		frmte = new JFrame();
		Jsontwo.Json(frmte);
		frmte.setTitle("text editor");
		frmte.setBounds(600, 300, 500, 400);
		frmte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmte.setVisible(true);
		
		//design the window parameter
		
		menu1 = new JMenu("File");
		menu2 = new JMenu("Search");
		menu3 = new JMenu("View");
		menu4 = new JMenu("Manage");
		menu5 = new JMenu("Help");		
		Json.Json(menu1,menu2,menu3,menu4,menu5);
		//set the name of menu
		open = new JMenu("Open");		
		//set the name of the second menu
		txtfile = new JMenuItem("txt");
		odtfile = new JMenuItem("odt");
		item1 = new JMenuItem("New");
		item2 = new JMenuItem("Save");
		item3 = new JMenuItem("Select");
		item4 = new JMenuItem("Copy");
		item5 = new JMenuItem("Paste");
		item6 = new JMenuItem("Cut");
		item7 = new JMenuItem("Search");
		item8 = new JMenuItem("Print");
		item9 = new JMenuItem("GetT&D");
		item10 = new JMenuItem("About");
		item11 = new JMenuItem("PDFconversation");
		item12 = new JMenuItem("Exit");
		//set name of menu item
		open.add(txtfile);
		open.add(odtfile);		
		menu1.add(item1);
		menu1.add(open);
		menu1.add(item2);
		menu1.add(item8);
		menu1.add(item12);
		menu2.add(item7);
		menu2.add(item9);
		menu3.add(item11);
		menu4.add(item3);
		menu4.add(item4);
		menu4.add(item5);
		menu4.add(item6);
		menu5.add(item10);

		//add second menu and items to menus respectively
		jmb = new JMenuBar();
		jmb.add(menu1);
		jmb.add(menu2);
		jmb.add(menu3);
		jmb.add(menu4);
		jmb.add(menu5);
		//add menu to bar
		jta = new JTextArea();
		jta = new RSyntaxTextArea(20, 30);
		((RSyntaxTextArea) jta).setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		((RSyntaxTextArea) jta).setCodeFoldingEnabled(true);
		
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		frmte.setJMenuBar(jmb);	
		frmte.add(jsp, BorderLayout.CENTER);	
		//add components to frame
		openDia = new FileDialog(frmte,"Open",FileDialog.LOAD);
		saveDia = new FileDialog(frmte, "Save", FileDialog.SAVE);
		frmte.setLocation(width/2-300,height/2-200);
		frmte.setVisible(true);
		//set the window can be see
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new New();
			}			
		});
		//achieve the New function
		txtfile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Open open = new Open();
				open.opentxt(openDia);
			}
		});
		//achieve the Open_txt_file function
		item2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Save save = new Save();
				save.save(jta,saveDia);
			}
		});
		item3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.select(jta);
			}
		});
		//achieve the Select function
		item4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.copy(jta);				
			}
		});
		//achieve the Copy function
		item5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.paste(jta);
			}
		});
		//achieve the Paste function
		item6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.cut(jta);
			}
		});
		//achieve the Cut function
		final JFileChooser pdfSaver = new JFileChooser();
        pdfSaver.setFileFilter(new FileNameExtensionFilter("pdf",".pdf"));

		item11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				pdfSaver.showDialog(frmte, "save as pdf");
				File file = pdfSaver.getSelectedFile();
				PDFconversation pdf = new PDFconversation();
				try {
					pdf.pdfconversation(file, jta.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

			}
				
		);
		//achieve the PDFconversation function
		item12.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});
		//achieve the Exit function
		item7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Search(frmte,jta);		
			}
		});
		//achieve the Search function
		item8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Print(jta,frmte);
			}
			
		});
		item9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TimeAndDate timeanddate = new TimeAndDate();
				timeanddate.setLocation(width/2, height/2-200);
			}
		});
		item10.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new About();
			}
		});
	}
	public static void main(String[] args) {
		new GUI();
		//initial frame
	}
}

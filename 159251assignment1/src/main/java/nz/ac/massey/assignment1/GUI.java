package nz.ac.massey.assignment1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
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
	private FileDialog openDia, saveDia;
	public GUI() {
		frmte = new JFrame();
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
		JScrollPane jsp = new JScrollPane(jta);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		frmte.setJMenuBar(jmb);	
		frmte.add(jsp, BorderLayout.CENTER);	
		//add components to frame
		openDia = new FileDialog(frmte,"Open",FileDialog.LOAD);
		saveDia = new FileDialog(frmte, "Save", FileDialog.SAVE);
		frmte.setVisible(true);
		//set the window can be see
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				New newWindow = new New();
				newWindow.newWindow();
			}			
		});
		//achieve the New function
		txtfile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new Open(openDia);
				
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
				select.select();
			}
		});
		//achieve the Select function
		item4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.copy();				
			}
		});
		//achieve the Copy function
		item5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.paste();
			}
		});
		//achieve the Paste function
		item6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.cut();
			}
		});
		//achieve the Cut function
		item11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new PDFconversation();				
			}
		});
		//achieve the PDFconversation function
		item12.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);			
			}
		});
		//achieve the Exit function
	}
	public static void main(String[] args) {
		new GUI();
		//initial frame
	}
}

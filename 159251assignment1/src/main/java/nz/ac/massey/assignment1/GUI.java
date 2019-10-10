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
	JMenuItem item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11;
	JMenu open;	
	JMenuItem txtfile, odtfile;
	//create the whole menu
	JTextArea jta;
	//create a text area for writing text 

	public GUI() {
		frmte = new JFrame();
		frmte.setTitle("text editor");
		frmte.setBounds(600, 300, 500, 400);
		frmte.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		//set name of menu item
		open.add(txtfile);
		open.add(odtfile);		
		menu1.add(item1);
		menu1.add(open);
		menu1.add(item2);
		menu1.add(item8);
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
		
		frmte.setVisible(true);
		//set the window can be see
	}
	public static void main(String[] args) {
		GUI texteditor = new GUI();
		texteditor.txtfile.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Open openfile = new Open();
				
			}
		});
		texteditor.item3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.select();
			}
		});
		texteditor.item4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.copy();				
			}
		});
		texteditor.item5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.paste();
			}
		});
		texteditor.item6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SCPC select = new SCPC();
				select.cut();;
			}
		});
		texteditor.item11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PDFconversation pdfc = new PDFconversation();				
			}
		});
	}
}

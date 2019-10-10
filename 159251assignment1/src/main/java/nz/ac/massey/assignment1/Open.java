package nz.ac.massey.assignment1;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Open extends GUI {
	private FileDialog openDia;
	private File file;
	public Open() {
        GUI openWindow = new GUI();
        openDia = new FileDialog(openWindow.frmte,"Open",FileDialog.LOAD);
        openDia.setVisible(true);//显示打开文件对话框
        String dirpath = openDia.getDirectory();//获取打开文件路径并保存到字符串中。
        String fileName = openDia.getFile();//获取打开文件名称并保存到字符串中
        
        if (dirpath == null || fileName == null)//判断路径和文件是否为空
            return;
        else
            openWindow.jta.setText(null);//文件不为空，清空原来文件内容。
        file = new File(dirpath, fileName);//创建新的路径和名称

        try {
            BufferedReader bufr = new BufferedReader(new FileReader(file));//尝试从文件中读东西
            String line = null;//变量字符串初始化为空
            while ((line = bufr.readLine()) != null) {
                openWindow.jta.append(line + "\r\n");//显示每一行内容
            }
            bufr.close();//关闭文件
        } catch (FileNotFoundException e1) {
            // 抛出文件路径找不到异常
            e1.printStackTrace();
        } catch (IOException e1) {
            // 抛出IO异常
            e1.printStackTrace();
        }

    }
}

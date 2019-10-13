package nz.ac.massey.assignment1;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;`

import javax.swing.*;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Json {
	@SuppressWarnings("deprecation")
	public static void Json(JMenu menu1,JMenu menu2,JMenu menu3,JMenu menu4,JMenu menu5) {
		JsonParser parser =new JsonParser();
        try {
            JsonObject json=(JsonObject) parser.parse(new FileReader("jsonfile.json"));
            int color = json.get("color").getAsInt();
            menu1.setForeground(new Color(color));
            menu2.setForeground(new Color(color));
            menu3.setForeground(new Color(color));
            menu4.setForeground(new Color(color));
            menu5.setForeground(new Color(color));
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}

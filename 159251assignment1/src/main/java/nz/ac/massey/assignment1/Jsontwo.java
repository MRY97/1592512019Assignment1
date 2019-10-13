package nz.ac.massey.assignment1;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.*;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Jsontwo {
	public static void Json(JFrame content) {
		@SuppressWarnings("deprecation")
		JsonParser parser =new JsonParser();
        try {
            @SuppressWarnings("deprecation")
			JsonObject json=(JsonObject) parser.parse(new FileReader("jsonfile.json"));
            int r = json.get("r").getAsInt();
            int g = json.get("g").getAsInt();
            int b = json.get("b").getAsInt();
            content.setForeground(new Color(r,g,b));
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
}

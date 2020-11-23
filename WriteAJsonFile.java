package JSONBasics;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteAJsonFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("Name", "Rajesh");
		jsonObject.put("Age", 29);
		
		JSONArray array=new JSONArray();
		array.add("Divya");
		array.add("Shivani");
		
		jsonObject.put("Familydetails", array);
		
		FileWriter fileWriter=new FileWriter("E:\\Software Testing\\Rajesh.txt");
		fileWriter.write(jsonObject.toJSONString());
		fileWriter.close();
		
	}

}

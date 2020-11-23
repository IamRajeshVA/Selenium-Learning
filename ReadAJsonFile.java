package JSONBasics;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import net.sourceforge.htmlunit.corejs.javascript.ast.WhileLoop;

public class ReadAJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		JSONParser jsonParser=new JSONParser();
		
		
	FileReader fileReader=new FileReader("E:\\Software Testing\\Rajesh.txt");
    Object object=jsonParser.parse(fileReader);
    JSONObject jsonObject=(JSONObject) object;
    String name=(String) jsonObject.get("Name");
    Long age =(Long) jsonObject.get("Age");
    JSONArray array=(JSONArray) jsonObject.get("Familydetails");
    System.out.println("Name :"+name);
    System.out.println("Age :"+age);
    Iterator iterator=array.iterator();
    while(iterator.hasNext())
    {
    	System.out.println("Family details :"+iterator.next());
    }

	}

}

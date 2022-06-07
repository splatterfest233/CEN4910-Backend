import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
  
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
  
public class JSONReadExample 
{
    public static void main(String[] args) throws Exception 
    {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
          
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
          
        // getting Property and Id 
        String propertyName = (String) jo.get("propertyName");
        String id = (String) jo.get("id");
          
        System.out.println(propertyName);
        System.out.println(id);
          
       // Getting Beds/Baths/Sqft

        String beds = (String) jo.get("beds");
        System.out.println(beds);
        String baths = (String) jo.get("baths");
        System.out.println(baths);
        String sqft = (String) jo.get("sqft");
        System.out.println(sqft);

          
        // getting address
        Map address = ((Map)jo.get("address"));
          
        // iterating address Map
        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
          
        // getting amenities
        JSONArray ja = (JSONArray) jo.get("amenities");
          
        // iterating amenities
        Iterator itr2 = ja.iterator();
        
        
          
        while (itr2.hasNext()) 
        {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }
}
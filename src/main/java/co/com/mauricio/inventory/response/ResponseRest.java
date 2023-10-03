package co.com.mauricio.inventory.response;

import java.util.ArrayList;
import java.util.HashMap;

public class ResponseRest {
	
	private ArrayList<HashMap<String, String>> metaData = new ArrayList<>();

	public ArrayList<HashMap<String, String>> getMetaData() {
		return metaData;
	}

	public void setMetaData(String type, String code, String date) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("code", code);
		map.put("date", date);
		
		metaData.add(map);
	}
	
	

}

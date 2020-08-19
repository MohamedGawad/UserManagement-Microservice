package bsu.chatbot.usermanagement.model;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Location {
	private String id;
	private String icon;
	private String name;
	private String vicinity;
	private String rating;
	private String types;
	private String exceptionalDate;
	private String openNow;
	private String weekdayText;
	private Double latitude;
	private Double longitude;
	private double distance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getExceptionalDate() {
		return exceptionalDate;
	}

	public void setExceptionalDate(String exceptionalDate) {
		this.exceptionalDate = exceptionalDate;
	}

	public String getOpenNow() {
		return openNow;
	}

	public void setOpenNow(String openNow) {
		this.openNow = openNow;
	}

	public String getWeekdayText() {
		return weekdayText;
	}

	public void setWeekdayText(String weekdayText) {
		this.weekdayText = weekdayText;
	}

	public static Location jsonToLocation(JSONObject jsonToLocation) {
		try {
			Location result = new Location();
			JSONObject geometry = (JSONObject) jsonToLocation.get("geometry");
			JSONObject location = (JSONObject) geometry.get("location");
			result.setLatitude((Double) location.get("lat"));
			result.setLongitude((Double) location.get("lng"));
			result.setIcon(getValue(jsonToLocation,"icon").toString());
			result.setName(getValue(jsonToLocation,"name").toString());
			result.setVicinity(getValue(jsonToLocation,"vicinity").toString());
			result.setId(getValue(jsonToLocation,"id").toString());
			result.setRating(getValue(jsonToLocation,"rating").toString());
			result.setTypes(getValue(jsonToLocation,"types").toString());
			Object obj= getValue(jsonToLocation,"opening_hours");
			if(!obj.toString().isEmpty()){
				JSONObject openingHours = (JSONObject)obj;
				result.setOpenNow(getValue(openingHours,"open_now").toString().contains("true") ? "open" : "closed");
				JSONArray arrayExce = openingHours.getJSONArray("exceptional_date");
				JSONArray arrayWeekday = openingHours.getJSONArray("weekday_text");
				String exceptionalDate="";
				String weekdayText="";
				for (int i = 0; i < arrayExce.length(); i++) {
					exceptionalDate+=arrayExce.get(i).toString();
				}
				for (int i = 0; i < arrayWeekday.length(); i++) {
					weekdayText+=arrayWeekday.get(i).toString();
				}
				result.setExceptionalDate(exceptionalDate);
				result.setWeekdayText(weekdayText);
			}
			
			return result;
		} catch (JSONException ex) {
			Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public static Object getValue(JSONObject json, String key) {
		Object val = "";
		try {
			val = json.get(key);
		} catch (JSONException e) {
			System.out.println(key + " key not found");
		}
		return val;
	}

	@Override
	public String toString() {
		return "Place{" + "id=" + id + ", icon=" + icon + ", name=" + name + ", latitude=" + latitude + ", longitude="
				+ longitude + '}';
	}

}
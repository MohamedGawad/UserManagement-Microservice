package bsu.chatbot.usermanagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LocationDetail {
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
	private String distanceKM;
	private List<String> photos;
	private static String G_PLACE_PHOTO_API;
	private static String IMG_API_KEY;
	
	public static void setGPlacePhotoAPI(String url) {
		G_PLACE_PHOTO_API = url;
	}
	public static void setGImgAPIKey(String key) {
		IMG_API_KEY = key;
	}

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

	public String getDistanceKM() {
		return distanceKM;
	}

	public void setDistanceKM(String distanceKM) {
		this.distanceKM = distanceKM;
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

	public List<String> getPhotos() {
		return photos;
	}
	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
	public static LocationDetail jsonToLocation(JSONObject jsonToLocation) {
		try {
			LocationDetail result = new LocationDetail();
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
			Object hoursObj= getValue(jsonToLocation,"opening_hours");
			if(!hoursObj.toString().isEmpty()){
				JSONObject openingHours = (JSONObject)hoursObj;
				result.setOpenNow(getValue(openingHours,"open_now").toString().contains("true") ? "open" : "closed");
				JSONArray arrayExce = getArray(openingHours,"exceptional_date");
				JSONArray arrayWeekday = getArray(openingHours,"weekday_text");
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
			}else{
				result.setOpenNow("");
				result.setExceptionalDate("");
				result.setWeekdayText("");
			}
			List<String> photos= new ArrayList<String>();
			Object photosObj= getValue(jsonToLocation,"photos");
			if(!photosObj.toString().isEmpty()){
				JSONArray photosArray = (JSONArray)photosObj;
				for (int i = 0; i < photosArray.length(); i++) {
					String maxheight=getValue(photosArray.getJSONObject(i),"height").toString();
					String maxwidth=getValue(photosArray.getJSONObject(i),"width").toString();
					String photoReference=getValue(photosArray.getJSONObject(i),"photo_reference").toString();
//					String html_attributions=getValue(photosArray.getJSONObject(i),"html_attributions").toString();
					String photoUrl=makePhotoUrl(maxwidth, maxheight, photoReference);
					photos.add(photoUrl);
					
				}				
			}
			result.setPhotos(photos);
			
			
			return result;
		} catch (JSONException ex) {
			Logger.getLogger(LocationDetail.class.getName()).log(Level.SEVERE, null, ex);
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
	public static JSONArray getArray(JSONObject json, String key) {
		JSONArray val = new JSONArray();
		try {
			json.getJSONArray(key);
		} catch (JSONException e) {
			System.out.println(key + " array not found");
		}
		return val;
	}
	
	private static String makePhotoUrl(String maxwidth, String maxheight, String photoreference) {
		StringBuilder urlString = new StringBuilder(G_PLACE_PHOTO_API);
		if (!maxwidth.isEmpty())
			urlString.append("&maxwidth=500");
		if (!maxheight.isEmpty())
			urlString.append("&maxheight=250");
		urlString.append("&photoreference=" + photoreference);
		urlString.append("&key=" + IMG_API_KEY);

		return urlString.toString();
	}

	@Override
	public String toString() {
		return "Place{" + "id=" + id + ", icon=" + icon + ", name=" + name + ", latitude=" + latitude + ", longitude="
				+ longitude + '}';
	}

}
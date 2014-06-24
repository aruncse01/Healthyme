package com.example.uidesign;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;


public class StoreActivity extends Activity implements LocationListener {

	//instance variables for Marker icon drawable resources
		private int userIcon, foodIcon, drinkIcon, shopIcon,otherIcon;

		//the map
		private GoogleMap theMap;

		//location manager
		private LocationManager locMan;

		//user marker
		private Marker userMarker;
		
		//places of interest
		private Marker[] placeMarkers;
		//max
		private final int MAX_PLACES = 20;//most returned from google
		//marker options
		private MarkerOptions[] places;

		@SuppressLint("NewApi")
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_store);

			//get drawable IDs
			userIcon = R.drawable.user;
			foodIcon = R.drawable.food;
			drinkIcon = R.drawable.drink;
			shopIcon = R.drawable.shop;
			otherIcon = R.drawable.other;

			//find out if we already have it
			if(theMap==null){
				//get the map
				theMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();
				//check in case map/ Google Play services not available
				if(theMap!=null){
					//ok - proceed
					theMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
					
					//create marker array
					placeMarkers = new Marker[MAX_PLACES];
					//update location
					updatePlaces();
				}

			}
		}
		
		//location listener functions
		
		@Override
		public void onLocationChanged(Location location) {
			Log.v("StoreActivity", "location changed");
			//updatePlaces();
		}
		@Override
		public void onProviderDisabled(String provider){
			Log.v("StoreActivity", "provider disabled");
		}
		@Override
		public void onProviderEnabled(String provider) {
			Log.v("StoreActivity", "provider enabled");
		}
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			Log.v("StoreActivity", "status changed");
		}
		
		/*
		 * update the place markers
		 */
		private void updatePlaces(){
			//get location manager
			locMan = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
			//get last location
			
			Location lastLoc = locMan.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			double lat = lastLoc.getLatitude();
			double lng = lastLoc.getLongitude();
			//create LatLng
			LatLng lastLatLng = new LatLng(lat, lng);

			//remove any existing marker
			if(userMarker!=null) userMarker.remove();
			//create and set marker properties
			userMarker = theMap.addMarker(new MarkerOptions()
			.position(lastLatLng)
			.title("You are here")
			.icon(BitmapDescriptorFactory.fromResource(userIcon))
			.snippet("Your last recorded location"));
			//move to location
			theMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lastLatLng, 10));
			//theMap.animateCamera(CameraUpdateFactory.newLatLng(lastLatLng), 3000, null);
			theMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
			//build places query string
			String placesSearchStr = "https://maps.googleapis.com/maps/api/place/nearbysearch/" +
					"json?location="+lat+","+lng+
					"&radius=1000&sensor=true" +
					"&name=supermarket"+
					"&types=grocery_or_supermarket"+
					"&key=AIzaSyBGe8Way9eFY4xGaYXqsHTJuLp0wtuk9VM";
			Log.i("StringPlaces",placesSearchStr);
			//execute query
			new GetPlaces().execute(placesSearchStr);
			
			locMan.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 30000, 100, this);
		}
		
		
		private class GetPlaces extends AsyncTask<String, Void, String> {
			@Override
			protected String doInBackground(String... placesURL) {
				//fetch places
				
				//build result as string
				StringBuilder placesBuilder = new StringBuilder();
				//process search parameter string(s)
				for (String placeSearchURL : placesURL) {
					HttpClient placesClient = new DefaultHttpClient();
					try {
						//try to fetch the data
						
						//HTTP Get receives URL string
						HttpGet placesGet = new HttpGet(placeSearchURL);
						//execute GET with Client - return response
						HttpResponse placesResponse = placesClient.execute(placesGet);
						//check response status
						StatusLine placeSearchStatus = placesResponse.getStatusLine();
						//only carry on if response is OK
						if (placeSearchStatus.getStatusCode() == 200) {
							//get response entity
							HttpEntity placesEntity = placesResponse.getEntity();
							//get input stream setup
							InputStream placesContent = placesEntity.getContent();
							//create reader
							InputStreamReader placesInput = new InputStreamReader(placesContent);
							//use buffered reader to process
							BufferedReader placesReader = new BufferedReader(placesInput);
							//read a line at a time, append to string builder
							String lineIn;
							while ((lineIn = placesReader.readLine()) != null) {
								placesBuilder.append(lineIn);
							}
						}
					}
					catch(Exception e){ 
						e.printStackTrace(); 
					}
				}
				Log.i("Placesresult",placesBuilder.toString());
				return placesBuilder.toString();
				
			}
			//process data retrieved from doInBackground
			protected void onPostExecute(String result) {
				//parse place data returned from Google Places
				//remove existing markers
				if(placeMarkers!=null){
					for(int pm=0; pm<placeMarkers.length; pm++){
						if(placeMarkers[pm]!=null)
							placeMarkers[pm].remove();
					}
				}
				try {
					//parse JSON
					
					//create JSONObject, pass string returned from doInBackground
					JSONObject resultObject = new JSONObject(result);
					Log.i("getJsonResult","Json Result");
					//get "results" array
					JSONArray placesArray = resultObject.getJSONArray("results");
					//marker options for each place returned
					places = new MarkerOptions[placesArray.length()];
					//loop through places
					for (int p=0; p<placesArray.length(); p++) {
						//parse each place
						//if any values are missing we won't show the marker
						boolean missingValue=false;
						LatLng placeLL=null;
						String placeName="";
						String vicinity="";
						int currIcon =otherIcon;
						try{
							//attempt to retrieve place data values
							missingValue=false;
							//get place at this index
							JSONObject placeObject = placesArray.getJSONObject(p);
							Log.i("Jsondata","places");
							//get location section
							JSONObject loc = placeObject.getJSONObject("geometry")
									.getJSONObject("location");
							//read lat lng
							placeLL = new LatLng(Double.valueOf(loc.getString("lat")), 
									Double.valueOf(loc.getString("lng")));	
							//get types
							JSONArray types = placeObject.getJSONArray("types");
							//loop through types
							Log.i("data from google places", placeObject.toString());
							for(int t=0; t<types.length(); t++){
								//what type is it
								String thisType=types.get(t).toString();
								//check for particular types - set icons
								if(thisType.contains("food")){
									currIcon = shopIcon;
									break;
								}
								else if(thisType.contains("bar")){
									currIcon = drinkIcon;
									break;
								}
								else if(thisType.contains("store")){
									currIcon = shopIcon;
									break;
								}
							}
							//vicinity
							vicinity = placeObject.getString("vicinity");
							//name
							placeName = placeObject.getString("name");
						}
						catch(JSONException jse){
							Log.v("PLACES", "missing value");
							missingValue=true;
							jse.printStackTrace();
						}
						//if values missing we don't display
						if(missingValue)	places[p]=null;
						else
							places[p]=new MarkerOptions()
						.position(placeLL)
						.title(placeName)
						.icon(BitmapDescriptorFactory.fromResource(currIcon))
						.snippet(vicinity);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				if(places!=null && placeMarkers!=null){
					for(int p=0; p<places.length && p<placeMarkers.length; p++){
						//will be null if a value was missing
						
						if(places[p]!=null)
							Log.i("PlacingMarkers","Adding Markers");
							placeMarkers[p]=theMap.addMarker(places[p]);
					}
				}
				
			}
		}
		
		@Override
		protected void onResume() {
			super.onResume();
			if(theMap!=null){
				locMan.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 30000, 100, this);
			}
		}
		
		@Override
		protected void onPause() {
			super.onPause();
			if(theMap!=null){
				locMan.removeUpdates(this);
			}
		}
}
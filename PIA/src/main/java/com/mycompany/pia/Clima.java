package com.mycompany.pia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class Clima {
	private JSONObject obj;
	public float tempMinima;
	public float tempMaxima;
	public void obtenerClima(){
		HttpURLConnection con = null;
		StringBuilder responseContent = new StringBuilder();
		BufferedReader reader;
		String line;
		try {
                	// "?apikey=Yy7ebZAAJt6Us4ZMEWrjrgGH5Nr0xKP1&" // llave buena
		        // "?apikey=ZYE36y5Z3p40ajDHWxgeAle5CsMC9ZZ0&" // llave bloqueada	
                    
                        URL url = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/1day/234445"
				+ "?apikey=ZYE36y5Z3p40ajDHWxgeAle5CsMC9ZZ0&" // llave bloqueada	
				+ "?apikey=Yy7ebZAAJt6Us4ZMEWrjrgGH5Nr0xKP1&"
				+ "language=es-mx&"
				+ "details=false&"
				+ "metric=true");
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			
			int status = con.getResponseCode();
			
			if (status >= 300) {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
				parse(responseContent.toString());
			}
		} catch (MalformedURLException ex) {
			Logger.getLogger(Clima.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Clima.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			con.disconnect();
		}
	}
	
	private void parse(String responseBody) {
		obj = new JSONObject(responseBody);
		this.tempMinima = obj.getJSONArray("DailyForecasts")
			.getJSONObject(0)
			.getJSONObject("Temperature")
			.getJSONObject("Minimum")
			.getFloat("Value");
		
		this.tempMaxima = obj.getJSONArray("DailyForecasts")
			.getJSONObject(0)
			.getJSONObject("Temperature")
			.getJSONObject("Maximum")
			.getFloat("Value");
	}
	
}

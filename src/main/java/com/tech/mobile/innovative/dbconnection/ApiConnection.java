/**
 * 
 */
package com.tech.mobile.innovative.dbconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author shabam
 *
 */
public class ApiConnection {

 	
public void saveMeetingApiConnection() {
	
	try {

		URL url = new URL("http://localhost:7070/api/v1/save");//your url i.e fetch data from .
	 	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		//String input = "{\"qty\":100,\"name\":\"iPad 4\"}";

		String input = 
				"{\"meetingDate\": \"2021-10-17\" , "
				+ "\"meetingDay\": \"Monday\" , "
				+ "\"meetingType\": \"Weekend meeting\","
				+ "\"attendance\": 999, "
				+ "\"soundOperatorFirstName\": \"Gani\", "
				+ "\"soundOperatorLastName\": \"Shaba\", "
				+ "\"attendantFirstName\": \"Michael\","
				+ "\"attendantLastName\": \"Banda\", "
				+ "\"announcement\": \"Test's group is cleaning the hall today\", "
				+ "\"emailTo\":null }";
		
		
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }
}
}
	

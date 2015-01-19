package com.varun.jersey.client;

import java.util.Timer;
import java.util.TimerTask;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyPostClient {

	public static void main(String[] args) {
		try {

			Timer timer = new Timer("Scheduled Poster");
			TimerTask task = new TimerTask() {

				@Override
				public void run() {
					Client client = Client.create();

					WebResource webResource = client
							.resource("http://localhost:8080/sun-jersey-atm-comet/chat");

					String input = "{\"message\":\"Metallica\",\"author\":\"Server\"}";

					ClientResponse response = webResource.type(
							"application/json").post(ClientResponse.class,
							input);

					if (response.getStatus() != 200) {
						throw new RuntimeException(
								"Failed : HTTP error code : "
										+ response.getStatus());
					}

					System.out.println("Output from Server .... \n");
					String output = response.getEntity(String.class);
					System.out.println(output);

				}
			};
			timer.scheduleAtFixedRate(task, 0, 5000);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
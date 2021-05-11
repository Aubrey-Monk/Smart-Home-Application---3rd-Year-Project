package smartHomeAppPC_Client;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.*;

public class mqttClient {

	private String clientId = UUID.randomUUID().toString();
	private String brokerUrl = "ws://test.mosquitto.org:8080";
    private static MqttClient mqttClient;

    public mqttClient() 
    {
    	try 
    	{
    		mqttClient = new MqttClient(brokerUrl, clientId);
    		mqttClient.setCallback(new subscriberCallback(mqttClient));
	        mqttClient.connect();
        } 
    	catch (MqttException e) 
    	{
            e.printStackTrace();
        } 
    }
    
    public void subscribe(String[] topics) 
    {
        try 
        {
	        for (int i = 0; i < topics.length; i++) {
	        	  mqttClient.subscribe(topics[i]);
	        	  System.out.println("Subscribed to topic: " + topics[i]);
	        }
	        
        } 
        catch (MqttException e) 
        {
            e.printStackTrace();
        }
    }
    
//    public void publish(String topic, String message) 
//    {
//        try 
//        {
//	        MqttMessage payload = new MqttMessage(message.getBytes());
//	        mqttClient.publish(topic, payload);
//        } 
//        catch (MqttException e) 
//        {
//            e.printStackTrace();
//        }
//    }  
}

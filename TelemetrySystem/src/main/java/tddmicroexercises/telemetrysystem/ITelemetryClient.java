package tddmicroexercises.telemetrysystem;

public interface ITelemetryClient {
	
	public static final String DIAGNOSTIC_MESSAGE = "AT#UD";
	void connect(String diagnosticChannelConnection);
	void disconnect();
	boolean getOnlineStatus();
	void send(String diagnosticMessage);
	String receive();
	
}

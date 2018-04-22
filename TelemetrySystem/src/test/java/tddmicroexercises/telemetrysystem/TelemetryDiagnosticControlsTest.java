package tddmicroexercises.telemetrysystem;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TelemetryDiagnosticControlsTest {

	@Test
	public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
			throws Exception {
		String diagnosticInfoExpected = "Diagnostic response";

		ITelemetryClient telemetryClient = mock(ITelemetryClient.class);
		when(telemetryClient.getOnlineStatus()).thenReturn(true);
		when(telemetryClient.receive()).thenReturn(diagnosticInfoExpected);

		TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
		telemetryDiagnosticControls.checkTransmission();
		assertEquals(diagnosticInfoExpected, telemetryDiagnosticControls.getDiagnosticInfo());

	}

}

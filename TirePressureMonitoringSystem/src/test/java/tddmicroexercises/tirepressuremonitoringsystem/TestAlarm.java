package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TestAlarm {

	@Test
	public void checkIfAlarmIsOnByDefault() {
		ISensor sensor = mock(ISensor.class);
		Alarm alarm = new Alarm(sensor);
		assertEquals(false, alarm.isAlarmOn());
	}

	@Test
	public void checkIfAlarmIsOnWithHighPsiPressureValue() {
		ISensor sensor = mock(ISensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(new Double(22));
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
	}

	@Test
	public void checkIfAlarmIsOnWithLowPsiPressureValue() {
		ISensor sensor = mock(ISensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(new Double(16));
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
	}

	@Test
	public void checkIfAlarmIsOnWithAllowPsiPressureValue() {
		ISensor sensor = mock(ISensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(new Double(18));
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertEquals(false, alarm.isAlarmOn());
	}
}

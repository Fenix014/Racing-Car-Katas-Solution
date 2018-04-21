package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TestAlarm {

	@Test
	public void checkIfAlarmIsOnByDefault() {
		Alarm alarm = new Alarm();
		assertEquals(false, alarm.isAlarmOn());
	}
	
	@Test
	public void checkIfAlarmIsOnWithHighPsiPressureValue() {
		ISensor sensor = mock(ISensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(new Double(22));
		Alarm alarm = new Alarm();
		alarm.setSensor(sensor);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
	}
	
	@Test
	public void checkIfAlarmIsOnWithLowPsiPressureValue() {
		ISensor sensor = mock(ISensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(new Double(16));
		Alarm alarm = new Alarm();
		alarm.setSensor(sensor);
		alarm.check();
		assertEquals(true, alarm.isAlarmOn());
	}
	
	@Test
	public void checkIfAlarmIsOnWithAllowPsiPressureValue() {
		ISensor sensor = mock(ISensor.class);
		when(sensor.popNextPressurePsiValue()).thenReturn(new Double(18));
		Alarm alarm = new Alarm();
		alarm.setSensor(sensor);
		alarm.check();
		assertEquals(false, alarm.isAlarmOn());
	}
}

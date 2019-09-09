package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void alarmShouldBeOnIfOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(14.0);

        Field fieldSensor = Alarm.class.getDeclaredField("sensor");
        fieldSensor.setAccessible(true);
        fieldSensor.set(alarm, sensor);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOffIfInRange() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17.0);

        Field fieldSensor = Alarm.class.getDeclaredField("sensor");
        fieldSensor.setAccessible(true);
        fieldSensor.set(alarm, sensor);

        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
}
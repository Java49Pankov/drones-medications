package telran.drones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import telran.drones.api.PropertiesNames;

@SpringBootTest(properties = { PropertiesNames.PERIODIC_UNIT_MICROS + "=5000" })
class DronesServicePeriodicTaskTest {

	@Test
	void test() throws InterruptedException {
		Thread.sleep(10000);
	}

}

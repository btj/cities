package cities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class CityTest {

	@Test
	void test() {
		City leuven = new City();
		City mechelen = new City();
		City antwerpen = new City();
		assertTrue(leuven.getConnectedCities().isEmpty());
		
		leuven.registerRoadTo(mechelen);
		antwerpen.registerRoadTo(mechelen);
		
		assertEquals(Set.of(leuven, antwerpen), mechelen.getConnectedCities());
		assertEquals(Set.of(mechelen), leuven.getConnectedCities());
		assertEquals(Set.of(mechelen), antwerpen.getConnectedCities());
		
		antwerpen.registerRoadRemoved(mechelen);

		assertEquals(Set.of(leuven), mechelen.getConnectedCities());
		assertEquals(Set.of(mechelen), leuven.getConnectedCities());
		assertEquals(Set.of(), antwerpen.getConnectedCities());
	}

}

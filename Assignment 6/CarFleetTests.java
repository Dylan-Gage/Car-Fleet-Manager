import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class CarFleetTests {

    @Test
    public void testConstructor() {
        CarFleet fleet = new CarFleet();
        Queue<Integer> requests = new Queue<>();
   
        List<Car> result = fleet.processRequests(requests);
        

    
        assertEquals(0, result.size());
}


    @Test
    public void testAddCar() {
        CarFleet fleet = new CarFleet();
        Car c1 = new Car(1,1,25.0f); 
        assertTrue(fleet.addCar(c1));

        Car c2 = new Car(2, 4, 30.0f);  
        assertFalse(fleet.addCar(c2));
    }

    @Test
    public void testProcessRequests() {
        CarFleet fleet = new CarFleet();
        fleet.addCar(new Car(1, 1, 25.0f)); 
        fleet.addCar(new Car(2, 2, 35.0f));  
        fleet.addCar(new Car(3, 3, 45.0f));  

        Queue<Integer> requests = new Queue<>();
        requests.enqueue(1);
        requests.enqueue(2);
        requests.enqueue(3);
        requests.enqueue(2);  

        List<Car> result = fleet.processRequests(requests);

        assertEquals(4, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(2, result.get(1).getId());
        assertEquals(3, result.get(2).getId());
        assertEquals(0, result.get(3).getId());  
    }

   
    
}

import java.util.ArrayList;
import java.util.List;

public class CarFleet {
    private final Queue<Car> gasCars = new Queue<>();
    private final Queue<Car> hybridCars = new Queue<>();
    private final Queue<Car> electricCars = new Queue<>();

    public boolean addCar(Car car) {
        switch (car.getPowerSource()) {
            case 1:
                gasCars.enqueue(car);
                return true;
            
            case 2:
                hybridCars.enqueue(car);
                return true;
            
            case 3:
                electricCars.enqueue(car);
                return true;
            
            default:
                return false;
            
        }
    }

    public List<Car> processRequests(Queue<Integer> requests) {
    List<Car> result = new ArrayList<>();

    while (!requests.isEmpty()) {
        int request = requests.dequeue();
        Queue<Car> queue;

        switch (request) {
            case 1:
                queue = gasCars;
                break;
            case 2:
                queue = hybridCars;
                break;
            case 3:
                queue = electricCars;
                break;
            default:
                queue = null;
                break;
        }

        if (queue != null && !queue.isEmpty()) {
            result.add(queue.dequeue());
        } else {
            result.add(new Car(0, request, 0.0f));
        }
    }

    return result;
}

}
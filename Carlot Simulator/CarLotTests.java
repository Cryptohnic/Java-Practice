
import org.junit.Test;
import org.junit.Assert;

public class CarLotTests {

    @Test
    public void testConstructor() {
        Assert.assertEquals("Gasoline cars: []\n\nHybrid cars: []\n\nElectric cars: []\n", new CarLot().toString());
    }

    @Test
    public void testAddCar() {
        CarLot cl = new CarLot();
        cl.addCar(new Car(1, 1, 100));
        Assert.assertEquals("Gasoline cars:\n[\nID: 1\nCar type: Gasoline\nPrice per day: $100.00\n]\n\nHybrid cars:\n[]\n\nElectric cars:\n[]\n", cl.toString());
    }

    @Test
    public void testSetId() {
        Car c = new Car(1, 1, 100);
        c.setId(2);
        Assert.assertEquals(2, c.getId());
    }

    @Test
    public void testProcessRequests() {
        CarLot lot = new CarLot();
        lot.addCar(new Car(1, 1, 100));
        lot.addCar(new Car(2, 2, 200));
        lot.addCar(new Car(3, 3, 300));
        lot.addCar(new Car(4, 1, 400));
        lot.addCar(new Car(5, 2, 500));
        lot.addCar(new Car(6, 3, 600));
        CarRequests requests = new CarRequests();
        requests.addRequest(1);
        requests.addRequest(2);
        requests.addRequest(3);
        requests.addRequest(1);
        Assert.assertEquals("[ID: 1\nCar type: Gasoline\nPrice per day: $100.00, ID: 2\nCar type: Hybrid\nPrice per day: $200.00, ID: 3\nCar type: Electric\nPrice per day: $300.00, ID: 4\nCar type: Gasoline\nPrice per day: $400.00]", lot.processRequests(requests).toString());
    }
}

import org.junit.Test;
import org.junit.Assert;

public class CarTests {
    @Test
    public void testConstructor() {
        Assert.assertEquals("ID: 1\nCar type: Gasoline\nPrice per day: $100.00",new Car(1,1,100).toString());
    }

    @Test
    public void testGetId() {
        Car c=new Car(1,1,100);
        Assert.assertEquals(1,c.getId());
    }

    @Test
    public void testSetId() {
        Car c=new Car(1,1,100);
        c.setId(2);
        Assert.assertEquals(2,c.getId());
    }

    @Test
    public void testGetPowerSource() {
        Car c=new Car(1,1,100);
        Assert.assertEquals(1,c.getPowerSource());
    }

    @Test
    public void testSetPowerSource() {
        Car c=new Car(1,1,100);
        c.setPowerSource(2);
        Assert.assertEquals(2,c.getPowerSource());
    }

    @Test
    public void testGetPricePerDay() {
        Car c=new Car(1,1,100);
        Assert.assertEquals(100f,c.getPricePerDay(),0.01);
    }

    @Test
    public void testSetPricePerDay() {
        Car c=new Car(1,1,100);
        c.setPricePerDay(125f);
        Assert.assertEquals(125f,c.getPricePerDay(),0.01);
    }
}
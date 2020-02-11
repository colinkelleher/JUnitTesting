import static org.junit.Assert.*;
import org.junit.Test;


public class Tester {
    //__________________________________________________
    // MOVE() TESTS X 2
    //__________________________________________________
    /*
        Car begins stopped, therefore is not moving
        Car speed is incremented and allowed to move
        The car is then moving, following the signal to move
     */
    @Test
    public void testIfCarIsMovingWhenGivenSpeedAndMoveSignal() {
        final Car car = new Car();
        car.stop();
        assertFalse("Car begins stopped",car.isMoving());
        car.move();
        car.incrementSpeedInHorizontalDirection();
        assertTrue("The car is now moving", car.isMoving());
    }
    /*
        This test shows that car speed needs to be incremented/decremented from zero for the car to move
        and that a simple move() does not move the car
     */
    @Test
    public void test_CarFromStopToMoveWhenSpeedIsIncrementedAndStopStart(){
        final Car car = new Car();
        car.stop();
        assertFalse("Car begins stopped",car.isMoving());
        car.move();
        assertFalse("The car is not moving because there is no speed",car.isMoving());
        car.stop();
        car.incrementSpeedInHorizontalDirection();
        car.move();
        assertTrue("The car is now moving as speed has been incremented",car.isMoving());

    }

    //__________________________________________________
    // isMoving() TESTS x 2
    //__________________________________________________
    /*
        Simple move and stop test

        Car begins stopped - therefore isn't moving (isMoving = false)
        Car is given speed and signal to move
        The car is then therefore moving
     */
    @Test
    public void test_carFromMovingToStop(){
        final Car car = new Car();
        car.stop();
        assertFalse("The car is not moving because it is stopped",car.isMoving());
        car.move();
        car.incrementSpeedInHorizontalDirection();
        assertTrue("The car is now moving as it has been given the speed and signal to move",car.isMoving());
    }
    /*
        Testing with incrementing and decrementing vertically, along with move and stop

        Speed is incremented and car is given signal to move, therefore the car is moving
        The car is then stopped -> Therefore car is not moving
        Speed is decremented and car is given the signal to move, therefore the car is moving
        Car is stopped

        Car is given the signal to move....but IS NOT moving, as speed has not been incremented
     */
    @Test
    public void test_carMoveToStopToMove() {
        final Car car = new Car();
        car.incrementSpeedInVerticalDirection();
        car.move();
        assertTrue("The car is moving as speed has been incremented" +
                "and the move signal has been given",car.isMoving());
        car.stop();
        assertFalse("The car has been stopped, and is therefore not moving",car.isMoving());
        car.decrementSpeedInVerticalDirection();
        car.move();
        assertTrue("The car is moving",car.isMoving());
        car.stop();
        car.move();
        assertFalse("Car is not moving, as speed needs to be incremented or " +
                "decremented from neutral(0)",car.isMoving());
    }

    //__________________________________________________
    // stop() TESTS x 2
    //__________________________________________________
    /*
        This test ensures the car begins stopped
        The car speed is then incremented and given the signal to move
        (Check to ensure car is moving)
        The car is then stopped, to check the stop function is working and that the
        car is not still moving
     */
    @Test
    public void test_stopMoveStop() {
        final Car car = new Car();
        car.stop();
        assertFalse("The car begins stopped (not moving)",car.isMoving());
        assertTrue("The car hasn't moved, so is therefore" +
                "at its original position",car.isAtOriginalPosition());
        car.move();
        car.incrementSpeedInHorizontalDirection();
        assertTrue("The car is moving as signal and speed is given",car.isMoving());
        car.stop();
        assertFalse("Car was stopped therefore the car is not moving",car.isMoving());
    }

    /*
        Car moves (speed decremented horizontally)
        car is stopped
        Car moves (speed incremented horizontally)
        car is stopped

        Checking to ensure car stops correctly after moving
     */
    @Test
    public void test_moveStopmoveStop(){
        final Car car = new Car();
        car.decrementSpeedInHorizontalDirection();
        car.move();
        assertTrue("The car is now moving as speed has been decremented",car.isMoving());
        car.stop();
        assertFalse("The car is now stopped",car.isMoving());
        car.incrementSpeedInHorizontalDirection();
        car.move();
        assertTrue("The car is now moving as speed has been incremented",car.isMoving());
        car.stop();
        assertFalse("The car is now stopped",car.isMoving());


    }
    //__________________________________________________
    // isAtOriginalPosition() TESTS X 2
    //__________________________________________________
    /*
        The car begins stopped, and it hasn't moved, therefore is at its original position
        Car is moved (incremented) one unit in vertical direction - i.e. not in original position
        Car is moved (decremented) one unit in vertical direction - i.e. back to original position

     */
    @Test
    public void test_incrementPosStopDecerementPosToOriginal() {
        final Car car = new Car();
        car.stop();
        assertFalse("The car begins stopped",car.isMoving());
        assertTrue("The car begins stopped and is at its original position",car.isAtOriginalPosition());
        car.incrementSpeedInVerticalDirection();
        car.move();
        assertFalse("Car speed has been incremented in a vertical direction" +
                "by one unit and is therefore not at original position",car.isAtOriginalPosition());
        car.stop();
        car.decrementSpeedInVerticalDirection();
        car.move();
        assertTrue("Car speed has been decremented in vertical direction" +
                "by one unit and is therefore back to original position",car.isAtOriginalPosition());
    }
    /*
        The car speed is decremented horizontally by three units
        then stopped
        incremented by three units horiztonally so it is back at its original position
     */
    @Test
    public void test_decrementByThreeIncrementByThreeToOriginal() {
        final Car car = new Car();
        car.stop();
        assertTrue(car.isAtOriginalPosition());
        assertFalse("Car is not moving - stopped",car.isMoving());
        car.decrementSpeedInHorizontalDirection();
        car.move();
        car.decrementSpeedInHorizontalDirection();
        car.move();
        car.decrementSpeedInHorizontalDirection();
        car.move();
        assertTrue("Car is moving as speed has been decremented horiztonally",car.isMoving());
        car.stop();
        car.incrementSpeedInHorizontalDirection();
        car.move();
        car.incrementSpeedInHorizontalDirection();
        car.move();
        car.incrementSpeedInHorizontalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at its original position",car.isAtOriginalPosition());

    }

    //__________________________________________________
    // incrementSpeedInHorizontalDirection() TESTS X 2
    //__________________________________________________
    /*
    Test to test decrementSpeedInHorizontalDirection

    Speed incremented horizontally by two from original position (+2)
    Speed decremented by two until original position is reached (-2)

    incrementSpeedInHorizontalDirection therefore works, as it takes the same amount of decrements
    as increments to bring the car back to its original position
     */
    @Test
    public void test_incrementSpeedHorizontally(){
        final Car car = new Car();
        car.stop();
        car.incrementSpeedInHorizontalDirection();
        car.move();
        assertTrue("The car is moving as speed is incremented horizontally",car.isMoving());
        assertFalse("The car is now not at its original position",car.isAtOriginalPosition());
        car.incrementSpeedInHorizontalDirection();
        car.move();
        assertFalse("The car is incremented by a second unit - therefore" +
                "is now two units from original position",car.isAtOriginalPosition());
        car.stop();
        car.decrementSpeedInHorizontalDirection();
        car.move();
        assertFalse("Speed is decremented by one unit so is therefore " +
                "one unit from original position",car.isAtOriginalPosition());
        car.decrementSpeedInHorizontalDirection();
        car.move();
        car.stop();
        assertTrue("The car is now back at its original position as it has been" +
                "decremented by a second unit",car.isAtOriginalPosition());
    }
    /*
    Decrement speed horizontally by one unit (one unit from original position)
    -1
    Increment speed horizontally by one unit (back at original position)
    +1
    Now at 0
    Increment speed horizontally by one unit (plus one unit from original position)
    +1
    Decrement speed horizontally by one unit (back at original position
    -1
    Now at 0
    */
    @Test
    public void test_incrementSpeedHorizontally2(){
        final Car car = new Car();
        car.stop();
        car.decrementSpeedInHorizontalDirection();
        car.move();
        assertFalse("Car has been moved, speed decremented in horizontal direction," +
                "therefore not at original position",car.isAtOriginalPosition());
        car.stop();
        car.incrementSpeedInHorizontalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at original position as speed has been decremented",car.isAtOriginalPosition());
        car.incrementSpeedInHorizontalDirection();
        car.move();
        car.stop();
        assertFalse("Car is not at original position as speed has been incremented",car.isAtOriginalPosition());
        car.decrementSpeedInHorizontalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at original position as speed has been decremented",car.isAtOriginalPosition());
    }

    //__________________________________________________
    // decrementSpeedInHorizontalDirection() TESTS X 2
    //__________________________________________________

    /*
        Increment speed horizontally by one unit (one unit from original position)
        +1
        Decrement speed horizontally by one unit (back at original position)
        -1
        Now at 0
        Decrement speed horizontally by one unit (minus one unit from original position)
        -1
        Increment speed horizontally by one unit (back at original position
        +1
        Now at 0
     */

    @Test
    public void test_decrementSpeedHorizontally(){
        final Car car = new Car();
        car.stop();
        car.incrementSpeedInHorizontalDirection();
        car.move();
        assertFalse("Car has been moved, speed incremented in horizontal direction," +
                "therefore not at original position",car.isAtOriginalPosition());
        car.stop();
        car.decrementSpeedInHorizontalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at original position as speed has been decremented",car.isAtOriginalPosition());
        car.decrementSpeedInHorizontalDirection();
        car.move();
        car.stop();
        assertFalse("Car is not at original position as speed has been decremented",car.isAtOriginalPosition());
        car.incrementSpeedInHorizontalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at original position as speed has been incremented",car.isAtOriginalPosition());
    }

/*
    Second test to test decrementSpeedInHorizontalDirection
    Speed decremented by two from original position (-2)
    Speed incremented by two until original position is reached (+2)

    decrementSpeedInHorizontalDirection therefore works, as it takes the same amount of increments
    as decrements to bring the car back to its original position
 */
    @Test
    public void test_decrementSpeedHorizontally2() {
        final Car car = new Car();
        car.stop();
        assertFalse("Car is stopped", car.isMoving());
        car.decrementSpeedInHorizontalDirection();
        car.move();
        assertTrue("Car is moving horizontally (decrementing)", car.isMoving());
        car.stop();
        car.decrementSpeedInHorizontalDirection();
        car.move();
        assertTrue("Car is moving horizontally (decrementing)", car.isMoving());
        car.stop();
        assertFalse("Car is now two units from the original position",car.isAtOriginalPosition());
        car.incrementSpeedInHorizontalDirection();
        car.move();
        assertFalse("Car has incremented in horizontal direction by one unit - " +
                "is not back at its original position yet",car.isAtOriginalPosition());
        car.stop();
        car.incrementSpeedInHorizontalDirection();
        car.move();
        assertTrue("Car has incremented in horizontal direction by two units",car.isMoving());
        car.stop();
        assertTrue("Car is now back at original position",car.isAtOriginalPosition());
    }


    //__________________________________________________
    // incrementSpeedInVerticalDirection() TESTS X 2
    //__________________________________________________

    /*
    Decrement speed vertically by one unit (one unit from original position)
    -1
    Increment speed vertically by one unit (back at original position)
    +1
    Now at 0
    Increment speed vertically by one unit (plus one unit from original position)
    +1
    Decrement speed vertically by one unit (back at original position
    -1
    Now at 0
    */
    @Test
    public void test_incrementSpeedVertically(){
        final Car car = new Car();
        car.stop();
        car.decrementSpeedInVerticalDirection();
        car.move();
        assertFalse("Car has been moved, speed decremented in vertical direction," +
                "therefore not at original position",car.isAtOriginalPosition());
        car.stop();
        car.incrementSpeedInVerticalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at original position as speed has been decremented",car.isAtOriginalPosition());
        car.incrementSpeedInVerticalDirection();
        car.move();
        car.stop();
        assertFalse("Car is not at original position as speed has been incremented",car.isAtOriginalPosition());
        car.decrementSpeedInVerticalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at original position as speed has been decremented",car.isAtOriginalPosition());
    }

    /*
    Speed incremented vertically by two from original position (+2)
    Speed decremented by two until original position is reached (-2)

    incrementSpeedInVerticalDirection therefore works, as it takes the same amount of decrements
    as increments to bring the car back to its original position
     */
    @Test
    public void test_incrementSpeedVertically2(){
        final Car car = new Car();
        car.stop();
        car.incrementSpeedInVerticalDirection();
        car.move();
        assertTrue("The car is moving as speed is incremented vertically",car.isMoving());
        assertFalse("The car is now not at its original position",car.isAtOriginalPosition());
        car.incrementSpeedInVerticalDirection();
        car.move();
        assertFalse("The car is incremented by a second unit - therefore" +
                "is now two units from original position",car.isAtOriginalPosition());
        car.stop();
        car.decrementSpeedInVerticalDirection();
        car.move();
        assertFalse("Speed is decremented by one unit so is therefore " +
                "one unit from original position",car.isAtOriginalPosition());
        car.decrementSpeedInVerticalDirection();
        car.move();
        car.stop();
        assertTrue("The car is now back at its original position as it has been" +
                "decremented by a second unit",car.isAtOriginalPosition());
    }


    //__________________________________________________
    // decrementSpeedInVerticalDirection() TESTS X 2
    //__________________________________________________

    /*
    Speed decremented vertically by two from original position (-2)
    Speed incremented vertically by two until original position is reached (+2)

    decrementSpeedInVerticalDirection therefore works, as it takes the same amount of increments
    as decrements to bring the car back to its original position
     */
    @Test
    public void test_decrementSpeedVertically(){
        final Car car = new Car();
        car.stop();
        assertFalse("Car is stopped", car.isMoving());
        car.decrementSpeedInVerticalDirection();
        car.move();
        assertTrue("Car is decrementing vertically", car.isMoving());
        car.stop();
        car.decrementSpeedInVerticalDirection();
        car.move();
        assertTrue("Car is decrementing vertically", car.isMoving());
        car.stop();
        assertFalse("Car is now two units from the original position",car.isAtOriginalPosition());
        car.incrementSpeedInVerticalDirection();
        car.move();
        assertFalse("Car has incremented in vertical direction by one unit - " +
                "is not back at its original position yet",car.isAtOriginalPosition());
        car.stop();
        car.incrementSpeedInVerticalDirection();
        car.move();
        assertTrue("Car has incremented in vertical direction by two units",car.isMoving());
        car.stop();
        assertTrue("Car is now back at original position",car.isAtOriginalPosition());
    }

    /*
    Increment speed vertically by one unit (one unit from original position)
    +1
    Decrement speed vertically by one unit (back at original position)
    -1
    Now at 0
    Decrement speed vertically by one unit (minus one unit from original position)
    -1
    Increment speed vertically by one unit (back at original position
    +1
    Now at 0
 */
    @Test
    public void test_decrementSpeedVertically2(){
        final Car car = new Car();
        car.stop();
        car.incrementSpeedInVerticalDirection();
        car.move();
        assertFalse("Car has been moved, speed incremented in vertical direction," +
                "therefore not at original position (+1)",car.isAtOriginalPosition());
        car.stop();
        car.decrementSpeedInVerticalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at original position as speed has been decremented" +
                "(back to zero)",car.isAtOriginalPosition());
        car.decrementSpeedInVerticalDirection();
        car.move();
        car.stop();
        assertFalse("Car is not at original position as speed has been decremented (-1)",car.isAtOriginalPosition());
        car.incrementSpeedInVerticalDirection();
        car.move();
        car.stop();
        assertTrue("Car is back at original position as speed has been incremented " +
                "(back to zero)",car.isAtOriginalPosition());
    }

}



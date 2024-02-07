import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayMethodsTest {
    /* The class ArrayMethodsTest includes instructor-provided tests
     * to evaluate the array methods that you will write in the class
     * ArrayMethods. You should also write some of your own tests.
    */

    /* Arrays used to test ArrayMethods*/
    float[] arr1 = {1.0f, 2.0f, 3.0f, 4.0f};
    float[] arr2 = {-7.5f, 3.2f};
    float[] arr3 = {};
    float[] arr4 = {1.0f, 3.0f, 2.0f};
    float[] arr5 = {0.0f, 5.0f, -4.0f, Float.NaN, 1.5f};
    float[] arr6 = {2.25f, 6.02f, -1.23f, 7.789f};

    @Test public void testWholeSum() {
        /* Tests for the wholeSum method*/

        // Format of assertEquals: expected value, actual value, delta
        // delta is your tolerance for minor differences in computation
        // For example, is 32.000001 the same as 32.0000009?
        // Here we tell it yes, for temperatures, those two are the same
        assertEquals(10.0f, ArrayMethods.wholeSum(arr1), 0.000001);
        assertEquals(-4.3f, ArrayMethods.wholeSum(arr2), 0.000001);
        assertEquals(0.0f, ArrayMethods.wholeSum(arr3), 0.000001);
        // Write TWO additional tests
        assertEquals(Float.NaN, ArrayMethods.wholeSum(arr5), 0.000001);
        assertEquals(14.829f, ArrayMethods.wholeSum(arr6), 0.000001);
    }
    
    @Test public void testSum(){
        assertEquals(5.0f, ArrayMethods.sum(arr1, 1, 3), 0.000001);
        assertEquals(10.0f, ArrayMethods.sum(arr1, 0, 4), 0.000001);
        assertEquals(0.0f, ArrayMethods.sum(arr1, 2, 2), 0.000001);
        // Write THREE additional tests
        assertEquals(0.0f, ArrayMethods.sum(arr3, 0, 0), 0.000001);
        assertEquals(4.0f, ArrayMethods.sum(arr4, 0, 2), 0.000001);
        assertEquals(Float.NaN, ArrayMethods.sum(arr5, 0, 4), 0.000001);
    }

    @Test public void testMean(){
        assertEquals(3.5f, ArrayMethods.mean(arr1, 2, 4), 0.000001);
        assertEquals(2.5f, ArrayMethods.mean(arr1), 0.000001);
        assertEquals(0.0f, ArrayMethods.mean(arr3), 0.000001);
        // Additional tests
        assertEquals(3.70725f, ArrayMethods.mean(arr6), 0.000001); // Test mean of all elements
        assertEquals(2.395f, ArrayMethods.mean(arr6, 1, 3), 0.000001); // Test mean of a subset of elements
        assertEquals(Float.NaN, ArrayMethods.mean(arr5), 0.000001); // Test mean of an array with NaN
    }


    @Test public void testMin(){
        assertEquals(2.0f, ArrayMethods.min(arr1, 1, 4), 0.000001);
        assertEquals(1.0f, ArrayMethods.min(arr1), 0.000001);
        assertEquals(Float.NaN, ArrayMethods.min(arr3), 0.000001);
        // Additional tests
        assertEquals(-4.0f, ArrayMethods.min(arr5), 0.000001); // Test min of an array with NaN
        assertEquals(-1.23f, ArrayMethods.min(arr6), 0.000001); // Test min of an array with negative values
    }


    @Test public void testMax(){
        assertEquals(4.0f, ArrayMethods.max(arr1, 1, 4), 0.000001);
        assertEquals(3.0f, ArrayMethods.max(arr4), 0.000001);
        assertEquals(Float.NaN, ArrayMethods.max(arr4, 0, 0), 0.000001);
        // Additional tests
        assertEquals(7.789f, ArrayMethods.max(arr6), 0.000001); // Test max of an array with positive values
        assertEquals(5.0f, ArrayMethods.max(arr5), 0.000001); // Test max of an array with NaN
    }

}
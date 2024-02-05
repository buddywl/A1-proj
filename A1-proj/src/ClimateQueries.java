import java.util.Arrays;
import java.io.*;

public class ClimateQueries{

    // Below are stubs for each of the methods for the 
    // climate analysis. You should include both ranged
    // and unranged methods for each, but only the unranged
    // are listed below
    public static void main(String[] args){
        ReadFile file = new ReadFile();
        File filepath = new File((args.length > 0) ? args[0] : "A1-proj/data/YUMA_2023.txt");
        String filename = filepath.getAbsolutePath();


        String[] dates = file.getStringData(1, filename);
        float[] temps = file.getFloatData(7, filename);
        float[] minTemps = file.getFloatData(6, filename);
        float[] maxTemps = file.getFloatData(5, filename);

        System.out.println("Source File: " + file.getFilename(filename));
//        System.out.println(filename);

        System.out.print("Annual Mean Temperature: ");
        System.out.print(mean(temps, logicalNot(isEqualTo(temps, -9999.0f))));
        System.out.println(" degrees Celsius");

        System.out.print("Minimum Average Daily Temperature: ");
        System.out.print(mean(minTemps, logicalNot(isEqualTo(minTemps, -9999.0f))));
        System.out.println(" degrees Celsius");

        System.out.print("Maximum Average Daily Temperature: ");
        System.out.print(mean(maxTemps, logicalNot(isEqualTo(maxTemps, -9999.0f))));
        System.out.println(" degrees Celsius");

        System.out.print("Mean Temperature in January: ");
        System.out.print(mean(temps, logicalAnd(datesBetween(dates, "20230101", "20230201"), logicalNot(isEqualTo(temps, -9999.0f)))));
        System.out.println(" degrees Celsius");

        System.out.print("Mean Temperature in July: ");
        System.out.print(mean(temps, logicalAnd(datesBetween(dates, "20230701", "20230801"), logicalNot(isEqualTo(temps, -9999.0f)))));
        System.out.println(" degrees Celsius");

    }

    /**
     * Returns an array of booleans dependent on if the index of the initial array is equal to a given value on a range in the array
     * @param   arr the array of floats to be accessed
     * @param   lo  the lower bound of the array (inclusive)
     * @param   hi  the upper bound of the array (exclusive)
     * @param   val the target value
     * @return  the final list of booleans
     */
    public static boolean[] isEqualTo(float[] arr, float val, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];
        for (int i = lo; i < hi; i++){
            indicator[i] = (arr[i] == val);
        }
        return indicator;
    }
    /**
     * Returns an array of booleans dependent on if the index of the initial array is equal to a given value
     * @param   arr the array of floats to be accessed
     * @param   val the target value
     * @return  the array of booleans
     */
    public static boolean[] isEqualTo(float[] arr, float val){
        // add your code here 
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++){
            indicator[i] = (arr[i] == val);
        }
        return indicator;
    }

    /**
     * Returns an array of booleans that inverts the value of an initial array of booleans on a given range
     * @param   arr the array of booleans to be accessed
     * @param   lo  the lower bound of the array (inclusive)
     * @param   hi  the upper bound of the array (exclusive)
     * @return  the inverted array of booleans
     */
    public static boolean[] logicalNot(boolean[] arr, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        int range = hi - lo;
        boolean[] indicator = new boolean[range];
        for(int i = lo; i < hi; i++){
            if(!arr[i]){
                indicator[i] = true;
            }
        }
        return indicator;
    }
    /**
     * Returns an array of booleans that inverts the value of an initial array of booleans
     *      That is, [true, false, false] --> [false, true, true].
     * @param   arr the array of booleans to be accessed
     * @return  the inverted array of booleans
     */
    public static boolean[] logicalNot(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(!arr[i]){
                indicator[i] = true;
            }
        }
        return indicator;
    }

    /**
     * Returns an array of booleans that compares the values of two initial arrays of booleans
     *      That is, the value of the indicator array is only true if both initial values at the same index is true.
     * @param   arr1 the array of booleans to be accessed
     * @param   arr2 the second array of booleans to be accessed
     * @param   lo  the lower bound of the array (inclusive)
     * @param   hi  the upper bound of the array (exclusive)
     * @return  the comparison array of booleans
     */
    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        int range = hi - lo;
        boolean[] indicator = new boolean[range];
        for(int i = lo; i < hi; i++){
            indicator[i] = arr1[i] && arr2[i];
        }
        return indicator;
    }
    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            indicator[i] = arr1[i] && arr2[i];
        }
        return indicator;
    }


    public static boolean[] isGreaterThan(float[] arr, float val, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        int range = hi - lo;
        boolean[] indicator = new boolean[range];
        for(int i = lo; i < hi; i++){
            indicator[i] = (arr[i] > val);
        }
        return indicator;
    }
    public static boolean[] isGreaterThan(float[] arr, float val){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            indicator[i] = (arr[i] > val);
        }
        return indicator;
    }


    public static boolean[] datesBetween(String[] arr, String date1, String date2){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];
        int date;

        for(int i = 0; i < arr.length; i++){
            date = Integer.parseInt(arr[i]);
            if (date > Integer.parseInt(date1) && date < Integer.parseInt(date2)){
                indicator[i] = true;
            }
        }
        return indicator;
    }


    public static float mean(float[] arr, boolean[] indicator, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        float sum = 0;
        int range = hi-lo;

        for(int i = lo; i < hi; i++){
            if (indicator[i]){
                sum += arr[i];
            }
            else {
                sum += 0;
                range = range-1;
            }
        }
        if (lo != hi){
            return sum/(range);
        }
        else{
            return 0f;
        }
    }

    public static float mean(float[] arr, boolean[] indicator){
        float sum = 0;
        int range = arr.length;
        for(int i = 0; i < arr.length; i++){
            if (indicator[i]){
                sum += arr[i];
            }
            else {
                sum += 0;
                range = range-1;
            }
        }
        if (arr.length != 0){
            return sum/(range);
        }
        else{
            return 0f;
        }
    }


    public static int count(boolean[] arr, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        int count = 0;
        for(int i = lo; i < hi; i++){
            if (arr[i]){
                count++;
            }
        }
        return count;
    }
    public static int count(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        int count = 0;
        for(boolean x : arr){
            if (x){
                count++;
            }
        }
        return count;
    }


    public static int findFirst(boolean[] arr, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        int index = -1;
        for(int i = lo; i < hi; i++){
            if(arr[i]){
                index = i;
                break;
            }
        }
        return index;
    }
    public static int findFirst(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]){
                index = i;
                break;
            }
        }
        return index;
    }


    public static int[] find(boolean[] arr, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        int[] indices = new int[count(arr)];
        int index = 0;
        for(int i = lo; i < hi; i++){
            if (arr[i]){
                indices[index] = i;
                index++;
            }
        }
        return indices;
    }
    public static int[] find(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        int[] indices = new int[count(arr)];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i]){
                indices[index] = i;
                index++;
            }
        }
        return indices;
    }
}
import java.io.*;

public class ClimateQueries{

    // Below are stubs for each of the methods for the 
    // climate analysis. You should include both ranged
    // and unranged methods for each, but only the unranged
    // are listed below
    public static void main(String[] args){
        File filepath = new File((args.length > 0) ? args[0] : "A1-proj/data/YUMA_2023.txt");
        String filename = filepath.getAbsolutePath();


        String[] dates = ReadFile.getStringData(1, filename);
        float[] temps = ReadFile.getFloatData(8, filename);
        float[] minTemps = ReadFile.getFloatData(6, filename);
        float[] maxTemps = ReadFile.getFloatData(5, filename);

        System.out.println("Source File: " + ReadFile.getFilename(filename));

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
     * @param   arr: the array of floats to be accessed
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @param   val: the target value
     * @return  indicator: the final list of booleans
     */
    public static boolean[] isEqualTo(float[] arr, float val, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        int range = hi - lo;
        boolean[] indicator = new boolean[range];
        for (int i = lo; i < hi; i++){
            indicator[i] = (arr[i] == val);
        }
        return indicator;
    }
    /**
     * Returns an array of booleans dependent on if the index of the initial array is equal to a given value
     * @param   arr: the array of floats to be accessed
     * @param   val: the target value
     * @return  indicator: the array of booleans
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
     * @param   arr: the array of booleans to be accessed
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @return  indicator: the inverted array of booleans
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
     * @param   arr: the array of booleans to be accessed
     * @return  indicator: the inverted array of booleans
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
     * Returns an array of booleans that compares the values of two initial arrays of booleans on a given range
     *      That is, the value of the indicator array is only true if both values of the initial arrays are true at the same index.
     * @param   arr1: the array of booleans to be accessed
     * @param   arr2: the second array of booleans to be accessed
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @return  indicator: the comparison array of booleans
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
    /**
     * Returns an array of booleans that compares the values of two initial arrays of booleans
     *      That is, the value of the indicator array is only true if both values of the initial arrays are true at the same index.
     * @param   arr1: the array of booleans to be accessed
     * @param   arr2: the second array of booleans to be accessed
     * @return  indicator: the comparison array of booleans
     */
    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            indicator[i] = arr1[i] && arr2[i];
        }
        return indicator;
    }

    /**
     * Returns an array of booleans that represents if a value is greater than the given value (on a range in the array)
     * @param   arr: the array of floats to be accessed
     * @param   val: the target value
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @return  indicator: the array of booleans containing whether a value is greater or not
     */
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
    /**
     * Returns an array of booleans that represents if a value is greater than the given value
     * @param   arr: the array of floats to be accessed
     * @param   val: the target value
     * @return  indicator: the array of booleans containing whether a value is greater or not
     */
    public static boolean[] isGreaterThan(float[] arr, float val){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            indicator[i] = (arr[i] > val);
        }
        return indicator;
    }

    /**
     * Returns an array of booleans that represents if a value is between two given dates (on a range in the array)
     * @param   arr: the array of strings to be accessed
     * @param   date1: the first date in the time range
     * @param   date2: the second date in the time range
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @return  indicator: the array of booleans containing whether a value is within the time frame
     */
    public static boolean[] datesBetween(String[] arr, String date1, String date2, int hi, int lo){
        // add your code here
        // replace code below with your own return statement
        int range = hi-lo;
        boolean[] indicator = new boolean[range];
        int date;

        for(int i = lo; i < hi; i++){
            date = Integer.parseInt(arr[i]);
            if (date > Integer.parseInt(date1) && date < Integer.parseInt(date2)){
                indicator[i] = true;
            }
        }
        return indicator;
    }
    /**
     * Returns an array of booleans that represents if a value is between two given dates
     * @param   arr: the array of strings to be accessed
     * @param   date1: the first date in the time range
     * @param   date2: the second date in the time range
     * @return  indicator: the array of booleans containing whether a value is within the time frame
     */
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

    /**
     * Returns the mean of the values in a given array with the condition that the value of an indicator array is true (on a range in the array)
     * @param   arr: the array of floats to be accessed
     * @param   indicator: the array of booleans to compare to
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @return  the mean of the values in the array
     */
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
    /**
     * Returns the mean of the values in a given array with the condition that the value of an indicator array is true
     * @param   arr: the array of floats to be accessed
     * @param   indicator: the array of booleans to compare to
     * @return  the mean of the values in the array
     */
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


    /**
     * Returns the number of times a true value appears in an array of booleans (on a range in the array)
     * @param   arr: the array of booleans to be accessed
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @return  count: the number of true values in an array of booleans
     */
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
    /**
     * Returns the number of times a true value appears in an array of booleans
     * @param   arr: the array of booleans to be accessed
     * @return  count: the number of true values in an array of booleans
     */
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

    /**
     * Returns the first occurrence of a true value in an array of booleans (on a range in the array)
     * @param   arr: the array of booleans to be accessed
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @return  index: the index of the first occurrence of a true value
     */
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
    /**
     * Returns the first occurrence of a true value in an array of booleans
     * @param   arr: the array of booleans to be accessed
     * @return  index: the index of the first occurrence of a true value
     */
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

    /**
     * Returns an array of the index of each true value in an array of booleans (on a range in the array)
     * @param   arr: the array of booleans to be accessed
     * @param   lo:  the lower bound of the array (inclusive)
     * @param   hi:  the upper bound of the array (exclusive)
     * @return  the array of indexes
     */
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
    /**
     * Returns an array of the index of each true value in an array of booleans (on a range in the array)
     * @param   arr: the array of booleans to be accessed
     * @return  the array of indexes
     */
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
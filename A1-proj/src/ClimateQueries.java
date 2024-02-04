import java.util.Arrays;

public class ClimateQueries{

    // Below are stubs for each of the methods for the 
    // climate analysis. You should include both ranged
    // and unranged methods for each, but only the unranged
    // are listed below
    public static void main(String[] args){
        boolean[] arr1 = {false, true, false, true};
        boolean[] arr2 = {false, true, true, false};

        boolean[] indicator = new boolean[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] && arr2[i]){
                indicator[i] = true;
            }
            else{
                indicator[i] = false;
            }
        }
        System.out.println(Arrays.toString(indicator));


    }

    public static boolean[] isEqualTo(float[] arr, float val){
        // add your code here 
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];
        for (int i = 0; i < indicator.length; i++){
            indicator[i] = arr[i] == val;
        }
        return indicator;
    }

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

    public static boolean[] logicalAnd(boolean[] arr1, boolean[] arr2){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] && arr2[i]){
                indicator[i] = true;
            }
            else{
                indicator[i] = false;
            }
        }
        return indicator;
    }

    public static boolean[] isGreaterThan(float[] arr, float val){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = {false};
        return indicator;
    }

    public static boolean[] datesBetween(String[] arr, String date1, String date2){
        // add your code here
        // replace code below with your own return statement
        boolean[] indicator = {false};
        return indicator;
    }

    public static float mean(float[] arr, boolean[] indicator, int lo, int hi){
        // add your code here
        // replace code below with your own return statement
        return 0f;
    }

    public static float mean(float[] arr, boolean[] indicator){
        // add your code here
        // replace code below with your own return statement
        return 0f;
    }

    public static int count(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        return 0;
    }

    public static int findFirst(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        return -1;
    }

    public static int[] find(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        int[] indices = {-1};
        return indices;
    }
}
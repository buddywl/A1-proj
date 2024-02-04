import java.util.Arrays;

public class ClimateQueries{

    // Below are stubs for each of the methods for the 
    // climate analysis. You should include both ranged
    // and unranged methods for each, but only the unranged
    // are listed below
    public static void main(String[] args){
        boolean[] ind1 = {false, true, true, false, true};
        boolean[] ind2 = {false, false, false};
//        int index = -1;
//        for(int i = 0; i < ind2.length; i++){
//            if(ind2[i]){
//                index = i;
//            }
//        }
//        System.out.println(index);
        System.out.println(Arrays.toString(find(ind1)));
        System.out.println(Arrays.toString(find(ind2)));


    }

    public static boolean[] isEqualTo(float[] arr, float val){
        // add your code here 
        // replace code below with your own return statement
        boolean[] indicator = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++){
            indicator[i] = (arr[i] == val);
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
            indicator[i] = arr1[i] && arr2[i];
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
            else if (!indicator[i]){
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
            else if (!indicator[i]){
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

    public static int findFirst(boolean[] arr){
        // add your code here
        // replace code below with your own return statement
        int index = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]){
                index = i;
            }
        }
        return index;
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
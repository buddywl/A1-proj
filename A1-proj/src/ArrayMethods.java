public class ArrayMethods {
    public static float wholeSum(float[] arr){
        float sum = 0;
        for(float v : arr){
            sum += v;
        }
        return sum;
    }

    public static float sum(float[] arr, int lo, int hi){
        float sum = 0;
        for(int i = lo; i < hi; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static float mean(float[] arr, int lo, int hi){
        if (lo != hi){
            return sum(arr, lo, hi)/(hi-lo);
        }
        else{
            return 0;
        }

    }

    public static float mean(float[] arr){
        if (arr.length != 0){
            return wholeSum(arr)/arr.length;
        }
        else{
            return 0;
        }

    }

    public static float min(float[] arr, int lo, int hi){
        float minVal= 10000;
        int range = hi - lo;

        if(range != 0){
            for (int i = lo; i < hi; i++){
                if (minVal > arr[i]){
                    minVal = arr[i];
                }

            }
            return minVal;
        }
        else{
            return Float.NaN;
        }

    }

    public static float min(float[] arr){
        float minVal = 10000;

        if(arr.length != 0){
            for (float v : arr){
                if (minVal > v){
                    minVal = v;
                }
            }
            return minVal;
        }
        else{
            return Float.NaN;
        }

    }

    public static float max(float[] arr, int lo, int hi){
        float maxVal = -10000;
        int range = hi - lo;

        if(range != 0){
            for (int i = lo; i < hi; i++){
                if (maxVal < arr[i]){
                    maxVal = arr[i];
                }

            }
            return maxVal;
        }
        else{
            return Float.NaN;
        }    }

    public static float max(float[] arr){
        float maxVal = -10000;

        if(arr.length != 0){
            for (float v : arr){
                if (maxVal < v){
                    maxVal = v;
                }
            }
            return maxVal;
        }
        else{
            return Float.NaN;
        }
    }

}

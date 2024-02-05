public class ArrayMethods {
    /**
     * Returns a float of sum of all elements in an array
     * @param   arr the array of floats to be accessed
     * @return  the sum of the elements
     */
    public static float wholeSum(float[] arr){
        float sum = 0;
        for(float v : arr){
            sum += v;
        }
        return sum;
    }
    /**
     * Returns a float of sum of the elements contained in a range on an array
     * @param   arr the array of floats to be accessed
     * @param   lo  the lower bound of the array (inclusive)
     * @param   hi  the upper bound of the array (exclusive)
     * @return  the sum of the elements in the given range
     */
    public static float sum(float[] arr, int lo, int hi){
        float sum = 0;
        for(int i = lo; i < hi; i++){
            sum += arr[i];
        }
        return sum;
    }


    /**
     * Returns a float of mean of the elements contained in a range on an array
     * @param   arr the array of floats to be accessed
     * @param   lo  the lower bound of the array (inclusive)
     * @param   hi  the upper bound of the array (exclusive)
     * @return  the mean of the elements in the given range
     */
    public static float mean(float[] arr, int lo, int hi){
        if (lo != hi){
            return sum(arr, lo, hi)/(hi-lo);
        }
        else{
            return 0;
        }

    }
    /**
     * Returns a float of mean of all elements in an array
     * @param   arr the array of floats to be accessed
     * @return  the mean of the elements
     */
    public static float mean(float[] arr){
        if (arr.length != 0){
            return wholeSum(arr)/arr.length;
        }
        else{
            return 0;
        }

    }

    /**
     * Returns a float of smallest value of the elements contained in a range on an array
     * @param   arr the array of floats to be accessed
     * @param   lo  the lower bound of the array (inclusive)
     * @param   hi  the upper bound of the array (exclusive)
     * @return  the smallest value of the elements in the given range
     */
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
    /**
     * Returns a float of smallest value of  all the elements in an array
     * @param   arr the array of floats to be accessed
     * @return  the smallest value of the elements
     */
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

    /**
     * Returns a float of largest value of the elements contained in a range on an array
     * @param   arr the array of floats to be accessed
     * @param   lo  the lower bound of the array (inclusive)
     * @param   hi  the upper bound of the array (exclusive)
     * @return  the largest value of the elements in the given range
     */
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
    /**
     * Returns a float of smallest value of  all the elements in an array
     * @param   arr the array of floats to be accessed
     * @return  the largest value of the elements
     */
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

package edu.monmouth.oddeven;
import java.util.Arrays;

public class OddEven {

    private final int[] intData;

    //Constructors
    public OddEven() {
        intData = new int[0];
    }

    public OddEven(int[] data) {
        this.intData = data;

    }

    //Methods
    public int numberOfEvens(){
        int evenCount = 0;

        for (int num : intData) {
            if (num % 2 == 0){
                evenCount++;
            }
        }

        return evenCount;
    }

    public int numberOfOdds(){
        int oddCount = 0;

        for (int num : intData){
            if(num % 2 > 0){
                oddCount++;
            }
        }

        return oddCount;
    }

    public int[] reverse(){
        int[] reverse = new int[intData.length];
        int startOfReverse = 0;
        for (int i = reverse.length - 1; i >= 0; i--){
             reverse[startOfReverse] = intData[i];
             startOfReverse++;
        }

        System.out.println("Reversed Array: " + Arrays.toString(reverse));

        return reverse;
    }

    public int countOccurrences(int searchNum){
        int occurCount = 0;
        for (int num : intData){
            if (num == searchNum){
                occurCount++;
            }
        }

        return occurCount;
    }

    public int[] mergeArrays(int[] newData){
        int[] mergedArray = Arrays.copyOf(intData, (intData.length + newData.length));

        for (int i = intData.length; i < mergedArray.length; i++) {
            mergedArray[i] = newData[i - intData.length];
        }

        System.out.println("Merged Array: " + Arrays.toString(mergedArray));

        return mergedArray;
    }

    public int duplicates(){
        int countDupes = 0;

        for (int i = 0; i < intData.length; i++) {
            for (int j = i+1; j < intData.length; j++) {
                if (intData[i] == intData[j]){
                    countDupes++;
                    break;
                }
            }
        }
        return countDupes;
    }

    // Code I want to save that does work lol

//        int[] newArray = new int[(intData.length + newData.length)];
//
//        for (int i = 0; i < newArray.length; i++){
//            if (i < intData.length){
//                newArray[i] = intData[i];
//            }
//            else {
//                newArray[i] = newData[i - intData.length];
//            }
//        }


}

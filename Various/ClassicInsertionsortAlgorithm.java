import java.util.Arrays;
import java.util.Scanner;
public class StringClass {
	public static void main(String[] args){
		
		Scanner inputObject = new Scanner(System.in);
		int[] values = {8, 3, 7, 9, 1, 2, 4};
		sort(values);
		inputObject.close();
		
	}
    public static void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            int indexSmallest = indexOfTheSmallestStartingFrom(array, i);
            swap(array, i, indexSmallest);
            System.out.println(Arrays.toString(array));
        }
    }
    public static int indexOfTheSmallestStartingFrom(int[] array, int index){
        int indexSmallestStarting = index;
        for(int i = index; i < array.length; i++){
            if(array[indexSmallestStarting] > array[i]){ 
				indexSmallestStarting = i; 
			}
        }
        return indexSmallestStarting;
    }
    public static void swap(int[] array, int index1, int index2){
		int value1 = array[index1]; 
		int value2 = array[index2];
        array[index1] = value2;  
		array[index2] = value1;
    }
	
}
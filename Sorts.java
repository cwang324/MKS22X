
public class Sorts {

	
   /**
    * Precondition: Every indexed variable of the array a has a value.
    * Postcondition: a[0] <= a[1] <= ... <= a[a.length - 1].
    */
	public static void mergeSort(int[] a)
	{
		int dataSize = a.length;
		
		if ( dataSize >= 2)
		{	
			int halfLength = dataSize / 2;
			int [] firstHalf = new int[halfLength];
			int [] secondHalf = new int[dataSize-halfLength];
			
			divide(a, firstHalf, secondHalf);
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(a, firstHalf, secondHalf);
		}
		else
		{	
			// do nothing, an array of size 1 is already sorted
		}
	}
	
	
	//Precondition: a.length = firstHalf.length + lastHalf.length.
    //Postcondition: All the elements of a are divided
    //between the arrays firstHalf and lastHalf.
    private static void divide(int[] a, int[] firstHalf, int[] lastHalf)
    {
        for (int i = 0; i < firstHalf.length; i++)
            firstHalf[i] = a[i];
        
        for (int i = 0; i < lastHalf.length; i++)
            lastHalf[i] = a[firstHalf.length + i];
    }
	
    
    //Precondition: Arrays firstHalf and lastHalf are sorted from 
    //smallest to largest; a.length = firstHalf.length + 
    //lastHalf.length.
    //Postcondition: Array a contains all the values from firstHalf 
    //and lastHalf and is sorted from smallest to largest.
	private static void merge(int[] a, int[] firstHalf, int[] lastHalf)
    {
        int firstHalfIndex = 0, lastHalfIndex = 0, aIndex = 0;

        while ((firstHalfIndex < firstHalf.length) &&
			   (lastHalfIndex < lastHalf.length))
        {
            if (firstHalf[firstHalfIndex] < lastHalf[lastHalfIndex])
            {
                a[aIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            }
            else
            {
                a[aIndex] = lastHalf[lastHalfIndex];
                lastHalfIndex++;
            }
            aIndex++;
        }
        //At least one of firstHalf and lastHalf has been
        //completely copied to a.

        //Copy rest of firstHalf, if any.
		while (firstHalfIndex < firstHalf.length)
        {
            a[aIndex] = firstHalf[firstHalfIndex];
            aIndex++;
            firstHalfIndex++;
        }

        //Copy rest of lastHalf, if any.
        while (lastHalfIndex < lastHalf.length)
        {
            a[aIndex] = lastHalf[lastHalfIndex];
            aIndex++;
            lastHalfIndex++;
        }
    }    
    

	   /**
	    * Precondition: Every indexed variable of the array a has a value.
	    * Postcondition: a[0] <= a[1] <= ... <= a[a.length - 1].
	    */
		public static void betterMergeSort(int[] a)
		{
			int startA = 0; 
			int endA = a.length-1;
			
			betterMergeSortImpl(a, startA, endA);
			
		}
	
	   /**
	    * Precondition: Every indexed variable of the array a has a value.
	    * Postcondition: a[0] <= a[1] <= ... <= a[a.length - 1].
	    */
		public static void betterMergeSortImpl(int[] a, int startIndex, int endIndex)
		{
			int dataSize = endIndex - startIndex + 1;
			
			if ( dataSize >= 2)
			{	
				int halfLength = dataSize / 2;
				int startA = startIndex;
				int endA = startIndex + halfLength-1;
				int startB = endA + 1;
				int endB = endIndex;
				betterMergeSortImpl(a, startA, endA);
				betterMergeSortImpl(a, startB, endB);
				betterMerge(a, startA, endA, startB, endB);
			}
			else
			{	
				// do nothing, an array of size 1 is already sorted
			}
		}
	
	
    //Precondition: int[] a conains the entire array to be sorted using merge sort 
    //startA <= endA <= startB <= endB 
    //
    //Postcondition: Array a index startA to endB is sorted from smallest to largest 
    //and lastHalf and is sorted from smallest to largest.
	private static void betterMerge(int[] a, int startA, int endA, int startB, int endB)
    {
		
         int tempArraySize = endB - startA + 1;
         int[] tempArray = new int[tempArraySize];
         int aIndex = startA;
         int bIndex = startB;
         int tIndex = 0;

         
         while ((aIndex <= endA) && (bIndex <= endB))
         {
             if (a[aIndex] < a[bIndex])
             {
                 tempArray[tIndex++] = a[aIndex++];                
             }
             else
             {
                 tempArray[tIndex++] = a[bIndex++];
             }
         }
        // At least one half (startA to endA or startB to endB) is
        // completely copied to tempArray

        //Copy rest of firstHalf, if any.
		while (aIndex <= endA)
        {
            tempArray[tIndex++] = a[aIndex++];
        }

        //Copy rest of lastHalf, if any.
        while (bIndex <= endB)
        {
            tempArray[tIndex++] = a[bIndex++];
        }
        
        // copy the merged result from tempArray back to array a
        tIndex = 0;
        aIndex = startA;
        while ( startA <= endB)
        {	
        	a[aIndex++] = tempArray[tIndex++];
        	startA++;
        }        
    }    

	
	
	public static void main (String[] args)
	{
	   int[] data1 = { 8, 3, 2, 4, 5, 9, 1, 7, 6};
	   int[] data2 = { 1, 8, 3, 6, 5, 4, 9, 2, 7, 0};
	   
/*	   
	   System.out.println("before mergeSort data1 =" + java.util.Arrays.toString(data1));
	   mergeSort(data1);
	   System.out.println("after mergeSort data1 =" + java.util.Arrays.toString(data1));
	   
	   System.out.println("============================================================");
	   System.out.println("before mergeSort data2 =" + java.util.Arrays.toString(data2));
	   mergeSort(data2);
	   System.out.println("after mergeSort data2 =" + java.util.Arrays.toString(data2));
*/	   
	   
	   System.out.println("before mergeSort data1 =" + java.util.Arrays.toString(data1));
	   betterMergeSort(data1);
	   System.out.println("after mergeSort data1 =" + java.util.Arrays.toString(data1));
	   
	   System.out.println("============================================================");
	   System.out.println("before mergeSort data2 =" + java.util.Arrays.toString(data2));
	   betterMergeSort(data2);
	   System.out.println("after mergeSort data2 =" + java.util.Arrays.toString(data2));
	   
	}
}

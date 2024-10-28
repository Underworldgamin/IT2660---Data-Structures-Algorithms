import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      // Bubble Sort
      System.out.println("\n\nBubble sort results ----------------------------------------------");
      ArrayList<Integer> bubbleSortedList = new ArrayList<>(integerList);
      long bubbleStart = System.nanoTime();
      bubbleSortedList = Lab4.bubbleSort(bubbleSortedList);
      long bubbleEnd = System.nanoTime();
      Lab4.outputList(bubbleSortedList);
      System.out.println("\nBubble Sort Time (ns): " + (bubbleEnd - bubbleStart));

      // Insertion Sort
      System.out.println("\n\nInsertion sort results -------------------------------------------");
      ArrayList<Integer> insertionSortedList = new ArrayList<>(integerList);
      long insertionStart = System.nanoTime();
      insertionSortedList = Lab4.insertionSort(insertionSortedList);
      long insertionEnd = System.nanoTime();
      Lab4.outputList(insertionSortedList);
      System.out.println("\nInsertion Sort Time (ns): " + (insertionEnd - insertionStart));
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    
    for (int i = 1; i < integerList.size(); i++) {
      int key = integerList.get(i);
      int j = i - 1;
      
      
      while (j >= 0 && integerList.get(j) > key) {
        integerList.set(j + 1, integerList.get(j));
        j = j - 1;
      }
      integerList.set(j + 1, key);
    }
    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    
    int n = integerList.size();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (integerList.get(j) > integerList.get(j + 1)) {
         
          int temp = integerList.get(j);
          integerList.set(j, integerList.get(j + 1));
          integerList.set(j + 1, temp);
        }
      }
    }
    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
    System.out.println();
  }
  
  /*
   * 1. If I were implementing a sort algorithm for a new language, I would use:
   *    - Insertion sort for smaller datasets or nearly sorted data due to its simplicity.
   *    - For larger datasets, I would opt for a more efficient algorithm like quicksort or mergesort.
   * 
   * 2. Time difference between bubble and insertion sort:
   *    - Yes, there is generally a difference in runtime. Bubble sort has a time complexity of O(n^2),
   *      making it slower than insertion sort, especially as data size grows. This is expected because
   *      insertion sort performs fewer operations on nearly sorted data.
   * 
   * 3. Which sort algorithm is easier to understand and implement?
   *    - Insertion sort is often easier to understand and implement due to its simple logic of shifting elements
   *      rather than performing repeated swaps as in bubble sort.
   */
}

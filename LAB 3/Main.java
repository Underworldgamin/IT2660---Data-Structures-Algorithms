public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    // Assigning best-case and worst-case scenarios
    String bestCase = "A"; // best-case: first character matches
    String worstCase = "9"; // worst-case: last character matches

    // Best-case scenario
    long startTime = System.nanoTime();  // * Initialize startTime for best-case
    int index = match(text, bestCase);
    long endTime = System.nanoTime();    // * Initialize endTime for best-case
    long elapsedTime = endTime - startTime; // * Calculate elapsedTime for best-case
    
    if (index >= 0)
      System.out.println("Best-case input matched at index " + index);
    else
      System.out.println("Best-case input unmatched");
    
    System.out.println("Best-case elapsed time: " + elapsedTime + " nanoseconds");
   
    // Worst-case scenario
    startTime = System.nanoTime();  // * Initialize startTime for worst-case
    index = match(text, worstCase);
    endTime = System.nanoTime();    // * Initialize endTime for worst-case
    elapsedTime = endTime - startTime; // * Calculate elapsedTime for worst-case
    
    if (index >= 0)
      System.out.println("Worst-case input matched at index " + index);
    else
      System.out.println("Worst-case input unmatched");
    
    System.out.println("Worst-case elapsed time: " + elapsedTime + " nanoseconds");
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }

    return -1;
  }

  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    return true;
    
    //According to the book, the Big O for the brute-force string matching algorithm is O(m * n), where m is the length of the text and n is the length of the pattern.
    //This means the time complexity grows linearly with the size of the text and the pattern, making it less efficient as input sizes increase.The calculated elapsed time should align with this complexity, where the best-case scenario, with an early match, takes less time than the worst-case scenario, where the pattern matches towards the end of the text or not at all. 
    //The purpose of the exercise is to help understand how theoretical time complexity, represented by Big O, correlates with practical time measurements and how input affects the algorithm's performance. 
    //While this gives a clear comparison between best and worst cases for specific input sizes, it is not comprehensive enough to account for all possible variations in text and pattern lengths, which would require more extensive testing across different inputs. 




    
  }
}

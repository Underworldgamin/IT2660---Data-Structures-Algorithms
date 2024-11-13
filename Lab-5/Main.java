public class Main {
  public static void main(String[] args) {
      BST<Integer> lab5Tree = new BST<>();

      // Insert the elements into the BST
      int[] values = {13, 22, 36, 5, 48, 17, 39, 2, 26, 40, 29, 34, 10};
      for (int value : values) {
          lab5Tree.insert(value);
      }

      // Delete element 17
      lab5Tree.delete(17);

      // Display the traversals
      System.out.print("Inorder (sorted): ");
      lab5Tree.inorder();
      System.out.println();

      System.out.print("Postorder: ");
      lab5Tree.postorder();
      System.out.println();

      System.out.print("Preorder: ");
      lab5Tree.preorder();
      System.out.println();

      // Test search method
      System.out.println("Search 36: " + lab5Tree.search(36));
      System.out.println("Search 37: " + lab5Tree.search(37));

      // Display paths
      System.out.println("Path to 2: " + formatPath(lab5Tree.path(2)));
      System.out.println("Path to 34: " + formatPath(lab5Tree.path(34)));
  }

  // Helper method to format the path
  private static String formatPath(java.util.ArrayList<BST.TreeNode<Integer>> path) {
      StringBuilder result = new StringBuilder();
      for (BST.TreeNode<Integer> node : path) {
          result.append(node.element).append(" -> ");
      }
      return result.substring(0, result.length() - 4); // Remove last arrow
  }
}

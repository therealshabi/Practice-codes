import java.util.*;

class BST {
  public int data;
  public int hd;
  public BST left, right;

  public BST(int data, int hd) {
    this.data = data;
    this.hd = hd;
    this.left = null;
    this.right = null;
  }
}

public class VerticalOrderTraversal {

  static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

  public static void verticalTraversal(BST root, Queue<BST> queue) {
    int d, hd;
    BST node = null;

    if(root==null || queue.isEmpty()) {
      return;
    }
      node = queue.poll();
      d = node.data;
      hd = node.hd;

      if (map.get(hd)==null) {
        map.put(hd,new ArrayList<>());
      }
      map.get(hd).add(d);

      if (root.left!=null) {
      queue.add(root.left);
     }
     if (root.right!=null) {
      queue.add(root.right);
     }

     verticalTraversal(root.left, queue);
     verticalTraversal(root.right, queue);
  }

  public static void printVerticalOrder() {
    System.out.println("Vertical Order Traversal : ");
    Iterator it = map.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        // System.out.println("HD = "+ pair.getKey() + " values : ");
        ArrayList<Integer> arr = (ArrayList)pair.getValue();
        for (Integer i : arr) {
          System.out.print(i+" ");
        }
        System.out.println();
    }
}

  public static BST insert(BST root, int data, int hd) {

    if (root==null) {
      root = new BST(data, hd);
    }
    else if(data<root.data){
      root.left = insert(root.left, data, (hd-1));
    }
    else if(data>root.data) {
      root.right = insert(root.right, data, (hd+1));
    }

    return root;
  }

  public static void traverse(BST root) {
    if(root==null) {
      return;
    }
      traverse(root.left);

      System.out.println(root.data + " "+root.hd);

      traverse(root.right);
  }

  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.print("Enter the no. of nodes : ");
      int n = in.nextInt();
      BST root = null;
      System.out.println("Enter the nodes of the BST : ");
      for(int i=0;i<n;i++){
          root = insert(root, in.nextInt(), 0);
      }

      // System.out.println("Inorder Traversal : ");
      // traverse(root);

      Queue<BST> queue = new LinkedList<>();
      queue.add(root);
      verticalTraversal(root, queue);

      printVerticalOrder();
  }
}

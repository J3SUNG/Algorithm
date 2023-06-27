import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = "";
    Node rootNode = new Node(Integer.parseInt(br.readLine()));

    while ((input = br.readLine()) != null) {
      rootNode.makeChild(Integer.parseInt(input));
    }

    postOrder(rootNode);
  }

  static public void postOrder(Node node) {
    if (node.left != null) {
      postOrder(node.left);
    }
    if (node.right != null) {
      postOrder(node.right);
    }
    System.out.print(node);
  }

  static public class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
      this.value = value;
    }

    public void makeChild(int num) {
      if (num < value) {
        if (this.left != null) {
          this.left.makeChild(num);
        } else {
          this.left = new Node(num);
        }
      } else {
        if (this.right != null) {
          this.right.makeChild(num);
        } else {
          this.right = new Node(num);
        }
      }
    }

    public String toString() {
      return value + "\n";
    }
  }
}

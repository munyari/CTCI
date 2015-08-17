import java.util.HashSet;

public class Partition
{
  private static class Node
  {
    Node next = null;
    int data;

    public Node(int d)
    {
      data = d;
    }

    void add(int d)
    {
      Node end = new Node(d);
      Node n = this;
      while (n.next != null)
      {
        n = n.next;
      }
      n.next = end;
    }
  }

  public static void main(String[] args)
  {
    Node linked = new Node(5);
    linked.add(2);
    linked.add(3);
    linked.add(2);
    linked.add(7);
    printList(linked);
    linked = partition(linked, 3);
    printList(linked);
  }


  private static void printList(Node head)
  {
    Node n = head;
    while (n.next != null)
    {
      System.out.printf("%d -> ", n.data);
      n = n.next;
    }
    System.out.println(n.data);
  }

  private static Node partition(Node head, int val)
  {
    Node left = null;
    Node right = null;
    while (head != null)
    {
      if (head.data < val)
      {
        if (left == null)
        {
          left = new Node(head.data);
        }
        else
        {
          left.add(head.data);
        }
      }
      else
      {
        if (right == null)
        {
          right = new Node(head.data);
        }
        else
        {
          right.add(head.data);
        }
      } 
      head = head.next;
    }
    concat(left, right);
    return left;
  }

  private static void concat(Node n1, Node n2)
  {
    Node curr = n1;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = n2;
  }
}

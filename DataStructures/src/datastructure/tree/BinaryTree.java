package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    Node top;

    private void insertElements(String str) {

        String[] s = str.split(" ");

        Queue<Node> queue = new LinkedList<>();

        int i = 0;
        top = new Node(Integer.parseInt(s[i++]));
        queue.add(top);
        Node current;

        while(!queue.isEmpty()) {

            Node root = queue.poll();

            current = new Node(Integer.parseInt(s[i++]));

            if(current.data != -1) {

                queue.add(current);
                root.left = current;
            }

            current = new Node(Integer.parseInt(s[i++]));

            if(current.data != -1) {

                queue.add(current);
                root.right = current;
            }
        }
    }

    void inOrderTraversal(Node node) {

        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }
    public void binaryTree() {

        Scanner sc = new Scanner(System.in);

        boolean isContinue = true;

        while (isContinue) {

            System.out.println("Choose what to do:");
            System.out.println("[1] Insert elements");
            System.out.println("[2] InOrder traversal");
            System.out.println("[3] PreOrder traversal");
            System.out.println("[4] PostOrder traversal");
            System.out.println("[0] Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter elements to be inserted:");

                        String input = sc.nextLine();

                        if (input.isEmpty())
                            break;

                        try {
                            insertElements(input);
                        } catch (Exception e) {
                            break;
                        }
                    break;


                case 2:
                    inOrderTraversal(top);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Input");
                    break;
            }

            System.out.println("Do you want to continue operation on Binary tree?");
            System.out.println("[Y] [N]");

            String con;
            try {
                con = sc.nextLine();
            } catch (Exception e) {

                continue;
            }

            if (!con.equalsIgnoreCase("y")) {

                isContinue = false;
            }
        }
    }

}

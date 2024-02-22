package datastructure.stack;

import java.util.Scanner;

public class Stack {


    static class Node {

        private final int data;
        private Node prev;

        Node(int data) {

            this.data = data;
        }
    }

    private Node top;

    void push(int n) {

        Node new_node = new Node(n);

        if(top != null) {

            new_node.prev = top;
        }
        top = new_node;
    }

    int pop() {

        int pop_val = -1;

        if(top != null) {

            Node temp = top;

            top = top.prev;

            pop_val = temp.data;

            temp = null;
        }

        return pop_val;
    }

    int top() {

        int top_val = -1;

        if(top != null) {

            top_val = top.data;
        }

        return top_val;
    }

    int size() {

        int len = 0;

        Node current = top;

        while(current != null) {

            ++len;
            current = current.prev;
        }

        return len;
    }

    boolean isEmpty() {


        return top == null;
    }


    public void stack() {


        Scanner sc = new Scanner(System.in);


        boolean isContinue = true;

        while(isContinue) {

            System.out.println("Enter number of queries: ");
            int no_of_queries = sc.nextInt();

            for(int i=0; i < no_of_queries; i++) {

                System.out.println("Choose what to do:");
                System.out.println("[1] Push element");
                System.out.println("[2] Pop element");
                System.out.println("[3] Get top element");
                System.out.println("[4] Get Size");
                System.out.println("[5] Check emptiness");
                System.out.println("[0] Exit");

                int q = sc.nextInt();

                switch (q) {

                    case 1:
                        push(sc.nextInt());
                        break;

                    case 2:
                        System.out.println(pop());
                        break;

                    case 3:
                        System.out.println(top());
                        break;

                    case 4:
                        System.out.println(size());
                        break;

                    case 5:
                        System.out.println(isEmpty());
                        break;
                }

            }
            System.out.println("Do you want to continue operation on stack?");
            System.out.println("[Y] [N]");

            String con;
            try {

                sc.nextLine();
                con = sc.nextLine();
            }
            catch (Exception e) {

                continue;
            }

            if(!con.equalsIgnoreCase("y")) {

                isContinue = false;
            }
        }
    }
}

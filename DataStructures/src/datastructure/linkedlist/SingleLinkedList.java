package datastructure.linkedlist;

import java.util.Scanner;

public class SingleLinkedList {

    static class Node {

        private final int data;
        private Node next = null;

        Node(int data) {

            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;

    void insertElements(int n) {

        Node new_node = new Node(n);

        if(head != null) {

            tail.next = new_node;
        }
        else {

            head = new_node;
        }
        tail = new_node;
    }

    void display() {

        Node current = head;

        while(current != null) {

            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void singleLinkedList() {

        Scanner sc = new Scanner(System.in);

        boolean isContinue = true;

        while(isContinue) {

            System.out.println("Choose what to do:");
            System.out.println("[1] Insert elements");
            System.out.println("[2] Insert elements at first");
            System.out.println("[3] Find middle element");
            System.out.println("[4] Display elements");
            System.out.println("[5] Delete elements");
            System.out.println("[6] Delete list");
            System.out.println("[0] Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter elements to be inserted:");
                    while(sc.hasNextLine()) {

                        String input = sc.nextLine();

                        if(input.isEmpty())
                            break;

                        try {
                            insertElements(Integer.parseInt(input));
                        }
                        catch (Exception e){
                            break;
                        }
                    }
                    break;

                case 2:
                    display();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Input");
                    break;
            }

            System.out.println("Do you want to continue operation on singly Linked List?");
            System.out.println("[Y] [N]");

            String con;
            try {

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

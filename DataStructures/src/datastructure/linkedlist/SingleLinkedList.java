package datastructure.linkedlist;

import datastructure.stack.Stack;

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
    void insertAtFirst(int n) {

        Node new_node = new Node(n);

        if(head != null) {

            new_node.next = head;
        }
        else {

            tail = new_node;
        }
        head = new_node;
    }

    void insertAtPosition(int position, int data) {

        Node current = head;
        Node prev = null;

        if(size() + 1 < position || position <= 0) {

            System.out.println("Invalid position");
        }
        else {

            if(position == 1) {

                insertAtFirst(data);
            }
            else {

                for(int i=0; i < position-2; i++) {

                    current = current.next;
                }

                Node new_node = new Node(data);

                Node temp = current.next;
                current.next = new_node;
                new_node.next = temp;
            }
        }
    }

    int size() {

        int len = 0;

        Node current = head;

        while(current != null) {

            ++len;
            current = current.next;
        }

        return len;
    }

    Node findMiddleElement() {

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
            System.out.println("[3] Insert elements at position");
            System.out.println("[4] Find middle element");
            System.out.println("[5] Display elements");
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
                    System.out.println("Enter elements to be inserted at first:");
                    while(sc.hasNextLine()) {

                        String input = sc.nextLine();

                        if(input.isEmpty())
                            break;

                        try {
                            insertAtFirst(Integer.parseInt(input));
                        }
                        catch (Exception e){
                            break;
                        }
                    }
                    break;

                case 3:

                    System.out.println("Enter elements to be inserted and position:");
                    try {

                        int data = sc.nextInt(), position = sc.nextInt();
                        insertAtPosition(position, data);
                        sc.nextLine();
                    }
                    catch (Exception e){
                        break;
                    }
                    break;


                case 4:
                    Node mid_node = findMiddleElement();
                    System.out.println("Middle element of the list: " + (mid_node != null ? mid_node.data : "null" ));
                    break;

                case 5:
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

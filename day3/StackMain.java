package CapgeminiTraining.day3;

import java.util.Scanner;

class StackArray {
    int maxSize;
    int stack[];
    int top;

    StackArray(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow! Cannot push.");
        } else {
            top++;
            stack[top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
        } else {
            int value = stack[top];
            top--;
            System.out.println(value + " popped from stack.");
        }
    }

    void peek() {
        if (top == -1) {
            System.out.println("Stack is empty. Nothing to peek.");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }
}

public class StackMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter stack size: ");
        int size = sc.nextInt();

        StackArray stack = new StackArray(size);

        int choice;

        do {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}

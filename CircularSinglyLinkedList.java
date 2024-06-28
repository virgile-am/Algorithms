public class CircularSinglyLinkedList {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Circular Singly Linked List class
    private Node head = null;

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            newNode.next = head;
            current.next = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    // Traverse the list
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Search for a node
    public boolean search(int key) {
        if (head == null) return false;
        Node current = head;
        do {
            if (current.data == key) return true;
            current = current.next;
        } while (current != head);
        return false;
    }

    // Delete a node
    public boolean deleteNode(int key) {
        if (head == null) return false;

        Node current = head;
        Node prev = null;

        // Check if head node itself is the key node
        if (current.data == key) {
            // Check if there is only one node in the list
            if (current.next == head) {
                head = null;
                return true;
            }
            // Find the last node
            while (current.next != head) {
                current = current.next;
            }
            // Point last node to the next of head
            current.next = head.next;
            head = head.next;
            return true;
        }

        // Traverse the list to find the key node
        prev = current;
        current = current.next;
        while (current != head) {
            if (current.data == key) {
                prev.next = current.next;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false; // Node with the given key not found
    }

    // Delete entire list
    public void deleteList() {
        head = null;
    }

    // Main method to test the Circular Singly Linked List
    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        // Insert elements
        csll.insertAtBeginning(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtBeginning(5);

        // Traverse the list
        System.out.print("Traversal: ");
        csll.traverse();

        // Search for an element
        System.out.println("Search for 20: " + csll.search(20));
        System.out.println("Search for 40: " + csll.search(40));

        // Delete a node
        csll.deleteNode(20);
        System.out.print("Traversal after deleting 20: ");
        csll.traverse();

        // Delete the entire list
        csll.deleteList();
        System.out.print("Traversal after deleting the list: ");
        csll.traverse();
    }

}
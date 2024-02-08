class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    int size;

    LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Insertar un elemento al final de la lista enlazada
    void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
    }

    // Eliminar un elemento de la lista enlazada por valor
    boolean remove(int value) {
        if (head == null) {
            return false;
        }

        if (head.data == value) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    // Buscar un elemento en la lista enlazada por valor
    Node search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    // Imprimir la lista enlazada
    void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Lista enlazada:");
        list.print();

        list.remove(3);
        System.out.println("Lista enlazada después de eliminar el valor 3:");
        list.print();

        Node node = list.search(2);
        if (node != null) {
            System.out.println("Elemento encontrado: " + node.data);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}

package Collection;

public class MyLinkedList<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    public void iterate(){
        Node<T> current=head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
        // System.out.println();
    }
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }
    public void add(int index, T data){
        Node<T> newNode = new Node<>(data);
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (head == null) {
            head = newNode;
        } else{
            Node<T> curr = head;
            curr=head;
            while(size<index-1){
                curr=curr.next;
                curr.next=newNode;
            }
        }
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }
}
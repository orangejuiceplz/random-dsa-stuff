package types.generic;

class Node<E> {

    private Node<E> next;
    private E value;

    public Node(E value) {
        this.value = value;
        this.next = null;
    }

    public Node<E> getNext() {
        return this.next;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
    public E getValue() {
        return this.value;
    }
    public void setValue(E value) {
        this.value = value;
    }



}

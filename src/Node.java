public class Node<T> {
    private T content;
    private Node<T> next;

    public Node(T pContent) {
        content = pContent;
        next = null;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T pContent) {
        content = pContent;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> pNext) {
        next = pNext;
    }
}

public interface Stack<E> { //StackInterface
    int size();

    boolean isFull();

    boolean isEmpty();

    boolean push(E anElement);

    E pop();

    E peek();

    void clear();
}
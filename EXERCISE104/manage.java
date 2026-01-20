package EXERCISE104;

public interface manage<T> {
    void addStudent(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}

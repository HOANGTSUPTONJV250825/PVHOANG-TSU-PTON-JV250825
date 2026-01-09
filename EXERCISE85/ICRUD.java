package EXERCISE85;

public interface ICRUD {
    Category[] findAll();
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteByID(int ID);
}

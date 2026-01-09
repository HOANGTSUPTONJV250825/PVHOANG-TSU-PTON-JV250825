package EXERCISE85;

import java.util.Scanner;

public class CategoryManager implements ICRUD{
    private Category[] categories = new Category[0];
    // tra ve gia tri mang
    @Override
    public Category[] findAll() {
        return categories;
    }
    // them vao gia tri mang
    @Override
    public void addCategory(Category category){
        Category[] newCategories = new Category[categories.length+1];
        for (int i=0; i<categories.length;i++ ){
            newCategories[i] = categories[i];
        }
        newCategories[newCategories.length-1] = category;
        categories = newCategories;

    }
    // update gia tri mang theo ID
    @Override
    public void updateCategory(Category category){
        for (int i= 0;i<categories.length;i++){
            if (categories[i].getID() == category.getID() ){
                categories[i]=category;
                return;
            }
        }
        System.out.println("khong tim thay ID danh muc");
    }
    // xoa gia tri mang
    @Override
    public void deleteByID(int ID){
        int findIndex = -1;
        for (int i=0;i<categories.length;i++){
            if (categories[i].getID() == ID){
                findIndex = i;
                break;
            }
        }
        if (findIndex == -1){
            System.out.println("khong tim thay ID danh muc can xoa");
            return;
        }
        Category[] newCategories = new Category[categories.length-1];
        int j = 0;
        for (int i = 0;i<categories.length;i++){
            if (i!=findIndex){
                newCategories[j++] = categories[i];
            }
        }
        categories = newCategories;
    }
}

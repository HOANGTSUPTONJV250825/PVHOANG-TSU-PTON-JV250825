package EXERCISE86;

public class bookManager implements IBookManager{
    private book[] books = new book[0];
    @Override
    public void addBook(book book){
        book[] newBooks = new book[books.length+1];
        for (int i=0;i<books.length;i++){
            newBooks[i] = books[i];
        }
        newBooks[newBooks.length-1] = book;
        books = newBooks;
    }
    @Override
    public void removeBook(String isbn) {
        int findIndex = -1;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && isbn.equals(books[i].getIsbn())) {
                findIndex = i;
                break;
            }
        }

        if (findIndex == -1) {
            System.out.println("Không tìm thấy dữ liệu cần xóa");
            return;
        }

        book[] newBooks = new book[books.length - 1];
        int j = 0;

        for (int i = 0; i < books.length; i++) {
            if (i != findIndex) {
                newBooks[j++] = books[i];
            }
        }

        books = newBooks;
        System.out.println(" Xóa sách thành công");
    }
    @Override
    public void displayBook(){
        for (book b: books ){
            if (b!=null){
                System.out.println(b.getDetail());
            }
        }
    }
}

package com.bookstore.Trabalho.Programacao3.dto.response;

import com.bookstore.Trabalho.Programacao3.document.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFavoriteResponse {

    private String userFavoriteId;
    private String userId;
    private List<Book> books;

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(int position){
        books.remove(position);
    }
}

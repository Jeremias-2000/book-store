package com.bookstore.Trabalho.Programacao3.dto.user;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {

    private String cartId;
    @NotBlank
    private String userId;
    private List<Book> books;

    public void add(Book book){
        books.add(book);
    }

    public void remove(int position){
        books.remove(position);
    }
}

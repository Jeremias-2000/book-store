package com.bookstore.Trabalho.Programacao3.dto.request;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
public class ShoppingCartRequest {


    private String cartId;
    @NotBlank
    private String userId;
    private List<Book> books;

    public void addBook(Book book){
        if (!book.equals(null)){
            books.add(book);
        }
    }

    public void removeBook(int position){
        if(position >= 0 &&position< books.size()){
            books.remove(position);
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

}

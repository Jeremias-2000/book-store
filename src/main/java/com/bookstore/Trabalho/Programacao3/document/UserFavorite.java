package com.bookstore.Trabalho.Programacao3.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFavorite {

    @Id
    private String userFavoriteId;
    private String userId;
    private List<Book> books;

}

package com.bookstore.Trabalho.Programacao3.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FavoriteRequest {

    private String favoriteId;
    private  int position;
    private boolean removeItem;
}

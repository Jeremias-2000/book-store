package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.UserFavorite;
import com.bookstore.Trabalho.Programacao3.dto.response.UserFavoriteResponse;

public class FavoriteMapper {


    public static UserFavoriteResponse maptoDTO(UserFavorite favorite){
        return UserFavoriteResponse.builder()
                .userFavoriteId(favorite.getUserFavoriteId())
                .userId(favorite.getUserId())
                .books(favorite.getBooks())
                .build();
    }

    public static UserFavorite mapToModel(UserFavoriteResponse response){
        return UserFavorite.builder()
                .userId(response.getUserId())
                .books(response.getBooks())
                .build();
    }
}

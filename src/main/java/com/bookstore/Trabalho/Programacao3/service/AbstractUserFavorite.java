package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.dto.request.FavoriteRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.UserFavoriteRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface AbstractUserFavorite<F> {



    F findUserFavoriteById(String userFavoriteId) throws ChangeSetPersister.NotFoundException;

    F createNewUserFavorite(UserFavoriteRequest  dto);
    F updateUserById(FavoriteRequest request,UserFavoriteRequest favoriteRequest) throws ChangeSetPersister.NotFoundException;
    void deleteFavorites(String favoriteId) throws ChangeSetPersister.NotFoundException;

}

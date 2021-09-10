package com.bookstore.Trabalho.Programacao3.controller.impl;

import com.bookstore.Trabalho.Programacao3.controller.UserFavoriteController;
import com.bookstore.Trabalho.Programacao3.dto.request.FavoriteRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.UserFavoriteRequest;
import com.bookstore.Trabalho.Programacao3.service.impl.UserFavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/favorite")
public class UserFavoriteControllerImpl implements UserFavoriteController {

    @Autowired
    private UserFavoriteServiceImpl favoriteService;

    public UserFavoriteControllerImpl(UserFavoriteServiceImpl favoriteService) {
        this.favoriteService = favoriteService;
    }

    @Override
    public ResponseEntity<?> findFavoritesById(String favoriteId) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(favoriteService.findUserFavoriteById(favoriteId));
    }

    @Override
    public ResponseEntity<?> saveFavorite(UserFavoriteRequest request) {
        return new ResponseEntity<>(favoriteService.createNewUserFavorite(request), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateFavorites(FavoriteRequest request, UserFavoriteRequest favoriteRequest) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(favoriteService.updateUserById(request,favoriteRequest));
    }


    @Override
    public ResponseEntity<?> deleteUserFavorite(String favoriteId) throws ChangeSetPersister.NotFoundException {
        favoriteService.deleteFavorites(favoriteId);
        return ResponseEntity.ok().build();
    }
}

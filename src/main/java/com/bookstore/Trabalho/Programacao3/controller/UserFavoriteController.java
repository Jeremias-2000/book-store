package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.request.FavoriteRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.UserFavoriteRequest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserFavoriteController {

    @GetMapping("/find/{id}")
    ResponseEntity<?> findFavoritesById(@PathVariable("id") String favoriteId) throws ChangeSetPersister.NotFoundException;

    @PostMapping("/save")
    ResponseEntity<?> saveFavorite (@RequestBody UserFavoriteRequest request);

    @PutMapping("/update")
    ResponseEntity<?> updateFavorites(@RequestBody FavoriteRequest request,@RequestBody UserFavoriteRequest favoriteRequest) throws ChangeSetPersister.NotFoundException;

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteUserFavorite(@PathVariable("id") String favoriteId) throws ChangeSetPersister.NotFoundException;
}

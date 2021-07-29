package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.document.UserFavorite;
import com.bookstore.Trabalho.Programacao3.dto.request.FavoriteRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.UserFavoriteRequest;
import com.bookstore.Trabalho.Programacao3.dto.response.UserFavoriteResponse;
import com.bookstore.Trabalho.Programacao3.mapper.FavoriteMapper;
import com.bookstore.Trabalho.Programacao3.mapper.UserMapper;
import com.bookstore.Trabalho.Programacao3.repository.UserFavoriteRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractUserFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


@Service
public class UserFavoriteServiceImpl implements AbstractUserFavorite<UserFavoriteResponse> {


    @Autowired
    private UserFavoriteRepository favoriteRepository;



    @Override
    public UserFavoriteResponse findUserFavoriteById(String userFavoriteId) throws ChangeSetPersister.NotFoundException {
        return favoriteRepository.findById(userFavoriteId).map(FavoriteMapper::maptoDTO)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    @Override
    public UserFavoriteResponse createNewUserFavorite(UserFavoriteRequest dto) {
        UserFavoriteResponse response = new UserFavoriteResponse();
        response.setUserId(dto.getUserId());
        response.addBook(dto.getBook());
        favoriteRepository.save(FavoriteMapper.mapToModel(response));
        return response;
    }

    @Override
    public UserFavoriteResponse updateUserById(FavoriteRequest request,UserFavoriteRequest favoriteRequest)
            throws ChangeSetPersister.NotFoundException {

        UserFavoriteResponse search = findUserFavoriteById(request.getFavoriteId());
        if(request.isRemoveItem() == false){
            search.addBook(favoriteRequest.getBook());

        }else {
            search.removeBook(request.getPosition());
        }
        return search;
    }


    @Override
    public void deleteFavorites(String favoriteId)
            throws ChangeSetPersister.NotFoundException {
        findUserFavoriteById(favoriteId);
        favoriteRepository.deleteById(favoriteId);
    }
}

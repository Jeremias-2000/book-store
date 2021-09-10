package com.bookstore.Trabalho.Programacao3.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class FavoriteRequest {

    private String favoriteId;
    @Min(value = 0)
    private  int position;
    private boolean removeItem;
}

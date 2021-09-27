package com.bookstore.Trabalho.Programacao3.dto.request;


import com.bookstore.Trabalho.Programacao3.enums.BookGenre;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest  {

    private String bookId;

    @NotBlank(message = "Nome do livro não informado")
    private String imageUrl;
    @NotBlank(message = "Nome do livro não informado")
    private String name;
    @NotBlank(message = "deve possuir alguma descrição")
    private String description;
    @NotNull
    private BookGenre genre;
    @NotBlank(message = "autor do livro não informado")
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate launchData;
    @NotNull
    private double price;
    @NotNull
    private int quantity;

}

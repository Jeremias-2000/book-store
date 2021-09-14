package com.bookstore.Trabalho.Programacao3.service.cep;

import com.bookstore.Trabalho.Programacao3.document.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="viacep",url = "https://viacep.com.br/ws")
public interface ViaApiService {
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep")String cep);
}

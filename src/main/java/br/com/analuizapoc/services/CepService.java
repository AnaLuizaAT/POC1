package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.responses.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface CepService {

    @GetMapping("/{cep}/json")
    AddressResponse getCep(@PathVariable("cep") String cep);
}
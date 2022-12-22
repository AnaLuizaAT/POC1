package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.AddressRequest;
import br.com.analuizapoc.entities.AddressEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AddressService {

    AddressEntity save(AddressRequest addressRequest, String cep);

    AddressEntity findById(UUID id);

    AddressEntity updateById(UUID id, AddressRequest addressRequest);

    void deleteById(UUID id);
}
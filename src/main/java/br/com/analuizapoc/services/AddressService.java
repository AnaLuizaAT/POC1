package br.com.analuizapoc.services;

import br.com.analuizapoc.controllers.requests.AddressRequest;
import br.com.analuizapoc.entities.AddressEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AddressService {
    void deleteById(UUID id);

    AddressEntity findById(UUID id);

    AddressEntity save(AddressRequest addressRequest, String cep, UUID id);

    AddressEntity updateById(UUID id, AddressRequest addressRequest);
}
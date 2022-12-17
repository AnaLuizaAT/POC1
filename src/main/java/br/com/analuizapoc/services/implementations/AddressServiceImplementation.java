package br.com.analuizapoc.services.implementations;

import br.com.analuizapoc.controllers.mappers.AddressMapper;
import br.com.analuizapoc.controllers.requests.AddressRequest;
import br.com.analuizapoc.controllers.responses.AddressResponse;
import br.com.analuizapoc.entities.AddressEntity;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.repositories.AddressRepository;
import br.com.analuizapoc.services.AddressService;
import br.com.analuizapoc.services.CepService;
import br.com.analuizapoc.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressServiceImplementation implements AddressService, CepService {

    private final AddressMapper mapper;
    private final CepService cepService;
    private final UserService userService;
    private final AddressRepository addressRepository;


    public AddressEntity findById(UUID id) {
        return null;
    }

    public void deleteById(UUID id) {
        //deleteById
    }

    public AddressResponse getCep(@PathVariable String cep) {
        return cepService.getCep(cep);
    }

    public AddressEntity updateById(UUID id, AddressRequest addressRequest) {
        return null;
    }

    public AddressEntity save(AddressRequest addressRequest, String cep, UUID id) {
        AddressResponse addressResponse = cepService.getCep(cep);
        UserEntity userEntity = userService.findById(addressRequest.getUserId());
        AddressEntity addressEntity = mapper.toEntity(addressResponse, addressRequest, userEntity);
        return addressRepository.save(addressEntity);
    }
}
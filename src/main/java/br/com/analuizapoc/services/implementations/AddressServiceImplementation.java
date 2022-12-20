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

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressServiceImplementation implements AddressService, CepService {

    private final AddressMapper mapper;
    private final CepService cepService;
    private final UserService userService;
    private final AddressRepository addressRepository;


    public void deleteById(UUID id) {
        addressRepository.deleteById(id);
    }

    public AddressEntity findById(UUID id) {
        return addressRepository.getReferenceById(id);
    }

    public AddressResponse getCep(@PathVariable String cep) {
        return cepService.getCep(cep);
    }

    public AddressEntity updateById(UUID id, AddressRequest addressRequest) {
        AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(RuntimeException::new);
        return addressRepository.save(AddressMapper.toUpdateAddress(addressRequest, addressEntity));
    }

    public AddressEntity save(AddressRequest addressRequest, String cep, AddressEntity addressEntity) {
        AddressResponse addressResponse = cepService.getCep(cep);
        UserEntity userEntity = userService.findById(addressRequest.getUserId());
        AddressEntity toEntity = mapper.toEntity(addressResponse, addressRequest, userEntity);
        limitAddressesValidation(userEntity);
        toEntity.setMainAddress(true);
        return addressRepository.save(toEntity);
    }

    public void limitAddressesValidation(UserEntity userEntity) {
        List<AddressEntity> addressEntities = addressRepository.findByUserOrderByDateCreated(userEntity);
        addressEntities.forEach(addressEntity -> addressEntity.setMainAddress(false));
        addressRepository.saveAllAndFlush(addressEntities);
        if (addressEntities.size() >= 5) {
            addressRepository.delete(addressEntities.get(0));
        }
    }
}
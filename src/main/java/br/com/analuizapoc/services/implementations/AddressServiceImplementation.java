package br.com.analuizapoc.services.implementations;

import br.com.analuizapoc.controllers.mappers.AddressMapper;
import br.com.analuizapoc.controllers.requests.AddressRequest;
import br.com.analuizapoc.controllers.responses.AddressResponse;
import br.com.analuizapoc.entities.AddressEntity;
import br.com.analuizapoc.entities.UserEntity;
import br.com.analuizapoc.enums.Errors;
import br.com.analuizapoc.exceptions.MainAddressException;
import br.com.analuizapoc.exceptions.NotFoundException;
import br.com.analuizapoc.repositories.AddressRepository;
import br.com.analuizapoc.repositories.UserRepository;
import br.com.analuizapoc.services.AddressService;
import br.com.analuizapoc.services.CepService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressServiceImplementation implements AddressService {

    private final AddressMapper mapper;
    private final CepService cepService;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public AddressEntity save(AddressRequest addressRequest, String cep) {
        AddressResponse addressResponse = cepService.getCep(cep);
        UserEntity userEntity = userRepository.findById(addressRequest.getUserId()).orElseThrow(() ->
                new NotFoundException(Errors.PC101.getMessage(),
                        Errors.PC101.getCode()));
        AddressEntity toEntity = mapper.toEntity(addressResponse, addressRequest, userEntity);
        limitAddressValidation(userEntity, addressRequest);
        toEntity.setMainAddress(addressRequest.getIsMain());
        return addressRepository.save(toEntity);
    }

    public AddressEntity findById(UUID id) {
        return addressRepository.getReferenceById(id);
    }

    public AddressEntity updateById(UUID id, AddressRequest addressRequest) {
        AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(() ->
                new NotFoundException(Errors.PC201.getMessage(),
                        Errors.PC201.getCode()));
        mainAddressesValidation(addressEntity, addressRequest);
        return addressRepository.save(AddressMapper.toUpdateAddress(addressRequest, addressEntity));
    }

    public void deleteById(UUID id) {
        if (Boolean.TRUE.equals(findById(id).getMainAddress())) {
            throw new MainAddressException(Errors.PC202.getMessage(), Errors.PC202.getCode());
        }
        addressRepository.deleteById(id);
    }

    public void limitAddressValidation(UserEntity userEntity, AddressRequest addressRequest) {
        List<AddressEntity> addressEntities = addressRepository.findByUserOrderByDateCreated(userEntity);
        if (addressEntities.isEmpty()) {
            addressRequest.setIsMain(true);
        } else {
            if (addressEntities.size() == 5) {
                int index = Boolean.TRUE.equals(addressEntities.get(0).getMainAddress()) ? 1 : 0;
                addressRepository.delete(addressEntities.get(index));
            }
        }
    }

    public void mainAddressesValidation(AddressEntity addressEntity, AddressRequest addressRequest) {
        List<AddressEntity> addressEntities = addressRepository.findByUserOrderByDateCreated(addressEntity.getUser());
        if (Boolean.TRUE.equals(addressRequest.getIsMain())) {
            addressEntities.forEach(address -> address.setMainAddress(false));
            addressRepository.saveAllAndFlush(addressEntities);
        } else if (Boolean.TRUE.equals(addressEntity.getMainAddress())) {
            throw new MainAddressException(Errors.PC202.getMessage(), Errors.PC202.getCode());
        }
    }
}
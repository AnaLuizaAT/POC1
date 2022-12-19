package br.com.analuizapoc.controllers.mappers;

import br.com.analuizapoc.controllers.requests.AddressRequest;
import br.com.analuizapoc.controllers.responses.AddressResponse;
import br.com.analuizapoc.entities.AddressEntity;
import br.com.analuizapoc.entities.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AddressMapper {
    public AddressEntity toEntity(AddressResponse addressResponse, AddressRequest addressRequest, UserEntity userEntity) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCep(addressResponse.getCep());
        addressEntity.setCity(addressResponse.getCity());
        addressEntity.setState(addressResponse.getState());
        addressEntity.setNumber(addressRequest.getNumber());
        addressEntity.setStreet(addressResponse.getStreet());
        addressEntity.setComplement(addressResponse.getComplement());
        addressEntity.setNeighborhood(addressResponse.getNeighborhood());
        addressEntity.setUser(userEntity);
        return addressEntity;
    }

    public static AddressResponse toAddressDto(AddressEntity addressEntity) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(addressEntity.getId());
        addressResponse.setCep(addressEntity.getCep());
        addressResponse.setCity(addressEntity.getCity());
        addressResponse.setState(addressEntity.getState());
        addressResponse.setStreet(addressEntity.getStreet());
        addressResponse.setNumber(addressEntity.getNumber());
        addressResponse.setUserId(addressEntity.getUser().getId());
        addressResponse.setComplement(addressEntity.getComplement());
        addressResponse.setDateUpdated(addressEntity.getDateUpdated());
        addressResponse.setMainAddress(addressEntity.getMainAddress());
        addressResponse.setDateCreated(addressEntity.getDateCreated());
        addressResponse.setNeighborhood(addressEntity.getNeighborhood());
        return addressResponse;
    }
}
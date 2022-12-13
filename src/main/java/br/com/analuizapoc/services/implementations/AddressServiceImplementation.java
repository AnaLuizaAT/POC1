package br.com.analuizapoc.services.implementations;

import br.com.analuizapoc.configuration.AddressMapper;
import br.com.analuizapoc.repositories.AddressRepository;
import br.com.analuizapoc.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImplementation implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
}
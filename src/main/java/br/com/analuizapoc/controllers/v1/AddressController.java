package br.com.analuizapoc.controllers.v1;

import br.com.analuizapoc.controllers.requests.AddressRequest;
import br.com.analuizapoc.controllers.responses.AddressResponse;
import br.com.analuizapoc.entities.AddressEntity;
import br.com.analuizapoc.services.AddressService;
import br.com.analuizapoc.services.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static br.com.analuizapoc.controllers.mappers.AddressMapper.toAddressDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/addresses")
public class AddressController {

    private final AddressService addressService;
    private final CepService cepService;

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse getAddress(@PathVariable String cep) {
        return cepService.getCep(cep);
    }

    @PostMapping("/{cep}")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse save(@Valid @RequestBody AddressRequest addressRequest, @PathVariable String cep, AddressEntity addressEntity) {
        return toAddressDto(addressService.save(addressRequest, cep, addressEntity));
    }
}
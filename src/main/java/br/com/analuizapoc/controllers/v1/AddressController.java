package br.com.analuizapoc.controllers.v1;

import br.com.analuizapoc.controllers.requests.AddressRequest;
import br.com.analuizapoc.controllers.responses.AddressResponse;
import br.com.analuizapoc.entities.AddressEntity;
import br.com.analuizapoc.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static br.com.analuizapoc.controllers.mappers.AddressMapper.toAddressDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/{cep}")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse save(@Valid @RequestBody AddressRequest addressRequest, @PathVariable String cep, AddressEntity addressEntity) {
        return toAddressDto(addressService.save(addressRequest, cep, addressEntity));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AddressResponse findById(@PathVariable UUID id) {
        return toAddressDto(addressService.findById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        addressService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AddressResponse update(@PathVariable UUID id, @RequestBody AddressRequest addressRequest) {
        return toAddressDto(addressService.updateById(id, addressRequest));
    }
}
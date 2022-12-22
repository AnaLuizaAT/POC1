package br.com.analuizapoc.enums;

import br.com.analuizapoc.validations.CnpjGroup;
import br.com.analuizapoc.validations.CpfGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserEnum {

    PF("000.000.000-00", CpfGroup.class),
    PJ("00.000.000/0000-00", CnpjGroup.class);

    private final String mask;
    private final Class<?> group;
}
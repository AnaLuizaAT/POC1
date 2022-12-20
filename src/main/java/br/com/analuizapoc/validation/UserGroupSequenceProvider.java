package br.com.analuizapoc.validation;

import br.com.analuizapoc.controllers.requests.UserRequest;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class UserGroupSequenceProvider implements DefaultGroupSequenceProvider<UserRequest> {

    public List<Class<?>> getValidationGroups(UserRequest userRequest) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(UserRequest.class);
        if (isSelectedPerson(userRequest)) {
            groups.add(userRequest.getDocumentType().getGroup());
        }
        return groups;
    }
    protected boolean isSelectedPerson(UserRequest userRequest) {
        return userRequest != null && userRequest.getDocumentType() != null;
    }
}

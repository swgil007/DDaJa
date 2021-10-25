package com.bng.ddaja.users.dto;

import com.bng.ddaja.common.domain.User;
import com.bng.ddaja.common.dto.CommonSearch;
import com.bng.ddaja.common.spec.SpecBuilder;

import org.springframework.data.jpa.domain.Specification;
import static com.bng.ddaja.users.spec.UserSpec.*;
import static org.springframework.data.jpa.domain.Specification.where;

public class UserSearch extends CommonSearch {
    
    private String nickName;
    private long id;
    private String eMail;

    @Override
    public Specification<User> toSpecification() {
        return SpecBuilder.builder(User.class)
                            .addSpec(where(nickNameLike(nickName)))
                            .addSpec(where(idEqual(id)))
                            .addSpec(where(eMailLike(eMail)))
                .toSpecification();
    }
}

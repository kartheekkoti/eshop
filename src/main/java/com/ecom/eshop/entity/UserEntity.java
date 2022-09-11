package com.ecom.eshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class UserEntity {

    @Id
    @Field("id")
    private String id;

    @Field("name")
    private String name;

    @Field("username")
    private String userName;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    private Set<RoleEntity> roles;


}

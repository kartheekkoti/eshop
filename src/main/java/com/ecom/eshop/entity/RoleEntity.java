package com.ecom.eshop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("roles")
public class RoleEntity {
    @Id
    @Field("id")
    private String id;

    @Field("roleName")
    private RoleName roleName;
}

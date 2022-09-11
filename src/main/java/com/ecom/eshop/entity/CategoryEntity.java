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
@Document("categories")
public class CategoryEntity {

    @Id
    @Field("_id")
    private String id;
    @Field("name")
    private String name;
    @Field("icon")
    private String icon;
    @Field("color")
    private String color;
}

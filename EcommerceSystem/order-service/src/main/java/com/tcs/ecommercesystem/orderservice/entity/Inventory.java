package com.tcs.ecommercesystem.orderservice.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
@Builder
public class Inventory {
    @Id
    String id;
    String name;
}
package com.example.caffix.DBconfig.payload.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;

    private String phoneNumber;

    private Float locationLongitude;

    private Float locationlatitude;

    private Long chatId;
}

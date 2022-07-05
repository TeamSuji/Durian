package com.example.durian.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetUserRes {
    private String name;
    private String nickName;
    private String email;
    private String phone;
}

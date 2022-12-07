package com.demo.user.service.VO;


import com.demo.user.service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {

    private User user;
    private Department department;
}

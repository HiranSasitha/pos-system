package com.sprinbootacademy.pointofsale.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StandardResponse {
    private Integer code;
    private String massage;
    private Object data;
}

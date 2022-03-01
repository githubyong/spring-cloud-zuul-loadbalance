package com.yong.lr;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVo implements Serializable {
    private long id;
    private long userid;
    private String name;
    private long price;
}

package com.example.demo.pojo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author MakiYO
 * @create 2021/3/6
 */
//TODO
@Component
@Scope("prototype")
@Data
public class Commodity {
    private int cId;
    private String cName;
    private String c;
}

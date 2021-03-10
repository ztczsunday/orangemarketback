package com.orangeSoft.market.pojo.extend;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class ResultInfo {
    private Integer statusCode;
    private String hint;
}

package com.orangeSoft.market.pojo;

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
public class User {
    private int uid;
    private String uPassword;
    private String uAlipayAccount;
    private String uName;
    private String uGender;
    private String uTel;
    private String uEmail;
    private String uSelfie;
    private String uLicense;
    private String uSignature;
}

package com.orangeSoft.market.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 管理员专用账户
 * </p>
 *
 * @since 2021-03-13
 */
@Data
@EqualsAndHashCode
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    private String managerAccount;

    private String managerPassword;


}

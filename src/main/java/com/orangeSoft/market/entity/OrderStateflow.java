package com.orangeSoft.market.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @since 2021-03-13
 */
@Data
@EqualsAndHashCode
public class OrderStateflow implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;

    private Long recordId;

    private LocalDateTime statusDate;


}

package com.orangeSoft.market.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @since 2021-03-13
 */
@Data
@EqualsAndHashCode
public class Footprint implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cid;

    private Integer uid;

    private LocalDate lastBrowserDate;


}

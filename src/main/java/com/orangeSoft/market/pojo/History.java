package com.orangeSoft.market.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class History {
    private Long cid;
    private Integer sid;
    private String commodityName;
    /**
     * 为0表示被下架，1表示可出售
     */
    private Boolean commodityStatus;
    private String mainIcon;
    private Integer commentCount;
    private Integer praiseCommentCount;
    private LocalDateTime lastBrowserDate;
}

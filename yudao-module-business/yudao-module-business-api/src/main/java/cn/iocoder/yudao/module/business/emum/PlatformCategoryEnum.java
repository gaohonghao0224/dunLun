package cn.iocoder.yudao.module.business.emum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 平台类别 Enum
 *
 * @author gaohonghao
 */

@Getter
@AllArgsConstructor
public enum PlatformCategoryEnum {

    /**
     * 美团
     */
    MEITUAN(1),
    /**
     * 饿了么
     */
    ELEME(2),
    /**
     * 京东
     */
    JINGDONG(3);

    private final Integer val;

}

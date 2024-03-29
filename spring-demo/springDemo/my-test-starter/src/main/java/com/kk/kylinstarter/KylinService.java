package com.kk.kylinstarter;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-09- 11:32:00
 */
//要自动配置的类
public class KylinService {

    private static KylinProperties kylinProperties;

    public KylinService(KylinProperties kylinProperties) {
        KylinService.kylinProperties = kylinProperties;
    }

    //外部调用
    public KylinProperties getKylinProperties() {
        return kylinProperties;
    }
}

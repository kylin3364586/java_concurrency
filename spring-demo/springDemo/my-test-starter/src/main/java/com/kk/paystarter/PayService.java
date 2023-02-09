package com.kk.paystarter;


/**
 * 需要装载的配置类
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-09- 15:19:00
 */
public class PayService {

    private static PayProperties payProperties;

    public PayService(PayProperties payProperties) {
        PayService.payProperties = payProperties;
    }

    //外部调用
    public static PayProperties getPayProperties() {
        return payProperties;
    }
}

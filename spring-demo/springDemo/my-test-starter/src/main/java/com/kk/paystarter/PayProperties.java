package com.kk.paystarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置文件
 *      可通过yml文件修改属性值
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2023-02-09- 15:10:00
 */
@ConfigurationProperties(prefix = "my.pay")
public class PayProperties {

    public String appId;

    public String aliPayPrivateKey;

    public String aliPayPublicKey;

    public String notifyUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAliPayPrivateKey() {
        return aliPayPrivateKey;
    }

    public void setAliPayPrivateKey(String aliPayPrivateKey) {
        this.aliPayPrivateKey = aliPayPrivateKey;
    }

    public String getAliPayPublicKey() {
        return aliPayPublicKey;
    }

    public void setAliPayPublicKey(String aliPayPublicKey) {
        this.aliPayPublicKey = aliPayPublicKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "PayProperties{" +
                "appId='" + appId + '\'' +
                ", aliPayPrivateKey='" + aliPayPrivateKey + '\'' +
                ", aliPayPublicKey='" + aliPayPublicKey + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
}

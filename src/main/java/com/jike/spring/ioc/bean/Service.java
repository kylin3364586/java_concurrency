package com.jike.spring.ioc.bean;

import lombok.Data;

/**
 * @author kylin
 * @version 1.0.0
 * @Description
 * @createTime 2022年05月07日 17:03:00
 */
@Data
public class Service {
    private MongoService mongoService;
    private MysqlService mysqlService;

}

class MongoService {

}

class MysqlService {

}
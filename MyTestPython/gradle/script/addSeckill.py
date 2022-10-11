#批量增加秒杀活动商品

import pymysql
import datetime
import time
from SnowflakeUtils import IdWorker

#db = pymysql.connect(host='192.168.20.47', port=3306, user='root', passwd='Rchz2020@', db='test-yijia-app', charset='utf8')
# db = pymysql.connect(host='192.168.20.49', port=3306, user='root', passwd='root', db='test-yijia-app', charset='utf8')
db = pymysql.connect(host='rm-2vc99x9o7xju5iy1uro.mysql.cn-chengdu.rds.aliyuncs.com', port=3306, user='yjroot', passwd='Rchz2020@', db='test-yijia-app', charset='utf8')

cursor = db.cursor()

sql = "select * from t_seckill order by start_time desc limit 8"
cursor.execute(sql)

lists = cursor.fetchall()

worker = IdWorker(1, 1, 0)

for row in lists:
    #id
    get_id = worker.get_id()
    #加1天
    timedelta = datetime.timedelta(days=2)
    #开始时间
    add1DayStart = row[2] + timedelta
    #结束时间
    add1DayEnd = row[3] + timedelta

    sql = "insert into t_seckill " \
          "(id,sku_id,start_time,end_time,start_stock,stock,description,create_id,update_id,create_time,update_time,is_deleted) " \
          "values" \
          "(%s ,%s ,%s ,%s ,%s ,%s ,%s ,%s ,%s ,%s ,%s ,%s)"

    val = (get_id,
           row[1],
           add1DayStart,
           add1DayEnd,
           row[4],
           row[5],
           row[6],
           row[7],
           row[8],
           row[9],
           row[10],
           row[11])
    cursor.execute(sql,val)
    db.commit()

cursor.close()
# 关闭连接
db.close()

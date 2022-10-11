#商品规格去重

import requests
import pymysql
import json

db = pymysql.connect(host='192.168.20.49', port=3306, user='root', passwd='root', db='test-yijia-app', charset='utf8')
# db = pymysql.connect(host='192.168.20.49', port=3306, user='root', passwd='root', db='test-yijia-app', charset='utf8')
# db = pymysql.connect(host='rm-2vc99x9o7xju5iy1uro.mysql.cn-chengdu.rds.aliyuncs.com', port=3306, user='yjroot', passwd='Rchz2020@', db='test-yijia-app', charset='utf8')

cursor = db.cursor()

cursor.execute("select version()")
data = cursor.fetchone()
print("Database Version:%s" % data)

get_sql = "select * from yj_product"
cursor.execute(get_sql)
lists = cursor.fetchall()  # 取多条数据
print(len(lists))  ##数据总行数
for row in lists:

    row_ = row[16]
    # print(row_)
    #拿到规格
    gg = row_[46: len(row_)-3]
    # print(gg)
    #转数组
    split = gg.split(',')
    # print(split)
    #去重
    list2 = list(set(split))
    # print(list2)

    join = ','.join(list2)
    # print(join)
    #替换
    replace = row_.replace(gg, join)
    # print(replace)


    #------------------
    replace2 = None
    row_2 = row[15]
    # print(row_2)
    if row_2 is not None:
        spec = row_2[23: len(row_2)-3]
        split2 = spec.split(',')
        list3 = list(set(split2))
        join2 = ','.join(list3)
        replace2 = row_2.replace(spec, join2)
        # print(replace2)

    # 拿到spu id
    row_1 = row[0]
    # 更新到数据库
    sql = "update yj_product set para_items='" + str(replace) + "',spec_items='" + str(replace2) + "'where id=" + str(row_1)

    execute = cursor.execute(sql)
    if execute == 1:
        print(row_1)
    # print(sql)
    # execute = cursor.execute(sql)
    # db.commit()
    # continue


cursor.close()
# 关闭连接
db.close()

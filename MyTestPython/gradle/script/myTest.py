print("更新图片宽高")
# help('modules')
# 导入模块
import requests
import pymysql
import json



# 创建数据库连接
db = pymysql.connect(host='192.168.20.47', port=3306, user='root', passwd='Rchz2020@', db='test-yijia-app', charset='utf8')
# db = pymysql.connect(host='192.168.20.49', port=3306, user='root', passwd='root', db='test-yijia-app', charset='utf8')

# 使用cursor方法创建一个游标
cursor = db.cursor()

# 查询数据库版本
cursor.execute("select version()")
data = cursor.fetchone()
print("Database Version:%s" % data)

# 查询操作
sql = "select * from yj_spu_waterfall"
cursor.execute(sql)
# data = cursor.fetchone()  # 获取单条数据
# # 输出结果
# SqlDomain = cursor.description
# DomainNum = len(SqlDomain)
# # 字段数
# # print(DomainNum)
#
# SqlDomainName = [None] * DomainNum
#
# for i in range(DomainNum):
#     SqlDomainName[i] = SqlDomain[i][0]
#     print(SqlDomainName[i], end=", ")
#     # print(SqlDomainName[i])  ##输出列名
#
# print("\n")
lists = cursor.fetchall()  # 取多条数据
print(len(lists))  ##数据总行数
for row in lists:
    row_ = row[5]
    if None is row_ or 0 == len(row_):
        print(row)
        url_ = row[1]
        url = "https://pic-zhijia-qiniu.zhijiapt.com/"+url_+"?imageInfo"
        requests_get = requests.get(url)
        json_loads = json.loads(requests_get.text)

        width_ = json_loads["width"]
        height_ = json_loads["height"]
        id_ = row[0]
        print("未查询到宽高的图片：" + str(id_) + ", " + str(width_) + ", " + str(height_))

        # 更新宽高到数据库
        sql = "update yj_spu_waterfall set width=" + str(width_) + ",height=" + str(height_) + " where id=" + str(id_)
        print(sql)
        cursor.execute(sql)
        db.commit()
        continue
    # print(row[5], end=", ")
    # print(row[6])

cursor.close()
# 关闭连接
db.close()

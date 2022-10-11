# 电棍充值总额
import json

# filename = 'D:\\ide_workspace\\MyTestPython\\gradle\\recharge\\recharge.json'
filename = 'D:\\ide_workspace\\MyTestPython\\gradle\\recharge\\11.json'
with open(filename, 'r', encoding='utf-8') as fp:
    json_data = json.load(fp)
    print('json中的数据：', json_data)

amount: int = 0
count: int = 0
for data in json_data['data']:
    print(data)
    price: int = data['price']
    amount += price
    count += 1
print("充值总额：", amount , "充值条数：", count)
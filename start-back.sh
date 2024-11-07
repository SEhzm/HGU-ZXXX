#!/usr/bin/bash
# 启动jar包运行
# 教学系统  启动文件

mvn clean package -Dmaven.test.skip=true >> zxxx-admin.log
echo "项目打包成功"

nohup java -Dfile.encoding=UTF-8 -Dspring.profiles.active=prod -jar ./zxxx-admin/target/zxxx-admin.jar >> zxxx-admin.log 2>&1 &
echo "项目启动成功"

@echo off
::ת����ǰ�̷�
%~d0
::�򿪵�ǰĿ¼
cd %~dp0
::��������JAR����·��
set MainJar=c1wanane.jar
::������JAR����·��
set jar1=SDK_C1wan_2.0.1.jar
set jar2=android_api.jar
::������JAR������������
set packageName1=com
set packageName2=wxd
echo =========== start combin ==============
::��ѹ��������
jar -xf %jar1%
jar -xf %jar2%
::�ϲ���JAR��
jar -uf %MainJar% %packageName1% 
::������б�Ķ��������Խ��źϲ������磺
jar -uf %MainJar% %packageName2%
echo =========== over ==============
echo �ٵ�һ�¾ͽ�����--СQ
pause
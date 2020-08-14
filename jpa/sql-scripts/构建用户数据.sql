# 注意:检查 数据表与存储过程 字段 是否存在变化,若存在作出相应变更即可

-------------------存储过程创建百万级测试数据:While 与 Loop 采用一种方式即可---------------------
/**数据表**/
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for learn_user
-- ----------------------------
DROP TABLE IF EXISTS `learn_user`;
CREATE TABLE `learn_user` (
  `user_id` bigint(20) NOT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `creator` varchar(20) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `modifier` varchar(20) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `modify_time` datetime(6) DEFAULT NULL,
  `pass_word` varchar(32) COLLATE utf8mb4_german2_ci NOT NULL,
  `user_name` varchar(10) COLLATE utf8mb4_german2_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

SET FOREIGN_KEY_CHECKS = 1;

/** while **/
DROP PROCEDURE
IF
	EXISTS createLearnUser;
CREATE PROCEDURE createLearnUser ( IN inputParamNum INT ) BEGIN
DECLARE
	i INT;

SET i = 1;
WHILE  /** while:执行前检查条件是否满足; repeat:执行后检查条件是否满足; **/
	i < inputParamNum DO
	INSERT INTO learn_user ( user_id, user_name, pass_word )
VALUES
	( UUID(), userName(), MD5("123456") );

SET i = i + 1;

END WHILE;
END;

DELETE FROM LEARN_USER;
CALL CREATELEARNUSER ( 100 );
SELECT * FROM LEARN_USER;
SHOW PROCEDURE STATUS;


/** Loop **/
DROP PROCEDURE
IF
	EXISTS createLearnUserLoop;
CREATE PROCEDURE createLearnUserLoop ( IN inputParamNum INT ) BEGIN
	DECLARE
		i INT;

	SET i = 1;
	loop_lable : LOOP /** 循环内部加入了IF……END IF语句，在IF语句中又加入了LEAVE语句，LEAVE语句的意思是离开循环, loop_label:循环标号 **/
			INSERT INTO learn_user ( user_id, user_name, pass_word )
		VALUES
			( UUID(), userName(), MD5( "123456" ) );

		SET i = i + 1;
		IF i > inputParamNum THEN LEAVE loop_lable;

	END IF;

END LOOP loop_lable;

END;

DELETE FROM LEARN_USER;
CALL createLearnUserLoop ( 1000000 );
SELECT * FROM LEARN_USER;


/**创建随机编号生成函数**/
DROP FUNCTION IF EXISTS id;
# 创建一个指定字符个数的函数
CREATE FUNCTION id ( )
# 返回字符串 注意: 此处关键字是returns 而不是return
RETURNS INT ( 5 )
BEGIN
	DECLARE
		i INT DEFAULT 0;

	SET i = FLOOR(1+ RAND( ) * 1000 );
	RETURN i;

	END;

/**创建随机姓名生成函数**/
DROP FUNCTION IF EXISTS userName;
CREATE FUNCTION userName() RETURNS VARCHAR(255)
BEGIN
  DECLARE xing varchar(2056) DEFAULT '赵钱孙李周郑王冯陈楮卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闽席季麻强贾路娄危江童颜郭梅盛林刁锺徐丘骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁';
	DECLARE ming varchar(2056) DEFAULT '嘉懿煜城懿轩烨伟苑博伟泽熠彤鸿煊博涛烨霖烨华煜祺智宸正豪昊然明杰诚立轩立辉峻熙弘文熠彤鸿煊烨霖哲瀚鑫鹏致远俊驰雨泽烨磊晟睿天佑文昊修洁黎昕远航旭尧鸿涛伟祺轩越泽浩宇瑾瑜皓轩擎苍擎宇志泽睿渊楷瑞轩弘文哲瀚雨泽鑫磊梦琪忆之桃慕青问兰尔岚元香初夏沛菡傲珊曼文乐菱痴珊恨玉惜文香寒新柔语蓉海安夜蓉涵柏水桃醉蓝春儿语琴从彤傲晴语兰又菱碧彤元霜怜梦紫寒妙彤曼易南莲紫翠雨寒易烟如萱若南寻真晓亦向珊慕灵以蕊寻雁映易雪柳孤岚笑霜海云凝天沛珊寒云冰旋宛儿绿真盼儿晓霜碧凡夏菡曼香若烟半梦雅绿冰蓝灵槐平安书翠翠风香巧代云梦曼幼翠友巧听寒梦柏醉易访旋亦玉凌萱访卉怀亦笑蓝春翠靖柏夜蕾冰夏梦松书雪乐枫念薇靖雁寻春恨山从寒忆香觅波静曼凡旋以亦念露芷蕾千兰新波代真新蕾雁玉冷卉紫山千琴恨天傲芙盼山怀蝶冰兰山柏翠萱乐丹翠柔谷山之瑶冰露尔珍谷雪乐萱涵菡海莲傲蕾青槐冬儿易梦惜雪宛海之柔夏青亦瑶妙菡春竹修杰伟诚建辉晋鹏天磊绍辉泽洋明轩健柏煊昊强伟宸博超君浩子骞明辉鹏涛炎彬鹤轩越彬风华靖琪明诚高格光华国源宇晗昱涵润翰飞翰海昊乾浩博和安弘博鸿朗华奥华灿嘉慕坚秉建明金鑫锦程瑾瑜鹏经赋景同靖琪君昊俊明季同开济凯安康成乐语力勤良哲理群茂彦敏博明达朋义彭泽鹏举濮存溥心璞瑜浦泽奇邃祥荣轩';

	DECLARE l_xing int DEFAULT LENGTH(xing)/3; /** 这里的长度不是字符串的字数,而是此字符串的占的容量大小,一个汉字占3个字节 **/
	DECLARE l_ming int DEFAULT LENGTH(ming)/3;
	DECLARE return_str varchar(255) DEFAULT '';

	# 先选出姓
	SET return_str = CONCAT(return_str, SUBSTRING(xing, FLOOR(1 + RAND() * l_xing), 1));
	# 再选出名
	SET return_str = CONCAT(return_str, SUBSTRING(ming, FLOOR(1 + RAND() * l_ming), 1));
	IF RAND()>0.400 THEN
  #再选出名
	SET return_str = CONCAT(return_str, SUBSTRING(ming, FLOOR(1 + RAND() * l_ming), 1));
	END IF;
	RETURN return_str;
END;







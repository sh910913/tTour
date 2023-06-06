DROP DATABASE IF EXISTS `ttour`;
CREATE DATABASE `ttour` DEFAULT CHARSET=utf8;  /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS `ttour`.`members`;
CREATE TABLE  `ttour`.`members` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  `email` varchar(40) NOT NULL,
  `gender` char(1) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_Unique_Email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `ttour`.`members`
(`name`, `password`,`email`,`gender`, `phone`)
VALUES('張三豐', '123456', 'Sammul.chang@gmail.com', 'M', '0912155555');

DROP TABLE IF EXISTS `ttour`.`types`;
CREATE TABLE  `ttour`.`types` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO types VALUES('1','art');
INSERT INTO types VALUES('2','design');
INSERT INTO types VALUES('3','history');
INSERT INTO types VALUES('4','nature');
INSERT INTO types VALUES('5','outdoor');
INSERT INTO types VALUES('6','special');

DROP TABLE IF EXISTS `ttour`.`tours`;
CREATE TABLE  `ttour`.`toturs` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type_id` int(10) unsigned NOT NULL,
  `area` varchar(20) NOT NULL,
  `price` int(10) unsigned NOT NULL,
  `introduce` varchar(500) DEFAULT NULL,
  `purchase` varchar(250) DEFAULT NULL,
  `cost` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_toturs_type` (`type_id`),
  CONSTRAINT `FK_toturs_type` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tours VALUES('1','與大師細細品味藝術','1','台中市','1400','null','null','null');
INSERT INTO tours VALUES('2','藝術情感與記憶','1','台中市','1600','null','null','null');
INSERT INTO tours VALUES('3','世界珍藏袖珍藝術品之美','1','台北市','1800','null','null','null');
INSERT INTO tours VALUES('4','與達利藝術大師的約會','1','台中市','1800','null','null','null');
INSERT INTO tours VALUES('5','走進維諾瓦的藝術心境','1','高雄市','1800','null','null','null');
INSERT INTO tours VALUES('6','李小鏡人與獸的藝術','1','台中市','1200','null','null','null');
INSERT INTO tours VALUES('7','另一種目線 王信攝影展','1','高雄市','1200','null','null','null');
INSERT INTO tours VALUES('8','超潮攝影家','1','高雄市','1600','null','null','null');
INSERT INTO tours VALUES('9','台灣得獎建築設計巡禮','2','台中市','1600','null','null','null');
INSERT INTO tours VALUES('10','與建築師品嘗建築美學','2','台中市','1200','null','null','null');
INSERT INTO tours VALUES('11','台灣最後一家鑄字行帶你品味繁體字之美','2','台北市','1600','null','null','null');
INSERT INTO tours VALUES('12','踏入珠寶設計的發展史','2','新北市','1600','null','null','null');
INSERT INTO tours VALUES('13','知名室內設計師帶你深入居家設計','2','台中市','1200','null','null','null');
INSERT INTO tours VALUES('14','每個人的家與你想得不同','2','高雄市','1200','null','null','null');
INSERT INTO tours VALUES('15','一腳跨進建築殿堂','2','台北市','1400','null','null','null');
INSERT INTO tours VALUES('16','世界前五十大名椅鑑賞','2','台北市','1200','null','null','null');
INSERT INTO tours VALUES('17','大稻埕小旅行','3','台北市','1800','null','null','null');
INSERT INTO tours VALUES('18','戲遊大稻埕','3','台北市','1600','null','null','null');
INSERT INTO tours VALUES('19','艋舺萬華風情','3','台北市','1200','null','null','null');
INSERT INTO tours VALUES('20','壹玖肆柒 回到二二八','3','台北市','1200','null','null','null');
INSERT INTO tours VALUES('21','北投軼夢—闖進繁華歲月','3','台北市','1800','null','null','null');
INSERT INTO tours VALUES('22','新北投溫泉眷村的時代對話','3','台北市','1200','null','null','null');
INSERT INTO tours VALUES('23','北投發現溫泉之路','3','台北市','1600','null','null','null');
INSERT INTO tours VALUES('24','高雄 擁抱橋仔頭糖金時代','3','高雄市','1200','null','null','null');
INSERT INTO tours VALUES('25','乘著飛羽與自然共舞','4','宜蘭縣','1400','null','null','null');
INSERT INTO tours VALUES('26','挖掘自然界的鐵甲武士','4','宜蘭縣','1400','null','null','null');
INSERT INTO tours VALUES('27','市郊日間生態探索','4','花蓮縣','1800','null','null','null');
INSERT INTO tours VALUES('28','自然觀察昆蟲旅行家','4','花蓮縣','1200','null','null','null');
INSERT INTO tours VALUES('29','蜘蛛與昆蟲的愛恨糾葛','4','花蓮縣','1800','null','null','null');
INSERT INTO tours VALUES('30','跟著專家慧眼識鷹雄','4','屏東縣','1800','null','null','null');
INSERT INTO tours VALUES('31','尋找森林中的寶石','4','屏東縣','1600','null','null','null');
INSERT INTO tours VALUES('32','市郊賞鳥小旅行','4','高雄市','1200','null','null','null');
INSERT INTO tours VALUES('33','天然秘境野溪溫泉之旅','5','花蓮縣','1200','null','null','null');
INSERT INTO tours VALUES('34','只緣身在此山中','5','花蓮縣','1800','null','null','null');
INSERT INTO tours VALUES('35','探尋驚險大斷涯錐麗古道','5','花蓮縣','1200','null','null','null');
INSERT INTO tours VALUES('36','走上銀色浪花的旅程','5','新北市','1200','null','null','null');
INSERT INTO tours VALUES('37','草嶺古道銀芒飛舞','5','新北市','1200','null','null','null');
INSERT INTO tours VALUES('38','踏進蝙蝠棲息地','5','新北市','1200','null','null','null');
INSERT INTO tours VALUES('39','東北角祕境緩慢行','5','新北市','1800','null','null','null');
INSERT INTO tours VALUES('40','遊賞東北角奇境','5','新北市','1200','null','null','null');
INSERT INTO tours VALUES('41','南勢角緬甸華僑聚落','6','新北市','1600','null','null','null');
INSERT INTO tours VALUES('42','台北小印尼','6','台北市','1200','null','null','null');
INSERT INTO tours VALUES('43','一窺酒店秘辛：暗夜的台式酒店之旅','6','台北市','1800','null','null','null');
INSERT INTO tours VALUES('44','神的隨扈:神秘八家將','6','台南市','1800','null','null','null');
INSERT INTO tours VALUES('45','不是馬遠部落的客人，是朋友，一起聆聽悠揚杵音','6','花蓮縣','1400','null','null','null');
INSERT INTO tours VALUES('46','探訪台灣最大石板屋聚落 - 排灣族','6','屏東縣','1600','null','null','null');
INSERT INTO tours VALUES('47','回到眷村1945','6','高雄市','1600','null','null','null');
INSERT INTO tours VALUES('48','城市無間道','6','高雄市','1400','null','null','null');



DROP TABLE IF EXISTS `ttour`.`reviews`;
CREATE TABLE  `ttour`.`reviews` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `member_id` int(10) unsigned NOT NULL,
  `tour_id` int(10) unsigned NOT NULL,
  `review` varchar(250) DEFAULT NULL,
  `rating` int(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_reviews_member` (`member_id`),
  KEY `FK_reviews_tour` (`tour_id`),
  CONSTRAINT `FK_reviews_member` FOREIGN KEY (`member_id`) REFERENCES `members` (`id`),
  CONSTRAINT `FK_reviews_tour` FOREIGN KEY (`tour_id`) REFERENCES `toturs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
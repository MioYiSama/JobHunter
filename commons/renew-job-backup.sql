-- 修改版
--
-- 本题自由度较大，同学们可直接修改给出的表结构，能够服务于自己设计的功能即可
-- ------------------------------------------------------
-- MySQL建议使用8.0以上的版本

-- 创建employer表
DROP TABLE IF EXISTS `employer`;

CREATE TABLE `employer` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '招聘者编号',
  `name` varchar(50) NOT NULL COMMENT '招聘者姓名',
  `password` varchar(255) NOT NULL COMMENT '招聘者密码', -- 推荐长度更大，支持哈希密码存储
  `company` varchar(50) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) COMMENT='招聘者表';

LOCK TABLES `employer` WRITE;

INSERT INTO `employer` VALUES (1, 'Dragon Long', '123456', '龙神科技');

UNLOCK TABLES;


DROP TABLE IF EXISTS `position`;

-- 创建Position表
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `detail_company` varchar(50) DEFAULT NULL COMMENT '公司名称(可为分部)',
  `title` varchar(40) NOT NULL COMMENT '职位名称',
  `salary` varchar(12) DEFAULT NULL COMMENT '薪资范围',
  `education` enum('大专','本科','硕士','博士') NOT NULL COMMENT '学历要求',
  `description` text NOT NULL COMMENT '职位描述',
  `hiring_manager` varchar(10) NOT NULL COMMENT '招聘负责人',
  `last_active` DATETIME DEFAULT NULL COMMENT '最后活跃时间',
  `address` varchar(80) NOT NULL COMMENT '工作地点',
  `link` varchar(500) DEFAULT NULL COMMENT '职位链接',
  `eid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employer_position_fk` (`eid`),
  CONSTRAINT `employer_position_fk` FOREIGN KEY (`eid`) REFERENCES `employer` (`id`) ON DELETE CASCADE
) COMMENT='职位表';


LOCK TABLES `position` WRITE;

-- 此处添加的数据为默认系统创建时添加好的职位
INSERT INTO `position` VALUES (0,'龙神科技','【初级】web前端开发工程师','2-4K·13薪','大专','1.熟悉HTML5、JavaScript、CSS3;2.熟悉使用css3的flex/grid布局3.熟悉Less/Sass/Stylus预编译器其中一种;4.熟悉使用uni-app开发小程序;5.熟悉前端模块化，组件化开发;6.熟悉Vue及element UI;7.对前后端分离有实际经验;8.有项目经验者优先9.简历请附作品10.中山附近优先','梁先生','2周内活跃','中山广东倾云科技有限公司一层','https://www.zhipin.com/job_detail/2c08c111e75221011n1539S8EVVQ.html?lid=6GPZx3II9Bv.search.31&securityId=f1xZgMo04Kywv-u1CqKcTn5qoCHek_nDfH_HMLOZDR2U7UD6hrtSKuU33BsHCW7ByiFvb2dqc6C5mDevs78kfFXp601IBEUpA0Rr43wDm5o5vDLg5UeiSXzoNHZYpCYCdkPCHw5liZ3l&sessionId=', 1),
                              (1,'龙神科技','IT运维工程师','2-4K','大专','一、工作内容1、软件数据分析，月/季报告撰写2、软件平台学习，能够熟练讲解，在使用过程中能够提出后期优化的建议3、组装、安装电子产品，搭建调试网络4、设备、网络环境的定期巡检，运维5、项目技术方案的编写6、项目基础信息的现场采集，系统维护等7、软件平台的讲解，培训二、能力要求1、学习表达能力强，沟通能力好2、能够熟练使用办公软件，制作PPT. ps，CAD等软件3、懂编程，汇编语言，数据库等4、热爱IT高科技行业，关注行业动态，自我学习行业知识5、熟悉电脑配件、网络设备，网络配置等6、动手能力强，踏实有责任心，做事有思路有规划三、其他优先说明条件1、有驾照，会开车2、多才多艺3、励志衡水发展，4、实习生如应聘成功，工作期间如表现良好毕业后可签正式合同','刘向宇','刚刚活跃','衡水桃城区众成大厦2407','https://www.zhipin.com/job_detail/8095129b424286831Xx53961FVZU.html?lid=6GPZx3II9Bv.search.32&securityId=nsR9uHW5KATNR-B1MwopcU4Cox09HgFQN4uLvMVSQcN4wzu3H8vtcumS5hrbqfvoWm6DJdxOUTlhqcVqfzOanS4FMI2XFoeSiNwmBQj1wYKcT2pOs9SMz_DXoK6K34YEnC3ZEG8RtcZC&sessionId=', 1),
                              (2,'郑州玉带信息技术有限责任公司','实习web前端开发工程师','1-6K','大专','参加公司自研产品的Web和微信端小程序开发，使用vue、elementUI和eCharts，前后端分离（后端JAVA）。不出差，不外派，就在郑州二七区做开发。实习工资（阶梯式）：前3月根据能力1-2k，然后每3个月加一次工资。','郭先生','刚刚活跃','郑州二七区升龙世纪花园壹区1号楼','https://www.zhipin.com/job_detail/83875f1369c538c11XZ-2d25FFFS.html?lid=6GPZx3II9Bv.search.33&securityId=n3MA2JOuS73KT-r1Nlxh3kvZXvOSHC90ilAlsoq9BoEQNPciyid8x5k0L-00ebcywNukntgNMy7nHJ9UbCveHbRprqwfFIiWnyqr-mwErc-NXnUyGRaRIkrK8wC9TUTcGb2WteIM8rdlAA~~&sessionId=', 1),
                              (3,'广东天勤科技有限公司','兴宁前端、程序员实习生','1-4K','大专','实习生要求：1、需要在梅州兴宁市长期工作（家在梅州市内）2、统招全日制大专或以上学历的应届毕业生（或实习生）3、入职进来接受前端+后端的综合技术学习（专人指导）4、在大学期间有接触过编程或者网页制作相关工作5、不接受短期实习，实习完成转正至少需要工作一年以上6、要求看书学习的习惯，能接受高强度学习要求，晚上能持续看书使用技术栈：用Python开发后端，框架是Flask，数据库是MongoDB和Redis，前端用VUE，我们要求每个技术都是全栈的，进来都会有人指导学习技术，如果你想入职我们公司，可以看下我们使用的技术这些（下载地址包括中文路径）， https://crx.tqdn.cn/soft/天勤科技-前端考核题.zip 公司业务：广东天勤科技有限公司是一家从事电商大数据的技术型互联网企业 ，五十多人的团队，技术占比三分之二，具有国内领先的大数据信息采集、存储、分析解决方案和信息技术服务提供商，研发出多款国内领先产品。','林先生','在线','梅州兴宁市天勤网络37号','https://www.zhipin.com/job_detail/9a7d1cb58dc773e01nR539m-EVJZ.html?lid=6GPZx3II9Bv.search.34&securityId=H2jPlD4r0vFF9-A1vCncuTcKvE19ZBYrHfAEfTeCLREMWZ-9-ZYopW84XxZBjtFEbwzru-L7L6nc-A8xUa5D3zxHORfInDO2pc_NnfK3oX3fJf_Amb9cR-9qt1z9nY0Arnb54nGYzLWI_N5mBM9UJbxAlodWzLYXl9NxANWFwjbAEHCtXQ%7E%7E&sessionId=', 1),
                              (4,'武汉赢月网络科技有限公司','运维工程师','2-3K','大专','负责日常网络及各子系统管理维护','赵爽','刚刚活跃','武汉洪山区长航·蓝晶国际7栋1009','https://www.zhipin.com/job_detail/f59b21cdfee85d701XNy2t27FlBY.html?lid=6GPZx3II9Bv.search.35&securityId=WQt7AL_kcLC0x-p152pRMATNyIhS07UQ9_CkRL-1i7NZd0FLvrcPAv0gk7eAyYZJgvDYEy-RXlyaJkhIadMSlgfbhaEDSKRF7BhesqvFUIrFeYpK6xEiMBJ8bP3G2d3ZJ0F33LuEbvmXmg~~&sessionId=', 1),
                              (5,'陕西润古网络科技有限公司','web前端实习生','2-3K','大专','1.专科以上学历（含），计算机、通信、电子等相关专业；2.热爱软件开发工作，对移动产品有浓厚兴趣，对移动产品有较好的个人理解；3.具备良好的沟通协调能力，与团队保持良好沟通，协调项目资源、保证项目进度、监控项目质量；4.本岗位欢迎优秀应届毕业生前来应聘（学习能力强者可宽松学历要求）公司可接受应届毕业生，提供实习岗位。','南旋','3日内活跃','西安雁塔区西安高新技术产业开发区(锦业路)','https://www.zhipin.com/job_detail/0e38c541b625b3f21HN43du_FlQ~.html?lid=6GPZx3II9Bv.search.36&securityId=eFkE7dNdtbybm-d1f-aI8b96mfLkyK1tFjpcj5IKo88LK7-bsZ4ya_61kxMdKq5d856qHpXZMSsKexwDa3CmB6P8hpgREcxRThUrdz5YVPMew1P-PDTEUFPEAFLqA5v7L9v9mz3_qA~~&sessionId=', 1),
                              (6,'江西天华新瑞信息技术有限公司南昌分公司','WEB前端开发实习生','2-4K','大专','职位描述：-负责公司项目网页前端设计、制作和维护。-网页互动服务产品的研发。-网页相关设计方案的文档编撰。-项目web前端简单的UI设计和资源处理。-项目APP前端(web封装)的UI设计和逻辑开发。 任职要求：-大专及以上学历-熟悉Html+css/javascript，了解Html5+css3，有实际项目经验优先。-熟悉jquery+bootstrap开发，有相应的工作经验。-有vue/react/angular使用经验，了解mvvm者优先。-懂得ps等图片处理软件，能进行简单UI设计优先。-有商业项目开发或github开源项目开发经验优先。-有良好的沟通能力和团队意识，工作主动热情，有责任心，学习能力强。福利待遇：-依法享受国家法定节假日及带薪年假-绩效奖金：会根据参与项目贡献度实际发放-五险一金：养老保险、医疗保险、工伤保险、失业保险、生育保险、公积金-三节福利：端午节福利、中秋节福利、春节福利-公司团建旅游：公司每年会组织大家团建旅游活动-不定期素质拓展：根据项目完成情况，组织相关市内素质拓展活动-定期体检：公司每年会组织定期体检-不定期团建聚餐：法定节假日、各类特殊日期等-团建观影：根据项目进度，组织观看当下热门电影-下午茶：披萨、卤味、咖啡、奶茶、炸鸡、水果、小零食等随机搭配-高温补贴（夏日饮品）：夏季高温期间（7、8、9月），按照发放防暑清凉饮料形式发放-应届毕业生专属租房补贴福利-公司私人厨师做饭，可提供丰富的午餐-不定期组织能力培训及相关技术学习分享','王浡','刚刚活跃','南昌萍钢总部大楼(东门)1302','https://www.zhipin.com/job_detail/d9de2ade256189e91nN40t-9EVVY.html?lid=6GPZx3II9Bv.search.37&securityId=rymFUj5eZf3zH-X1Er2CNxO2jpoy2Jvq3sNVGbyATs5ZymPHi_jemBh-Il1f0SjYooe_qYg2mw43skf78fdDDHRw037ZQsL_pot3zu99SRwfFa_8PvkaYKVXTkbveHQigVgHKeWeT6N_Bw~~&sessionId=', 1),
                              (7,'遵义小红椒网络科技有限公司','前端开发（接受实习生）','2-3K','大专','任职要求：1、精通HTML/CSS/JavaScript，有良好的编码习惯，有代码洁癖者优先；2、熟悉JS技术，包括AJAX、DOM、JSON、熟悉Vue；3、较强的学习能力、逻辑思维能力、良好的沟通能力、团队协作精神；4、有常见框架（uni/Element）项目经验者优先。5、熟悉小程序，公众号开发优先考虑招聘说明：优先考虑22年毕业生，要求有一定实践经验，肯吃苦，学习沟通能力强','张先生','3日内活跃','遵义红花岗区中关村遵义创业中心3层A区','https://www.zhipin.com/job_detail/e345caf076d3d0d11XR40tq4F1VZ.html?lid=6GPZx3II9Bv.search.38&securityId=_qfzUsTuWvA72-Q1VTTaQZEpxJoPpjiRCcaV7YFRXrvDvCy1Hw4AOIjorMBI2cy58XD2P-skAk480dfOgL4vHpWjlwcx_YJgJWY-qSiJ1pIbCdPW3ZlKgH-EpQbfLCQm2YYpumWH3w%7E%7E&sessionId=', 1),
                              (8,'广州小檬信息科技有限公司','Web前端开发工程师(实习）','2-4K','大专','【岗位职责】1)负责公司相关web产品的前端开发；【岗位要求】1)工作经验无要求，但需要有编码经验；2)熟悉 Javascript/CSS/HTML；3)了解相关 web 规范标准，了解模块化开发，了解前端组件化概念；4)至少了解一门服务器端相关技术；5)有技术博客者优先；【职位吸引】1)完善的前端培训体系，团队发展空间大，利于个人的成长；2)良好的技术氛围，团队大牛多，可随时与他们讨论和交流；','黄均河','本周活跃','广州海珠区保利叁悦广场C塔1005','https://www.zhipin.com/job_detail/9da6647fc2ba5bb01n1z0tS8F1c~.html?lid=6GPZx3II9Bv.search.39&securityId=FM6fMaPJnfQTc-x1mkNP1jxkKeNzYXVYmTxL0ft80_zVuDVCArMX0IYOGS4CFDKZrKuX6--doHhW-Oz7l-2nn4X79YNwDiJGVbU7s2uoUS_egFpeieC7N_oCR5tBsr-Fz1Ju4j5Qmw%7E%7E&sessionId=', 1),
                              (9,'娄底宇麒科技有限责任公司','unity工程师助理','1-3K','大专','可培养新人，愿意学习，勤奋刻苦大专及以上学历对游戏开发，编程行业热爱有游戏开发大佬带','黄先生','刚刚活跃','娄底娄星区SOHO尚都10层1011','https://www.zhipin.com/job_detail/914a42ac19b68df71XN-29q6GFVT.html?lid=6GPZx3II9Bv.search.40&securityId=DoINrl43z6i2Z-s1UVxevm8dh2ILoc3adtNXDsXb9D0o-FJpARCJIIEdi5jNS_9PQHrsG3PE_69o_iT3xwZg7FzL4S52PguPhD536yacSbY25dHUx859lXEBXvY1hApw4VUMnqaKBYW_&sessionId=', 1);

UNLOCK TABLES;

-- 创建雇员表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL COMMENT '用户ID',
  `name` varchar(50) NOT NULL COMMENT '用户姓名',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `birth_year` smallint DEFAULT NULL COMMENT '出生年份',
  `min_expected_salary` varchar(4) DEFAULT NULL COMMENT '最低期望工资',
  `max_expected_salary` varchar(4) DEFAULT NULL COMMENT '最高期望工资',
  `education` enum('大专','本科','硕士','博士') DEFAULT NULL COMMENT '最高学历',
  `school` varchar(30) DEFAULT NULL COMMENT '学校',
  `major` varchar(30) DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`id`)
) COMMENT='用户表';


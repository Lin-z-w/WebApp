CREATE TABLE IF NOT EXISTS products
(
    id       VARCHAR(255) PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    price    DECIMAL(10,
                 2),
    category VARCHAR(50),
    quantity INT,
    stock    INT,
    img      VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS user
(
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    address  VARCHAR(255),
    img      VARCHAR(255),
    phone    VARCHAR(20),
    balance  DOUBLE PRECISION DEFAULT 0
);

INSERT IGNORE INTO user (username, password, email, address, img, phone, balance)
VALUES ('admin', '123456', 'admin@localhost', 'admin address', 'admin.jpg', '1234567890', 0);

INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '900 压缩饼干90干粮家庭应急长期储备食品户外代餐饱腹即食充饥抗饿 90饼干10斤铁桶装含全脂奶粉 5kg', 189.00,
        'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/185453/23/39822/106405/65264a69F168da9bc/0f65bc02eefc4bf1.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('3052114', '双汇 火腿肠 玉米热狗40g*8支 网兜装 出游 露营款', 9.90, 'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/175565/36/3709/133452/60754002E64de11af/a541724d74608d3e.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('2910606', '康师傅 方便面 经典香菇炖鸡面五连包101g*5 泡面袋装速食 方便食品', 15.90, 'food', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/141925/22/29055/207551/630c4b6bE741e07d4/184f0d9a3466ee75.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('100091743380', '白象 方便面 白象多半金汤肥牛面134g*5袋 大面饼泡面袋装五连包', 12.90, 'food', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/106106/13/47352/129291/65d1641bF5ba3eaff/da7f193bf8994508.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10025304146402', '【10万人已购买】非油炸兰州牛肉面重庆小面杂粮面私房牛肉面 【邀新专享】兰州牛肉面2桶 超值好物',
        3.99, 'food', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/149528/20/43587/106835/66139c57F958037dc/f030998b08e2124a.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023593080502', '享鲜人奥尔良小鸡腿即食鸡肉熟食卤味零食根真空休闲小吃解馋食品整箱 奥尔良味+蜜汁口味共10根',
        21.80, 'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/132705/26/34309/224982/6482b919Fd8ed8ff9/47d166cf87c16536.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '陶陶居老婆饼广东手信糕点广州传统特产休闲零食品中华老字号192g', 29.80, 'food', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/224513/5/15680/119413/6620e7f5F1fd6a111/a68fc261b2babaa3.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('100064297600', '比比赞辣卤零食大礼包75包深夜解馋夜宵小零食肉脯荤素年货送礼休闲食品 京东超市超多爆款好物',
        24.90, 'food', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/219234/38/38928/176043/662f5c0aF228105e9/569194179f999151.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('100071294613',
        '麦酥园五黑桑葚紫米饼饼干蛋糕点心早餐面包休闲零食无糖精食品代餐小吃 专注无糖精食品糖尿病人专用食品', 19.90,
        'food', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/100277/25/40821/163895/652a5896F8db027aa/dfbee41bdd5c3ad9.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('14286046194', '袋鼠先生30包纯鸡胸肉即食低脂健身代餐开袋速食高蛋白鸡胸脯肉休闲零食品 鸡胸肉 100g *15袋（30包）',
        67.80, 'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/230145/9/15934/136768/663ad1c3Ffa49fda1/f1725cce34cb8a4d.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('100033325577', '杉城巨型零食大礼包整箱小吃休闲零食品大全送女友礼物盒成人肉类儿童 京东超市超多爆款好物', 86.90,
        'food', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/95050/37/33068/334688/65ae0912F1dbd13cd/f22538acf7633a87.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10022230683884',
        '双汇（Shuanghui）香辣香脆肠玉米热狗肠32g即食香肠烤肠玉米肠火腿肠整箱休闲零食 香辣肠15支+玉米肠15支', 27.00,
        'food', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/103904/38/26279/217597/6242aebaE91dfd7d0/02d35f725a7e645d.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '叁雨优品一米辣条超长一根香辣爆汁经典湖南味香油条休闲童年美食 一米辣条8包', 7.99, 'food', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/211200/21/41890/234153/661d2e11F15ffa415/c5aa19be74584715.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('14207476064', '魔法士 干脆面混合口味整箱干吃方便面童年怀旧小零食品捏碎面整箱批发 *推荐*【整箱】混合多口味48包',
        22.80, 'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/203114/4/40361/272535/65d6e926F9cef2c52/c830ecd673f9d220.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10025234542976', '高尚锦记卤蛋茶叶蛋乡巴佬风味卤蛋熟食零食搭档休闲零食真空包装整箱 五香蛋 20个', 18.80, 'food',
        0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/244501/37/2340/288901/6599204bF715ccd4c/f499af9f263458ec.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('100059931779', '其妙黑森林蛋糕卷400g 休闲零食 蛋糕面包早餐糕点瑞士卷食品小吃', 16.90, 'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/109493/39/23796/156583/6469828aF76bad0b0/ef9d0e197376630e.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('100092864027', '华夏九月天麻酱米线108g/4桶装免煮懒人夜宵方便速食学生嗦粉非油炸冲泡粉丝', 15.80, 'food', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/208651/19/37060/225028/661253ebF75c50e71/c1980efa743b0fe4.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10022009033061', '统一开小灶红油抄手口味小馄饨红油抄手早餐夜宵方便速食【肖战推荐】 鸡汤馄饨 2盒', 15.80, 'food',
        0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/169245/8/41176/140975/64e571c3F28e4fd6e/5a0ef07e0cf5858d.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '太丰缤纷牛肉干零食混合口味大礼包125g*6袋宁波老字号国货休闲卤肉脯', 239.00, 'food', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/233985/21/2474/286241/654ef942F394f807f/fd72b41d630a2315.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024325600779',
        '三只松鼠（Three Squirrels）坚果大礼包成人解馋小零食干果礼盒高端食品大全送长辈端午节礼物 535g 10款坚果零食【1彩箱装】',
        26.90, 'food', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/168840/39/46427/218452/663b0fffF69eb73c5/192fb2424edd33cd.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023720040053', '渝林会【6盒1箱装】重庆自热小火锅懒人自煮自助酸辣粉网红食品学生钜惠 【活动冲量】蔬菜火锅6盒',
        33.80, 'food', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/229598/8/2255/264709/654d8b5fF384a7473/c0f54c125e71ed53.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024248914020', '劲丰博士牛筋辣条怀旧零食8090后儿时回忆麻辣面筋素牛筋休闲食品小吃 麻辣 1kg 牛筋50包收纳盒',
        18.80, 'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/47880/1/20893/223769/647558dfFdd441364/ea33a72b11dd3990.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10025110278441',
        '双汇多种口味火腿肠香肠鸡肉肠王中王润口泡面拍档玉米肠混搭零食小吃 鸡肉肠+润口肠+泡面肠+王中王+藤椒肠 20支',
        18.80, 'food', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/110815/14/47376/299902/65700f7fF0ae9cd60/ff99c7c1bc050378.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023970220578', '比比赞（BIBIZAN）拉面丸子干吃干脆面解馋小零食小吃货休闲食品网红小方便面 拉面丸子【混合味】30包',
        15.90, 'food', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/134781/3/42215/262202/663c9ad2Faa164011/9c357ae8c2bdda66.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '热烈 三合一爆米花玉米花商用影院巧克力焦糖奶油味休闲食品零食零售 蝶形焦糖味5包', 23.80, 'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/180795/36/40996/52380/65f9248eFe2b9ffd8/2343d522c9949c86.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023924720915', '美希恩酸奶西米露水果罐头整箱黄桃 6种西米露口味各一罐', 17.80, 'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/121769/4/35969/916048/6422cc1eF79122067/8f1788e4efc986c1.png.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024469507017', '舸渡奥尔良小鸡腿即食卤味零食香辣休闲小吃食品整箱批发熟食充饥夜宵 【20根】奥尔良+卤香+麻辣',
        21.90, 'food', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/183566/20/34806/194190/64ad072eF232e1774/6ebc2f5beeaa7247.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024594060013', '哈藏蒙食品俄罗斯风味牛筋肠大块牛筋香肠俄式火腿肠下酒菜熟食开袋即食 180g 牛筋肠5根', 21.97,
        'food', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/231666/16/226/158738/6530f1b5F434ebf16/215e590b403044d4.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024809169205',
        '舸渡厚切吐司面包整箱早餐健康切片代餐营养好吃的小零食小吃休闲食品 【整箱14包】厚切吐司面包 630g', 14.70, 'food',
        0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/230757/9/6013/200115/656d935eF7eed074a/85ebe37fd134ca7d.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024980312682', '麦口滋花椒锅巴小包装手工麻辣零食追剧宿舍休闲解馋食品散装整箱批发 超值装丨【混合味40包】',
        45.80, 'food', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/226407/6/1910/142782/6545be3bF436bc9a5/0c7fb87c1754d2e3.jpg.avif');

INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '学而思大阅读二年级北大名师96节小班课+书套装小学生课外必读书写作阅读理解学习方法作文名著语文培优课',
        2399.00, 'book', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/211242/32/32246/178246/660d084bFc4dca47b/d3d3daf2aa4902fd.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('11619884', '【自营包邮】余华作品 我们生活在巨大的差距里 以犀利的目光洞见时代病灶', 17.50, 'book', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/130607/13/34165/117883/63b36216Fd9e7d56c/95aa49380c694484.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('11792121', '世界简史(京东定制） 京东APP搜【图书企业购】享采购特权', 7.50, 'book', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1867/171/847897355/242695/e4f8f55f/56302509N3ca12c63.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12653936', '局外人（孤独没有什么不好', 15.80, 'book', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/188360/17/31746/39918/63b36247Fba8f9298/73212dbd5e2079c9.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12622838', '一开口就让人喜欢你 语言能力并非与生俱来', 4.90, 'book', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/122929/36/5514/130181/5ef2f7b4E15a8f3a3/291c67d69d653e1e.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12929237',
        '策略+见识+眼界+格局+情商（套装5册）思维格局类情商全集 社交职场正能量自我提升书籍 一套让你走出人生困境的实用智慧书',
        16.00, 'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/199623/33/4842/134119/61263280Ec6e545b2/8e3b05ee5dd26efe.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '学而思90天伴读书房大语文3年级培养阅读习惯思考能力名著必读课外书互动课堂', 299.00, 'book', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/222057/9/39993/142326/662784c3Ffb5a6abe/37d61da626e3a764.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12987083', '【包邮】余华作品 活着（精装版', 28.40, 'book', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/219391/30/35672/56868/6507f993Ff8d61acc/61b698866622254c.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('13443857', '杀死一只知更鸟（新）（豆瓣9.3', 24.50, 'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/214904/28/21761/88048/634516d2E96f1eb25/93d894a1152b229e.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('11715978', '【高启强同款】孙子兵法 正版原著 京东自营 原文白话文译文注释 中华国学经典精粹 传承国学经典', 3.60,
        'book', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/116200/23/31593/75734/63dcdc5aF4a789072/8957d20d87bf0c79.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('14526302', '【全3册】人间值得+不抱怨的世界+把生活过成你想要的样子 官方正版成功励志心理疗愈书籍', 29.80, 'book',
        0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/100442/20/45664/113706/660cf5e6Fdfdec847/5130ff496d276cc3.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('14158706', '静心的智慧：静下来一切都会好N个早解决早受益的静心策略不是世界喧闹是你内心太吵', 6.30, 'book', 0,
        100, 'https://img11.360buyimg.com/n7/jfs/t1/119245/37/42909/51253/6502a7a7Fee48c272/fe2f28fe0cbf6a9f.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12628332', '额尔古纳河右岸 迟子建 茅盾文学奖获奖作品全集 第七届茅奖 人民文学出版社 人民文学出版社官方正版',
        13.80, 'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/227794/25/16132/94895/661c7de8Fef2ac7d5/b49d90a863667417.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('14023917', '情绪控制：化解焦虑、抑郁、愤怒的情绪管理术', 4.99, 'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/169147/4/41960/23222/65f02818F7a9dd06f/3647f299589baa20.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10025019413629',
        '博弈论 正版原著 经商谋略人际交往为人处世商业谈判博弈心理学基础经管励志成功书籍宏观经济学原理战略博弈论与信息经济学青 博弈论',
        4.48, 'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/180376/28/41202/116302/6551bfceFf98cb32d/f204dc0c18c38928.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024972753179',
        '包邮 人间值得正版书 董宇辉推荐的书籍成功与励志书籍 不抱怨的世界把生活过成你想要的样子畅销书 排行2023 人间值得正版现货 官方正品',
        4.90, 'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/96050/20/33201/71855/65435711Fbe61890c/c947daaf1f4b94ba.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('11503588352',
        '全套十册受益一生的10本书人性的弱点狼道鬼谷子墨菲定律羊皮卷正版全集完整版原著原版成功励志热门心理学书籍谋略职场畅销书五本',
        29.80, 'book', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/49684/25/22893/167794/63ddb328F84f4bbf3/8a9955e7926dc402.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('13354962', '狂人日记：鲁迅小说全集（1938年复社底本', 15.80, 'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/232842/7/8967/112382/658cf101Fa3ef9ef5/889fb628aee9e78b.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '古文观止樊登推荐青少年版写给青少年的趣说古文观止漫画版藏在古文观止里的那些事儿', 49.80, 'book', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/198131/30/39712/180171/65bc531aF07ec9d46/fd3d8541da2a7406.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('14181206', '听风八百遍', 23.50, 'book', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/40523/37/25051/152621/6513c8adF1cdbc615/d778c258bd65265b.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12696381', '绝叫（罗翔推荐', 26.10, 'book', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/160360/22/31490/94504/635ffe7bEd72636c2/ad4cfbeb4e9a24a2.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12967512', '逻辑学入门：清晰思考、理性生活的88个逻辑学常识 生活中的任何问题都可以用逻辑思维加以思考和解决',
        10.90, 'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/170917/40/32166/43748/636e7563Ee43491c4/1c82cd725e5d42d8.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('11024004', '图说天下·国家地理系列：走遍中国 团购50册以上优惠咨询：（010）89110538', 8.00, 'book', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/198644/9/35511/118358/64d45092Febe19db3/fcec815dd32b196e.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12263069', '渡边淳一·钝感力（帮你玩转人际关系', 16.00, 'book', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/168283/29/34722/71137/6409784eFe9d6944b/127d5d6f6ab536cc.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '新华书店四大名著正版原著五年级下册必读课外书全4册小学生版彩绘主因学校老师推荐阅读 读世界【单册】红楼梦',
        12.80, 'book', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/247912/34/6658/118679/66066d2cF1e7aaf34/a762cf41ba01be56.png.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('11997615', '极简：在你拥有的一切之下', 10.90, 'book', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/179247/13/31129/39401/636e71dfE03cc33b1/46a3a27aacba571c.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('13731110', '理想国 柏拉图著 世界经典哲学书籍（全书373页）原著无删减', 12.00, 'book', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/110953/13/33188/53760/636e7597Efbaaca9f/f4ecaa624694625d.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('13936042', '全2册 王阳明心学知行合一+王阳明心学的智慧 中国哲学人生哲理修身处世之道王阳明经典哲学书籍', 16.40,
        'book', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/174681/20/31012/114653/643921c6F31948c24/d5024c2f235db9e3.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10025429008027',
        '月亮与六便士正版书籍毛姆原著长篇小说无删减毛姆经典作品集青少年课外阅读外国小说畅销书籍排行榜人间失格 月亮与六便士单册',
        4.49, 'book', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/248004/4/5483/53556/65ee6a77F60e23bfd/af291dcda2669937.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('12314331', '曾国藩家书：蕴含曾国藩后代英才辈出', 7.50, 'book', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t15190/270/2448539443/485681/f6c3b0d/5aa73abdN45f24764.jpg.avif');

INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024342697539',
        '爱心东东 金武端自行车成人山地车公路赛车单车骑行变速超轻越野中学生初中青少年 顶配版-辐条轮-黑白色 26寸21速【适合160-185CM】',
        232.00, 'vehicle', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/183568/23/44386/340428/6620f9f5F20faca39/659ddd884ec0c54d.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10022922280700', 'EG7山地自行车成人学生变速越野单车双减震赛车26寸青少年男女 顶配-钢架黑白色【辐条轮】 26寸21速',
        238.00, 'vehicle', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/243509/21/7452/202141/6633646cF31e2ad24/d4c1907492c33b75.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('',
        'Jeep 吉普(JEEP)山地车自行车学生成人减震碟刹通勤男变速越野青少年 巡航者-辐条轮-骑士黑 （26寸）适合160-183cm 24速运动版',
        839.00, 'vehicle', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/235623/6/16171/116612/663aef9eFa4a6cf08/156b430e8f1c9cb7.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024547381562',
        '金武端自行车成人山地车公路赛车单车骑行变速超轻越野中学生初中青少年 顶配版-辐条轮-白黑色 26寸21速【适合160-185CM】',
        256.00, 'vehicle', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/187540/27/41979/176824/654fa9fcF614d6e98/98204b217952809d.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024145723980',
        '菲利普（PHILLIPS）山地车自行车学生男女成人公路城市减震碟刹通勤男变速越野青少年 高级灰 （26寸）适合160-183cm 21速运动版',
        488.00, 'vehicle', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/184313/39/44463/134381/6637b07dF64b6ad7b/94959e76c4f1d8f3.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('100052641592', '凤凰（Phoenix）山地自行车成人学生碟刹越野变速单车 ZB888 26英寸24速灰色', 518.00, 'vehicle', 0,
        100, 'https://img12.360buyimg.com/n7/jfs/t1/232820/12/8869/137624/657fecf1Fa1d72598/3c26c01761352e51.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', 'XOSS行者自行车夜骑灯高亮下挂前灯山地公路车前灯单车配件骑行手电筒 XL-400（400流明）', 69.00, 'vehicle', 0,
        100,
        'https://img14.360buyimg.com/n7/jfs/t1/199390/12/24159/267165/62bbc2d5E68411657/4aedfab262f97ff9.png.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10020908401965',
        'LAUXJACK 山地自行车成人一体轮单车变速公路车男女式学生青少年越野赛车 顶配-辐条轮-白色 26英寸 21速', 235.00,
        'vehicle', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/133860/34/41472/179866/662b69efF3aed8641/114f5a0a612dd242.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024989102408',
        '永久山地车自行车成人男女学生变速铝合金油碟公路自行车越野减震单车 摩天灰【钢架 线碟刹】减震+礼包 26英寸21速【推荐155-185cm】',
        678.00, 'vehicle', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/231087/32/7160/70838/65743501F4b3d499f/d5f9d6e76ea08cd2.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023114358363',
        '爱心东东 凤凰（Phoenix） 自行车学生成人男女山地车变速公路单车双碟刹越野山地自行车 传奇浅灰色（钢架线刹） 26英寸适合150cm-180cm 24速',
        518.00, 'vehicle', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/105358/25/43754/96934/663d150dF25248d23/8df5c6ec392f4680.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10025624659464', '菲利普公路车自行车直把弯把山地男女学生成人跑车变速700C单车竞速赛车 飓风灰弯把 24速', 639.00,
        'vehicle', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/109409/3/48288/80246/6628b6f0Fde753705/52be276f01bbbe44.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10025401013558',
        'WELLCLS公路自行车赛车成人单速实心胎死飞骑行男女学生自行车单车山地 30刀-纯黑色 26寸【适合：165-185cm】', 348.00,
        'vehicle', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/103238/19/40975/112583/66209154F988047b4/be5247b10514a902.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('',
        '凤凰（Phoenix）山地自行车成人男女内走线越野竞赛青少年运动铝合金自行车 战神 加厚钢架 辐条轮白橙 26寸【适合155-185cm】 24速',
        518.00, 'vehicle', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/236382/2/8000/142247/657969eeF277b4e8b/979018b0e5559859.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023994609291',
        '爱心东东 飞鸽（FLYING PIGEON）山地自行车男女变速成人赛车单车山地车中小学生越野公路通勤车 极速-高碳钢架-辐条轮-浅灰色 26英寸 21速',
        399.00, 'vehicle', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/99387/6/43175/62633/64e07793F6e99e98d/bc9def2ce884ad92.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10025409534946',
        'LAUXJACK山地自行车成人学生变速减震双碟刹男女骑行代步单车 灰色福条轮【高碳钢】 M码24速【建议160-175cm】 26寸',
        298.00, 'vehicle', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/132401/5/40321/133880/6636eba4F8de8eee0/354a0f18950eea80.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10020627799747',
        '飛鸽（FG FLYING PIGEON）山地自行车山地车男女变速越野减震单车公路车中小学生少年成人 黑红色高碳钢辐条轮26寸 21速顶配 【经典飞鸽',
        399.00, 'vehicle', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/159722/30/846/195543/5fed99f9E79e14640/3d7addb51d919343.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024613924875',
        'KASIDIAO山地自行车成人学生单车变速越野骑行男士赛车减震初中青少年高中 顶配-黑白色-辐条轮 26寸21速', 268.00,
        'vehicle', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/164557/33/39262/286959/65d377bcF5015519f/f9ff2dc0b9aef793.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023969180642',
        'Jeep吉普(JEEP)公路自行车碟刹变速自行车男女学生公路车竞技代步车 RS730-公路把-高级灰 M码（适合身高165-185CM） 21速',
        1169.00, 'vehicle', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/231817/29/17235/144344/663a4ce1F87938d60/bacce3ff29f9ca05.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', 'RALEIGH城市通勤自行车铝合金成人变速轻便男女士带小孩代步兰令单车 花语-祖母绿【弯把+加厚车座】 26英寸 7速',
        1019.00, 'vehicle', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/105450/8/47454/151633/65dd61d6F8e99613e/ed542e169b10f85b.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10021488382416',
        '永久（FOREVER）山地车自行车成人男女初中高中学生越野赛车变速碟刹减震脚踏单车 标配版-炫彩紫-辐条轮 26英寸21速【推荐155-185cm】',
        448.00, 'vehicle', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/193144/9/44879/131172/6639fbb9Fecdc6fa3/2de3b44af3a0a047.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10021085035845',
        '永久（FOREVER）山地自行车男越野单车变速赛车26英寸学生成年大人女成人 旗舰-辐条-黑银色 26寸21速【适合:160-180cm】 主图展示车型为三刀轮-黑银色',
        448.00, 'vehicle', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/219529/22/38539/145407/65f952abFbb38b373/5e647371a19cc16d.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023623302565',
        '飛鸽（FG FLYING PIGEON）自行车男式单车普通轻便大人城市26寸通勤车上班青少年中学生成人 黑色-单速款', 359.00,
        'vehicle', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/186047/13/31147/89739/63bd14afFde78f4bb/57ce00a4a99bec51.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10020696778914', 'ICOLOUR 公路自行车成人男变速山地车超轻便实心胎活飞单车女学生 26寸24速标配钛银色 充气胎',
        378.00, 'vehicle', 0, 100,
        'https://img12.360buyimg.com/n7/jfs/t1/189652/5/43295/77610/660bacbaF4c7baa7f/b3ebec667fd6ecc7.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023628801391',
        '爱心东东 SANGPU折叠自行车成人山地车公路学生男变速赛车越野单车通勤城市代步女 顶配版-白黑色-【辐条轮】 26寸21速【适合身高160-180cm】',
        279.00, 'vehicle', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/217423/38/40087/176757/662caef5F2e96ab28/71ed9f10c1fa4482.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('', '凤凰（Phoenix）自行车成人男女式通用型城市通勤单车女芭蕾 24英寸米黄色', 428.00, 'vehicle', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/230530/37/16822/137625/66286e8eFc5ff0b11/fe6f09fb204d4ae1.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024641160677', 'EG7公路自行车成人赛车变速活飞弯把超快竞速超轻实心胎死飞男女单车 升级减震40刀【白黑白】',
        426.00, 'vehicle', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/232211/36/16437/91790/661cf935Fbcbe436f/7036b5e8124f01d7.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10023838760944',
        '百士盾山地车自行车成人学生车公路变速越野单车赛车碟刹26寸青少年男女 骑士版钢架辐条轮-黑白色 26寸21速/身高160-180/',
        258.00, 'vehicle', 0, 100,
        'https://img10.360buyimg.com/n7/jfs/t1/240489/21/7470/252955/6629bc3dFa12bddf4/53f393675834f2b3.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10022921930578',
        '永久（FOREVER） 山地自行车成人男女初高学生越野减震赛车变速碟刹减震脚踏单车 【钢架】黑橙蓝-辐条轮 26英寸21速 建议身高:155-185cm',
        678.00, 'vehicle', 0, 100,
        'https://img13.360buyimg.com/n7/jfs/t1/238839/5/7497/162639/6639e232Ffed6c045/d4db09400c4915cd.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10024016435110',
        '爱心东东 金武端折叠自行车成人山地车单车变速骑行越野赛车高中学生初中生青少年 旗舰版-辐条轮-黑红色 26寸21速【适合160-180CM】',
        279.00, 'vehicle', 0, 100,
        'https://img14.360buyimg.com/n7/jfs/t1/97885/5/40840/232434/6613c9d0F0c912111/a0ac4c6a3cd1ea63.jpg.avif');
INSERT IGNORE INTO products (id, name, price, category, quantity, stock, img)
VALUES ('10020601291237', 'ICOLOUR死飞自行车男实心胎活飞双碟刹轻便公路赛网红成年学生成人女单车 30刀碟刹比安奇 26寸',
        318.00, 'vehicle', 0, 100,
        'https://img11.360buyimg.com/n7/jfs/t1/135212/15/39144/195703/65e91c45Fad80c85c/b48c379ac667944f.jpg.avif');

package com.example.webapp.jddb;

import com.example.webapp.model.Product;
import com.example.webapp.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class JD{

    private final ProductRepository productRepository;

    @Autowired
    public JD(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        // 启动时执行一次爬取任务
        try {
            parseJD("java");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseJD(String keyword) throws IOException {
        System.out.println("Start parsing JD for keyword: " + keyword);
        // 获取请求 https://search.jd.com/Search?keyword=java
        String url = "https://search.jd.com/Search?keyword=" + keyword;

        // 构建连接，并设置 cookie 信息
        Connection connection = Jsoup.connect(url)
                .cookie("shshshfpa", "461d84d4-8ecf-9868-ea12-fb2b7f44b25f-1639296109")
                .cookie("shshshfp", "fb37b45816929833866f6513a2dbd1dd")
                .cookie("__jdu", "1712978612309663156699")
                .cookie("__jdv", "76161171|cn.bing.com|-|referral|-|1714483502799")
                .cookie("areaId", "12")
                .cookie("ipLoc-djd", "12-904-0-0")
                .cookie("PCSYCityID", "CN_320000_320100_0")
                .cookie("shshshfpx", "461d84d4-8ecf-9868-ea12-fb2b7f44b25f-1639296109")
                .cookie("pinId", "PXOhISIsaoOmmjtIna-OcQ")
                .cookie("pin", "jd_NCBGcrSGcQyJ")
                .cookie("unick", "%E8%BF%9C%E5%B1%B1-%E6%B7%A1%E5%BD%B1")
                .cookie("_tp", "SUZWuTIM%2Bd95kcrCOIeoHA%3D%3D")
                .cookie("_pst", "jd_NCBGcrSGcQyJ")
                .cookie("qrsc", "3")
                .cookie("3AB9D23F7A4B3CSS", "jdd03LXL64RIJAGX5RWBU34XQHAY24DL4BLLSZBNVV6NS2HF3FO2TO3T7DHM55IEIOJE5KO63OTTDAE53M4FMTYXZSOGWSYAAAAMPIGJJCZAAAAAAD6FQUQTCVO4XIEX")
                .cookie("_gia_d", "1")
                .cookie("wlfstk_smdl", "03gupduqx4aukc3kkyle362tsl9ju1gv")
                .cookie("TrackID", "1HDFzkLG4rKHh9T5zAlAyN1F2g-MKw-sQR0gR_K4k8o-4y0GmlF2I4tXcAI5ocBTP1ZFjm06P72IPDMYHYEWtRv1Lk5znb8pERURAiDC8DzTyHlGpNA3l1e7YUw6NHAo0")
                .cookie("thor", "73B46387236ADF4528A85DD9307F9D1890184249EEABE8B4DDCDA173A35DEDB44D9A166978C4AC46C9C59EF93E6742471DC04CF697A5F8BE08A7C9751F55C86C7458E1C995F44FFFACCCB69589BEE1E6966199298ECC0DC85A8958FAD4C275CC78E7FC01DC3ECD48D2C2673994BCA8FCE5384EDD7AEFCC2AA860FE4925EDB90A17816F0E63DC8BE18C3A40B4203CFBC1C400BB84F4EAF21DD6CF708318D23A31")
                .cookie("flash", "2_Hji45cgHhtAkOQcdsUVERX_BVFi2-7YEWztSOo8Uze1-AfekP53UKgiGCghl2Gb5-Z8dyD-zNCkXn4d7MJL9k7TWbcIBc2dqCK_lRu_vALynFz2Yb59x16djdPbdGz0cvU5tIM_t7gXZZNwXW43WYdiF7JxM8gZSyCiz6SnfHbq*")
                .cookie("ceshi3.com", "000")
                .cookie("jsavif", "1")
                .cookie("xapieid", "jdd03LXL64RIJAGX5RWBU34XQHAY24DL4BLLSZBNVV6NS2HF3FO2TO3T7DHM55IEIOJE5KO63OTTDAE53M4FMTYXZSOGWSYAAAAMPIGJJCZAAAAAAD6FQUQTCVO4XIEX")
                .cookie("__jda", "143920055.1712978612309663156699.1712978612.1714531460.1714792075.5")
                .cookie("__jdb", "143920055.4.1712978612309663156699|5.1714792075")
                .cookie("__jdc", "143920055")
                .cookie("shshshfpb", "BApXcUD8mLOpA6yrEfIh23FjbklzEggOFB3toZiZo9xJ1MozKLYC2")
                .cookie("rkv", "1.0")
                .cookie("avif", "1")
                .cookie("__jda", "143920055.1712978612309663156699.1712978612.1714483503.1714486158.3")
                .cookie("__jdc", "143920055")
                .cookie("qrsc", "3")
                .cookie("xapieid", "jdd03LXL64RIJAGX5RWBU34XQHAY24DL4BLLSZBNVV6NS2HF3FO2TO3T7DHM55IEIOJE5KO63OTTDAE53M4FMTYXZSOGWSYAAAAMPF5P7PGYAAAAACT44AAAG5HJQAAX")
                .cookie("3AB9D23F7A4B3CSS", "jdd03LXL64RIJAGX5RWBU34XQHAY24DL4BLLSZBNVV6NS2HF3FO2TO3T7DHM55IEIOJE5KO63OTTDAE53M4FMTYXZSOGWSY")
                .cookie("__jdb", "143920055.5.1712978612309663156699|3.1714486158")
                .cookie("3AB9D23F7A4B3C9B", "LXL64RIJAGX5RWBU34XQHAY24DL4BLLSZBNVV6NS2HF3FO2TO3T7DHM55IEIOJE5KO63OTTDAE53M4FMTYXZSOGWSY")
                // 添加其他 cookie 信息...
                ;

        // 解析网页
        Document document = connection.get();

        // 打印网页内容
        document.outerHtml();

        // 所有 js 的方法都能用
        Element element = document.getElementById("J_goodsList");

        // 获取所有 li 标签
        assert element != null;
        Elements elements = element.getElementsByTag("li");

        for (Element el : elements) {
            // 关于图片特别多的网站，所有图片都是延迟加载的
            String id = el.attr("data-spu");
            String img = "https:".concat(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
            String price = el.getElementsByAttribute("data-price").text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            if (title.contains("，")) {
                title = title.substring(0, title.indexOf("，"));
            }

            // 先尝试解析价格字符串为 double，如果不能成功，则直接跳过该元素
            double parsedPrice;
            try {
                parsedPrice = Double.parseDouble(price);
            } catch (NumberFormatException e) {
                // 如果解析价格时出现异常，打印错误信息并继续下一个元素的处理
                System.err.println("Error parsing price for product: " + title);
                continue;
            }

            // 查询数据库检查是否存在相同 id 的商品
            if (productRepository.getProductById(id) != null) {
                // 如果存在相同 id 的商品，则跳过该商品的处理
                System.out.println("Product with id " + id + " already exists. Skipping...");
                continue;
            }

            // 创建产品对象
            Product product = new Product(id, parsedPrice, "unknown", 100, title, 1, img);

            // 将商品插入到数据库中
            productRepository.addProduct(product);
        }
    }
}

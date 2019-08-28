package com.zq.springbootsecurity.web;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

@Component
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 按照我文章图上的信息填写
    public static String app_id = "2016101300679608";

    // 商户私钥，您的PKCS8格式RSA2私钥  刚刚生成的私钥直接复制填写
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDcdxoEkNUPMMrYT9o43KRD1rGybr6LdFGPjZalBDYCLXhqLDTw/TCYIBFSHGvi+bPDDFILvnkALf7JFcL7wzE6IrigeapLhsF+aB7xpfK9hK/BYWzMpgNozyC2Aom8joI5NMuBSaLpyN4utbAGssbic+Ipk5zjJFYqaq1rnuYHIxGm9676avBR0/jZmjYboiUOrwCALSGKQgec3QGfaTs3Mlsbo4h8vk4ItZtGfiIUilYWfqIhxGwCny6NTiG9A9jmNdq0mip5tALFCuzLygTN9/S1vGIyonlkFXSfhlpPnE0tIGna7TeBSg0ZjmtNzw0j95welh6DGJ+X5cDdR5sPAgMBAAECggEBALE2DzTSUmB2gOZlMWz5dhSNk6JwwDsKUbEJR6j2/I69jAgT5q47Zn8xb5rH+7SjsGo9EgocndiWIDH0ixmh6YToee2MPmWdORVpjk4BbWAHMttHe5P4cc8ihxGmcp6dEnH3TQlsbkZrTqTPKGIJ/DH0ojt3SumNwLExtJpITHA4slwCJXQMl/xdmz7lf4KBPTuwLROH3G6rKwKtw5u/hQ4Vo2b+r0+TK94tr7SWf72xht+6F+Dos11ulDkiYdKjJnXtEwmBpSJSBKgjvJLagBV4jmWCJcphW07fKmluGmSmdSqC86A3G8J7gF289RAp6AW9UjMWlY+mMjlBv/QE3IkCgYEA/luSxE76962Ihm47vjas1S2nA56GI0fVNj+l+6DzlK+zIwY6/BE1phrScHYfizDOO+mIGIHRo594BXbycTvg285k3gJVJLx4kqWBuyNPtLmjNJAI6XJknTnBQK1/tBhWhudt4QNOHnDc3yu/yihTslJRTqtHE1FEyDF++LdKMS0CgYEA3eOB819PqhEWy3qwEvDJrISyR6IyGF4d/JJe3bXIhwa6aqeV268fus/hodWfKtXAmXjhVQY04crzLIeC8hl56Ycfljf9DtsjNn89SIFUDGeLSm6uImXT4gZihdi5aop8DXEKL9Zl7LFlM12doYFkW65KEnPfn8CLydWoZTohCqsCgYEAjgK2iJ/IAuyCIvv8oxCHomXgr2acYapDYgxbMYgFNuh5zX43BHDfUSP8hgmNRvsyycRy1av1TbNFIVftuEbEHjS3oDQRMXeAoe+B5OesIqzacAhS0XOqtRV/zgqQGA7WkG85q71aqig9SOR2Kfol8JOBDbkW77QaAOORjm9XHukCgYEAmQl+Km41UtXAhA0VfarHXg6Tq6ZpqLbZNcd6WK41JTP1xPPa/w7U8pLIS0c8JV4SHYfq2iqStJy2haLdJL9/fxqsJX5uMh3gNokhqm1Qm9Gal3ao8Z6LuduvfiNRFvN2xgqN/RqBZ/OeGgRaYPcOUdFu0zVKKjOx9j4/i7nA6ksCgYAWhhhR244Wc+KhwNaLYt4ho02fxkOEriBWoYS3vggho3z0zkD2lqRZtc/sFKEVkMfQpTapCSj3KNVhjH0xH0JaE1eUAyhAlzHThL2gimruJKLhUzbDSE/6pQIj+OEx9eUiZqXOR8kKb9l2F1y8iCcN+n+ZRMftRf42sHixJekCoQ==";

    // 支付宝公钥,对应APPID下的支付宝公钥。 按照我文章图上的信息填写支付宝公钥，别填成商户公钥
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsGNoJje6TP45F5h+DFGncZyoB46tuSrXiAzCWFb9DgoPyo8fbzROcHiIo+BezXOUHzUdO0ddSFKfT5U6KuQPjXKTxEvgp5lkMhT8Bs2qWEnLrlS7Jay58NvCRw55UsFsSTUxkDLuhIHoMlyYYXA4LlSEVFOArtjMKT75PazemL+KM8VBbgIIaBShCevGyCG6aQxHF+0m3Hs9Jy4mChWnjVJLvMhA9td71U6f6aPrzC5xbWHD2r4iPyOCylYbQsWgNlmZtZfXv3xWBNyu4pYFYL6HBGD2pWoK2KYlmz/34vIK2zJdoRI1Xd1lDi6zNSDl8Wc4mvPDAyW0fWfKJ5AW8wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
    public static String notify_url = "http://localhost:9999/alipay/notifyurl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，其实就是你的一个支付完成后返回的页面URL
    public static String return_url = "http://localhost:9999/orders/addOrders";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
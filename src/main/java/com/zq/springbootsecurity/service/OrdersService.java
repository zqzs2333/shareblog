package com.zq.springbootsecurity.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zq.springbootsecurity.entity.SysUser;
import com.zq.springbootsecurity.util.codeutil;
import com.zq.springbootsecurity.web.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class OrdersService {
//    String name = SecurityContextHolder.getContext().getAuthentication().getName();//登入的用户的名字

//    @Autowired
//    SysUserService sysUserService;

    public void ali(HttpServletResponse response, HttpServletRequest request) throws AlipayApiException, IOException, IOException {
        //设置编码
        response.setContentType("text/html;charset=utf-8");

       String name=(String) request.getSession().getAttribute("loginuser");


        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AlipayConfig.return_url);
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url);
        codeutil Codeutil = new codeutil();
        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        String order_number = String.valueOf(Codeutil.getCode());
        //付款金额，从前台获取，必填
        String total_amount = request.getParameter("money");
        //订单名称，必填
        String subject = new String("支付宝沙箱支付");
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(aliPayRequest).getBody();
        //输出
        response.getWriter().println(result);
//        //处理数据库
//        SysUser sysUser = sysUserService.selectByName(name);
//        sysUser.setMoney(Integer.valueOf(total_amount));
//        sysUserService.update(sysUser);


    }
}

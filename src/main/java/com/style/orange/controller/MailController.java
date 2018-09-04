package com.style.orange.controller;

import com.style.orange.enums.OrangeResultCode;
import com.style.orange.exception.OrangeException;
import com.style.orange.service.MailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.Li
 * @create 2018-09-04 15:29
 * @desc
 **/
@RestController
@Api(tags = {"邮件接口"})
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/sendSimpleMail")
    public void sendSimpleMail() {
        try {
            mailService.sendSimpleMail("1343778927@qq.com", "SpringBoot Email", "这是一封普通的SpringBoot测试邮件");
        } catch (Exception e) {
            throw new OrangeException(OrangeResultCode.ERROR_SENDMAIL);
        }
    }

    @GetMapping("/htmlEmail")
    public void htmlEmail() {
        try {
            mailService.sendHtmlMail("pds_lxymmm@163.com", "IJPay让支付触手可及", "<body style=\"text-align: center;margin-left: auto;margin-right: auto;\">\n"
                    + "	<div id=\"welcome\" style=\"text-align: center;position: absolute;\" >\n"
                    + "		<h3>欢迎使用IJPay -By Javen</h3>\n"
                    + "		<span>https://github.com/Javen205/IJPay</span>"
                    + "		<div\n"
                    + "			style=\"text-align: center; padding: 10px\"><a style=\"text-decoration: none;\" href=\"https://github.com/Javen205/IJPay\" target=\"_bank\" ><strong>IJPay 让支付触手可及,欢迎Start支持项目发展:)</strong></a></div>\n"
                    + "		<div\n" + "			style=\"text-align: center; padding: 4px\">如果对你有帮助,请任意打赏</div>\n"
                    + "		<img width=\"180px\" height=\"180px\"\n"
                    + "			src=\"https://javen205.gitbooks.io/ijpay/content/assets/wxpay.png\">\n"
                    + "	</div>\n" + "</body>");
        } catch (Exception ex) {
            throw new OrangeException(OrangeResultCode.ERROR_SENDMAIL);
        }
    }

    @GetMapping("/resourceMail")
    public void resourceMail() {
        try {
            String rscId = "IJPay";
            String content = "<html><body>这是有图片的邮件<br/><img src=\'cid:" + rscId + "\' ></body></html>";
            String imgPath = "C:/Users/gygh/Desktop/62558PICxm8_1024.jpg";
            mailService.sendResourceMail("pds_lxymmm@163.com", "这邮件中含有图片", content, imgPath, rscId);
        } catch (Exception ex) {
            throw new OrangeException(OrangeResultCode.ERROR_SENDMAIL);
        }
    }

}

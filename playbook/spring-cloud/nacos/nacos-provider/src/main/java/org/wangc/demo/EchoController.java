package org.wangc.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Description:
 * @Company: 北京九恒星科技股份有限公司
 * @author: 王晨
 * @Date: 2021/9/17 11:38
 */
@RestController
public class EchoController {

    @GetMapping("/echo/{str}")
    public String echo(@PathVariable String str) {
        return "nacos discovery echo :" + str;
    }

}

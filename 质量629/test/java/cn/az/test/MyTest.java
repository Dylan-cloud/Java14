/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MyTest
 * Author:   Administrator
 * Date:     2019/6/26 20:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.az.test;

import cn.az.service.FinalCountCheckService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class MyTest {
    @Autowired
    FinalCountCheckService f;
    @Test
    public void testMapper(){
//        List<FinalCountCheck> finalCountChecks = f.selectAll();
//        f.deleteBatch("20156");
//        FinalCountCheck value = new FinalCountCheck();
//        private BigDecimal qualify;
//        Date date = new Date();
//
//        value.setCdate(date);
//        value.setCheckItem("aaa");
//        value.setCheckNumber(111);
//        value.setEmpId("111");
//        value.setfCountCheckId("111111");
//
//        value.setMeasureData("111");
//        value.setNote("aaaaaa");
//        value.setOrderId("000006");
//        value.setResult("1111");
//        BigDecimal total = new BigDecimal("0");
//        value.setQualify(total);
//
//        value.setUnqualify(111);
//        value.setSample(111) ;
//        System.out.println(value);
//
//        f.updateAll(value);
//        int i = f.insert(value);
//        System.out.println(i);
    }
}
package com.example.springboot.controller;

import com.example.springboot.entity.BPaymentapplyhead;
import com.example.springboot.service.BpaymentService;
import com.example.springboot.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目名称：data-leading-in
 * 类 名 称：PaymentController
 * 类 描 述：TODO
 * 创建时间：2020/4/2 5:19 下午
 * 创 建 人：apple
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private BpaymentService bpaymentService;

    /**
     * alter table ys_payment add Uid VARCHAR(255)
     */
    @RequestMapping("/importPayment")
    public void payment() throws Exception {
        List<BPaymentapplyhead> bPaymentapplyheadList = bpaymentService.findAll();
        if (bPaymentapplyheadList.size() > 0) {
            int count = paymentService.addPayment(bPaymentapplyheadList);
            if (count > 0) {
                System.out.println("ys_Payment data import success");
            } else {
                System.out.println("ys_Payment data import error");
            }

        }
    }
}

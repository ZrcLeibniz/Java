package rich.zrc.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rich.zrc.springcloud.entities.CommonResult;
import rich.zrc.springcloud.entities.Payment;
import rich.zrc.springcloud.service.PaymentService;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功", result);
        } else {
            return new CommonResult(0, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/select/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "成功", payment);
        } else {
            return new CommonResult(0, "失败", null);
        }
    }
}

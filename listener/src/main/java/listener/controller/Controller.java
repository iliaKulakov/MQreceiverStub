package listener.controller;


import listener.controller.domain.BankSystemsDomain;
import listener.controller.dto.CreateBankSystemInfo;
import listener.controller.service.BankSystemOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class Controller {

    private BankSystemOneService bankSystemOneService;


    @ResponseBody
    @PostMapping
    public BankSystemsDomain createBankSystemONE(@RequestBody CreateBankSystemInfo createBankSystemInfo) {

        int BankSystemOne = createBankSystemInfo.getBankSystemOne();
        int BankSystemTwo = createBankSystemInfo.getBankSystemOne();

        BankSystemsDomain bankSystemsDomain = BankSystemsDomain.getInstance();
        bankSystemsDomain.setBankSystemOne(BankSystemOne);
        bankSystemsDomain.setBankSystemTwo(BankSystemTwo);
//        BankSystemsDomain bankSystemsDomain = new BankSystemsDomain(BankSystemOne,BankSystemTwo);

        System.out.println(bankSystemsDomain.toString());
        return bankSystemsDomain;

    }




}

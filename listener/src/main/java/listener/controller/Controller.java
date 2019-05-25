package listener.controller;


import listener.controller.domain.BankSystemsDomain;
import listener.controller.dto.CreateBankSystemInfo;
import listener.controller.service.BankSystemOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuration")
public class Controller {

    private BankSystemOneService bankSystemOneService;

//    @Autowired
//    public Controller(BankSystemOneService bankSystemOneService) {
//        this.bankSystemOneService = bankSystemOneService;
//    }


//    @ResponseBody
//    @PostMapping
//    public BankSystemsDomain createBankSystemConfig(@RequestBody int bankSystemOne, int bankSystemTwo) {
//
//        BankSystemsDomain bankSystemsDomain = new BankSystemsDomain();
//        bankSystemsDomain.setBankSystemOne(bankSystemOne);
//        bankSystemsDomain.setBankSystemTwo(bankSystemTwo);
//        return bankSystemsDomain;
//
//    }


    @ResponseBody
    @PostMapping
    public BankSystemsDomain createBankSystemONE(@RequestBody CreateBankSystemInfo createBankSystemInfo) {

        int BankSystemOne = createBankSystemInfo.getBankSystemOne();
        int BankSystemTwo = createBankSystemInfo.getBankSystemOne();
        BankSystemsDomain bankSystemsDomain = new BankSystemsDomain(BankSystemOne,BankSystemTwo);

        System.out.println(bankSystemsDomain.toString());
        return bankSystemsDomain;


    }




}

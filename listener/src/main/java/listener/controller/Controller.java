package listener.controller;


import listener.controller.domain.BankSystemsDomain;
import listener.controller.dto.BankSystemInfoDto;
//import listener.controller.repo.BankSystemInfoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class Controller {

//    @ResponseBody
//    @PostMapping
//    public BankSystemsDomain createBankSystemONE(@RequestBody BankSystemInfoDto bankSystemInfoDto) {
//
//        int BankSystemOne = bankSystemInfoDto.getBankSystemOne();
//        int BankSystemTwo = bankSystemInfoDto.getBankSystemOne();
//
//        BankSystemsDomain bankSystemsDomain = BankSystemsDomain.getInstance();
//        bankSystemsDomain.setBankSystemOne(BankSystemOne);
//        bankSystemsDomain.setBankSystemTwo(BankSystemTwo);
//
//        System.out.println(bankSystemsDomain.toString());
//        return bankSystemsDomain;
//
//    }

//    private BankSystemInfoRepository bankSystemInfoRepository;
//
//    @ResponseBody
//    @GetMapping
//    public List<BankSystemsDomain> getAllCategory() {
//        List<BankSystemsDomain> bankSystemsDomains = bankSystemInfoRepository.findAll();
//
//
//        return bankSystemsDomains;
//
//    }

}

package com.bwh.study_springboots.restapis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bwh.study_springboots.Service.CarCompanyService;
import com.bwh.study_springboots.Service.CarInforsService;

@RestController // 데이터만 리턴할때 사용하자. //리턴이 jsp이면 @Controller를 사용하자.
public class CarCompanyController {
    @Autowired
    CarCompanyService carCompanyService;
    
    //selectsearch/COMPANY_ID/C
    //selectsearch/COMPANY/현
    @GetMapping("/carCompanysearch/{COMPANY_ID}/{NAME}")
    public ResponseEntity CarCompanysearch(@PathVariable String COMPANY_ID, @PathVariable String NAME) {
        Object result =   carCompanyService.CarCompanysearch(COMPANY_ID, NAME);

        return ResponseEntity.ok().body(result);
    }

    // create
    //carCompanyinsert/CI001/쌍용
    @PostMapping("/carCompanyinsert") // @PostMapping 은 insert로 인식한다.
    public ResponseEntity CarCompanyinsert(@RequestBody Map paramMap) { // url설정, RequestBody, json방식(전송) 설정
        Object result =  carCompanyService.CarCompanyinsert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // update
    //carCompanyupdate/CI001/대우
    @PutMapping("/carCompanyupdate") // @PutMapping 은 update로 인식한다.
    public ResponseEntity CarCompanyupdate(@RequestBody Map paramMap) { // url설정, RequestBody, json방식(전송) 설정
        Object result =  carCompanyService.CarCompanyupdate(paramMap);
        return ResponseEntity.ok().body(result);
    }

    //carCompanydelete/CI001
    @DeleteMapping("/carCompanydelete/{COMPANY_ID}")
    public ResponseEntity CarCompanydelete(@PathVariable String COMPANY_ID) {
        Object result =  carCompanyService.CarCompanydelete(COMPANY_ID);

        return ResponseEntity.ok().body(result);
    }

}

package com.bwh.study_springboots.restapis;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bwh.study_springboots.Service.HelloWorldService;

@Controller // extends httpservlet 과 같은 설정.
public class HelloWorldController {// 메소드의 이름만 다르다면 여러개의 url을 넣을 수있다.
    @Autowired // new HelloWorldService(); 생략할수 있다.
    HelloWorldService helloWorldService;

    @GetMapping("/helloworld") // servlet의 doGet 과 같은 설정임.
    public int helloworld() {
        return 0;
    }

    // /helloworldGetRequest?Name=bwh <-- 기존의 url방식은X.
    // /helloworldGetRequest/bwh <-- REST 방식.
    @GetMapping("/helloworldGetRequest/{name}/{Id}") // servlet의 doGet 과 같은 설정임.
    public int helloworldGetRequest(@PathVariable String name, @PathVariable String Id) {// @PathVariable 해당 변수가
                                                                                         // parameter라고 설정해주는 것
        return 0;
    }

    // ?serviceKey=6coIXzbt%2BUyCLWaOOeFagVBVv8gvGl1JxmsKOd4H9vp%2BWyqA5T%2BG15Y4W2o4xeSxmYMAEo7ve48tBIlLlrFGdg%3D%3D
    // &currentPage=1
    // &perPage=10
    // &SN=1
    @GetMapping("/helloworldResponse/{spm_row}/{SN}/{CMPNM}/{RDNMADR}") // servlet의 doGet 과 같은 설정임.
    public ResponseEntity<Object> helloworldResponse(@PathVariable String spm_row, @PathVariable String SN,
            @PathVariable String CMPNM, @PathVariable String RDNMADR) {// @PathVariable 해당 변수가 parameter라고 설정해주는 것
        // "spm_row": 471,
        // "SN": 1,
        // "CMPNM": "로이유통",
        // "RDNMADR": null,
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);

        return ResponseEntity.ok().body(resultMap);
    }

    @GetMapping("/helloworldResponseList/{spm_row}/{SN}/{CMPNM}/{RDNMADR}") // servlet의 doGet 과 같은 설정임.
    public ResponseEntity<Object> helloworldResponseList(@PathVariable String spm_row, @PathVariable String SN,
            @PathVariable String CMPNM, @PathVariable String RDNMADR) {// @PathVariable 해당 변수가 parameter라고 설정해주는 것
        // "spm_row": 471, "SN": 1,"CMPNM": "로이유통", "RDNMADR": null
        // "spm_row": 571, "SN": 2,"CMPNM": "의료유통", "RDNMADR": 3
        ArrayList arrayList = new ArrayList<>();
        HashMap resultMap = new HashMap<>();
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);
        resultMap = new HashMap<>();
        resultMap.put("spm_row", 571);
        resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");
        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList);
    }

    // http://192.168.0.46:8080/helloworldResponseWithService/1/10/1
    @GetMapping("/helloworldResponseWithService/{spm_row}/{SN}/{CMPNM}") // servlet의 doGet 과 같은 설정임.
    public ResponseEntity<Object> helloworldResponseWithService(@PathVariable String spm_row, @PathVariable String SN,
            @PathVariable String CMPNM) {// @PathVariable 해당 변수가 parameter라고 설정해주는 것
        ArrayList arrayList = new ArrayList<>();

        arrayList = helloWorldService.fakeSelect(spm_row, SN);
        return ResponseEntity.ok().body(arrayList);
    }

    // http://192.168.0.46:8080/helloworldResponseFake/C001CAR_INFOR_ID
    @GetMapping("/helloworldResponsefake/{companyId}") // servlet의 doGet 과 같은 설정임.
    public ResponseEntity<Object> helloworldResponseFake(@PathVariable String companyId) {// @PathVariable 해당 변수가
                                                                                          // parameter라고 설정해주는 것
        ArrayList arrayList = new ArrayList<>();

        helloWorldService.fakeSelect(companyId);
        return ResponseEntity.ok().body(arrayList); //신호를 ok, value를 body에 담아 전송.
    }
}

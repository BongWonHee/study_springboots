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

import com.bwh.study_springboots.Service.CarInforsService;

@RestController // 데이터만 리턴할때 사용하자. //리턴이 jsp이면 @Controller를 사용하자.
public class CarInforsController {
    @Autowired
    CarInforsService carInforsService;

    @GetMapping("/selectInUID") 
    public ResponseEntity selectInUID(@RequestBody Map paramMap) { // url설정, RequestBody, json방식(전송) 설정
        Object result = null;
        try {
            result = carInforsService.selectInUID(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }

    // selectsearch/YEAR/2020
    // selectsearch/CAR_NAME/소
    @GetMapping("/selectsearch/{search}/{words}")
    public ResponseEntity selectsearch(@PathVariable String search, @PathVariable String words) {
        Object result = carInforsService.selectsearch(search, words);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/selectAll/{CAR_INFOR_ID}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectAll(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    // http:127.0.0.1:8080/selectDetail/CI002
    @GetMapping("/selectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    // create
    @PostMapping("/insert") // @PostMapping 은 insert로 인식한다.
    public ResponseEntity insert(@RequestBody Map paramMap) { // url설정, RequestBody, json방식(전송) 설정
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // update
    @PutMapping("/update") // @PutMapping 은 update로 인식한다.
    public ResponseEntity update(@RequestBody Map paramMap) { // url설정, RequestBody, json방식(전송) 설정
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/{CAR_INFOR_ID}")
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.delete(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/insertDouble") // @PostMapping 은 insert로 인식한다.
    public ResponseEntity insertDouble(@RequestBody Map paramMap) { // url설정, RequestBody, json방식(전송) 설정
        Object result = null;
        try {
            result = carInforsService.insertDouble(paramMap);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result); // 에러 메세지 확인용
        }
        return ResponseEntity.ok().body(result);

    }
}

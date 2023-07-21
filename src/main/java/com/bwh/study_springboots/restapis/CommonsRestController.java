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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bwh.study_springboots.Service.CarInforsService;

@RestController
 // 데이터만 리턴할때 사용하자. //리턴이 jsp이면 @Controller를 사용하자.
public class CommonsRestController {
    @Autowired
    CarInforsService carInforsService;

    @GetMapping("/rselectInUID") 
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
    @GetMapping("/rselectsearch/{search}/{words}")
    public ResponseEntity selectsearch(@PathVariable String search, @PathVariable String words) {
        Object result = carInforsService.selectsearch(search, words);

        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/rselectAll")
    public ResponseEntity selectAll(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = carInforsService.selectAll(params);
        modelAndView.addObject("parmas", params);
        modelAndView.addObject("result", result);
        modelAndView.setViewName("/WEB-INF/views/CarInfors/list_Map.jsp");

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/rselectAll/{CAR_INFOR_ID}")
    public ResponseEntity selectAll(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectAll(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    // http:127.0.0.1:8080/selectDetail/CI002
    @GetMapping("/rselectDetail/{CAR_INFOR_ID}")
    public ResponseEntity selectDetail(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.selectDetail(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    // create
    @PostMapping("/rinsert") // @PostMapping 은 insert로 인식한다.
    public ResponseEntity insert(@RequestBody Map paramMap) { // url설정, RequestBody, json방식(전송) 설정
        Object result = carInforsService.insert(paramMap);
        return ResponseEntity.ok().body(result);
    }

    // update
    @PutMapping("/rupdate") // @PutMapping 은 update로 인식한다.
    public ResponseEntity update(@RequestBody Map paramMap) { // url설정, RequestBody, json방식(전송) 설정
        Object result = carInforsService.update(paramMap);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/rdelete/{CAR_INFOR_ID}")
    public ResponseEntity delete(@PathVariable String CAR_INFOR_ID) {
        Object result = carInforsService.delete(CAR_INFOR_ID);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/rinsertDouble") // @PostMapping 은 insert로 인식한다.
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

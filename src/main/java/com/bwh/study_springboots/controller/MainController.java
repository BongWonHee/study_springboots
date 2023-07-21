package com.bwh.study_springboots.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bwh.study_springboots.Service.MainService;

@Controller
@RequestMapping("/main")

public class MainController {
    @Autowired
    MainService mainService;

    // /selectSearch?search=YEAR&words=2020
    // /selectSearch/CAR_NAME/소
    @GetMapping("/selectSearch")
    public ModelAndView selectSearch(@RequestParam Map params
                            , ModelAndView modelAndView) {
        Object result = mainService.selectSearch(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);
        
        modelAndView.setViewName("/WEB-INF/views/example.jsp");
        return modelAndView;
    }

    // 왠지 회원탈퇴? admin이 관리
    @PostMapping("/deleteAndSelectSearch/{UNIQUE_ID}")
    public ModelAndView deleteAndSelectSearch(@PathVariable String UNIQUE_ID
                        , @RequestParam Map params, ModelAndView modelAndView) {
        Object result = mainService.deleteAndSelectSearch(UNIQUE_ID, params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/WEB-INF/views/example.jsp");
        return modelAndView;
    }

    // 왠지 회원가입, 리뷰, Q&A 등록? 같음
    @PostMapping("/insertAndSelectSearch")
    public ModelAndView deleteAndSelectSearch(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = mainService.insertAndSelectSearch(params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/WEB-INF/views/example.jsp");
        return modelAndView;
}

    @PostMapping("/updateAndSelectSearch/{UNIQUE_ID}")
    public ModelAndView updateAndSelectSearch(@PathVariable String UNIQUE_ID
                        , @RequestParam Map params, ModelAndView modelAndView) {
        Object result = mainService.updateAndSelectSearch(UNIQUE_ID, params);
        modelAndView.addObject("params", params);
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/WEB-INF/views/example.jsp");
        return modelAndView;
    }

    // /selectDetail
    @GetMapping("/selectDetail/{UNIQUE_ID}")
    public ModelAndView selectDetail(@PathVariable String UNIQUE_ID
                        , @RequestParam Map params, ModelAndView modelAndView) {
        Object result = mainService.selectDetail(UNIQUE_ID, params);
        modelAndView.addObject("params", params);

        modelAndView.setViewName("/WEB-INF/views/example.jsp");
        return modelAndView;
    }

    // create
    @GetMapping("/insertForm")
    public ModelAndView insertForm(@RequestParam Map params, ModelAndView modelAndView) {
        modelAndView.setViewName("/WEB-INF/views/insert.jsp");
        return  modelAndView;
    }

    // update
    @GetMapping("/updateForm/{UNIQUE_ID}")
    public ModelAndView updateForm(@PathVariable String UNIQUE_ID, @RequestParam Map params, ModelAndView modelAndView) {
         modelAndView.setViewName("/WEB-INF/views/update.jsp");
        return  modelAndView;
    }

    // 2PC create
    @PostMapping("/insertDouble")
    public ResponseEntity insertDouble(@RequestBody Map paramMap) {
        Object result = null;
        try {
            result = mainService.insertDouble(paramMap);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok().body(result);
    }


}

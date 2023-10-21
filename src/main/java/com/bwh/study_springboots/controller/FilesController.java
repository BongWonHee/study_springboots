package com.bwh.study_springboots.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bwh.study_springboots.utils.Commons;

@Controller
@RequestMapping("/files")
public class FilesController {
    @Value("${remote.server.url}")
    private String remoteServerUrl;

    @Value("${root.file.folder}")
    private String rootFileFolder;

    @Autowired
    Commons commons;

    @RequestMapping(value = { "/formMulti" }, method = RequestMethod.GET)
    public ModelAndView formMulti(@RequestParam Map<String, Object> params, ModelAndView modelAndView) {
        String viewName = "/WEB-INF/views/files/form_multi.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

     @RequestMapping(value = { "/insertMulti" }, method = RequestMethod.POST)
    public ModelAndView insertMulti(MultipartHttpServletRequest multipartHttpServletRequest,
            @RequestParam Map<String, Object> params, ModelAndView modelAndView) throws IOException {

        Iterator<String> fileNames = multipartHttpServletRequest.getFileNames();

        // 폴더 생성
        String storePath = rootFileFolder;

        if (fileNames.hasNext()){
            storePath = storePath + commons.getUniqueSequence() + "\\";
            commons.makeFolder(storePath);
        }
        

        Map attachfile = null;
        List attachfiles = new ArrayList();

        while (fileNames.hasNext()) {
            String fileName = fileNames.next();
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(fileName);
            String originalFilename = multipartFile.getOriginalFilename();

            if (originalFilename != null && multipartFile.getSize() > 0){
                String storePathFileName = storePath + originalFilename;
                multipartFile.transferTo(new File(storePathFileName));
                // 파일 저장 시 중복 유의
                attachfile = new HashMap();

                attachfile.put("FILE_UNIQUE", commons.getUniqueSequence());
                attachfile.put("FILE_NAME", originalFilename);
                attachfiles.add(attachfile);
            }

        }
        modelAndView.addObject("title", params.get("title"));
        modelAndView.addObject("content", params.get("content"));

        modelAndView.addObject("remoteServerUrl", remoteServerUrl);
        modelAndView.addObject("attachfiles", attachfiles);

        String viewName = "/WEB-INF/views/files/update_multi.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }

}

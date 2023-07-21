package com.bwh.study_springboots.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwh.study_springboots.dao.SharedDao;



@Service
@Transactional
public class MainService {
    @Autowired
    SharedDao sharedDao;

    // public Object selectInUID(Map dataMap) {
    //     String sqlMapId = "Infors.selectInUID";

    //     Object result = sharedDao.getList(sqlMapId, dataMap);
    //     return result;
    // }

    
    // 검색(조건-?)
    public Map selectSearch(Map dataMap) {
        String sqlMapId = "Infors.selectSearch";
        
        HashMap result = new HashMap<>();
        result.put("resultList", sharedDao.getList(sqlMapId, dataMap));
        return result;
    }

    // 검색(조건-?)
    public Object selectSearch(String search, String words) {
        String sqlMapId = "Infors.selectSearch";

        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);

        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

        // MVC view
    public Object deleteAndSelectSearch(String UNIQUE_ID, Map dataMap) {
        dataMap.put("COMMON_CODE_ID", UNIQUE_ID);

        HashMap result = new HashMap<>();
        result.put("deleteCount", this.delete(dataMap));

        result.putAll(this.selectSearch(dataMap));
        return result;
    }

    public Object insertAndSelectSearch(Map dataMap) {

        HashMap result = new HashMap<>();
        result.put("insertCount", this.insert(dataMap));

        result.putAll(this.selectSearch(dataMap));
        return result;
    }

    public Object updateAndSelectSearch(String UNIQUE_ID,Map dataMap) {
        dataMap.put("COMMON_CODE_ID", UNIQUE_ID);
        
        HashMap result = new HashMap<>();
        result.put("updateCount", this.update(dataMap));

        result.putAll(this.selectSearch(dataMap));
        return result;
    }

    // public Object selectAll(String COMMON_CODE_ID) {
    //     // Object getOne(String sqlMapId, Object dataMap)
    //     String sqlMapId = "Infors.selectAll";
    //     HashMap dataMap = new HashMap<>();
    //     dataMap.put("COMMON_CODE_ID", COMMON_CODE_ID);

    //     Object result = sharedDao.getList(sqlMapId, dataMap);
    //     return result;
    // }

    // public Object selectDetail(String CAR_INFOR_ID) {
    //     // Object getOne(String sqlMapId, Object dataMap)
    //     String sqlMapId = "Infors.selectByUID";
    //     HashMap dataMap = new HashMap<>();
    //     dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);

    //     Object result = sharedDao.getOne(sqlMapId, dataMap);
    //     return result;
    // }

    public Object selectDetail(String COMMON_CODE_ID, Map dataMap) {
        // Object getOne(String sqlMapId, Object dataMap)
        String sqlMapId = "Infors.selectByUID";
        dataMap.put("COMMON_CODE_ID", COMMON_CODE_ID);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object insert(Map dataMap) {
        String sqlMapId = "Infors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

    public Object update(Map dataMap) {
        String sqlMapId = "Infors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        return result;
    }


    // MVC view
    public Object delete(Map dataMap) {
        String sqlMapId = "Infors.delete";

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }
    
    // rest api
    public Object delete(String COMMON_CODE_ID) {
        String sqlMapId = "Infors.delete";
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMMON_CODE_ID", COMMON_CODE_ID);

        Object result = sharedDao.delete(sqlMapId, dataMap);
        return result;
    }

    // 2PC
    public Object insertDouble(Map dataMap) {
        String sqlMapId = "Infors.insert";
        // sucess
        Object result = sharedDao.insert(sqlMapId, dataMap);
        // error
        result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }

}



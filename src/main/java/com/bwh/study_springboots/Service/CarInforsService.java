package com.bwh.study_springboots.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwh.study_springboots.dao.SharedDao;

@Service
@Transactional // 서비스중에 오류가 발생하면 자동으로rollback한다.(select 제외)
public class CarInforsService {
    @Autowired
    SharedDao sharedDao;
    //검색 조건 : YEAR, CAR_NAME임.
     public Object selectsearch(String search, String words) {
        // getOne(String sqlMapId, Object dataMap)
        HashMap dataMap = new HashMap<>();
        dataMap.put("search", search);
        dataMap.put("words", words);
        String sqlMapId = "CarInfors.selectsearch";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

      public Object selectAll(String CAR_INFOR_ID) {
        // getOne(String sqlMapId, Object dataMap)
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);
        String sqlMapId = "CarInfors.selectAll";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

    public Object selectDetail(String CAR_INFOR_ID) {
        // getOne(String sqlMapId, Object dataMap)
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);
        String sqlMapId = "CarInfors.selectByUID";
        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }

    public Object insert(Map dataMap){ //파라미터가 Map형식이다.
        String sqlMapId = "CarInfors.insert";
        Object result = sharedDao.insert(sqlMapId, dataMap);
        
        return result;

    }

     public Object update(Map dataMap){ //파라미터가 Map형식이다.
        String sqlMapId = "CarInfors.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        
        return result;

    }

    public Object delete(String CAR_INFOR_ID){ //파라미터가 Map형식이다.
        HashMap dataMap = new HashMap<>();
        dataMap.put("CAR_INFOR_ID", CAR_INFOR_ID);
        String sqlMapId = "CarInfors.delete";
        Object result = sharedDao.update(sqlMapId, dataMap);
        
        return result;

    }
        // 2PC 2pagecommit create
        public Object insertDouble(Map dataMap){ //파라미터가 Map형식이다.
        String sqlMapId = "CarInfors.insert";
        //sucess
        Object result = sharedDao.insert(sqlMapId, dataMap);
        //error
        result = sharedDao.insert(sqlMapId, dataMap);
        
        
        return result;

    }
}

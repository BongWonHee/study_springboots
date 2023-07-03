package com.bwh.study_springboots.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bwh.study_springboots.dao.SharedDao;

@Service
@Transactional // 서비스중에 오류가 발생하면 자동으로rollback한다.(select 제외)
public class CarCompanyService {
    @Autowired
    SharedDao sharedDao;
    //검색 조건이 YEAR, CAR_NAME 일때!!
     public Object CarCompanysearch(String COMPANY_ID, String NAME) {
        // getOne(String sqlMapId, Object dataMap)
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);
        dataMap.put("NAME", NAME);
        
        String sqlMapId = "CarCompany.search";
        Object result = sharedDao.getList(sqlMapId, dataMap);
        return result;
    }

   
 
    public Object CarCompanyinsert(Map dataMap){ //파라미터가 Map형식이다.
        String sqlMapId = "CarCompany.insert";
       Object result = sharedDao.insert(sqlMapId, dataMap);
        
        return result;

    }

     public Object CarCompanyupdate(Map dataMap){ //파라미터가 Map형식이다.
        String sqlMapId = "CarCompany.update";
        Object result = sharedDao.update(sqlMapId, dataMap);
        
        return result;

    }

    public Object CarCompanydelete(String COMPANY_ID){ //파라미터가 Map형식이다.
        HashMap dataMap = new HashMap<>();
        dataMap.put("COMPANY_ID", COMPANY_ID);
        String sqlMapId = "CarCompany.delete";
        Object result = sharedDao.update(sqlMapId, dataMap);
        
        return result;

    }
    
}

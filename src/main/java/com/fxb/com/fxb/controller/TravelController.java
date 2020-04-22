package com.fxb.com.fxb.controller;

import com.fxb.com.fxb.dao.TravelDao;
import com.fxb.com.fxb.entity.TravelEntity;
import com.fxb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Transactional
public class TravelController {
    @Autowired
    private TravelDao travelDao;
    //查询所有活动
    @RequestMapping("{zt}/listtravel")
    public List<TravelEntity> getListTravel(@PathVariable("zt")int zt){
        return  travelDao.getListTravelByZt(zt);
    }
    @RequestMapping("{zt}/listtravelNow")
    public List<TravelEntity> getListTravelNow(@PathVariable("zt")int zt){
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY");
        String year=sdf.format(new Date());
        return  travelDao.getListTravelByZt(zt,year);
    }
    //查询所有活动
    @RequestMapping("{zt}/{yearStr}/listtravel")
    public List<TravelEntity> getListTravel(@PathVariable("zt")int zt,@PathVariable("yearStr")String yearStr){
        if(yearStr.equals("1")){
            return  travelDao.getListTravelByZt(zt);
        }else {
            return  travelDao.getListTravelByZt(zt,yearStr);
        }
    }
   //添加活动
    @RequestMapping("addActive")
    public  List<TravelEntity> addActive(TravelEntity trave){
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY");
        String year=sdf.format(new Date());
        trave.setYearStr(year);
       travelDao.save(trave);
        return travelDao.getListTravelByZt(0);
    }

    //关闭活动
    @RequestMapping("{id}/closeActive")
    public  List<TravelEntity> closeActive(@PathVariable("id") String id){
       TravelEntity travel= travelDao.findById(id).get();
       travel.setZt(1);
        return travelDao.getListTravelByZt(0);
    }
    //开启活动
    @RequestMapping("{id}/openActive")
    public List<TravelEntity> openActive(@PathVariable("id") String id){
        TravelEntity travel= travelDao.findById(id).get();
        travel.setZt(0);
        return travelDao.getListTravelByZt(1);
    }
}

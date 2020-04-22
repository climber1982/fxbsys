package com.fxb.com.fxb.dao;

import com.fxb.com.fxb.entity.TravelEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TravelDao extends CrudRepository<TravelEntity,String> {
    /**
     * 根据状态查询所有活动
     * @param zt
     * @return
     */
    @Query("from TravelEntity where zt=?1 order by startT desc  ")
    public List<TravelEntity> getListTravelByZt(int zt);
    @Query("from TravelEntity where zt=?1 and  yearStr=?2 order by startT desc  ")
    public List<TravelEntity> getListTravelByZt(int zt,String yearStr);


}

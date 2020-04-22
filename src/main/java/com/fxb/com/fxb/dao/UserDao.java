package com.fxb.com.fxb.dao;

import com.fxb.com.fxb.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface UserDao extends CrudRepository<UserEntity,String> {
    @Query("from UserEntity  u where u.travelEntity.id=?1 ")
    public List<UserEntity> getListUserByTravelId(String trid);
   @Query("select new map(u.userName as userName,u.carId as carId,u.tel as tel) from UserEntity  u where u.travelEntity.id=?1")
    public List<Map<String,Object>> getListUserMapByTravelId(String trid);

    @Query("from UserEntity  u where  u.userName=?1")
    public  List<UserEntity> findUser(String userName);
}

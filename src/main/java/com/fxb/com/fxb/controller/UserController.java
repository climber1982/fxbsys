package com.fxb.com.fxb.controller;

import com.fxb.com.fxb.dao.UserDao;
import com.fxb.com.fxb.entity.TravelEntity;
import com.fxb.com.fxb.entity.UserEntity;
import com.fxb.util.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Transactional
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("addUser")
    public List<UserEntity> addUser(UserEntity user,String tr_id){
        TravelEntity tr=new TravelEntity();
        tr.setId(tr_id);
        user.setTravelEntity(tr);
        userDao.save(user);
        return (List<UserEntity>) userDao.getListUserByTravelId(tr_id);
    }

  @RequestMapping("{trid}/listUser")
    public List<UserEntity> listUser(@PathVariable("trid") String trid){
      return (List<UserEntity>) userDao.getListUserByTravelId(trid);
    }
    @RequestMapping("{trid}/listUserMap")
    public void listUserMap(@PathVariable("trid") String trid, HttpServletResponse response) throws IOException {
      List<Map<String,Object>> maps= userDao.getListUserMapByTravelId(trid);
      Map<String,Object> map=new HashMap<>();
      map.put("userName","用户名");
      map.put("carId","身份证号码");
      map.put("tel","电话号码");
        HSSFWorkbook workbook= ExportExcel.exportData("fxb",map,maps);
        ExportExcel.down(response,"保险EXCLE",workbook);
    }
   @RequestMapping("{userId}/{trid}/delUser")
    public List<UserEntity>  delUser(@PathVariable("userId")String userId,@PathVariable("trid") String trid){
       userDao.deleteById(userId);
       return (List<UserEntity>) userDao.getListUserByTravelId(trid);
  }
 @RequestMapping("{userId}/updateUserGoto")
  public UserEntity updateUserGoto(@PathVariable("userId")String userId){
        return userDao.findById(userId).get();
  }
  @RequestMapping("{userName}/findUser")
  public UserEntity findUser(@PathVariable("userName")String userName){
    List<UserEntity> list=  userDao.findUser(userName);
      UserEntity userEntity=new UserEntity();
    if (null!=list){
        return list.get(0);
    }
    return  userEntity;
  }
  @RequestMapping("loginUser")
  public boolean loginUser(String loginName, String loginPass, HttpServletRequest request) throws Exception {

        if(!loginName.equals("fxb")||!loginPass.equals("fxb1798")){
          return  false;
        }else {
            request.getSession().setAttribute("userObj","userObj");
            return true;
        }
  }




}

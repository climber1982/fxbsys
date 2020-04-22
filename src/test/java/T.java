import com.fxb.FxbMain;
import com.fxb.com.fxb.dao.TravelDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FxbMain.class)
public class T {

    @Autowired
  private  TravelDao travelDao;

    @Test
    public  void test(){
        travelDao.getListTravelByZt(1);
    }

}

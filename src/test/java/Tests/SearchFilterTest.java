package Tests;

import Pages.HomePage;
import org.testng.annotations.Test;


public class SearchFilterTest extends BaseTest{
    HomePage home;
    @Test
    public void testSearch(){
        home = new HomePage(driver);
        home.search();
        if(home.checkItemSearch()){
            test.pass("good");
        }
        else {
            test.fail("bad");
        }
    }

}

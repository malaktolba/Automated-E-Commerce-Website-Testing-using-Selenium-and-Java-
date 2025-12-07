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
    @Test
    public void testFilter(){
        home = new HomePage(driver);
        if(home.filter()){
            test.pass("pass");
        }
        else{
            test.fail("fail");
        }
    }
    @Test
    public void testSort(){
        home = new HomePage(driver);
        home.sort();
        if(home.checkSort()){
            test.pass("right");
        }
        else{
            test.fail("wrong");
        }
    }
}

package testpackages;
import org.testng.annotations.DataProvider;

public class DataForTests {
	
	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost(){
		return new Object [][] {
			{"Graham2", "Bell2", 1},
			{"Grad2", "Simon2", 2}
		};
	}
	
	@DataProvider(name = "DataForDelete")
	public Object[] DataForDelete() {
		
		return new Object[] {
				8, 9, 10
		};
	}

}

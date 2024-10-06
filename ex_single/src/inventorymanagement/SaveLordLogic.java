package inventorymanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveLordLogic {

	public void saveData(IMVO vo) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"))){
			writer.write(vo.toString());
			writer.newLine();			
			System.out.println("저장성공");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void lordData() {
		
	}
}

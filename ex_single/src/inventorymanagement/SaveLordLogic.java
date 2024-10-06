package inventorymanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveLordLogic {

	public void saveData(ArrayList<String> list) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("products.txt"))){
			for(String item : list) {
				writer.write(item);
				writer.newLine();
			}
			System.out.println("저장성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

package inventorymanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
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
	public ArrayList<IMVO> lordData() {
		ArrayList<IMVO> list = new ArrayList<>();
		
		
		try(BufferedReader reader = new BufferedReader(new FileReader("products.txt"))){
			String line;
			while((line = reader.readLine()) != null) {
				String [] parts = line.split(",");
				IMVO vo = new IMVO();
				
				vo.setCategory(parts[0]);
				vo.setProductkey(parts[1]);
				vo.setProduct(parts[2]);
				vo.setPrice(parts[3]);
				vo.setUnit(parts[4]);
				
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

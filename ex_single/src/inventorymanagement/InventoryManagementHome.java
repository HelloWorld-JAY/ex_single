package inventorymanagement;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class InventoryManagementHome extends JFrame {

	MainTab main;
	InsertUpdateDeleteTab inUpDe;
	
	public InventoryManagementHome() {
	
		main = new MainTab();
		inUpDe = new InsertUpdateDeleteTab();
		
		JTabbedPane jTab = new JTabbedPane();
		jTab.addTab("재고관리 메인", main);
		jTab.addTab("상품(등록,수정,삭제)", inUpDe);
		
		jTab.setSelectedIndex(1);
		
		add(jTab,BorderLayout.CENTER);
		
		setTitle("재고관리 프로그램");
		setBounds(600, 150, 800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {

		new InventoryManagementHome();
		
		

	}

}

package inventorymanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class InsertUpdateDeleteTab extends JPanel{

	JLabel		jlProductAdd,jlCategory,jlProduct,jlPrice,jlUnit; 	// 상품등록
	JTextField	jtfCategory,jtfProduct,jtfPrice,jtfUnit;			// 상품등록
	JButton		jbAdd;												// 상품등록

	JLabel		jlProductUpDel,jlCategory2,jlSearch;										// 상품수정,삭제
	JTextField	jtfSearch;
	JButton		jbDel,jbUpdate;	
	
	JComboBox<String>	jcUpDel;

	String[] header = {"카테고리명","NO.상품명","가격","단위/수량"};
	JTable table;
	DefaultTableModel model;
	JScrollPane jsPane;											
	
	SaveLordLogic slLohic;
	
	public InsertUpdateDeleteTab() {
		
		slLohic = new SaveLordLogic();
		
		//================================================ 상품등록
		jlProductAdd	= new JLabel("상 품 등 록");
		jlCategory		= new JLabel("카테고리명");
		jlProduct		= new JLabel("       상품명");
		jlPrice			= new JLabel("          가격");
		jlUnit			= new JLabel("  단위/수량");

		jtfCategory		= new JTextField(10);
		jtfProduct		= new JTextField(10);
		jtfPrice		= new JTextField(10);
		jtfUnit			= new JTextField(10);

		jbAdd			= new JButton("상 품 등 록");
		jbDel			= new JButton("상품삭제");
		jbUpdate		= new JButton("상품수정");
		//================================================ 상품수정
		jlProductUpDel	= new JLabel("상 품 수 정 / 삭 제");
		jlCategory2		= new JLabel("카테고리선택");
		jlSearch		= new JLabel("              검색");
		
		jtfSearch		= new JTextField(10);
		
		
		jcUpDel			= new JComboBox<>();
		model 			= new DefaultTableModel(header,0);
		table 			= new JTable(model);
		jsPane			= new JScrollPane(table);
		//================================================ 메서드
		
		eventPro();
		addLayout();

	}
	public void addLayout() {

			
		
		// ----------------------------------------------------- 상품등록페이지
		JPanel productAdd = new JPanel();							// 상품등록 패널생성 

		productAdd.setLayout(new GridBagLayout());					// 그리드백레이아웃 설정
		GridBagConstraints gbcAdd = new GridBagConstraints();		// 그리드백콘스트레인트 설정 (그리드백 내부설정 클래스)
		gbcAdd.insets = new Insets(22, 10, 40, 10);					// 좌우상하 여백설정

		gbcAdd.gridx = 0; gbcAdd.gridy = 0;							// 1행1열 배치
		gbcAdd.gridwidth = 2;										// 두행 합치기
		gbcAdd.anchor = GridBagConstraints.CENTER;					// 합친 두행에 중앙에 배치
		productAdd.add(jlProductAdd, gbcAdd);						// 레이블 패널에 등록
		jlProductAdd.setFont(new Font("고딕",Font.BOLD,30));			// 글씨 설정

		gbcAdd.gridwidth = 1;								
		gbcAdd.gridy = 1;
		productAdd.add(jlCategory, gbcAdd);
		jlCategory.setFont(new Font("고딕",Font.ITALIC,15));

		gbcAdd.gridx = 1;
		productAdd.add(jtfCategory, gbcAdd);
		jtfCategory.setHorizontalAlignment(JTextField.RIGHT);
		
		gbcAdd.gridx = 0; gbcAdd.gridy = 2;
		productAdd.add(jlProduct, gbcAdd);
		jlProduct.setFont(new Font("고딕",Font.ITALIC,15));

		gbcAdd.gridx = 1; // 상품명 필드
		productAdd.add(jtfProduct, gbcAdd);
		jtfProduct.setHorizontalAlignment(JTextField.RIGHT);
		
		gbcAdd.gridx = 0; gbcAdd.gridy = 3;
		productAdd.add(jlPrice, gbcAdd);
		jlPrice.setFont(new Font("고딕",Font.ITALIC,15));

		gbcAdd.gridx = 1; // 가격 필드
		productAdd.add(jtfPrice, gbcAdd);
		jtfPrice.setHorizontalAlignment(JTextField.RIGHT);
		
		gbcAdd.gridx = 0; gbcAdd.gridy = 4;
		productAdd.add(jlUnit, gbcAdd);
		jlUnit.setFont(new Font("고딕",Font.ITALIC,15));

		gbcAdd.gridx = 1; // 단위 필드
		productAdd.add(jtfUnit, gbcAdd);
		jtfUnit.setHorizontalAlignment(JTextField.RIGHT);
		
		gbcAdd.gridx = 0; gbcAdd.gridy = 5;							// 1행 6번째 열 배치
		gbcAdd.gridwidth = 2;										// 행합침  
		gbcAdd.anchor = GridBagConstraints.CENTER;					// 합친행 중앙배치
		productAdd.add(jbAdd, gbcAdd);
		jbAdd.setFont(new Font("고딕",Font.BOLD,15));
		jbAdd.setPreferredSize(new Dimension(120,30));

		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);		// 테두리 클래스 선언
		productAdd.setBorder(blackLine);									// 테두리 패널에 추가

		//-------------------------------------------------	상품 수정 매개변수 초기화
		
		//------------------------------------------------- 상품 수정,삭제 페이지
		
		
		JPanel productUpDel = new JPanel();
		
		
		productUpDel.setLayout(new GridBagLayout());
		GridBagConstraints gbcUpDel = new GridBagConstraints();
		gbcUpDel.insets = new Insets(0, 10, 15, 10);
		
		gbcUpDel.gridx = 0;	gbcUpDel.gridy = 0;
		gbcUpDel.gridwidth = 4;											// 두행 합치기
		gbcUpDel.anchor = GridBagConstraints.CENTER;					// 합친 두행에 중앙에 배치
		productUpDel.add(jlProductUpDel, gbcUpDel);						// 레이블 패널에 등록
		jlProductUpDel.setFont(new Font("고딕",Font.BOLD,30));			// 글씨 설정
		
		gbcUpDel.gridwidth = 1;
		gbcUpDel.gridx = 0; gbcUpDel.gridy = 1; 
		productUpDel.add(jlCategory2, gbcUpDel);
		jlCategory2.setFont(new Font("고딕",Font.ITALIC,15));
		
		
		gbcUpDel.gridx = 1; 
		productUpDel.add(jcUpDel, gbcUpDel);
		jcUpDel.setPreferredSize(new Dimension(150,20));
		
		gbcUpDel.gridx = 2;
		productUpDel.add(jlSearch, gbcUpDel);
		jlSearch.setFont(new Font("고딕",Font.ITALIC,15));
		
		gbcUpDel.gridx = 3;
		productUpDel.add(jtfSearch, gbcUpDel);
		
		gbcUpDel.gridwidth = 4;
		gbcUpDel.gridx = 0; gbcUpDel.gridy = 2;
		gbcUpDel.anchor = GridBagConstraints.CENTER;
		productUpDel.add(jsPane, gbcUpDel);
		jsPane.setPreferredSize(new Dimension(500,325));
		
		gbcUpDel.gridwidth = 2;
		gbcUpDel.gridx = 0; gbcUpDel.gridy = 3;
		gbcUpDel.anchor = GridBagConstraints.CENTER;
		productUpDel.add(jbUpdate, gbcUpDel);
		jbUpdate.setFont(new Font("고딕",Font.BOLD,15));
		jbUpdate.setPreferredSize(new Dimension(120,30));
		
		gbcUpDel.gridwidth = 2;
		gbcUpDel.gridx = 2; gbcUpDel.gridy = 3;
		gbcUpDel.anchor = GridBagConstraints.CENTER;
		productUpDel.add(jbDel, gbcUpDel);
		jbDel.setFont(new Font("고딕",Font.BOLD,15));
		jbDel.setPreferredSize(new Dimension(120,30));
		
		
		productUpDel.setBorder(blackLine);									// 테두리 패널에 추가 
		
		
		//------------------------------------------------- 화면 설정 및 배치
		setLayout(new GridBagLayout());
		GridBagConstraints gbcPane = new GridBagConstraints();
		gbcPane.fill = GridBagConstraints.BOTH;
		
		gbcPane.weightx = 0.15;
        gbcPane.weighty = 1;
        gbcPane.gridx = 0;
        gbcPane.gridy = 0;
        add(productAdd, gbcPane);
        
        gbcPane.weightx = 0.7;
        gbcPane.gridx = 1;
        add(productUpDel, gbcPane);
	}
	
	public void eventPro() {
		jbAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				prductAdd();
				
			}
		});
	}
	
	void prductAdd() {
		
		ArrayList<String> list = new ArrayList<>();

		list.add(jtfCategory.getText());
		list.add(UUID.randomUUID().toString());
		list.add(jtfProduct.getText());
		list.add(jtfPrice.getText());
		list.add(jtfUnit.getText());
		
		System.out.println(list);
		slLohic.saveData(list);
		
		clearField();
	}
	void clearField() {
		jtfCategory.setText("");;
		jtfProduct.setText("");;
		jtfPrice.setText("");;
		jtfUnit.setText("");;
	}
}

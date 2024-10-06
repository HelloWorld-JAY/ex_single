package inventorymanagement;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainTab extends JPanel {

	JLabel 		jlSearch,jlCount;
	JTextField 	jtfSearch,jtfCount;
	JButton 	jbCountAdd,jbCountDel;
	String[] header = {"카테고리명","NO.상품명","가격","수량","단위"};
	
	JTable table;
	DefaultTableModel model;
	JScrollPane jsPane;
	
	SaveLordLogic slLohic = new SaveLordLogic();
	public MainTab(){
		
		model 	= new DefaultTableModel(header,0);
		table 	= new JTable(model);
		jsPane	= new JScrollPane(table);
		
		lordData();
		addLayout();
	}
	public void addLayout() {
		
		jlSearch	= new JLabel("검색");
		jlCount		= new JLabel("                                              입고/출고");
		
		jbCountAdd	= new JButton("상품입고");
		jbCountDel	= new JButton("상품출고");
		
		jtfSearch	= new JTextField(15);
		jtfCount	= new JTextField(8);
		
		JPanel searchCount = new JPanel();
		searchCount.setLayout(new FlowLayout(FlowLayout.CENTER,5,22));
		searchCount.add(jlSearch);
		jlSearch.setFont(new Font("고딕",Font.ITALIC,15));
		searchCount.add(jtfSearch);
		jtfSearch.setHorizontalAlignment(JTextField.RIGHT);
		searchCount.add(jlCount);
		jlCount.setFont(new Font("고딕",Font.ITALIC,15));
		searchCount.add(jtfCount);
		jtfCount.setHorizontalAlignment(JTextField.RIGHT);
		searchCount.add(jbCountAdd);
		jbCountAdd.setPreferredSize(new Dimension(90,19));
		jbCountAdd.setFont(new Font("고딕",Font.ITALIC,14));
		jbCountAdd.setMargin(new Insets(0,0,0,0));
		searchCount.add(jbCountDel);
		jbCountDel.setPreferredSize(new Dimension(90,19));
		jbCountDel.setFont(new Font("고딕",Font.ITALIC,14));
		
		JPanel maintable = new JPanel();
		maintable.add(jsPane);
		jsPane.setPreferredSize(new Dimension(750,450));
		
		
		setLayout(new BorderLayout());
		add(searchCount,BorderLayout.NORTH);
		add(maintable,BorderLayout.CENTER);
		
	}
	void lordData() {
		
		ArrayList<IMVO> vo = slLohic.lordData();
		for(IMVO item : vo) {
			model.addRow(item.toStringArrayAdd());
		}
	}
}

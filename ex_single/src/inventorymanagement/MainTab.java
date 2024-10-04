package inventorymanagement;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainTab extends JPanel {

	JLabel 		jlSearch,jlCount;
	JTextField 	jtfSearch,jtfCount;
	JButton 	jbCountAdd,jbCountDel;
	String[] header = {"No.카테고리명","NO.상품명","가격","수량/단위"};
	
	JTable table;
	DefaultTableModel model;
	JScrollPane jsPane;
	
	
	public MainTab(){
		
		model 	= new DefaultTableModel(header,0);
		table 	= new JTable(model);
		jsPane	= new JScrollPane(table);
		
		
		addLayout();
	}
	public void addLayout() {
		
		jlSearch	= new JLabel("검색");
		jlCount		= new JLabel("                                                                    입고/출고");
		
		jbCountAdd	= new JButton("상품입고");
		jbCountDel	= new JButton("상품출고");
		
		jtfSearch	= new JTextField(15);
		jtfCount	= new JTextField(8);
		
		JPanel searchCount = new JPanel();
		searchCount.setLayout(new FlowLayout(FlowLayout.CENTER,5,22));
		searchCount.add(jlSearch);
		searchCount.add(jtfSearch);
		jtfSearch.setHorizontalAlignment(JTextField.RIGHT);
		searchCount.add(jlCount);
		searchCount.add(jtfCount);
		jtfCount.setHorizontalAlignment(JTextField.RIGHT);
		searchCount.add(jbCountAdd);
		jbCountAdd.setPreferredSize(new Dimension(90,19));
		searchCount.add(jbCountDel);
		jbCountDel.setPreferredSize(new Dimension(90,19));
		
		JPanel maintable = new JPanel();
		maintable.add(jsPane);
		jsPane.setPreferredSize(new Dimension(750,450));
		
		
		setLayout(new BorderLayout());
		add(searchCount,BorderLayout.NORTH);
		add(maintable,BorderLayout.CENTER);
		
	}
}

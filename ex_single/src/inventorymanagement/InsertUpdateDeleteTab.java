package inventorymanagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InsertUpdateDeleteTab extends JPanel{

	JLabel jlProductAdd,jlCategory,jlProduct,jlPrice,jlUnit;
	JTextField jtfCategory,jtfProduct,jtfPrice,jtfUnit;
	JButton jbAdd,jbDel,jbUpdate;
	
	
	public InsertUpdateDeleteTab() {

		addLayout();
		
	}
	public void addLayout() {
        
		jlProductAdd	= new JLabel("       상품등록 페이지 ");
		jlCategory		= new JLabel("    카테고리명 ");
		jlProduct		= new JLabel("           상품명 ");
		jlPrice			= new JLabel("               가격 ");
		jlUnit			= new JLabel("               단위 ");
		
		jtfCategory		= new JTextField(10);
		jtfProduct		= new JTextField(10);
		jtfPrice		= new JTextField(10);
		jtfUnit			= new JTextField(10);
		
		jbAdd			= new JButton("상품등록");
		jbDel			= new JButton("상품삭제");
		jbUpdate		= new JButton("상품수정");
		
		JPanel productAdd = new JPanel();
		
		productAdd.setLayout(new FlowLayout(FlowLayout.LEFT,10,55));
		productAdd.add(jlProductAdd);
		jlProductAdd.setFont(new Font("고딕",Font.BOLD,20));
		productAdd.add(jlCategory);
		jlCategory.setFont(new Font("고딕",Font.ITALIC,15));
		productAdd.add(jtfCategory);
		productAdd.add(jlProduct);
		jlProduct.setFont(new Font("고딕",Font.ITALIC,15));
		productAdd.add(jtfProduct);
		productAdd.add(jlPrice);
		jlPrice.setFont(new Font("고딕",Font.ITALIC,15));
		productAdd.add(jtfPrice);
		productAdd.add(jlUnit);
		jlUnit.setFont(new Font("고딕",Font.ITALIC,15));
		productAdd.add(jtfUnit);
		productAdd.add(new JLabel("                "));
		productAdd.add(jbAdd);
		jbAdd.setFont(new Font("고딕",Font.BOLD,15));
		jbAdd.setPreferredSize(new Dimension(120,30));
		Border blackLine = BorderFactory.createLineBorder(Color.BLACK);
		productAdd.setBorder(blackLine);
		
		JPanel productDel = new JPanel();
		
		JPanel productUpdate = new JPanel();
		
		
		setLayout(new GridLayout(0,3));
		add(productAdd);
		add(productUpdate);
		add(productDel);
		
	}
}

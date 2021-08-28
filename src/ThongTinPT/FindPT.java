package ThongTinPT;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.apple.dnssd.TXTRecord;

import thang.dev.data.dao.PhongTroDAO;
import thang.dev.data.model.PhongTro;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FindPT extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdPhongTro;
	private JTable tblPhongTro;
	private JLabel lblTmKimThng;
	private JLabel lblIdPhongTro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindPT frame = new FindPT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FindPT() {
		setTitle("T\u00ECm Ki\u1EBFm Ph\u00F2ng Tr\u1ECD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfIdPhongTro = new JTextField();
		tfIdPhongTro.setBounds(283, 82, 149, 34);
		contentPane.add(tfIdPhongTro);
		tfIdPhongTro.setColumns(10);
		
		JButton btnTimKiem = new JButton("T\u00ECm Ki\u1EBFm");
		btnTimKiem.setBounds(444, 82, 97, 34);
		contentPane.add(btnTimKiem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 148, 479, 283);
		contentPane.add(scrollPane);
		
		tblPhongTro = new JTable();
		scrollPane.setViewportView(tblPhongTro);
		
		lblTmKimThng = new JLabel("T\u00ECm Ki\u1EBFm Th\u00F4ng Tin Ph\u00F2ng Tr\u1ECD");
		lblTmKimThng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKimThng.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTmKimThng.setBounds(132, 25, 336, 35);
		contentPane.add(lblTmKimThng);
		
		lblIdPhongTro = new JLabel("Nh\u1EADp ID ph\u00F2ng tr\u1ECD mu\u1ED1n t\u00ECm:");
		lblIdPhongTro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdPhongTro.setBounds(72, 86, 197, 34);
		contentPane.add(lblIdPhongTro);
		
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhongTro phongtro=new PhongTroDAO().findById(Integer.parseInt(tfIdPhongTro.getText()));
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("Id");
				model.addColumn("Gia");
				model.addColumn("Trang Thai");
				model.addColumn("Mo ta");
				Object[] object =new Object[10];
				object[0]=phongtro.getId();
				object[1]=phongtro.getGia();
				object[2]=phongtro.getTrangThai();
				object[3]=phongtro.getMoTa();
				model.addRow(object);
				tblPhongTro.setModel(model);
			}
		});
	}

}

package ThongTinTT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import thang.dev.data.dao.KhachHangDAO;
import thang.dev.data.dao.ThueTroDAO;
import thang.dev.data.model.KhachHang;
import thang.dev.data.model.ThueTro;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FindTT extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdKhachHang;
	private JTable tblThueTro;
	private JLabel lblTmKimThng;
	private JLabel lblNhpIdPhng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindTT frame = new FindTT();
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
	public FindTT() {
		setTitle("T\u00ECm Ki\u1EBFm Th\u00F4ng Tin Thu\u00EA Tr\u1ECD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 909, 422);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfIdKhachHang = new JTextField();
		tfIdKhachHang.setBounds(412, 83, 174, 34);
		panel.add(tfIdKhachHang);
		tfIdKhachHang.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 140, 655, 262);
		panel.add(scrollPane);
		
		tblThueTro = new JTable();
		scrollPane.setViewportView(tblThueTro);
		
		JButton btnTimKiem = new JButton("T\u00ECm Ki\u1EBFm");
		btnTimKiem.setBounds(611, 83, 97, 34);
		panel.add(btnTimKiem);
		
		lblTmKimThng = new JLabel("T\u00ECm Ki\u1EBFm Th\u00F4ng Tin Thu\u00EA Tr\u1ECD");
		lblTmKimThng.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKimThng.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTmKimThng.setBounds(217, 24, 336, 35);
		panel.add(lblTmKimThng);
		
		lblNhpIdPhng = new JLabel("Nh\u1EADp ID kh\u00E1ch h\u00E0ng ho\u1EB7c ph\u00F2ng tr\u1ECD mu\u1ED1n t\u00ECm:");
		lblNhpIdPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpIdPhng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhpIdPhng.setBounds(43, 83, 371, 34);
		panel.add(lblNhpIdPhng);
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ThueTro thueTro=new ThueTroDAO().findById(Integer.parseInt(tfIdKhachHang.getText()));
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("Id khach hang");
				model.addColumn("Id Phong Tro");
				model.addColumn("Ngay den");
				model.addColumn("Ngay di");
				Object[]object =new Object[10];
				object[0]=thueTro.getId_kh();
				object[1]=thueTro.getId_room();
				object[2]=thueTro.getNgayDen();
				object[3]=thueTro.getNgayDi();
				model.addRow(object);
				tblThueTro.setModel(model);
				
			}
		});
	}

}

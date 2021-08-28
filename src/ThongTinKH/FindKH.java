package ThongTinKH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import thang.dev.data.dao.KhachHangDAO;
import thang.dev.data.model.KhachHang;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class FindKH extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdKH;
	private JTable tblKhachHang;
	private JLabel lblFindKH;
	private JLabel lbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindKH frame = new FindKH();
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
	public FindKH() {
		setTitle("Tìm Kiếm Khách Hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Panel panel = new Panel();
		panel.setBounds(0, 0, 630, 436);
		contentPane.add(panel);
		panel.setLayout(null);

		txtIdKH = new JTextField();
		txtIdKH.setBounds(251, 76, 225, 34);
		panel.add(txtIdKH);
		txtIdKH.setColumns(10);

		JButton btnTimKiem = new JButton("T\u00ECm Ki\u1EBFm");
		btnTimKiem.setBounds(500, 75, 97, 37);
		panel.add(btnTimKiem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 123, 554, 264);
		panel.add(scrollPane);

		tblKhachHang = new JTable();
		scrollPane.setViewportView(tblKhachHang);
		
		lblFindKH = new JLabel("Tìm Kiếm Thông Tin Khách Hàng");
		lblFindKH.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFindKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblFindKH.setBounds(153, 26, 336, 35);
		panel.add(lblFindKH);
		
		lbl = new JLabel("Nhập ID khách hàng muốn tìm:");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setBounds(33, 78, 212, 34);
		panel.add(lbl);

		btnTimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				KhachHang khachhang = new KhachHang();
				KhachHangDAO cus = new KhachHangDAO();
				khachhang = cus.findById(Integer.parseInt(txtIdKH.getText()));
                DefaultTableModel model=new DefaultTableModel();
                model.addColumn("id");
                model.addColumn("Tên khách hàng");
                model.addColumn("Tuổi");
                model.addColumn("Địa chỉ");
                Object[] object =new Object[4];
                object[0]=khachhang.getId();
                object[1]=khachhang.getTen();
                object[2]=khachhang.getTuoi();
                object[3]=khachhang.getDiachi();
                model.addRow(object);
                tblKhachHang.setModel(model);
			}
		});
	}

}

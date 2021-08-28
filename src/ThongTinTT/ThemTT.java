package ThongTinTT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import thang.dev.data.dao.PhongTroDAO;
import thang.dev.data.dao.ThueTroDAO;
import thang.dev.data.model.ThueTro;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class ThemTT extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdKhachHang;
	private JTextField tfIdPhongTro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemTT frame = new ThemTT();
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
	public ThemTT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Thêm Thông Tin Thuê Trọ: ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(87, 13, 295, 53);
		contentPane.add(label);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(12, 76, 446, 151);
		contentPane.add(layeredPane);
		
		JLabel lblIdkh = new JLabel("ID_KH");
		lblIdkh.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdkh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdkh.setBounds(12, 23, 56, 34);
		layeredPane.add(lblIdkh);
		
		tfIdKhachHang = new JTextField();
		tfIdKhachHang.setColumns(10);
		tfIdKhachHang.setBounds(81, 24, 131, 34);
		layeredPane.add(tfIdKhachHang);
		
		JLabel lblIdpt = new JLabel("ID_PT");
		lblIdpt.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdpt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdpt.setBounds(12, 93, 56, 34);
		layeredPane.add(lblIdpt);
		
		tfIdPhongTro = new JTextField();
		tfIdPhongTro.setColumns(10);
		tfIdPhongTro.setBounds(81, 94, 131, 34);
		layeredPane.add(tfIdPhongTro);
		
		JLabel lblNgyn = new JLabel("Ngày Đến:");
		lblNgyn.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgyn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyn.setBounds(221, 23, 82, 34);
		layeredPane.add(lblNgyn);
		
		JLabel lblNgyi = new JLabel("Ngày Đi:");
		lblNgyi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgyi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyi.setBounds(224, 93, 56, 34);
		layeredPane.add(lblNgyi);
		
		JDateChooser txtNgayDen = new JDateChooser();
		txtNgayDen.setBounds(315, 23, 119, 34);
		layeredPane.add(txtNgayDen);
		
		JDateChooser txtNgayDi = new JDateChooser();
		txtNgayDi.setBounds(318, 93, 116, 34);
		layeredPane.add(txtNgayDi);
		
		JButton btnthem = new JButton("Thêm");
		btnthem.setBounds(301, 240, 77, 39);
		contentPane.add(btnthem);
			
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(392, 240, 77, 39);
		contentPane.add(btnCancel);
		
		btnthem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                 int idKhachHang  =Integer.parseInt(tfIdKhachHang.getText().toString());
                 int idPhongTro =Integer.parseInt(tfIdPhongTro.getText().toString());
                 java.sql.Date ngayDi=new Date(txtNgayDi.getDate().getTime());
                 java.sql.Date ngayDen=new Date(txtNgayDen.getDate().getTime());
                 int namdi=ngayDi.getYear()+1901;
                 ngayDi.setYear(namdi);
                 int namden=ngayDen.getYear()+1901;
                 ngayDen.setYear(namden);
                 ThueTro thueTro = new ThueTro(idKhachHang, idPhongTro, ngayDen, ngayDi);
                 ThueTroDAO thueTroDAO = new ThueTroDAO();
                 thueTroDAO.save(thueTro);
                 JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công");
            }
		});
	}
	
}

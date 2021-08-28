package ThongTinKH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import thang.dev.data.dao.KhachHangDAO;
import thang.dev.data.model.KhachHang;
import thang.dev.gui.DoAnGui;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Window.Type;

public class Them extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdKhachHang;
	private JTextField tfTenKhachHang;
	private JTextField tfTuoiKhachHang;
	private JTextField tfDiaChiKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Them frame = new Them();
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
	public Them() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThemThongTin = new JLabel("Thêm Thông Tin Khách Hàng");
		lblThemThongTin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThemThongTin.setBounds(90, 13, 295, 53);
		contentPane.add(lblThemThongTin);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(24, 65, 419, 154);
		contentPane.add(layeredPane);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBackground(Color.WHITE);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(23, 13, 36, 43);
		layeredPane.add(lblId);
		
		tfIdKhachHang = new JTextField();
		tfIdKhachHang.setBounds(70, 15, 116, 41);
		layeredPane.add(tfIdKhachHang);
		tfIdKhachHang.setColumns(10);
		
		JLabel lblTen = new JLabel("Tên: ");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTen.setBounds(23, 78, 44, 41);
		layeredPane.add(lblTen);
		
		tfTenKhachHang = new JTextField();
		tfTenKhachHang.setBounds(70, 76, 116, 41);
		layeredPane.add(tfTenKhachHang);
		tfTenKhachHang.setColumns(10);
		
		JLabel lblTuoi = new JLabel("Tuổi: ");
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTuoi.setBounds(231, 19, 56, 30);
		layeredPane.add(lblTuoi);
		
		tfTuoiKhachHang = new JTextField();
		tfTuoiKhachHang.setBounds(291, 17, 116, 37);
		layeredPane.add(tfTuoiKhachHang);
		tfTuoiKhachHang.setColumns(10);
		
		JLabel lbldiachi = new JLabel("Địa Chỉ: ");
		lbldiachi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbldiachi.setBounds(231, 91, 56, 16);
		layeredPane.add(lbldiachi);
		
		tfDiaChiKhachHang = new JTextField();
		tfDiaChiKhachHang.setBounds(291, 78, 116, 41);
		layeredPane.add(tfDiaChiKhachHang);
		tfDiaChiKhachHang.setColumns(10);
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(265, 239, 77, 39);
		contentPane.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ten = tfTenKhachHang.getText();
				int old = Integer.parseInt(tfTuoiKhachHang.getText());
				String diaChi = tfDiaChiKhachHang.getText();
				KhachHang kH = new KhachHang(ten, old, diaChi);
				KhachHangDAO cus = new KhachHangDAO();
				cus.save(kH);
				JOptionPane.showMessageDialog(null, "Đã thêm xong");
			}
		});
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(354, 239, 77, 39);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	hide();
            }});
	}
}

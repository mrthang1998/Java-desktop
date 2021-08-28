package ThongTinKH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import thang.dev.data.dao.KhachHangDAO;
import thang.dev.data.model.KhachHang;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField tfIDKhachHang;
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
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Sửa Thông Tin Khách Hàng");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(93, 13, 295, 53);
		contentPane.add(label);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(40, 70, 419, 154);
		contentPane.add(layeredPane);
		
		JLabel label_1 = new JLabel("Id:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(23, 13, 36, 43);
		layeredPane.add(label_1);
		
		tfIDKhachHang = new JTextField();
		tfIDKhachHang.setColumns(10);
		tfIDKhachHang.setBounds(70, 15, 116, 41);
		layeredPane.add(tfIDKhachHang);
		
		JLabel label_2 = new JLabel("Tên:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(23, 78, 44, 41);
		layeredPane.add(label_2);
		
		tfTenKhachHang = new JTextField();
		tfTenKhachHang.setColumns(10);
		tfTenKhachHang.setBounds(70, 76, 116, 41);
		layeredPane.add(tfTenKhachHang);
		
		JLabel label_3 = new JLabel("Tuổi:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(231, 19, 56, 30);
		layeredPane.add(label_3);
		
		tfTuoiKhachHang = new JTextField();
		tfTuoiKhachHang.setColumns(10);
		tfTuoiKhachHang.setBounds(291, 17, 116, 37);
		layeredPane.add(tfTuoiKhachHang);
		
		JLabel label_4 = new JLabel("Địa Chỉ");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(231, 91, 56, 16);
		layeredPane.add(label_4);
		
		tfDiaChiKhachHang = new JTextField();
		tfDiaChiKhachHang.setColumns(10);
		tfDiaChiKhachHang.setBounds(291, 78, 116, 41);
		layeredPane.add(tfDiaChiKhachHang);
		
		JButton buttonCancel = new JButton("Hủy");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonCancel.setBounds(382, 249, 77, 39);
		contentPane.add(buttonCancel);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setBounds(282, 249, 77, 39);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfIDKhachHang.getText());
				String ten = tfTenKhachHang.getText();
				int tuoi = Integer.parseInt(tfTuoiKhachHang.getText());
				String diaChi = tfDiaChiKhachHang.getText();
				KhachHang kH = new KhachHang(id, ten, tuoi, diaChi);
				
				KhachHangDAO cus = new KhachHangDAO();
				cus.update(kH);
				JOptionPane.showMessageDialog(null, "Đã cập nhật xong khách hàng");
			}
		});
		
	}
}

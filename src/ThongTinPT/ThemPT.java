package ThongTinPT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import thang.dev.data.dao.PhongTroDAO;
import thang.dev.data.model.PhongTro;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ThemPT extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdPhongTro;
	private JTextField tfTrangThaiPhong;
	private JTextField tfGiaPhongTro;
	private JTextField tfMoTa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemPT frame = new ThemPT();
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
	public ThemPT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Thêm Thông Tin Phòng Trọ: ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(92, 13, 295, 53);
		contentPane.add(label);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(12, 70, 446, 151);
		contentPane.add(layeredPane);
		
		JLabel lblID = new JLabel("ID: ");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(12, 23, 56, 34);
		layeredPane.add(lblID);
		
		tfIdPhongTro = new JTextField();
		tfIdPhongTro.setBounds(60, 23, 131, 34);
		layeredPane.add(tfIdPhongTro);
		tfIdPhongTro.setColumns(10);
		
		JLabel lblGi = new JLabel("Giá: ");
		lblGi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGi.setBounds(12, 93, 56, 34);
		layeredPane.add(lblGi);
		
		tfGiaPhongTro = new JTextField();
		tfGiaPhongTro.setColumns(10);
		tfGiaPhongTro.setBounds(60, 93, 131, 34);
		layeredPane.add(tfGiaPhongTro);
		
		JLabel lblTrngThi = new JLabel("Trạng Thái: ");
		lblTrngThi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTrngThi.setBounds(224, 23, 82, 34);
		layeredPane.add(lblTrngThi);
		
		tfTrangThaiPhong = new JTextField();
		tfTrangThaiPhong.setColumns(10);
		tfTrangThaiPhong.setBounds(303, 23, 131, 34);
		layeredPane.add(tfTrangThaiPhong);
		
		JLabel lblMT = new JLabel("Mô Tả: ");
		lblMT.setHorizontalAlignment(SwingConstants.CENTER);
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMT.setBounds(224, 93, 56, 34);
		layeredPane.add(lblMT);
		
		tfMoTa = new JTextField();
		tfMoTa.setColumns(10);
		tfMoTa.setBounds(303, 94, 131, 34);
		layeredPane.add(tfMoTa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(285, 234, 77, 39);
		contentPane.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int gia = Integer.parseInt(tfGiaPhongTro.getText());
				int trangThai = Integer.parseInt(tfTrangThaiPhong.getText());
				String moTa = tfMoTa.getText();
				PhongTro phongTro= new PhongTro(moTa, gia, trangThai);
				PhongTroDAO room = new PhongTroDAO();
				room.save(phongTro);
				JOptionPane.showMessageDialog(null, "Đã thêm xong phòng trọ");
			}
		});
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(381, 234, 77, 39);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}

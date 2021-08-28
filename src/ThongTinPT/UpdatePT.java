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

public class UpdatePT extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdPhongTro;
	private JTextField tfGiaPhongTro;
	private JTextField tfTrangThaiPhong;
	private JTextField tfMoTa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePT frame = new UpdatePT();
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
	public UpdatePT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Sửa Thông Tin Phòng Trọ: ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(87, 13, 295, 53);
		contentPane.add(label);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(12, 68, 446, 151);
		contentPane.add(layeredPane);
		
		JLabel label_1 = new JLabel("ID: ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(12, 23, 56, 34);
		layeredPane.add(label_1);
		
		tfIdPhongTro = new JTextField();
		tfIdPhongTro.setColumns(10);
		tfIdPhongTro.setBounds(60, 23, 131, 34);
		layeredPane.add(tfIdPhongTro);
		
		JLabel label_2 = new JLabel("Giá: ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(12, 93, 56, 34);
		layeredPane.add(label_2);
		
		tfGiaPhongTro = new JTextField();
		tfGiaPhongTro.setColumns(10);
		tfGiaPhongTro.setBounds(60, 93, 131, 34);
		layeredPane.add(tfGiaPhongTro);
		
		JLabel label_3 = new JLabel("Trạng Thái: ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(224, 23, 82, 34);
		layeredPane.add(label_3);
		
		tfTrangThaiPhong = new JTextField();
		tfTrangThaiPhong.setColumns(10);
		tfTrangThaiPhong.setBounds(303, 23, 131, 34);
		layeredPane.add(tfTrangThaiPhong);
		
		JLabel label_4 = new JLabel("Mô Tả: ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_4.setBounds(224, 93, 56, 34);
		layeredPane.add(label_4);
		
		tfMoTa = new JTextField();
		tfMoTa.setColumns(10);
		tfMoTa.setBounds(303, 94, 131, 34);
		layeredPane.add(tfMoTa);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setBounds(290, 232, 77, 39);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfIdPhongTro.getText());
				int gia = Integer.parseInt(tfGiaPhongTro.getText());
				int trangThai = Integer.parseInt(tfTrangThaiPhong.getText());
				String moTa = tfMoTa.getText();
				PhongTro phongTro = new PhongTro(id, moTa, gia, trangThai);
				PhongTroDAO room = new PhongTroDAO();
				room.update(phongTro);
				JOptionPane.showMessageDialog(null, "Đã cập nhật xong phòng trọ");
			}
		});
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(381, 232, 77, 39);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}

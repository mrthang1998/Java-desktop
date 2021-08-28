package ThongTinPT;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import thang.dev.data.dao.PhongTroDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeletePT extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdPhongTro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePT frame = new DeletePT();
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
	public DeletePT() {
		setTitle("Xóa Thông Tin Phòng Trọ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Xóa Thông Tin Phòng Trọ: ");
		label.setBounds(93, 15, 295, 53);
		contentPane.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 81, 446, 113);
		contentPane.add(layeredPane);
		
		JLabel lblNhpIdPhng = new JLabel("Nhập ID phòng muốn xóa: ");
		lblNhpIdPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhpIdPhng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhpIdPhng.setBounds(12, 23, 233, 35);
		layeredPane.add(lblNhpIdPhng);
		
		tfIdPhongTro = new JTextField();
		tfIdPhongTro.setColumns(10);
		tfIdPhongTro.setBounds(257, 24, 131, 34);
		layeredPane.add(tfIdPhongTro);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(282, 207, 77, 39);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfIdPhongTro.getText());
				PhongTroDAO room = new PhongTroDAO();
				room.delete(id);
				JOptionPane.showMessageDialog(null, "Đã xóa xong phòng trọ");
			}
		});
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setBounds(371, 207, 77, 39);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}

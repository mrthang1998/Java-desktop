package ThongTinKH;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import thang.dev.data.dao.KhachHangDAO;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField tfIdKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblXoaThongTin = new JLabel("Xóa Thông tin khách hàng");
		lblXoaThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblXoaThongTin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblXoaThongTin.setBounds(90, 13, 295, 53);
		contentPane.add(lblXoaThongTin);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(23, 79, 414, 121);
		contentPane.add(layeredPane);
		
		JLabel lblNhpIdCa = new JLabel("Nhập thông tin khách hàng cần xóa: ");
		lblNhpIdCa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNhpIdCa.setHorizontalAlignment(SwingConstants.LEFT);
		lblNhpIdCa.setBounds(12, 13, 295, 84);
		layeredPane.add(lblNhpIdCa);
		
		tfIdKhachHang = new JTextField();
		tfIdKhachHang.setBounds(275, 34, 116, 45);
		layeredPane.add(tfIdKhachHang);
		tfIdKhachHang.setColumns(10);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setBounds(281, 213, 77, 39);
		contentPane.add(btnDelete);
		
		JButton btnCancel1 = new JButton("Hủy");
		btnCancel1.setBounds(370, 213, 77, 39);
		contentPane.add(btnCancel1);
	
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfIdKhachHang.getText());
				KhachHangDAO cus = new KhachHangDAO();
				cus.delete(id);
				JOptionPane.showMessageDialog(null, "Đã xóa xong khách hàng");
				
			}
		});
		
		btnCancel1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }});
	}
}

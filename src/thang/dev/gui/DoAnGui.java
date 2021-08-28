package thang.dev.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.*;
import thang.dev.data.dao.KhachHangDAO;
import thang.dev.data.dao.PhongTroDAO;
import thang.dev.data.dao.ThueTroDAO;
import thang.dev.data.model.KhachHang;
import thang.dev.data.model.PhongTro;
import thang.dev.data.model.ThueTro;

import javax.swing.JTabbedPane;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.apple.dnssd.TXTRecord;

import ThongTinKH.Them;
import ThongTinKH.Delete;
import ThongTinKH.Update;
import ThongTinKH.FindKH;


import ThongTinPT.ThemPT;
import ThongTinPT.UpdatePT;
import ThongTinPT.DeletePT;
import ThongTinPT.FindPT;

import ThongTinTT.ThemTT;
import ThongTinTT.FindTT;


public class DoAnGui extends JFrame {

	private JPanel contentPane;
	private JTable tblKhachHang;
	KhachHangDAO khdao;
	List<KhachHang> list;
	DefaultTableModel modelKhachHang; 
	
	private JTable tblPhongTro;
	PhongTroDAO ptDao;
	List<PhongTro> listPT;
	DefaultTableModel modelPhongTro;
	private JTable tblThueTro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoAnGui frame = new DoAnGui();
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
	public DoAnGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 823, 704);
		contentPane.add(tabbedPane);

		//Thông tin khách hàng
		Panel panelThongTinKH = new Panel();
		panelThongTinKH.setBackground(Color.WHITE);
		tabbedPane.addTab("Thông tin Khách hàng", null, panelThongTinKH, null);
		panelThongTinKH.setLayout(null);

		JButton btnAdd = new JButton("Thêm Thông Tin");
		btnAdd.setBounds(12, 32, 127, 127);
		panelThongTinKH.add(btnAdd);
		
		//Thực hiện click cho nút thêm thông tin khách hàng
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Them them = new Them();
				them.main(null);
				
			}
		});

		JButton btnUpdate = new JButton("Sửa Thông Tin");
		btnUpdate.setBounds(12, 191, 127, 127);
		panelThongTinKH.add(btnUpdate);
		
		//Thực hiện click cho nút Sửa thông tin khách hàng
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Update update = new Update();
				update.main(null);
			}
		});

		JButton btnDelete = new JButton("Xóa Thông Tin");
		btnDelete.setBounds(12, 351, 127, 127);
		panelThongTinKH.add(btnDelete);
		
		//Thực hiện click cho nút xóa thông tin khách hàng
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Delete delete = new Delete();
				delete.main(null);
			}
		});
		

		JButton btnFindKH = new JButton("Tìm Kiếm ");
		btnFindKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindKH findKhachHang = new FindKH();
				findKhachHang.main(null);
			}
		});
		btnFindKH.setBounds(12, 518, 127, 127);
		panelThongTinKH.add(btnFindKH);

		JLabel lblListCus = new JLabel("Danh sách Khách Hàng");
		lblListCus.setHorizontalAlignment(SwingConstants.CENTER);
		lblListCus.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListCus.setBounds(221, 32, 497, 53);
		panelThongTinKH.add(lblListCus);

		//Hiển thị danh sách khách hàng lấy từ mysql
		JScrollPane scrPaneKH = new JScrollPane();
		scrPaneKH.setBounds(177, 98, 608, 491);
		panelThongTinKH.add(scrPaneKH);

		tblKhachHang = new JTable();
		tblKhachHang.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Tên", "Tuổi", "Địa Chỉ" }));
		scrPaneKH.setViewportView(tblKhachHang);
		
		khdao = new KhachHangDAO();
		list = new ArrayList<>();
		modelKhachHang = (DefaultTableModel) tblKhachHang.getModel();
		fillToTable();

		
		//Thông tin phòng trọ
		Panel panelThongTinPT = new Panel();
		panelThongTinPT.setBackground(Color.WHITE);
		tabbedPane.addTab("Thông tin phòng trọ", null, panelThongTinPT, null);
		panelThongTinPT.setLayout(null);
		
		JButton btnAddPT = new JButton("Thêm Thông Tin");
		btnAddPT.setBounds(12, 43, 127, 127);
		panelThongTinPT.add(btnAddPT);
		
		//Thực hiện Click cho nút thêm phòng trọ
		btnAddPT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ThemPT themPT = new ThemPT();
				themPT.main(null);
			}
		});
	
		
		JButton btnUpdatePT = new JButton("Sửa Thông Tin");
		btnUpdatePT.setBounds(12, 196, 127, 127);
		panelThongTinPT.add(btnUpdatePT);
		
		//Thực hiện click cho nút sửa thông tin phòng trọ
		btnUpdatePT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdatePT updatePT = new UpdatePT();
				updatePT.main(null);
			}
		});
		
		JButton btnDeletePT = new JButton("Xóa Thông Tin");
		btnDeletePT.setBounds(12, 344, 127, 127);
		panelThongTinPT.add(btnDeletePT);
		
		//Thực hiện click cho nút xóa thông tin phòng trọ 
		btnDeletePT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeletePT deletePT = new DeletePT();
				deletePT.main(null);
			}
		});
		
		JButton btnFindPT = new JButton("Tìm Kiếm");
		btnFindPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindPT findPhongTro = new FindPT();
				findPhongTro.main(null);
			}
		});
		btnFindPT.setBounds(12, 505, 127, 127);
		panelThongTinPT.add(btnFindPT);
		
		JLabel lblDSPhongTro = new JLabel("Danh sách phòng trọ:");
		lblDSPhongTro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDSPhongTro.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDSPhongTro.setBounds(226, 43, 497, 53);
		panelThongTinPT.add(lblDSPhongTro);
		
		//Hiển thị danh sách phòng trọ lấy từ mysql
		JScrollPane scrPanePT = new JScrollPane();
		scrPanePT.setBounds(166, 118, 608, 514);
		panelThongTinPT.add(scrPanePT);
		
		tblPhongTro = new JTable();
		tblPhongTro.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Giá", "Trạng Thái", "Mô Tả" }));
		scrPanePT.setViewportView(tblPhongTro);
		ptDao = new PhongTroDAO();
		listPT = new ArrayList<>();
		modelPhongTro = (DefaultTableModel) tblPhongTro.getModel();
		fillToTablePT();
		
		
		//Thông tin thuê trọ
		Panel panelThongTinTT = new Panel();
		tabbedPane.addTab("Thông tin thuê trọ", null, panelThongTinTT, null);
		panelThongTinTT.setLayout(null);
		
		JButton btnAddTT = new JButton("Thêm Thông Tin");
		btnAddTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemTT themThueTro = new ThemTT();
				themThueTro.main(null);
				
			}
		});
		btnAddTT.setBounds(12, 202, 127, 127);
		panelThongTinTT.add(btnAddTT);
		
		JButton btnFindTT = new JButton("Tìm Kiếm");
		btnFindTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindTT findThueTro = new FindTT();
				findThueTro.main(null);
			}
		});
		btnFindTT.setBounds(12, 386, 127, 127);
		panelThongTinTT.add(btnFindTT);
		
		JLabel lblDSThueTro = new JLabel("Danh sách thuê trọ");
		lblDSThueTro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDSThueTro.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDSThueTro.setBounds(224, 41, 497, 53);
		panelThongTinTT.add(lblDSThueTro);
		
		JScrollPane scrPaneTT = new JScrollPane();
		scrPaneTT.setBounds(185, 115, 600, 510);
		panelThongTinTT.add(scrPaneTT);
		
		tblThueTro = new JTable();
		scrPaneTT.setViewportView(tblThueTro);
		fillToTableThueTro();
		
	}
	
	//phuong thuc hien thi danh sach khach hang
	public void fillToTable() {
		list = khdao.findAll();


		for (KhachHang kh : list) {
			Object[] obj = { kh.getId(), kh.getTen(), kh.getTuoi(), kh.getDiachi() };
			modelKhachHang.addRow(obj);

		}
	}
	
	//phuong thuc hien thi danh sach Phòng Trọ
		public void fillToTablePT() {
			listPT = ptDao.findAll();
			modelPhongTro.setRowCount(0);
			for (PhongTro pt : listPT) {
				Object[] obj= {pt.getId(), pt.getGia(), pt.getTrangThai(), pt.getMoTa()};
				modelPhongTro.addRow(obj);
				
			}
			
		}
		
	//Phuong thuc hien thi danh sach thue tro
		public void fillToTableThueTro() {
			List<ThueTro> listthuetro = new ArrayList<ThueTro>();
			listthuetro = new ThueTroDAO().findAll();
			DefaultTableModel modelThueTro=new DefaultTableModel();
			modelThueTro.setRowCount(0);
			modelThueTro.addColumn("Id Khách Hàng");
			modelThueTro.addColumn("Id room");
			modelThueTro.addColumn("Ngày đến");
			modelThueTro.addColumn("Ngày đi");
			for (ThueTro thuetro : listthuetro) {
				Object[] obj= {thuetro.getId_kh(), thuetro.getId_room(), thuetro.getNgayDen(),thuetro.getNgayDi()};
				modelThueTro.addRow(obj);
			}
			tblThueTro.setModel(modelThueTro);
		}
		
}


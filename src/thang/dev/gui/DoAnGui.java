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

		//Th??ng tin kh??ch h??ng
		Panel panelThongTinKH = new Panel();
		panelThongTinKH.setBackground(Color.WHITE);
		tabbedPane.addTab("Th??ng tin Kh??ch h??ng", null, panelThongTinKH, null);
		panelThongTinKH.setLayout(null);

		JButton btnAdd = new JButton("Th??m Th??ng Tin");
		btnAdd.setBounds(12, 32, 127, 127);
		panelThongTinKH.add(btnAdd);
		
		//Th???c hi???n click cho n??t th??m th??ng tin kh??ch h??ng
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Them them = new Them();
				them.main(null);
				
			}
		});

		JButton btnUpdate = new JButton("S???a Th??ng Tin");
		btnUpdate.setBounds(12, 191, 127, 127);
		panelThongTinKH.add(btnUpdate);
		
		//Th???c hi???n click cho n??t S???a th??ng tin kh??ch h??ng
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Update update = new Update();
				update.main(null);
			}
		});

		JButton btnDelete = new JButton("X??a Th??ng Tin");
		btnDelete.setBounds(12, 351, 127, 127);
		panelThongTinKH.add(btnDelete);
		
		//Th???c hi???n click cho n??t x??a th??ng tin kh??ch h??ng
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Delete delete = new Delete();
				delete.main(null);
			}
		});
		

		JButton btnFindKH = new JButton("T??m Ki???m ");
		btnFindKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindKH findKhachHang = new FindKH();
				findKhachHang.main(null);
			}
		});
		btnFindKH.setBounds(12, 518, 127, 127);
		panelThongTinKH.add(btnFindKH);

		JLabel lblListCus = new JLabel("Danh s??ch Kh??ch H??ng");
		lblListCus.setHorizontalAlignment(SwingConstants.CENTER);
		lblListCus.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblListCus.setBounds(221, 32, 497, 53);
		panelThongTinKH.add(lblListCus);

		//Hi???n th??? danh s??ch kh??ch h??ng l???y t??? mysql
		JScrollPane scrPaneKH = new JScrollPane();
		scrPaneKH.setBounds(177, 98, 608, 491);
		panelThongTinKH.add(scrPaneKH);

		tblKhachHang = new JTable();
		tblKhachHang.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "T??n", "Tu???i", "?????a Ch???" }));
		scrPaneKH.setViewportView(tblKhachHang);
		
		khdao = new KhachHangDAO();
		list = new ArrayList<>();
		modelKhachHang = (DefaultTableModel) tblKhachHang.getModel();
		fillToTable();

		
		//Th??ng tin ph??ng tr???
		Panel panelThongTinPT = new Panel();
		panelThongTinPT.setBackground(Color.WHITE);
		tabbedPane.addTab("Th??ng tin ph??ng tr???", null, panelThongTinPT, null);
		panelThongTinPT.setLayout(null);
		
		JButton btnAddPT = new JButton("Th??m Th??ng Tin");
		btnAddPT.setBounds(12, 43, 127, 127);
		panelThongTinPT.add(btnAddPT);
		
		//Th???c hi???n Click cho n??t th??m ph??ng tr???
		btnAddPT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ThemPT themPT = new ThemPT();
				themPT.main(null);
			}
		});
	
		
		JButton btnUpdatePT = new JButton("S???a Th??ng Tin");
		btnUpdatePT.setBounds(12, 196, 127, 127);
		panelThongTinPT.add(btnUpdatePT);
		
		//Th???c hi???n click cho n??t s???a th??ng tin ph??ng tr???
		btnUpdatePT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdatePT updatePT = new UpdatePT();
				updatePT.main(null);
			}
		});
		
		JButton btnDeletePT = new JButton("X??a Th??ng Tin");
		btnDeletePT.setBounds(12, 344, 127, 127);
		panelThongTinPT.add(btnDeletePT);
		
		//Th???c hi???n click cho n??t x??a th??ng tin ph??ng tr??? 
		btnDeletePT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeletePT deletePT = new DeletePT();
				deletePT.main(null);
			}
		});
		
		JButton btnFindPT = new JButton("T??m Ki???m");
		btnFindPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindPT findPhongTro = new FindPT();
				findPhongTro.main(null);
			}
		});
		btnFindPT.setBounds(12, 505, 127, 127);
		panelThongTinPT.add(btnFindPT);
		
		JLabel lblDSPhongTro = new JLabel("Danh s??ch ph??ng tr???:");
		lblDSPhongTro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDSPhongTro.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblDSPhongTro.setBounds(226, 43, 497, 53);
		panelThongTinPT.add(lblDSPhongTro);
		
		//Hi???n th??? danh s??ch ph??ng tr??? l???y t??? mysql
		JScrollPane scrPanePT = new JScrollPane();
		scrPanePT.setBounds(166, 118, 608, 514);
		panelThongTinPT.add(scrPanePT);
		
		tblPhongTro = new JTable();
		tblPhongTro.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Gi??", "Tr???ng Th??i", "M?? T???" }));
		scrPanePT.setViewportView(tblPhongTro);
		ptDao = new PhongTroDAO();
		listPT = new ArrayList<>();
		modelPhongTro = (DefaultTableModel) tblPhongTro.getModel();
		fillToTablePT();
		
		
		//Th??ng tin thu?? tr???
		Panel panelThongTinTT = new Panel();
		tabbedPane.addTab("Th??ng tin thu?? tr???", null, panelThongTinTT, null);
		panelThongTinTT.setLayout(null);
		
		JButton btnAddTT = new JButton("Th??m Th??ng Tin");
		btnAddTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ThemTT themThueTro = new ThemTT();
				themThueTro.main(null);
				
			}
		});
		btnAddTT.setBounds(12, 202, 127, 127);
		panelThongTinTT.add(btnAddTT);
		
		JButton btnFindTT = new JButton("T??m Ki???m");
		btnFindTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindTT findThueTro = new FindTT();
				findThueTro.main(null);
			}
		});
		btnFindTT.setBounds(12, 386, 127, 127);
		panelThongTinTT.add(btnFindTT);
		
		JLabel lblDSThueTro = new JLabel("Danh s??ch thu?? tr???");
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
	
	//phuong thuc hien thi danh sach Ph??ng Tr???
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
			modelThueTro.addColumn("Id Kh??ch H??ng");
			modelThueTro.addColumn("Id room");
			modelThueTro.addColumn("Ng??y ?????n");
			modelThueTro.addColumn("Ng??y ??i");
			for (ThueTro thuetro : listthuetro) {
				Object[] obj= {thuetro.getId_kh(), thuetro.getId_room(), thuetro.getNgayDen(),thuetro.getNgayDi()};
				modelThueTro.addRow(obj);
			}
			tblThueTro.setModel(modelThueTro);
		}
		
}


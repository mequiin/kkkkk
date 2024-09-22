package chuong9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {

	private JFrame frameDangNhap;
	private JTextField tfTenDangNhap;
	private JPasswordField pwf;
	private boolean showPass = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frameDangNhap.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDangNhap = new JFrame();
		frameDangNhap.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int luaChon = JOptionPane.showConfirmDialog(frameDangNhap, "Bạn thật sự muốn thoát?", "Hệ thống", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if(luaChon == JOptionPane.YES_OPTION) {
					System.exit(1);
				}else {
					frameDangNhap.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		frameDangNhap.setTitle("Đăng nhập hệ thống");
		frameDangNhap.getContentPane().setBackground(new Color(128, 255, 255));
		frameDangNhap.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(87, 74, 58, 13);
		frameDangNhap.getContentPane().add(lblNewLabel);
		
		tfTenDangNhap = new JTextField();
		tfTenDangNhap.setBounds(156, 71, 132, 19);
		frameDangNhap.getContentPane().add(tfTenDangNhap);
		tfTenDangNhap.setColumns(10);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(87, 123, 58, 13);
		frameDangNhap.getContentPane().add(lblPassword);
		
		JButton btnDangnhap = new JButton("Đăng nhập");
		btnDangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tenDangNhap = tfTenDangNhap.getText().trim();
				String matKhau = String.valueOf(pwf.getPassword()).trim();
				if (tenDangNhap.length() > 0 && matKhau.length() >0) {
					if(tenDangNhap.equals("admin") && matKhau.equals("123456")) {
						QLSV.main(null);
						frameDangNhap.dispose();
					}else {
						JOptionPane.showMessageDialog(btnDangnhap,"Mật khẩu không đúng!","Hệ thống", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(btnDangnhap,"Mật khẩu không được để trống!","Hệ thống", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDangnhap.setForeground(new Color(0, 0, 64));
		btnDangnhap.setBounds(135, 172, 121, 21);
		frameDangNhap.getContentPane().add(btnDangnhap);
		
		pwf = new JPasswordField();
		pwf.setEchoChar('*');
		pwf.setBounds(156, 120, 132, 19);
		frameDangNhap.getContentPane().add(pwf);
		
		JButton btnHien = new JButton("Hiện");
		btnHien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showPass) {
					btnHien.setText("Hiện");
					pwf.setEchoChar('*');
					showPass = false;
				}else {
					btnHien.setText("Ẩn");
					pwf.setEchoChar('\0'); // hiện mật khẩu
					showPass = true;
				}
			}
		});
		btnHien.setForeground(new Color(0, 0, 0));
		btnHien.setBackground(new Color(128, 255, 128));
		btnHien.setBounds(305, 119, 67, 21);
		frameDangNhap.getContentPane().add(btnHien);
		
		JLabel lblNewLabel_1 = new JLabel("Đăng nhập hệ thống");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(135, 22, 153, 34);
		frameDangNhap.getContentPane().add(lblNewLabel_1);
		frameDangNhap.setBounds(100, 100, 450, 300);
		frameDangNhap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

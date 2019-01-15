package demo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PasswordView extends JFrame implements ActionListener{
	private JButton button1,button2;
	private JPanel panel1,panel2,panel3,panel4;
	private JRadioButton ragioButton1,ragioButton2;
	private JTextField text1,text2;
	private JPasswordField password;
	private JLabel lable1,lable2,lable3;
	private ButtonGroup buttonGroup;
	private static PasswordCMD cmd =new PasswordCMD();
	private final String runKey="yaicwx";
	public static void main(String[] args) {
        new PasswordView().login();
		
	}
	
	private void login(){
		KeyListener login_Listener=new KeyListener() {
			
			public void keyTyped(KeyEvent e) {
	
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER){
					loginCheck();
				}
				
			}
		};
		//创建组件
		button1=new JButton("登录");
		button2=new JButton("重置");
		//设置监听
		button1.addActionListener(this);
		button2.addActionListener(this);
	    lable1=new JLabel("登录密码");
       password=new JPasswordField(20);
       //设置键盘监听
       password.addKeyListener(login_Listener);
       panel1=new JPanel();
       panel2 =new JPanel();
       
       panel1.add(lable1);
       panel1.add(password);
       
       panel2.add(button1);
       panel2.add(button2);
        
       this.add(panel1);
       this.add(panel2);
       this.setLayout(new GridLayout(2,1));
       this.setTitle("密码系统");
       this.setSize(300,300);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
       //禁止改变窗口大小
       this.setResizable(false);
	}
		
	protected void init() {
		//键盘监听事件
		KeyListener init_Listener=new KeyListener() {
		public void keyTyped(KeyEvent e) {
			}
			
			
			public void keyReleased(KeyEvent e) {
	
				
			}
			
			public void keyPressed(KeyEvent e) {
	     	if(e.getKeyChar()==KeyEvent.VK_ENTER){
	     		kissCheck();
	     	}
	     	}
			};	
			//创建组件
			button1=new JButton("提交");
			button2=new JButton("重置");
			
			//设置监听
			button1.addActionListener(this);
			button2.addActionListener(this);
			
			//设置组件
			ragioButton1=new JRadioButton("加密");
			ragioButton2=new JRadioButton("解密");
	        buttonGroup=new ButtonGroup();
	        buttonGroup.add(ragioButton1);
	        buttonGroup.add(ragioButton2);
	        ragioButton1.setSelected(true);
	        ragioButton1.addActionListener(this);
	        ragioButton2.addActionListener(this);
	        panel1=new JPanel();
	        panel2=new JPanel();
	        panel3=new JPanel();
	        panel4=new JPanel();
	        
	        lable1=new JLabel("原文");
	        lable2=new JLabel("模式");
	        lable3=new JLabel("译文");
	        
	        text1=new JTextField(30);
	        
	        text1.addKeyListener(init_Listener);
	        
	        text2=new JTextField(30);
	        password=new JPasswordField(30);
	        
	        panel1.add(lable1);
	        panel1.add(text1);
	        
	        panel4.add(lable3);
	        panel4.add(text2);
	        
	        panel2.add(lable2);
	        panel2.add(ragioButton1);
	        panel2.add(ragioButton2);
	        
	        panel3.add(button1);
	        panel3.add(button2);
	        
	        this.add(panel1);
	        this.add(panel4);
	        this.add(panel2);
	        this.add(panel3);
	        
	        this.setLayout(new GridLayout(4,1));
	        this.setTitle("密码系统");
	        this.setSize(400,400);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	        this.setResizable(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String mode=e.getActionCommand();
	    if("登录".equals(mode)){
	    	loginCheck();
	    }
	    else if("提交".equals(mode)){
	    	kissCheck();
	    }
	    else{
	    	clear();
	    }
	    	
		
	}
	private void clear() {
		if(null!=text1){
			text1.setText("");
		}
		if(null!=text1){
			text2.setText("");
		}
		if(null!=text1){
			password.setText("");
		}
	}

	private void loginCheck() {
				
				String run=new String(password.getPassword());
				if("".equals(run.trim())){
					JOptionPane.showMessageDialog(null, "请输入密码！","提数消息",JOptionPane.WARNING_MESSAGE);
				}
				else if(runKey.equals(run)){
					dispose();
					new PasswordView().init();
				}
				else{
					JOptionPane.showMessageDialog(null, "密码错误！","提数消息",JOptionPane.ERROR_MESSAGE);
					  clear();
					}
				  
			}

			private void kissCheck() {
				String value="";
				text2.setText(value);
				String key=text1.getText();
				//解密
				if(ragioButton2.isSelected()&&!"".equals(key.trim())){
					value=cmd.toGeneratePassword(key);
					
				}
				//加密
				if(ragioButton1.isSelected()&&!"".equals(key.trim())){
					value=cmd.toSeePassword(key);
				}
				if("".equals(value)&&!"".equals(key.trim())){
					JOptionPane.showMessageDialog(null, "数据格式错误", "提数消息",JOptionPane.ERROR_MESSAGE);
				   clear();
				}
				text2.setText(value);
			}
	
		
	}



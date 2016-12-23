package experiment.project05;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;


/**
 * 客户端画板类，该类继承于线程类并且实现了鼠标监听器接口
 * 
 * 
 * 
 */
public class UserDraw extends Thread implements MouseListener {
					Graphics g;
					private int x1, x2, R, G, B;
					private int y1, y2;
					ObjectInputStream ois;
					Socket client;
					Socket chatclient;
					ObjectOutputStream oos;
					OutputStream ous;
					InputStream ins;
					
					JSlider jsR, jsG, jsB;//实例化三个拉杆
					//发送消息
					PrintWriter pw = null;
					JTextArea textArea;
//					JTextArea textArea=null;
//					JTextField textField=new JTextField();
					//textField = new JTextField();
					
					private ButtonGroup bg = new ButtonGroup();// 实例化一个按钮组
					JTextField textField;
					private final Action action = new SwingAction();

							/**
							 * 入口主函数
							 * 
							 * @param args
							 */
							public static void main(String[] args) {
								UserDraw user = new UserDraw();
								user.connectServer();
								user.GUI();
								user.start();
								System.out.println("客户端读线程启动");
							}
							//聊天窗口用到的时间函数
							public String getTime() 
							{
								Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
								int hour = c.get(Calendar.HOUR_OF_DAY); 
								int minute = c.get(Calendar.MINUTE); 
								int second = c.get(Calendar.SECOND);
								return hour+":"+ minute+":"+second;
							}
							/**
							 * 用于显示界面的方法，该界面显示了按钮组，还有 三个拉杆。
							 */
							public void GUI() {
								JFrame jf = new JFrame();
								jf.setTitle("网络白板----客户端系统");
								jf.setSize(900, 600);
								jf.setLocation(150, 100);
								jf.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
							
								/************按钮组的建立************/
								JRadioButton jline = new JRadioButton("画线");
								jline.setActionCommand("画线");
								JRadioButton jcircle = new JRadioButton("画圆");
								jcircle.setActionCommand("画圆");
								JRadioButton jrect = new JRadioButton("画方");
								jrect.setActionCommand("画方");
								this.bg.add(jline);
								this.bg.add(jcircle);
								this.bg.add(jrect);
								jf.getContentPane().add(jline);
								jf.getContentPane().add(jcircle);
								jf.getContentPane().add(jrect);
						
								/** *****设置G滑块的值** */
								jsG = new JSlider(0, 255);// 添加控制颜色的滑块
								jsG.setMajorTickSpacing(10);// 主刻度
								jsG.setMinorTickSpacing(5);// 副刻度
								jsG.setPaintTicks(true);
								jf.getContentPane().add(jsG);
						
								/** ****设置R滑块的值***** */
								jsR = new JSlider(0, 255);// 添加控制颜色的滑块
								jsR.setMajorTickSpacing(10);// 主刻度
								jsR.setMinorTickSpacing(5);// 副刻度
								jsR.setPaintTicks(true);
								jf.getContentPane().add(jsR);
						
								/** ****设置R滑块***** */
								jsB = new JSlider(0, 255);// 添加控制颜色的滑块
								jsB.setMajorTickSpacing(50);// 主刻度
								jsB.setMinorTickSpacing(10);// 副刻度
								jsB.setPaintTicks(true);
								jf.getContentPane().add(jsB);
								
								textArea = new JTextArea();
								textArea.setEditable(false);
								textArea.setRows(10);
								textArea.setColumns(30);
								jf.getContentPane().add(textArea);
								
								textField = new JTextField();
								jf.getContentPane().add(textField);
								textField.setColumns(20);
								
								JButton btnSend = new JButton("send");
								btnSend.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
									}
								});
								btnSend.setAction(action);
								jf.getContentPane().add(btnSend);
//						
//								textArea = new JTextArea();
//							    textArea.setEditable(false);
//								textArea.setRows(10);
//								textArea.setColumns(30);
//								jf.getContentPane().add(textArea);
//								jf.getContentPane().add(textField);
//								textField.setColumns(20);
								
								//JButton btnNewButton = new JButton("New button");
//								btnNewButton.addMouseListener(new MouseAdapter() {
//									@Override
//									public void mouseClicked(MouseEvent e) {
//									}
//								});
								//btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
								//btnNewButton.setAction(action);
								//jf.getContentPane().add(btnNewButton);
								jf.setVisible(true);
								g = jf.getGraphics();
								jf.addMouseListener(this);
								setColor();//调用设置颜色的方法。
							}
						
							/**
							 * 设置画笔的R，G,B三原色，给每个控制基色的拉杆加一个
							 * 监听器。
							 */
							public void setColor() {
					         	//为红色加监听器
								ChangeListener red = (new ChangeListener() {
									public void stateChanged(ChangeEvent e) {
										R = jsR.getValue();
										g.setColor(new Color(R, G, B));
									}
								});
							
								/************给绿色加监听器*************/
								ChangeListener green = (new ChangeListener() {
									public void stateChanged(ChangeEvent e) {
										G = jsG.getValue();
										g.setColor(new Color(R, G, B));
									}
								});
								/************给蓝色加监听器**************/
								ChangeListener blue = (new ChangeListener() {
									public void stateChanged(ChangeEvent e) {
										B = jsB.getValue();
										g.setColor(new Color(R, G, B));
									}
								});
								jsR.addChangeListener(red);
								jsG.addChangeListener(green);
								jsB.addChangeListener(blue);
							}
						/**
						 * 连接服务器的方法，没有给方法设置参数，通过直接赋初始值的方式进行
						 * @return返回 boolean类型，连接成功则返回true，否侧返回false。 
						 */
							public boolean connectServer() {
								try {
						
									client = new Socket("localhost", 6700);
									chatclient=new Socket("localhost", 6500);
									
						
									System.out.println("与服务器连接成功");
									
									while (true) {
										pw = new PrintWriter(chatclient.getOutputStream(),true);//发送聊天
										ins = client.getInputStream();
										ous = client.getOutputStream();
										ois = new ObjectInputStream(ins);
										oos = new ObjectOutputStream(ous);
										return true;
									}
								} catch (Exception ef) {
									ef.printStackTrace();
								}
								return false;
							}
						
							/**
							 * 发送消息的方法，通过鼠标监听器实现
							 * 
							 * @param 要发送的消息
							 * @throws Exception
							 */
						
							@Override
							public void mousePressed(MouseEvent e) {
								x1 = e.getX();
								y1 = e.getY();
						
							}
						
							@Override
							public void mouseReleased(MouseEvent e) {
						
								x2 = e.getX();
								y2 = e.getY();
								Line line = new Line();
								try {
								//获取按钮组的中设置的命令值
									String command = bg.getSelection().getActionCommand();
								/*********设置属性值**********/
									line.setX1(x1);
									line.setX2(x2);
									line.setY1(y1);
									line.setY2(y2);
									line.setCommand(command);
									line.setR(R);
									line.setG(G);
									line.setB(B);
									System.out
											.println("客户端输出的R=" + R + "客户端输出的G=" + G + "客户端输出的B=" + B);
									if (command.equals("画线")) {
										g.drawLine(x1, y1, x2, y2);
									} else if (command.equals("画圆")) {
										g.drawOval(x1, y1, x2 - x1, y2 - y1);
									} else if (command.equals("画方")) {
										g.drawRect(x1, y1, x2 - x1, y2 - y1);
									}
									oos.writeObject(line);
									System.out.println("客户端坐标发送成功");
								} catch (IOException e2) {
									e2.printStackTrace();
								}
						
							}
						 /************重写监听器的方法， 并把这些方法设置为空方法*************/
							@Override
							public void mouseClicked(MouseEvent e) {
							}
						
							@Override
							public void mouseEntered(MouseEvent e) {
							}
						
							@Override
							public void mouseExited(MouseEvent e) {
							}
						
							public void readMesage() {
								try {
						
									BufferedReader br = new BufferedReader
											(new InputStreamReader(chatclient.getInputStream()));//接受消息
								
									String info = br.readLine();
									//if(info.startsWith("client  "))
									//{
										textArea.append("client  "+getTime()+"\r\n"+info+"\r\n");
									//}
									
								//	else
									//{
										Line line = (Line) ois.readObject();
									System.out.println("主机收到客户机发来的东西");
									while (line != null) {
										System.out.println(line.getX1());
										x1 = line.getX1();
										x2 = line.getX2();
										y1 = line.getY1();
										y2 = line.getY2();
										R=line.getR();
										G=line.getG();
										B=line.getB();
										g.setColor(new Color(R,G,B));
										System.out.println("服务器收到的R="+R+"服务器收到的G="+G+"服务器收到的B="+B);
										String command = line.getCommand();
										if (command.equals("画线")) {
											g.drawLine(x1, y1, x2, y2);
										} else if (command.equals("画圆")) {
											g.drawOval(x1, y1, x2 - x1, y2 - y1);
										} else if (command.equals("画方")) {
											g.drawRect(x1, y1, x2 - x1, y2 - y1);
										}
										line = (Line) ois.readObject();
									}
								//	}
								} catch (Exception ef) {
									ef.printStackTrace();
								}
						
								finally {
									try {
										ois.close();
										oos.close();
										ous.close();
										ins.close();
										client.close();
									} catch (IOException e) {
										e.printStackTrace();
									}
						
								}
						
							}
						
							public void run() {
								readMesage();
							}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "send");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("send")) {
				//把写的内容发送
				String info = textField.getText();
				textArea.append("client  "+getTime()+"\r\n"+info+"\r\n");
				pw.println(info);
				//清空发送框内容
				textField.setText("");
		}
		}
	}
}
//class SwingAction extends AbstractAction {
//	public SwingAction() {
//		putValue(NAME, "send");
//		putValue(SHORT_DESCRIPTION, "Some short description");
//	}
//   public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals("send")) {
//			//把写的内容发送
//			String info = textField.getText();
//			textArea.append("server  "+getTime()+"\r\n"+info+"\r\n");
//			pw.println(info);
//			//清空发送框内容
//			textField.setText("");
//			
//		}
//	}
	


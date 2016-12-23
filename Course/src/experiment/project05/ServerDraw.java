package experiment.project05;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;

     			/**
				 * 创建服务器画板类。该类用于实现网络画板
				 * 
				 * 
				 * 
				 */
				public class ServerDraw extends Thread implements MouseListener {
						private InputStream ins;
						private OutputStream ous;
						private static int x1;
						private static int x2;
						private static int y1, R,G,B;
						private static int y2;
						private static Graphics g;
						private ButtonGroup bg = new ButtonGroup();// 创建一个按钮组
						static ObjectInputStream ois;
						Socket client;
						Socket chatclient;
						ObjectOutputStream oos;
						JSlider jsR,jsG,jsB;
						//把信息发给客户端的对象
						PrintWriter pw = null;
					
						JTextArea textArea=null;
						private final JTextField textField = new JTextField();
						private final Action action = new SwingAction();
					
						// 入口的方法
						public static void main(String[] args) {
							ServerDraw server = new ServerDraw();
					
							server.GUI();
							server.setUpServer();
							
					
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
						 * 显示界面的方法
						 */
						public void GUI() {
							JFrame jf = new JFrame();
							jf.setTitle("网络白板---服务器");
							jf.setSize(900, 600);
							jf.setLocation(150, 100);
							jf.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
						
							/***********按钮组的添加*************/
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
						
							/*******设置G滑块的值***/
							
							JLabel label = new JLabel("\u8C03\u8272\uFF1A");
							jf.getContentPane().add(label);
						
							/******设置R滑块的值******/
							jsB = new JSlider(0, 255);// 添加控制颜色的滑块
							jsB.setMajorTickSpacing(50);//主刻度
							jsB.setMinorTickSpacing(10);//副刻度
							jsB.setPaintTicks(true);
							jf.getContentPane().add(jsB);
							jsG = new JSlider(0, 255);// 添加控制颜色的滑块
							jsG.setMajorTickSpacing(10);//主刻度
							jsG.setMinorTickSpacing(5);//副刻度
							jsG.setPaintTicks(true);
							jf.getContentPane().add(jsG);
							jsR = new JSlider(0, 255);// 添加控制颜色的滑块
							jsR.setMajorTickSpacing(10);//主刻度
							jsR.setMinorTickSpacing(5);//副刻度
							jsR.setPaintTicks(true);
							jf.getContentPane().add(jsR);
							
						    textArea = new JTextArea();
						    textArea.setEditable(false);
							textArea.setRows(10);
							textArea.setColumns(30);
							jf.getContentPane().add(textArea);
							jf.getContentPane().add(textField);
							textField.setColumns(20);
							
							JButton btnNewButton = new JButton("New button");
							btnNewButton.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
								}
							});
							btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
							btnNewButton.setAction(action);
							jf.getContentPane().add(btnNewButton);
							
							JPanel panel = new JPanel();
							jf.getContentPane().add(panel);
							panel.setLayout(new BorderLayout(0, 0));
					       
							jf.setVisible(true);
							g = jf.getGraphics();
							jf.addMouseListener(this);// 添加监听器
							setColor();
						}
					   
						/**
						 * 设置画笔的R，G,B三原色，给每个控制基色的拉杆加一个
						 * 监听器。
						 */
						public void setColor(){
						 
						   
						   ChangeListener red= (new ChangeListener() {
								public void stateChanged(ChangeEvent e) {
									R = jsR.getValue();
									g.setColor(new Color(R,G,B));
								}
							});
							/************给绿色加监听器*************/
						   ChangeListener green= (new ChangeListener() {
								public void stateChanged(ChangeEvent e) {
									G = jsG.getValue();
									g.setColor(new Color(R,G,B));
								}
							});
							/************给蓝色加监听器**************/
						   ChangeListener blue= (new ChangeListener() {
								public void stateChanged(ChangeEvent e) {
									B= jsB.getValue();
									g.setColor(new Color(R,G,B));
								}
							});
							jsR.addChangeListener(red); 
							jsG.addChangeListener(green); 
							jsB.addChangeListener(blue); 
					   }
						/**
						 * 定义创建端口的方法
						 * 
						 * @param port创建索引的窗口
						 */
						public void setUpServer() {
							try {
								// 建立绑定在指点端口上的服务器对象
								//ServerSocket server = new ServerSocket(12345);
								ServerSocket server = new ServerSocket(6700);
								ServerSocket chatserver = new ServerSocket(6500);
								System.out.println("端口创建成功");
								
								
								// 当有客户机连结上来时，等待方法就会返回一个代表与客户机连结的对象
								while (true) {// 让服务器进入循环等待状态
									client = server.accept();
									chatclient=chatserver.accept();
									System.out.println("等待中" + client.getRemoteSocketAddress());
									// 调用处理连结对象的方法处理连结对象
									pw = new PrintWriter(chatclient.getOutputStream(),true);//发送聊天
									ous = client.getOutputStream();
									ins = client.getInputStream();
									oos = new ObjectOutputStream(ous);
									ois = new ObjectInputStream(ins);
									
									System.out.println("已经与客户端连接");
									this.start();
									System.out.println("启动了");
					
								}
					
							} catch (Exception ef) {
								ef.printStackTrace();
							}
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
							String command = bg.getSelection().getActionCommand();
							try {
								
								line.setX1(x1);
								line.setX2(x2);
								line.setY1(y1);
								line.setY2(y2);
								line.setCommand(command);
								line.setR(R);
								line.setG(G);
								line.setB(B);
								System.out.println("服务器输出的R="+R+"服务器输出的G="+G+"服务器输出的B="+B);
								if (command.equals("画线")) {
									g.drawLine(x1, y1, x2, y2);
								} else if (command.equals("画圆")) {
									g.drawOval(x1, y1, x2 - x1, y2 - y1);
								} else if (command.equals("画方")) {
									g.drawRect(x1, y1, x2 - x1, y2 - y1);
								}
								oos.writeObject(line);
					
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
								//}
							} catch (Exception ef) {
								ef.printStackTrace();
							} finally {
								try {
					
									ois.close();
									ous.close();
									ins.close();
									oos.close();
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
								//把服务器在写的内容发送给客户端
								String info = textField.getText();
								textArea.append("server  "+getTime()+"\r\n"+info+"\r\n");
								pw.println(info);
								//清空发送框内容
								textField.setText("");
								
							}
						}
						
					}
					}

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
				 * ���������������ࡣ��������ʵ�����续��
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
						private ButtonGroup bg = new ButtonGroup();// ����һ����ť��
						static ObjectInputStream ois;
						Socket client;
						Socket chatclient;
						ObjectOutputStream oos;
						JSlider jsR,jsG,jsB;
						//����Ϣ�����ͻ��˵Ķ���
						PrintWriter pw = null;
					
						JTextArea textArea=null;
						private final JTextField textField = new JTextField();
						private final Action action = new SwingAction();
					
						// ��ڵķ���
						public static void main(String[] args) {
							ServerDraw server = new ServerDraw();
					
							server.GUI();
							server.setUpServer();
							
					
						}
						//���촰���õ���ʱ�亯��
						public String getTime() 
						{
							Calendar c = Calendar.getInstance();//���Զ�ÿ��ʱ���򵥶��޸�
							int hour = c.get(Calendar.HOUR_OF_DAY); 
							int minute = c.get(Calendar.MINUTE); 
							int second = c.get(Calendar.SECOND);
							return hour+":"+ minute+":"+second;
						}
						/**
						 * ��ʾ����ķ���
						 */
						public void GUI() {
							JFrame jf = new JFrame();
							jf.setTitle("����װ�---������");
							jf.setSize(900, 600);
							jf.setLocation(150, 100);
							jf.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
						
							/***********��ť������*************/
							JRadioButton jline = new JRadioButton("����");
							jline.setActionCommand("����");
							JRadioButton jcircle = new JRadioButton("��Բ");
							jcircle.setActionCommand("��Բ");
							JRadioButton jrect = new JRadioButton("����");
							jrect.setActionCommand("����");
							this.bg.add(jline);
							this.bg.add(jcircle);
							this.bg.add(jrect);
							jf.getContentPane().add(jline);
							jf.getContentPane().add(jcircle);
							jf.getContentPane().add(jrect);
						
							/*******����G�����ֵ***/
							
							JLabel label = new JLabel("\u8C03\u8272\uFF1A");
							jf.getContentPane().add(label);
						
							/******����R�����ֵ******/
							jsB = new JSlider(0, 255);// ��ӿ�����ɫ�Ļ���
							jsB.setMajorTickSpacing(50);//���̶�
							jsB.setMinorTickSpacing(10);//���̶�
							jsB.setPaintTicks(true);
							jf.getContentPane().add(jsB);
							jsG = new JSlider(0, 255);// ��ӿ�����ɫ�Ļ���
							jsG.setMajorTickSpacing(10);//���̶�
							jsG.setMinorTickSpacing(5);//���̶�
							jsG.setPaintTicks(true);
							jf.getContentPane().add(jsG);
							jsR = new JSlider(0, 255);// ��ӿ�����ɫ�Ļ���
							jsR.setMajorTickSpacing(10);//���̶�
							jsR.setMinorTickSpacing(5);//���̶�
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
							jf.addMouseListener(this);// ��Ӽ�����
							setColor();
						}
					   
						/**
						 * ���û��ʵ�R��G,B��ԭɫ����ÿ�����ƻ�ɫ�����˼�һ��
						 * ��������
						 */
						public void setColor(){
						 
						   
						   ChangeListener red= (new ChangeListener() {
								public void stateChanged(ChangeEvent e) {
									R = jsR.getValue();
									g.setColor(new Color(R,G,B));
								}
							});
							/************����ɫ�Ӽ�����*************/
						   ChangeListener green= (new ChangeListener() {
								public void stateChanged(ChangeEvent e) {
									G = jsG.getValue();
									g.setColor(new Color(R,G,B));
								}
							});
							/************����ɫ�Ӽ�����**************/
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
						 * ���崴���˿ڵķ���
						 * 
						 * @param port���������Ĵ���
						 */
						public void setUpServer() {
							try {
								// ��������ָ��˿��ϵķ���������
								//ServerSocket server = new ServerSocket(12345);
								ServerSocket server = new ServerSocket(6700);
								ServerSocket chatserver = new ServerSocket(6500);
								System.out.println("�˿ڴ����ɹ�");
								
								
								// ���пͻ�����������ʱ���ȴ������ͻ᷵��һ��������ͻ�������Ķ���
								while (true) {// �÷���������ѭ���ȴ�״̬
									client = server.accept();
									chatclient=chatserver.accept();
									System.out.println("�ȴ���" + client.getRemoteSocketAddress());
									// ���ô����������ķ��������������
									pw = new PrintWriter(chatclient.getOutputStream(),true);//��������
									ous = client.getOutputStream();
									ins = client.getInputStream();
									oos = new ObjectOutputStream(ous);
									ois = new ObjectInputStream(ins);
									
									System.out.println("�Ѿ���ͻ�������");
									this.start();
									System.out.println("������");
					
								}
					
							} catch (Exception ef) {
								ef.printStackTrace();
							}
						}
					
						/**
						 * ������Ϣ�ķ�����ͨ����������ʵ��
						 * 
						 * @param Ҫ���͵���Ϣ
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
								System.out.println("�����������R="+R+"�����������G="+G+"�����������B="+B);
								if (command.equals("����")) {
									g.drawLine(x1, y1, x2, y2);
								} else if (command.equals("��Բ")) {
									g.drawOval(x1, y1, x2 - x1, y2 - y1);
								} else if (command.equals("����")) {
									g.drawRect(x1, y1, x2 - x1, y2 - y1);
								}
								oos.writeObject(line);
					
							} catch (IOException e2) {
								e2.printStackTrace();
							}
					
						}
						 /************��д�������ķ����� ������Щ��������Ϊ�շ���*************/
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
										(new InputStreamReader(chatclient.getInputStream()));//������Ϣ
							
								String info = br.readLine();
								//if(info.startsWith("client  "))
								//{
									textArea.append("client  "+getTime()+"\r\n"+info+"\r\n");
								//}
								
							//	else
								//{
									Line line = (Line) ois.readObject();
								System.out.println("�����յ��ͻ��������Ķ���");
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
									System.out.println("�������յ���R="+R+"�������յ���G="+G+"�������յ���B="+B);
									String command = line.getCommand();
									if (command.equals("����")) {
										g.drawLine(x1, y1, x2, y2);
									} else if (command.equals("��Բ")) {
										g.drawOval(x1, y1, x2 - x1, y2 - y1);
									} else if (command.equals("����")) {
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
								//�ѷ�������д�����ݷ��͸��ͻ���
								String info = textField.getText();
								textArea.append("server  "+getTime()+"\r\n"+info+"\r\n");
								pw.println(info);
								//��շ��Ϳ�����
								textField.setText("");
								
							}
						}
						
					}
					}

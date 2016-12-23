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
 * �ͻ��˻����࣬����̳����߳��ಢ��ʵ�������������ӿ�
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
					
					JSlider jsR, jsG, jsB;//ʵ������������
					//������Ϣ
					PrintWriter pw = null;
					JTextArea textArea;
//					JTextArea textArea=null;
//					JTextField textField=new JTextField();
					//textField = new JTextField();
					
					private ButtonGroup bg = new ButtonGroup();// ʵ����һ����ť��
					JTextField textField;
					private final Action action = new SwingAction();

							/**
							 * ���������
							 * 
							 * @param args
							 */
							public static void main(String[] args) {
								UserDraw user = new UserDraw();
								user.connectServer();
								user.GUI();
								user.start();
								System.out.println("�ͻ��˶��߳�����");
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
							 * ������ʾ����ķ������ý�����ʾ�˰�ť�飬���� �������ˡ�
							 */
							public void GUI() {
								JFrame jf = new JFrame();
								jf.setTitle("����װ�----�ͻ���ϵͳ");
								jf.setSize(900, 600);
								jf.setLocation(150, 100);
								jf.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
							
								/************��ť��Ľ���************/
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
						
								/** *****����G�����ֵ** */
								jsG = new JSlider(0, 255);// ��ӿ�����ɫ�Ļ���
								jsG.setMajorTickSpacing(10);// ���̶�
								jsG.setMinorTickSpacing(5);// ���̶�
								jsG.setPaintTicks(true);
								jf.getContentPane().add(jsG);
						
								/** ****����R�����ֵ***** */
								jsR = new JSlider(0, 255);// ��ӿ�����ɫ�Ļ���
								jsR.setMajorTickSpacing(10);// ���̶�
								jsR.setMinorTickSpacing(5);// ���̶�
								jsR.setPaintTicks(true);
								jf.getContentPane().add(jsR);
						
								/** ****����R����***** */
								jsB = new JSlider(0, 255);// ��ӿ�����ɫ�Ļ���
								jsB.setMajorTickSpacing(50);// ���̶�
								jsB.setMinorTickSpacing(10);// ���̶�
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
								setColor();//����������ɫ�ķ�����
							}
						
							/**
							 * ���û��ʵ�R��G,B��ԭɫ����ÿ�����ƻ�ɫ�����˼�һ��
							 * ��������
							 */
							public void setColor() {
					         	//Ϊ��ɫ�Ӽ�����
								ChangeListener red = (new ChangeListener() {
									public void stateChanged(ChangeEvent e) {
										R = jsR.getValue();
										g.setColor(new Color(R, G, B));
									}
								});
							
								/************����ɫ�Ӽ�����*************/
								ChangeListener green = (new ChangeListener() {
									public void stateChanged(ChangeEvent e) {
										G = jsG.getValue();
										g.setColor(new Color(R, G, B));
									}
								});
								/************����ɫ�Ӽ�����**************/
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
						 * ���ӷ������ķ�����û�и��������ò�����ͨ��ֱ�Ӹ���ʼֵ�ķ�ʽ����
						 * @return���� boolean���ͣ����ӳɹ��򷵻�true����෵��false�� 
						 */
							public boolean connectServer() {
								try {
						
									client = new Socket("localhost", 6700);
									chatclient=new Socket("localhost", 6500);
									
						
									System.out.println("����������ӳɹ�");
									
									while (true) {
										pw = new PrintWriter(chatclient.getOutputStream(),true);//��������
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
								try {
								//��ȡ��ť��������õ�����ֵ
									String command = bg.getSelection().getActionCommand();
								/*********��������ֵ**********/
									line.setX1(x1);
									line.setX2(x2);
									line.setY1(y1);
									line.setY2(y2);
									line.setCommand(command);
									line.setR(R);
									line.setG(G);
									line.setB(B);
									System.out
											.println("�ͻ��������R=" + R + "�ͻ��������G=" + G + "�ͻ��������B=" + B);
									if (command.equals("����")) {
										g.drawLine(x1, y1, x2, y2);
									} else if (command.equals("��Բ")) {
										g.drawOval(x1, y1, x2 - x1, y2 - y1);
									} else if (command.equals("����")) {
										g.drawRect(x1, y1, x2 - x1, y2 - y1);
									}
									oos.writeObject(line);
									System.out.println("�ͻ������귢�ͳɹ�");
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
				//��д�����ݷ���
				String info = textField.getText();
				textArea.append("client  "+getTime()+"\r\n"+info+"\r\n");
				pw.println(info);
				//��շ��Ϳ�����
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
//			//��д�����ݷ���
//			String info = textField.getText();
//			textArea.append("server  "+getTime()+"\r\n"+info+"\r\n");
//			pw.println(info);
//			//��շ��Ϳ�����
//			textField.setText("");
//			
//		}
//	}
	


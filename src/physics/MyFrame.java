package physics;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class MyFrame extends JFrame {

 private static final long serialVersionUID = 1L;
 private JSlider slider;
 private JLabel lblNewLabel;
 private JLabel lblSlit;
 private JSlider slider_1;
 private JTextField textField;
 private JLabel lblMm;
 private JLabel lblm;
 private JTextField textField_1;
 private JLabel lblDistance;
 private JTextField textField_2;
 private JLabel lblCm;
 private JSlider slider_2;

 public MyFrame() {
  this.setSize(293, 400);
  this.setLocation(600, 0);
  setTitle("Setting");
  getContentPane().setLayout(null);
  getContentPane().add(getLblSlit());
  getContentPane().add(getSlider());
  getContentPane().add(getLblNewLabel());
  getContentPane().add(getSlider_1_1());
  getContentPane().add(getTextField());
  getContentPane().add(getLblMm());
  getContentPane().add(getLblm());
  getContentPane().add(getTextField_1());
  getContentPane().add(getLblDistance());
  getContentPane().add(getTextField_2());
  getContentPane().add(getLblCm());
  getContentPane().add(getSlider_2());
  getContentPane().add(getTxtpnEclipseIdeFor());
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  this.setResizable(false);
  this.setVisible(true);

  Graph_reset();
 }

 private JFrame frame = new JFrame("Graph");
 private JTextPane txtpnEclipseIdeFor;

 private void Graph_reset() {

  frame.setResizable(false);
  frame.setSize(600, 400);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  int width = slider.getValue();
  int slit = slider_1.getValue();
  int distance = slider_2.getValue();

  MyComponent component = new MyComponent(width, slit, distance);
  frame.getContentPane().add(component);
  frame.setVisible(true);

 }

 private void Graph_draw() {

  int width = slider.getValue();
  int slit = slider_1.getValue();
  int distance = slider_2.getValue();

  MyComponent component = new MyComponent(width, slit, distance);
  frame.getContentPane().add(component);
  frame.setVisible(true);

 }

 private JSlider getSlider() {
  if (slider == null) {
   slider = new JSlider(JSlider.HORIZONTAL, 400, 700, 550);
   slider.setBounds(12, 35, 260, 48);
   slider.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent e) {
     int wavelength = slider.getValue();
     String strI = Integer.toString(wavelength);
     textField.setText(strI);
     Graph_draw();
    }
   });
   slider.setPaintTicks(true);
   slider.setPaintLabels(true);
   slider.setMajorTickSpacing(50);
   slider.setMinorTickSpacing(25);
  }
  return slider;
 }

 private JLabel getLblNewLabel() {
  if (lblNewLabel == null) {
   lblNewLabel = new JLabel("Wavelength");
   lblNewLabel.setBounds(12, 10, 148, 15);
   lblNewLabel.setLabelFor(getSlider());
  }
  return lblNewLabel;
 }

 private JLabel getLblSlit() {
  if (lblSlit == null) {
   lblSlit = new JLabel("Slit Width");
   lblSlit.setBounds(12, 93, 148, 15);
   lblSlit.setLabelFor(getSlider_1_1());
  }
  return lblSlit;
 }

 private JSlider getSlider_1_1() {
  if (slider_1 == null) {
   slider_1 = new JSlider(SwingConstants.HORIZONTAL, 1, 9, 5);
   slider_1.setBounds(12, 118, 260, 48);
   slider_1.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent e) {
     int slit = slider_1.getValue();
     String strI = Integer.toString(slit);
     textField_1.setText(strI);
     Graph_draw();
    }
   });
   slider_1.setPaintTicks(true);
   slider_1.setPaintLabels(true);
   slider_1.setMinorTickSpacing(1);
   slider_1.setMajorTickSpacing(2);
  }
  return slider_1;
 }

 private JTextField getTextField() {
  if (textField == null) {
   textField = new JTextField();
   textField.setBounds(215, 10, 35, 21);
   textField.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
     String strI = textField.getText();
     int wavelength = Integer.parseInt(strI);
     slider.setValue(wavelength);
     Graph_draw();
    }
   });
   textField.setHorizontalAlignment(SwingConstants.RIGHT);
   textField.setText("550");
   textField.setColumns(10);
  }
  return textField;
 }

 private JLabel getLblMm() {
  if (lblMm == null) {
   lblMm = new JLabel("nm");
   lblMm.setBounds(246, 13, 26, 15);
   lblMm.setHorizontalAlignment(SwingConstants.RIGHT);
  }
  return lblMm;
 }

 private JLabel getLblm() {
  if (lblm == null) {
   lblm = new JLabel("x10\u207B\u2074m");
   lblm.setBounds(217, 96, 55, 15);
   lblm.setHorizontalAlignment(SwingConstants.RIGHT);
  }
  return lblm;
 }

 private JTextField getTextField_1() {
  if (textField_1 == null) {
   textField_1 = new JTextField();
   textField_1.setBounds(182, 93, 35, 21);
   textField_1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     String strI = textField_1.getText();
     int slit = Integer.parseInt(strI);
     slider_1.setValue(slit);
     Graph_draw();
    }
   });
   textField_1.setText("5");
   textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
   textField_1.setColumns(10);
  }
  return textField_1;
 }

 private JLabel getLblDistance() {
  if (lblDistance == null) {
   lblDistance = new JLabel("Distance");
   lblDistance.setBounds(12, 176, 148, 15);
  }
  return lblDistance;
 }

 private JTextField getTextField_2() {
  if (textField_2 == null) {
   textField_2 = new JTextField();
   textField_2.setBounds(215, 176, 35, 21);
   textField_2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
     String strI = textField_2.getText();
     int distance = Integer.parseInt(strI);
     slider_2.setValue(distance);
     Graph_draw();
    }
   });
   textField_2.setText("6");
   textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
   textField_2.setColumns(10);
  }
  return textField_2;
 }

 private JLabel getLblCm() {
  if (lblCm == null) {
   lblCm = new JLabel("m");
   lblCm.setBounds(246, 179, 26, 15);
   lblCm.setHorizontalAlignment(SwingConstants.RIGHT);
  }
  return lblCm;
 }

 private JSlider getSlider_2() {
  if (slider_2 == null) {
   slider_2 = new JSlider(SwingConstants.HORIZONTAL, 2, 10, 6);
   slider_2.setBounds(12, 201, 260, 48);
   slider_2.addChangeListener(new ChangeListener() {
    public void stateChanged(ChangeEvent arg0) {
     int slit = slider_2.getValue();
     String strI = Integer.toString(slit);
     textField_2.setText(strI);
     Graph_draw();
    }
   });
   slider_2.setPaintTicks(true);
   slider_2.setPaintLabels(true);
   slider_2.setMinorTickSpacing(1);
   slider_2.setMajorTickSpacing(2);
  }
  return slider_2;
 }
 private JTextPane getTxtpnEclipseIdeFor() {
  if (txtpnEclipseIdeFor == null) {
   txtpnEclipseIdeFor = new JTextPane();
   txtpnEclipseIdeFor.setEditable(false);
   txtpnEclipseIdeFor.setForeground(Color.GRAY);
   txtpnEclipseIdeFor.setBackground(UIManager.getColor("Button.background"));
   txtpnEclipseIdeFor.setText("Single Slit Diffraction\r\n\r\nCopyright\u24D2. 2015. \uB77C\uC601\uCCA0.\r\nAll Rights Reserved.\r\ne-mail : fkdudcjf16@yonsei.ac.kr\r\nHomepage : https://physicallaw.tistory.com/");
   txtpnEclipseIdeFor.setBounds(12, 251, 263, 139);
  }
  return txtpnEclipseIdeFor;
 }
}

class MyComponent extends JPanel {
 /**
  * 
  */
 private static final long serialVersionUID = 1L;
 private int wave_1, slit_1, distance_1;
 private double wavelength_d, slit_d, distance_d;
 private double beta, I;
 
 public MyComponent(int a, int b, int c) {
  wave_1 = a;
  wavelength_d = wave_1;
  slit_1 = b;
  slit_d = slit_1;
  distance_1 = c;
  distance_d = distance_1;
 }

 public void paintComponent(Graphics g) {
  g.clearRect(0, 0, 600, 400);
  double Con = 200;
  int x = 550, y = 185;
  int[] rgb = waveLengthToRGB(wave_1);
  
  Color co1 = new Color(0, 0, 0);
  g.setColor(co1);
  g.drawLine(x + 1, 0, x + 1, 600);
  co1 = new Color(100, 100, 100);
  g.setColor(co1);
  g.fillRect(x - 200 - distance_1*30, y + slit_1*2, 10, 40);
  g.fillRect(x - 200 - distance_1*30, y - 40 - slit_1*2, 10, 40);
  Color co = new Color(rgb[0], rgb[1], rgb[2]);
  g.setColor(co);
  g.drawLine(x - (int) Con, y, x, y);
  
  for (int i = 1; i < 200; i++) {
   beta = slit_d * Math.PI / wavelength_d * Math.pow(10, 5);
   beta *= i / Math.sqrt(distance_d * distance_d * 100000000 + i * i);
   I = (Math.sin(beta) / beta) * (Math.sin(beta) / beta) * Con;
   g.setColor(co);
   g.drawLine(x - (int) I, i + y, x, i + y);
   g.drawLine(x - (int) I, y - i, x, y - i);
   co1 = new Color((int) (255 * (I / Con)), (int) (255 * (I / Con)), (int) (255 * (I / Con)));
   g.setColor(co1);
   g.drawLine(x + 2, i + y, 600, i + y);
   g.drawLine(x + 2, y - i, 600, y - i);
  }

  co1 = new Color(255, 255, 255);
  g.setColor(co1);
  g.drawLine(x + 2, y, 600, y);
 }

 static private double Gamma = 0.80;
 static private double IntensityMax = 255;

 public static int[] waveLengthToRGB(double Wavelength) {
  double factor;
  double Red, Green, Blue;

  if ((Wavelength >= 380) && (Wavelength < 440)) {
   Red = -(Wavelength - 440) / (440 - 380);
   Green = 0.0;
   Blue = 1.0;
  } else if ((Wavelength >= 440) && (Wavelength < 490)) {
   Red = 0.0;
   Green = (Wavelength - 440) / (490 - 440);
   Blue = 1.0;
  } else if ((Wavelength >= 490) && (Wavelength < 510)) {
   Red = 0.0;
   Green = 1.0;
   Blue = -(Wavelength - 510) / (510 - 490);
  } else if ((Wavelength >= 510) && (Wavelength < 580)) {
   Red = (Wavelength - 510) / (580 - 510);
   Green = 1.0;
   Blue = 0.0;
  } else if ((Wavelength >= 580) && (Wavelength < 645)) {
   Red = 1.0;
   Green = -(Wavelength - 645) / (645 - 580);
   Blue = 0.0;
  } else if ((Wavelength >= 645) && (Wavelength < 781)) {
   Red = 1.0;
   Green = 0.0;
   Blue = 0.0;
  } else {
   Red = 0.0;
   Green = 0.0;
   Blue = 0.0;
  }
  ;

  // Let the intensity fall off near the vision limits

  if ((Wavelength >= 380) && (Wavelength < 420)) {
   factor = 0.3 + 0.7 * (Wavelength - 380) / (420 - 380);
  } else if ((Wavelength >= 420) && (Wavelength < 701)) {
   factor = 1.0;
  } else if ((Wavelength >= 701) && (Wavelength < 781)) {
   factor = 0.3 + 0.7 * (780 - Wavelength) / (780 - 700);
  } else {
   factor = 0.0;
  }
  ;

  int[] rgb = new int[3];

  // Don't want 0^x = 1 for x <> 0
  rgb[0] = Red == 0.0 ? 0 : (int) Math.round(IntensityMax * Math.pow(Red * factor, Gamma));
  rgb[1] = Green == 0.0 ? 0 : (int) Math.round(IntensityMax * Math.pow(Green * factor, Gamma));
  rgb[2] = Blue == 0.0 ? 0 : (int) Math.round(IntensityMax * Math.pow(Blue * factor, Gamma));

  return rgb;
 }
}
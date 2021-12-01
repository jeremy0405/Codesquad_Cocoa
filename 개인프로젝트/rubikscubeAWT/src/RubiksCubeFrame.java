import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RubiksCubeFrame extends Frame {
    private int count = 0;
    private long startTime;
    private Cube cube = new Cube();
    private String[][] PlaneU = cube.getPlaneU();
    private String[][] PlaneL = cube.getPlaneL();
    private String[][] PlaneF = cube.getPlaneF();
    private String[][] PlaneR = cube.getPlaneR();
    private String[][] PlaneB = cube.getPlaneB();
    private String[][] PlaneD = cube.getPlaneD();

    public RubiksCubeFrame(String title) {
        super(title);
        startTime = System.currentTimeMillis();
        setBounds(250, 100, 1000, 600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setButton();
        setVisible(true);
    }

    public void paint(Graphics g) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkColor(g, PlaneU, i, j);
                g.fillRect(350 + 50 * j, 50 + 50 * i, 40, 40);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkColor(g, PlaneL, i, j);
                g.fillRect(200 + 50 * j, 200 + 50 * i, 40, 40);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkColor(g, PlaneF, i, j);
                g.fillRect(350 + 50 * j, 200 + 50 * i, 40, 40);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkColor(g, PlaneR, i, j);
                g.fillRect(500 + 50 * j, 200 + 50 * i, 40, 40);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkColor(g, PlaneB, i, j);
                g.fillRect(650 + 50 * j, 200 + 50 * i, 40, 40);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkColor(g, PlaneD, i, j);
                g.fillRect(350 + 50 * j, 350 + 50 * i, 40, 40);
            }
        }
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.ITALIC, 20));
        g.drawString("횟수 : " + count,40,80);

        double time = (System.currentTimeMillis() - startTime) / 1000.0;
        g.drawString("경과 시간 : " + time, 40, 130);

        if(time > 2 && cube.checkAnswer()){
            g.fillRect(0,0,1000,800);
            g.setColor(Color.white);
            g.drawString("정답입니다! 계속 하려면 아래 버튼을 아무거나 누르세요!", 200, 300);
            g.drawString("횟수 : " + count + "  경과 시간 : " + time,200,400);
            count = 0;
            startTime = System.currentTimeMillis();
            Cube newcube = new Cube();
            cube = newcube;
        }

    }

    private void checkColor(Graphics g, String[][] PlaneU, int i, int j) {
        if(PlaneU[i][j].equals("B")){
            g.setColor(Color.BLUE);
        } else if (PlaneU[i][j].equals("W")){
            g.setColor(Color.WHITE);
        } else if (PlaneU[i][j].equals("O")){
            g.setColor(Color.ORANGE);
        } else if (PlaneU[i][j].equals("G")){
            g.setColor(Color.GREEN);
        } else if (PlaneU[i][j].equals("Y")){
            g.setColor(Color.YELLOW);
        } else if (PlaneU[i][j].equals("R")){
            g.setColor(Color.RED);
        }
    }

    private void setButton() {
        Panel p = new Panel();
        p.setBackground(Color.GRAY);
        Button buttonU = new Button("U");
        buttonU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cube.turnCube("U");
                getPlane(cube);
                count++;
                repaint();
            }
        });
        Button buttonD = new Button("D");
        buttonD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cube.turnCube("D");
                getPlane(cube);
                count++;
                repaint();
            }
        });
        Button buttonF = new Button("F");
        buttonF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cube.turnCube("F");
                getPlane(cube);
                count++;
                repaint();
            }
        });
        Button buttonB = new Button("B");
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cube.turnCube("B");
                getPlane(cube);
                count++;
                repaint();
            }
        });
        Button buttonL = new Button("L");
        buttonL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cube.turnCube("L");
                getPlane(cube);
                count++;
                repaint();
            }
        });
        Button buttonR = new Button("R");
        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cube.turnCube("R");
                getPlane(cube);
                count++;
                repaint();
            }
        });

        p.add(buttonU);
        p.add(buttonD);
        p.add(buttonL);
        p.add(buttonR);
        p.add(buttonF);
        p.add(buttonB);

        setBackground(Color.lightGray);
        add(p, "South");
    }

    private void getPlane(Cube cube) {
        PlaneB = cube.getPlaneB();
        PlaneF = cube.getPlaneF();
        PlaneD = cube.getPlaneD();
        PlaneU = cube.getPlaneU();
        PlaneR = cube.getPlaneR();
        PlaneL = cube.getPlaneL();
    }
}

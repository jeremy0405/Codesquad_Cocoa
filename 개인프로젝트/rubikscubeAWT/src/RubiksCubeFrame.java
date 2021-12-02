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
import java.util.Timer;
import java.util.TimerTask;

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
    Timer timer;
    TimerTask task;
    public RubiksCubeFrame(String title) {
        super(title);
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        timer.schedule(task,200,99);
        startTime = System.currentTimeMillis();
        setBounds(250, 100, 1000, 600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                timer.cancel();
            }
        });
        setButton();
        setVisible(true);
    }

    public void paint(Graphics g) {

        paintCube(g, PlaneU,350, 50);
        paintCube(g, PlaneL,200, 200);
        paintCube(g, PlaneF,350, 200);
        paintCube(g, PlaneR,500, 200);
        paintCube(g, PlaneB,650, 200);
        paintCube(g, PlaneD,350, 350);
        
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.ITALIC, 20));
        g.drawString("횟수 : " + count,40,80);

        double time = (System.currentTimeMillis() - startTime) / 1000.0;
        String s = String.format("경과 시간 : %.1f sec", time);
        g.drawString(s, 40, 130);


        if(time > 1 && cube.checkAnswer()){
            g.fillRect(0,0,1000,800);
            g.setColor(Color.white);
            g.drawString("정답입니다!", 200, 300);
            g.drawString("횟수 : " + count + "  경과 시간 : " + time,200,400);
            //todo timer 를 잠깐 멈추던지
            // timer를 죽이고 다시 키던지
            task.cancel();
            timer.cancel();
            timer.purge();
            count = 0;
            startTime = System.currentTimeMillis();
            cube = new Cube();
        }

    }

//    private void newTimer() {
//        timer = new Timer();
//        task = new TimerTask() {
//            @Override
//            public void run() {
//                repaint();
//            }
//        };
//        timer.schedule(task,200,100);
//    }

    private void paintCube(Graphics g, String[][] p, int x, int y) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkColor(g, p, i, j);
                g.fillRect(x + 50 * j, y + 50 * i, 40, 40);
            }
        }
    }

    private void checkColor(Graphics g, String[][] p, int i, int j) {
        if(p[i][j].equals("B")){
            g.setColor(Color.WHITE);
        } else if (p[i][j].equals("W")){
            g.setColor(Color.ORANGE);
        } else if (p[i][j].equals("O")){
            g.setColor(Color.GREEN);
        } else if (p[i][j].equals("G")){
            g.setColor(Color.RED);
        } else if (p[i][j].equals("Y")){
            g.setColor(Color.BLUE);
        } else if (p[i][j].equals("R")){
            g.setColor(Color.YELLOW);
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


//        Panel restart = new Panel();
//        Button buttonRestart = new Button("ReStart");
//        buttonRestart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cube = new Cube();
//                count = 0;
//                startTime = System.currentTimeMillis();
//                repaint();
//            }
//        });
//        restart.add(buttonRestart);
//        setBackground(Color.lightGray);
//        add(restart, "East");

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

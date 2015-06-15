package ui.stats;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.InferStatsService;
import ui.config.PanelConfig;
import ui.config.SystemConfig;
import ui.home.HomeUI;
import ui.util.LoadFont;
import ui.util.MyComboBox;
import vo.TeamWinAnalysisVO;

public class Stat1 extends JPanel{

    private PanelConfig pcfg ;
    private HomeUI frame;
    List<InferPanel> pList;
    String season;
    InferPanel ip;
    InferStatsService ss;
    int show = 0;
    JLabel next;

    public Stat1(HomeUI frame){
        this.pcfg = SystemConfig.getHOME_CONFIG().getConfigMap()
                .get(this.getClass().getName());
        this.frame = frame;
        // 设置布局管理器为自由布局
        this.setOpaque(false);
        this.setLayout(null);
        this.setSize(pcfg.getW(), pcfg.getH());
        this.setLocation(pcfg.getX(), pcfg.getY());
        // 初始化组件
        this.initComponent();
        this.repaint();
	}

    private void initComponent() {
        initPanels();

//        try {
//            ss = ServiceFactoryImpl.getInstance().getInferenceService();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }

    private void initPanels() {
        pList = new ArrayList<>();

        // STEP1
        ip = new InferPanel(frame);
        MyComboBox seasons = new MyComboBox(pcfg.getComboboxes().element("season"));
        seasons.setFont(LoadFont.loadFont("XIHEI.TTF", 0, 12));
        ip.add(seasons);
        JLabel start = new JLabel("开始");
        start.setBounds(870, 137, 50, 25);
        start.setFont(new Font("微软雅黑", 0, 15));
        start.setForeground(new Color(72, 207, 173));
        start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                season = (String)seasons.getSelectedItem();
                initNormal();
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                start.setText("<html><u>开始</u></html>");

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                start.setText("开始");
            }
        });
        ip.add(start);
        JLabel bg = new JLabel(new ImageIcon("img/stat/stats1/step1.png"));
        bg.setBounds(0, 0, 940, 511);
        ip.add(bg);
        this.add(ip);
        pList.add(ip);

    }

    private void initNormal() {
        next = new JLabel("Next");
        next.setBounds(844, 455, 50, 25);
        next.setFont(new Font("微软雅黑", 0, 15));
        next.setForeground(new Color(72, 207, 173));
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                next.setText("<html><u>Next</u></html>");

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                next.setText("Next");
            }
        });

        TeamWinAnalysisVO vo = new TeamWinAnalysisVO();
//        try {
//            vo = ss.getTeamTestingResultBySeason(season);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

        ip.setVisible(false);

        // PP
        show = 1;
        ip = new InferPanel(frame);
//        JLabel home_pp = new JLabel(vo.home_P_P);
//        JLabel guest_pp = new JLabel(vo.guest_P_P);
//        home_pp.setBounds(273, 240, 400, 300);
//        guest_pp.setBounds(570, 240, 400, 300);
//        ip.add(home_pp);
//        ip.add(guest_pp);
        ip.add(next);
        JLabel bg = new JLabel(new ImageIcon("img/stat/stats1/step1.png"));
        bg.setBounds(0, 0, 940, 511);
        ip.add(bg);
        add(ip);
        pList.add(ip);

        // 单总体KS
        ip = new InferPanel(frame);
        ip.setVisible(false);

        bg = new JLabel(new ImageIcon("img/stat/stats1/step1.png"));
        bg.setBounds(0, 0, 940, 511);
        ip.add(bg);
        add(ip);
        pList.add(ip);

        //

    }
}
package com.github.andriell.gui.process;

import com.github.andriell.processor.ManagerInterface;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by Rybalko on 11.07.2016.
 */
public class Process extends JPanel {
    private static final int P = 5; // отступ
    private static final int TW; // Ширина заголовка
    private static final int TH = 20; // Высота заголовка
    private static final int W13 = 90; // Ширина столбца 1 и 3
    private static final int W24 = 60; // Ширина столбца 2 и 4
    private static final int H = 20; // Высота столбца
    private static final Dimension size;
    private static final Font fontTitle = new Font("Arial", Font.PLAIN, 16);
    private static final Border border = BorderFactory.createLineBorder(Color.black);
    //private static final Border border2 = BorderFactory.createLineBorder(Color.YELLOW);
    private static final Border border2 = null;
    private static final String timeZero = "00:00:00";

    static {
        TW = W13 * 2 + W24 * 2 + P * 3;
        size = new Dimension(TW + P * 2, TH + P * 2 + (H + P) * 2);
    }

    private JLabel inQueue;
    private JLabel timeLeft;
    private JLabel runProcess;
    private JSpinner limit;

    private ManagerInterface manager;
    private int startCount = 0;
    private long startTime = 0L;

    public Process(ManagerInterface m) {
        manager = m;
        setLayout(null);
        setPreferredSize(size);
        setBorder(border);

        JLabel title = new JLabel(manager.getProcessBeanId(), JLabel.CENTER);
        title.setSize(TW, TH);
        title.setLocation(P, P);
        title.setFont(fontTitle);
        title.setBorder(border2);
        add(title);

        JLabel label = new JLabel("In queue:");
        label.setSize(W13, H);
        label.setLocation(P, TH + P * 2);
        label.setBorder(border2);
        add(label);

        inQueue = new JLabel("0");
        inQueue.setSize(W24, H);
        inQueue.setLocation(W13 + P * 2, TH + P * 2);
        inQueue.setBorder(border2);
        add(inQueue);


        label = new JLabel("Run process:");
        label.setSize(W13, H);
        label.setLocation(W13 + W24 + P * 3, TH + P * 2);
        label.setBorder(border2);
        add(label);

        runProcess = new JLabel("0");
        runProcess.setSize(W24, H);
        runProcess.setLocation(W13 * 2 + W24 + P * 4, TH + P * 2);
        runProcess.setBorder(border2);
        add(runProcess);

        label = new JLabel("Limit process:");
        label.setSize(W13, H);
        label.setLocation(P, TH + H + P * 3);
        label.setBorder(border2);
        add(label);

        limit = new JSpinner(new SpinnerNumberModel(2, 1, 999, 1));
        limit.setSize(40, H);
        limit.setLocation(W13 + P * 2, TH + H + P * 3);
        limit.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                manager.setLimitProcess((Integer) limit.getValue());
            }
        });
        add(limit);

        label = new JLabel("Time left:");
        label.setSize(W13, H);
        label.setLocation(W13 + W24 + P * 3, TH + H + P * 3);
        label.setBorder(border2);
        add(label);

        timeLeft = new JLabel(timeZero);
        timeLeft.setSize(W24, H);
        timeLeft.setLocation(W13 * 2 + W24 + P * 4, TH + H + P * 3);
        timeLeft.setBorder(border2);
        add(timeLeft);
    }

    private static String secToTime(int totalSecs) {
        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void update() {
        int count = manager.getProcessInQueue();
        long time = System.currentTimeMillis();
        inQueue.setText(Integer.toString(count));
        runProcess.setText(Integer.toString(manager.getRunningProcesses()));
        limit.setValue(manager.getLimitProcess());

        if (count > 10 && startTime > 0 && count < startCount) {
            float inTime = (startCount - count) / ((time - startTime) / 1000);
            if (inTime > 0) {
                timeLeft.setText(secToTime(Math.round((count / inTime))));
            }
        } else {
            startTime = time;
            startCount = count;
            timeLeft.setText(timeZero);
        }
    }
}

package com.github.andriell.gui.process;

import com.github.andriell.gui.GuiHelper;
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
    private static final Font fontTitle = new Font("Arial", Font.PLAIN, 16);
    private static final Border border = BorderFactory.createLineBorder(Color.black);
    private static final String timeZero = "00:00:00";
    private static final String zero = "0";

    private JLabel inQueue;
    private JLabel timeLeft;
    private JLabel runProcess;
    private JLabel pcSec;
    private JLabel total;
    private JSpinner limit;

    private ManagerInterface manager;
    private int startComplitedCount = 0;
    private long startTime = 0L;

    public Process(ManagerInterface m) {
        manager = m;
        setLayout(null);
        setPreferredSize(new Dimension(325, 105));
        setBorder(border);

        JLabel title = new JLabel(manager.getProcessBeanId(), JLabel.CENTER);
        title.setSize(315, 20);
        title.setLocation(5, 5);
        title.setFont(fontTitle);
        add(title);

        GuiHelper.gridFormatter(
                this,
                new int[]{5, 30},
                new int[]{90, 5, 60, 5, 90, 5, 60},
                new int[]{20, 5, 20, 5, 20},
                new Component[][]{
                        {new JLabel("Completed:"), null, total = new JLabel(zero), null, new JLabel("Run process:"), null, runProcess = new JLabel(zero)},
                        null,
                        {new JLabel("In queue:"), null, inQueue = new JLabel(zero), null, new JLabel("Item/sec:"), null, pcSec = new JLabel(zero)},
                        null,
                        {new JLabel("Limit process:"), null, limit = new JSpinner(new SpinnerNumberModel(2, 1, 999, 1)), null, new JLabel("Time left:"), null, timeLeft = new JLabel(timeZero)},
                }
        );
        limit.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                manager.setLimitProcess((Integer) limit.getValue());
            }
        });
        limit.setSize(40, 20);
    }

    private static String secToTime(int totalSecs) {
        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void update() {
        int complitedCount = manager.getCompletedProcess();
        long time = System.currentTimeMillis();
        int inQueueCount = manager.getProcessInQueue();
        inQueue.setText(Integer.toString(inQueueCount));
        runProcess.setText(Integer.toString(manager.getRunningProcesses()));
        total.setText(Integer.toString(complitedCount));
        limit.setValue(manager.getLimitProcess());

        if (inQueueCount > 10 && startTime > 0 && complitedCount > startComplitedCount) {
            float inTime = ((float) (complitedCount - startComplitedCount)) / ((time - startTime) / 1000);
            if (inTime > 0) {
                pcSec.setText(Float.toString(((float) Math.round(inTime * 100)) / 100));
                timeLeft.setText(secToTime(Math.round((inQueueCount / inTime))));
            }
        } else {
            startTime = time;
            startComplitedCount = complitedCount;
            timeLeft.setText(timeZero);
        }
    }
}

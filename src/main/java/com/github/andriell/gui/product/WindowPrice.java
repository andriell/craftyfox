package com.github.andriell.gui.product;

import com.github.andriell.db.Product;
import com.github.andriell.db.ProductProperty;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.util.Set;

/**
 * Created by Rybalko on 11.07.2016.
 */
public class WindowPrice extends JFrame {
    private TimeSeriesCollection dataset;

    public WindowPrice(String title) {
        super(title);
        setDefaultCloseOperation(ApplicationFrame.HIDE_ON_CLOSE);
        RefineryUtilities.centerFrameOnScreen(this);

        // create the chart...
        dataset = new TimeSeriesCollection();

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Multiple Dataset Demo 1", "Time", "Value", dataset, true, true, false
        );

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);



    }

    public void show(Product product) {
        final TimeSeries series = new TimeSeries("Second");

        Set<ProductProperty> properties = product.getProperty();
        if (properties != null) {
            for (ProductProperty property:properties) {
                if (!"price".equals(property.getName())) {
                    continue;
                }
                series.add(new Day(property.getDate()), property.getFloat());
            }
        }

        dataset.removeAllSeries();
        dataset.addSeries(series);

        setVisible(true);
        pack();
    }
}

package org.jfree.chart.demo;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.Date;

/**
 * A simple demonstration application showing how to create a line chart using data from an
 * {@link XYDataset}.
 *
 */
public class LineChartDemo6 extends ApplicationFrame {

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public LineChartDemo6(final String title) {

        super(title);

        final TimeSeries series2 = new TimeSeries("Second");
        Day day = new Day(new Date());
        series2.add(day, 5);
        series2.add(day.next(), 10);
        series2.add(day.next().next().next(), 8);



        final TimeSeriesCollection dataset = new TimeSeriesCollection ();

        dataset.addSeries(series2);

        // create the chart...
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Multiple Dataset Demo 1", "Time", "Value", dataset, true, true, false
        );

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final LineChartDemo6 demo = new LineChartDemo6("Line Chart Demo 6");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }


}
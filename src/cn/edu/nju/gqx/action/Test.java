package cn.edu.nju.gqx.action;

import java.awt.Font;
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Test {
	public static void main(String[] args) throws Exception{
		new Test().testLineChart("asdf");
	}
	
	 private static void testLineChart(String name) throws Exception{  
		 
         
	        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
	          
//	        dataset.addValue(100, name, "1");  
//	        dataset.addValue(150, name, "2");  
//	        dataset.addValue(130, name, "3");  
//	        dataset.addValue(120, name, "4");
//	        dataset.addValue(120, name, "5");
//	        dataset.addValue(120, name, "6");
//	        dataset.addValue(120, name, "7");
//	        dataset.addValue(120, name, "8");
//	        dataset.addValue(120, name, "9");
//	        dataset.addValue(120, name, "10");
//	        dataset.addValue(120, name, "11");
//	        dataset.addValue(120, name, "12");
	        for(int i = 0;i < 24;i++){
	        	 dataset.addValue(120, name, i+1+"");
	        }
	          
	        JFreeChart chart = ChartFactory.createLineChart("", "时间", "数值", dataset, PlotOrientation.VERTICAL, true, true, true);  
	        CategoryPlot plot = chart.getCategoryPlot();  
	        plot.getRangeAxis().setUpperMargin(0.15);  
	          
	        Font font = new Font("黑体", Font.BOLD, 15);  
	        chart.getLegend().setItemFont(font);  
	        chart.getTitle().setFont(font);  
	        plot.getDomainAxis().setTickLabelFont(font);  
	        plot.getDomainAxis().setLabelFont(font);  
	        plot.getRangeAxis().setLabelFont(font);  
	          
	        LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) plot.getRenderer();  
	        lineAndShapeRenderer.setBaseLinesVisible(true);  
	        lineAndShapeRenderer.setBaseShapesVisible(true);  
	        lineAndShapeRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());  
	        lineAndShapeRenderer.setBaseItemLabelsVisible(true);  
	          
	        ChartFrame frame = new ChartFrame(name, chart);  
	        frame.pack();  
	        frame.setVisible(true);   
	          
//	        ChartUtilities.saveChartAsJPEG(new File("d:/testLineChart.jpg"), chart, 1024, 768);  
	    }  
}

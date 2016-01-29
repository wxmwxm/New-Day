package common.utils;

import java.util.List;
/**
 * 封装数据集合和总数
 * @author King.xw
 * @time 2013-08-08
 * @param <T>
 */
public class DataGrid<T> {
	private List<T> rows;  // 数据集
	private int total;  // 总数
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}

package common.base;

import java.util.List;

@SuppressWarnings("rawtypes")
public class BaseBean {
	private int rowSize = 10;// 每页显示多少行
	private int currentPage=1;// 当前页数
	private int rowCount;// 总行数
	private List pageData;// 分页数据

	public BaseBean(){}
	
	public BaseBean(int rowSize) {
		super();
		this.rowSize = rowSize;
	}

	public BaseBean(int rowSize,int currentPage) {
		super();
		this.rowSize = rowSize;
		this.currentPage=currentPage;
	}
	public List getPageData() {
		return pageData;
	}

	public void setPageData(List pageData) {
		this.pageData = pageData;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	/**
	 * 获得下一页
	 * 
	 * @return int
	 */
	public int getBackPage() {
		return (this.currentPage + 1) > getMaxPage() ? getMaxPage()
				: this.currentPage + 1;
	}

	/**
	 * 获得上一页
	 * 
	 * @return int
	 */
	public int getPreviousPage() {
		return (this.currentPage - 1) < 1 ? 1 : this.currentPage - 1;
	}

	/**
	 * 获得最大页数
	 * 
	 * @return int
	 */
	public int getMaxPage() {
		return (int) Math.ceil((double) rowCount / rowSize);
	}

	
	
	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
}

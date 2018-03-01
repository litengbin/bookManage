package org.tool;

/**
 * 
 * @ClassName: Pager
 * @Description: ��ҳ��
 * @author litengbin
 * @date 2017��5��12��
 * 
 */
public class Pager {
	private int pageNow;// ��ǰҳ��
	private int pageSize = 4;// ÿҳ��ʾ��������¼
	private int totalPage;// ���ж���ҳ
	private int totalSize;// һ�����ټ�¼
	private boolean hasFirst;// �Ƿ�����ҳ
	private boolean hasPre;// �Ƿ���ǰһҳ
	private boolean hasNext;// �Ƿ�����һҳ
	private boolean hasLast;// �Ƿ������һҳ

	/**
	 * 
	 * ����һ���µ�ʵ�� Pager.
	 * 
	 * @param pageNow
	 * @param totalSize
	 */
	public Pager(int pageNow, int totalSize) {
		// TODO Auto-generated constructor stub
		// ���ù��췽��Ϊ������ֵ
		this.pageNow = pageNow;
		this.totalSize = totalSize;
	}

	/**
	 * 
	 * @Title: getPageNow
	 * @Description: pageNow��getter����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int getPageNow() {
		return pageNow;
	}

	/**
	 * 
	 * @Title: setPageNow
	 * @Description: pageNow��setter����
	 * @param @param pageNow ����
	 * @return void ��������
	 * @throws
	 */
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	/**
	 * 
	 * @Title: getPageSize
	 * @Description: pageSize��getter����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 
	 * @Title: setPageSize
	 * @Description: pageSize��setter����
	 * @param @param pageSize ����
	 * @return void ��������
	 * @throws
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 
	 * @Title: getTotalPage
	 * @Description: totalPage��getter����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int getTotalPage() {
		// һ������ҳ���㷨
		totalPage = getTotalSize() / getPageSize();
		if (totalSize % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	/**
	 * 
	 * @Title: setTotalPage
	 * @Description: totalPage��setter����
	 * @param @param totalPage ����
	 * @return void ��������
	 * @throws
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 
	 * @Title: getTotalSize
	 * @Description: totalSize��getter����
	 * @param @return ����
	 * @return int ��������
	 * @throws
	 */
	public int getTotalSize() {
		return totalSize;
	}

	/**
	 * 
	 * @Title: setTotalSize
	 * @Description: totalSize��setter����
	 * @param @param totalSize ����
	 * @return void ��������
	 * @throws
	 */
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * 
	 * @Title: isHasFirst
	 * @Description: hasFirst��getter����
	 * @param @return ����
	 * @return boolean ��������
	 * @throws
	 */
	public boolean isHasFirst() {
		// �����ǰΪ��1ҳ��û����ҳ
		if (pageNow == 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @Title: setHasFirst
	 * @Description: hasFirst��setter����
	 * @param @param hasFirst ����
	 * @return void ��������
	 * @throws
	 */
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}

	/**
	 * 
	 * @Title: isHasPre
	 * @Description: hasPre��getter����
	 * @param @return ����
	 * @return boolean ��������
	 * @throws
	 */
	public boolean isHasPre() {
		// �������ҳ����ǰһҳ����Ϊ����ҳ�Ͳ��ǵ�1ҳ
		if (pageNow == 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @Title: setHasPre
	 * @Description: hasPre��setter����
	 * @param @param hasPre ����
	 * @return void ��������
	 * @throws
	 */
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}

	/**
	 * 
	 * @Title: isHasNext
	 * @Description: hasNext��getter����
	 * @param @return ����
	 * @return boolean ��������
	 * @throws
	 */
	public boolean isHasNext() {
		// �����βҳ������һҳ����Ϊ��βҳ�����������һҳ
		if (isHasLast()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @Title: setHasNext
	 * @Description: hasNext��setter����
	 * @param @param hasNext ����
	 * @return void ��������
	 * @throws
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

	/**
	 * 
	 * @Title: isHasLast
	 * @Description: hasLast��getter����
	 * @param @return ����
	 * @return boolean ��������
	 * @throws
	 */
	public boolean isHasLast() {
		// ����������һҳ����βҳ
		if (pageNow == this.getTotalPage()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * @Title: setHasLast
	 * @Description: hasLast��setter����
	 * @param @param hasLast ����
	 * @return void ��������
	 * @throws
	 */
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}

}

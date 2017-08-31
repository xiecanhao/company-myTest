package mytest;

import java.io.Serializable;
import java.util.Date;

public class RechDatil implements Serializable {
	/**  */
	private static final long serialVersionUID = 1L;
	private int grade;
	private String rechId;
	private Date createTime;

	public RechDatil(int grade, String rechId) {
		this.grade = grade;
		this.rechId = rechId;
		this.createTime = new Date();
	}

	public RechDatil() {
	}

	@Override
	public int hashCode() {
		return this.grade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof RechDatil)) {
			return false;
		}
		return this.grade == ((RechDatil) obj).getGrade();
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getRechId() {
		return rechId;
	}

	public void setRechId(String rechId) {
		this.rechId = rechId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
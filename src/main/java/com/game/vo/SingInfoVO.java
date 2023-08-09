package com.game.vo;

public class SingInfoVO {
	private int siNum;
	private String siName;
	private String siGenre;
	private String siTitle;
	public int getSiNum() {
		return siNum;
	}
	public void setSiNum(int siNum) {
		this.siNum = siNum;
	}
	public String getSiName() {
		return siName;
	}
	public void setSiName(String siName) {
		this.siName = siName;
	}
	public String getSiGenre() {
		return siGenre;
	}
	public void setSiGenre(String siGenre) {
		this.siGenre = siGenre;
	}
	public String getSiTitle() {
		return siTitle;
	}
	public void setSiTitle(String siTitle) {
		this.siTitle = siTitle;
	}
	@Override
	public String toString() {
		return "SingInfoVO [siNum=" + siNum + ", siName=" + siName + ", siGenre=" + siGenre + ", siTitle=" + siTitle
				+ "]";
	}

}

package com.entities.share;

import java.io.Serializable;

public class ResultInfo implements Serializable {

	/**  */
	private static final long serialVersionUID = 3171758779442297158L;

	private boolean resultFlag = true;
	private String resultText;
	private String resultDetailText;
	private Object resultObject;
	private Boolean resultBoolean;
	private String resultString;

	/**
	 * @return the resultFlag
	 */
	public boolean getResultFlag() {
		return resultFlag;
	}

	/**
	 * @param resultFlag
	 *            the resultFlag to set
	 */
	public void setResultFlag(boolean resultFlag) {
		this.resultFlag = resultFlag;
	}

	/**
	 * @return the resultText
	 */
	public String getResultText() {
		return resultText;
	}

	/**
	 * @param resultText
	 *            the resultText to set
	 */
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

	/**
	 * @return the resultDetailText
	 */
	public String getResultDetailText() {
		return resultDetailText;
	}

	/**
	 * @param resultDetailText
	 *            the resultDetailText to set
	 */
	public void setResultDetailText(String resultDetailText) {
		this.resultDetailText = resultDetailText;
	}

	/**
	 * @return the resultObject
	 */
	public Object getResultObject() {
		return resultObject;
	}

	/**
	 * @param resultObject
	 *            the resultObject to set
	 */
	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}

	/**
	 * @return the resultObjectBoolean
	 */
	public Boolean getResultBoolean() {
		return resultBoolean;
	}

	/**
	 * @param resultObjectBoolean
	 *            the resultObjectBoolean to set
	 */
	public void setResultBoolean(Boolean resultBoolean) {
		this.resultBoolean = resultBoolean;
	}

	/**
	 * @return the resultObjectString
	 */
	public String getResultString() {
		return resultString;
	}

	/**
	 * @param resultObjectString
	 *            the resultObjectString to set
	 */
	public void setResultString(String resultString) {
		this.resultString = resultString;
	}

}


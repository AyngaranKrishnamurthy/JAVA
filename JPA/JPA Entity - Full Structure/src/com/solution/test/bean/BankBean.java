package com.solution.test.bean;

import java.util.ArrayList;
import java.util.List;

public class BankBean 
{
private int bankId;
private String bankName;
private List<AddressBean> AddressBean=new ArrayList<AddressBean>();
public int getBankId() {
	return bankId;
}
public void setBankId(int bankId) {
	this.bankId = bankId;
}
public String getBankName() {
	return bankName;
}
public void setBankName(String bankName) {
	this.bankName = bankName;
}
public List<AddressBean> getAddressBean() {
	return AddressBean;
}
public void setAddressBean(List<AddressBean> addressBean) {
	AddressBean = addressBean;
}

}

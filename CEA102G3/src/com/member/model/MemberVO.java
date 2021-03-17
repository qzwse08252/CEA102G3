package com.member.model;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.ServletOutputStream;

public class MemberVO implements Serializable{
	private Integer memberNo;
	private String account;
	private String password;
	private String name;
	private String idNumber;
	private Date birthDate;
	private String phone;
	private String email;
	private Integer memberState;
	private byte[] memberPic;
	private byte[] liscePic1;
	private byte[] liscePic2;
	private byte[] liscePic3;
	private String lisceName1;
	private String lisceName2;
	private String lisceName3;
	
	public MemberVO() {
	}


	public Integer getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Integer memberNo) {
		this.memberNo = memberNo;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getMemberState() {
		return memberState;
	}

	public void setMemberState(Integer memberState) {
		this.memberState = memberState;
	}

	
	public byte[] getMemberPic() {
		return memberPic;
	}


	public void setMemberPic(byte[] memberPic) {
		this.memberPic = memberPic;
	}


	public byte[] getLiscePic1() {
		return liscePic1;
	}


	public void setLiscePic1(byte[] liscePic1) {
		this.liscePic1 = liscePic1;
	}


	public byte[] getLiscePic2() {
		return liscePic2;
	}


	public void setLiscePic2(byte[] liscePic2) {
		this.liscePic2 = liscePic2;
	}


	public byte[] getLiscePic3() {
		return liscePic3;
	}


	public void setLiscePic3(byte[] liscePic3) {
		this.liscePic3 = liscePic3;
	}


	public String getLisceName1() {
		return lisceName1;
	}

	public void setLisceName1(String lisceName1) {
		this.lisceName1 = lisceName1;
	}

	public String getLisceName2() {
		return lisceName2;
	}

	public void setLisceName2(String lisceName2) {
		this.lisceName2 = lisceName2;
	}

	public String getLisceName3() {
		return lisceName3;
	}

	public void setLisceName3(String lisceName3) {
		this.lisceName3 = lisceName3;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((lisceName1 == null) ? 0 : lisceName1.hashCode());
		result = prime * result + ((lisceName2 == null) ? 0 : lisceName2.hashCode());
		result = prime * result + ((lisceName3 == null) ? 0 : lisceName3.hashCode());
		result = prime * result + Arrays.hashCode(liscePic1);
		result = prime * result + Arrays.hashCode(liscePic2);
		result = prime * result + Arrays.hashCode(liscePic3);
		result = prime * result + ((memberNo == null) ? 0 : memberNo.hashCode());
		result = prime * result + Arrays.hashCode(memberPic);
		result = prime * result + ((memberState == null) ? 0 : memberState.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idNumber == null) {
			if (other.idNumber != null)
				return false;
		} else if (!idNumber.equals(other.idNumber))
			return false;
		if (lisceName1 == null) {
			if (other.lisceName1 != null)
				return false;
		} else if (!lisceName1.equals(other.lisceName1))
			return false;
		if (lisceName2 == null) {
			if (other.lisceName2 != null)
				return false;
		} else if (!lisceName2.equals(other.lisceName2))
			return false;
		if (lisceName3 == null) {
			if (other.lisceName3 != null)
				return false;
		} else if (!lisceName3.equals(other.lisceName3))
			return false;
		if (!Arrays.equals(liscePic1, other.liscePic1))
			return false;
		if (!Arrays.equals(liscePic2, other.liscePic2))
			return false;
		if (!Arrays.equals(liscePic3, other.liscePic3))
			return false;
		if (memberNo == null) {
			if (other.memberNo != null)
				return false;
		} else if (!memberNo.equals(other.memberNo))
			return false;
		if (!Arrays.equals(memberPic, other.memberPic))
			return false;
		if (memberState == null) {
			if (other.memberState != null)
				return false;
		} else if (!memberState.equals(other.memberState))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

}

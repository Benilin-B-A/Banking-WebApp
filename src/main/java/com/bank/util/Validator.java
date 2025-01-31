package com.bank.util;

import java.util.regex.Pattern;

import com.bank.exceptions.InvalidInputException;

public class Validator {

	private static Pattern mobilePattern = Pattern.compile("^[7-9]{1}[0-9]{9}$");
	private static Pattern alphaNumeric = Pattern.compile("\\A[0-9A-Z]+\\Z");
	private static Pattern mailPattern = Pattern.compile(
			"^[\\w.%+-]{1,25}@[a-zA-Z0-9.-]{1,10}\\.[a-zA-Z]{2,10}$");
	private static Pattern passwordPattern = Pattern.compile(
			"^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+]).{8,}$");
	private static Pattern pinPattern = Pattern.compile("[0-9]{4}");
	private static Pattern dOBPattern = Pattern.compile(
			"^(?:\\d{4})-(?:0[1-9]|1[0-2])-(?:0[1-9]|[1][0-9]|[2][0-9]|3[01])$");
	private static Pattern genderPattern = Pattern.compile("^(Male|Female|Other)$");
	private static Pattern userIdPattern = Pattern.compile("^[1-9]{1}[0-9]{0,15}$");
	private static Pattern iFSCPattern = Pattern.compile("^[0-9A-Z]{5,15}$");
	private static Pattern pANPattern = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
	private static Pattern descriptionPattern = Pattern.compile("^.{1,50}$");
	private static Pattern addressPattern = Pattern.compile("^[a-zA-Z0-9, ]+$");
	private static Pattern pinCodePattern = Pattern.compile("^[0-9]{6}$");
	private static Pattern namePattern = Pattern.compile("^[a-z A-Z]{1,45}$");
	private static Pattern aadharPattern = Pattern.compile("^[1-9]{1}[0-9]{11}$");
	private static Pattern eDOBPattern = Pattern.compile(
			"^(19[7-9]\\d|2000)-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
	private static Pattern cDOBPattern = Pattern.compile(
			"^(1920|19[2-9]\\d|20[01]\\d|2020)-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
	
	public static boolean validateIFSC(String iFSC) throws InvalidInputException {
		checkNull(iFSC, "IFSC cannot be null");
		boolean isValid = validate(iFSCPattern, iFSC);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid IFSC format");
	}
	
	public static boolean validatePAN(String pAN) throws InvalidInputException {
		checkNull(pAN, "PAN number cannot be null");
		boolean isValid = validate(pANPattern, pAN);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid PAN format");
	}
	
	public static boolean validateUserID(String userId) throws InvalidInputException {
		checkNull(userId, "UserID cannot be null");
		boolean isValid = validate(userIdPattern, userId);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid User ID format");
	}
	
	public static boolean validateMobile(String num) throws InvalidInputException {
		checkNull(num, "Mobile number cannot be null");
		boolean isValid = validate(mobilePattern, num);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid mobile number");
	}
	
	public static boolean validateGender(String gender) throws InvalidInputException {
		checkNull(gender, "Gender cannot be null");
		boolean isValid = validate(genderPattern, gender);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid mobile number");
	}
	
	public static boolean validateDOB(String dOB) throws InvalidInputException {
		checkNull(dOB, "DOB cannot be null");
		boolean isValid = validate(dOBPattern, dOB);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid DOB");
	}

	public static boolean validateAlphaNum(String alphaNum) throws InvalidInputException {
		checkNull(alphaNum, "IFSC cannot be null");
		boolean isValid = validate(alphaNumeric, alphaNum);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid IFSC");
	}

	public static boolean validateMail(String mail) throws InvalidInputException {
		checkNull(mail, "Mail cannot be null");
		boolean isValid = validate(mailPattern, mail);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid E-Mail");
	}

	public static boolean validatePassword(String password) throws InvalidInputException {
		checkNull(password, "Password cannot be null");
		boolean isValid = validate(passwordPattern, password);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Password");
	}

	private static boolean validate(Pattern pattern, String str) throws InvalidInputException {
		return pattern.matcher(str).matches();

	}
	
	public static void checkNull(Object obj)throws InvalidInputException{
		checkNull(obj,"Invalid Input : Values cannot be null");
	}
	
	public static void checkNull(Object obj,String message)throws InvalidInputException{
		if (obj==null){
			throw new InvalidInputException(message);
		}
	}

	public static boolean validatePin(String newPin) throws InvalidInputException {
		checkNull(newPin, "PIN cannot be null");
		boolean isValid = validate(pinPattern, newPin);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Pin must be a four digit number");
	}

	public static boolean validateAccount(String accNumber) throws InvalidInputException {
		checkNull(accNumber, "Account number cannot be null");
		boolean isValid = validate(userIdPattern, accNumber);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Account Number");
	}

	public static boolean validateAmount(String amount) throws InvalidInputException {
		checkNull(amount, "Amount cannot be null");
		boolean isValid = validate(userIdPattern, amount);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Amount");		
	}

	public static boolean validateDescription(String description) throws InvalidInputException {
		checkNull(description, "Description cannot be null");
		boolean isValid = validate(descriptionPattern, description);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Description");		
	}

	public static boolean validateAddress(String address) throws InvalidInputException {
		checkNull(address, "Address cannot be null");
		boolean isValid = validate(addressPattern, address);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Address");
	}

	public static boolean validatePinCode(String pinCode) throws InvalidInputException {
		checkNull(pinCode, "PinCode cannot be null");
		boolean isValid = validate(pinCodePattern, pinCode);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid PinCode");
	}

	public static boolean validateName(String name) throws InvalidInputException {
		checkNull(name, "Name cannot be null");
		boolean isValid = validate(namePattern, name);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Name");
	}

	public static boolean validateAadharNumber(String aadharNumber) throws InvalidInputException {
		checkNull(aadharNumber, "Aadhar number cannot be null");
		boolean isValid = validate(aadharPattern, aadharNumber);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Name");
	}
	
	public static boolean validateEmployeeDOB(String dOB) throws InvalidInputException {
		checkNull(dOB, "DOB cannot be null");
		boolean isValid = validate(eDOBPattern, dOB);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Date of birth");
	}

	public static boolean validateCustomerDOB(String dOB) throws InvalidInputException {
		checkNull(dOB, "DOB cannot be null");
		boolean isValid = validate(cDOBPattern, dOB);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Date of birth");
	}

	public static boolean validateBranchID(String branchID) throws InvalidInputException {
		checkNull(branchID, "Branch ID cannot be null");
		boolean isValid = validate(userIdPattern, branchID);
		if (isValid) {
			return true;
		}
		throw new InvalidInputException("Invalid Branch ID");
	}
	

}

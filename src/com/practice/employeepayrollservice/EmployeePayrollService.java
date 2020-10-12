package com.practice.employeepayrollservice;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeePayrollService {
	enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private ArrayList<EmployeePayrollData> employeePayrollDataList;

	public EmployeePayrollService(ArrayList<EmployeePayrollData> employeePayrollDataList) {
		super();
		this.employeePayrollDataList = employeePayrollDataList;
	}

	public EmployeePayrollService() {
		this.employeePayrollDataList = new ArrayList<EmployeePayrollData>();
	}

	/**
	 *  Reads from console
	 */
	public void readEmployeeData() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the employee data\n\nEnter Employee name: ");
			String empName = sc.next();
			System.out.println("Enter the employee id:");
			long empId = sc.nextLong();
			System.out.println("Enter the employee salary:");
			long salary = sc.nextLong();
			employeePayrollDataList.add(new EmployeePayrollData(empId, empName, salary));
			sc.close();

	}
	
	/**
	 * Writes to file or consoles
	 */
	public void writeEmployeeData(IOService ioService) {
		if(ioService.equals(IOService.CONSOLE_IO)) {
			employeePayrollDataList.forEach(System.out::println);
		}
		else if(ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeData(employeePayrollDataList);
		}
		
	}

	/**
	 * Counts the entries
	 */
	public long countEntries(IOService ioService) {
		return new EmployeePayrollFileIOService().countEntries();
	}

}

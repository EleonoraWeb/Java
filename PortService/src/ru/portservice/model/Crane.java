package ru.portservice.model;

import java.util.Date;

//����� �����
public class Crane {
	//������������������ �� ������
	private int _productivity;
	//��� �����, ������� ����� ���������� ����
	private CargoType _cargoType;
	
	private Date lastWorkFinished;
	
	//�����������
	public Crane(int productivity, CargoType cargoType) {
		_productivity = productivity;
		_cargoType = cargoType;
	}
	
	//������ ������������������
	public int getProductivity() {
		return _productivity;
	}
	
	//������ ��� �����
	public CargoType getCargoType() {
		return _cargoType;
	}

	public Date getLastWorkFinished() {
		return lastWorkFinished;
	}

	public void setLastWorkFinished(Date lastWorkFinished) {
		this.lastWorkFinished = lastWorkFinished;
	}
}

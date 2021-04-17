package ru.portservice.model;

import java.util.Date;

//Класс крана
public class Crane {
	//Производительность за минуту
	private int _productivity;
	//Тип груза, который может разгружать кран
	private CargoType _cargoType;
	
	private Date lastWorkFinished;
	
	//Конструктор
	public Crane(int productivity, CargoType cargoType) {
		_productivity = productivity;
		_cargoType = cargoType;
	}
	
	//Геттер производительность
	public int getProductivity() {
		return _productivity;
	}
	
	//Геттер тип груза
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

package ru.portservice.service1;

import ru.portservice.model.*;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Generator {
	//��������� ��������� �����
	private static Random rnd = new Random();
	
	//������ ��������
	private static ArrayList<Schedule> schedule;
		
	public static String Generate(int count)  throws IOException {
		schedule = new ArrayList<Schedule>();
				
		Calendar c;
		
		for(int i = 0; i < count; i++) {
			Schedule record = new Schedule();
			
			int type = rnd.nextInt(3);			
			switch(type) {
			case 0:
				record.setCargoType(CargoType.�������);
				break;
			case 1:
				record.setCargoType(CargoType.������);
				break;
			case 2:
				record.setCargoType(CargoType.���������);
				break;
			}
			
			record.setShipName("������� �" + (i + 1));
			
			c = new GregorianCalendar(2021, Calendar.APRIL, 
					1 + rnd.nextInt(30), rnd.nextInt(24), rnd.nextInt(60), 00);
			Date plannedArrivalTime = c.getTime();
			c.add(Calendar.DATE, -7 + rnd.nextInt(14));
			Date realArrivalTime = c.getTime();
			
			record.setPlannedArrivalTime(plannedArrivalTime);
			record.setRealArrivalTime(realArrivalTime);
			
			record.setCargoValue(1000 * (1 + rnd.nextInt(20)));
			
			record.setUnloadingDelay(rnd.nextInt(1440));
			
			schedule.add(record);
		}
		
		//��������� ���������� �� ��������� ������� �������� �������� � ����
		Collections.sort(schedule, new Comparator<Schedule>() {
		    @Override
		    public int compare(Schedule left, Schedule right) {
		        return left.getRealArrivalTime().after(right.getRealArrivalTime()) ? 1 : 
		        	(left.getRealArrivalTime().before(right.getRealArrivalTime())) ? -1 : 0;
		    }
		});
		
		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(writer, schedule);
		return writer.toString();
	}
}

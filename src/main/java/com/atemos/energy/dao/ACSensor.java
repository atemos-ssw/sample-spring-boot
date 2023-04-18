package com.atemos.energy.dao;
 
import org.hibernate.annotations.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Entity(name="ACSensor")
@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
@ToString
public class ACSensor{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int id;
	
	String LogicalId; 
	float CreatedTs; 
	String CreatedDate;
	int GroupId;
	int ModuleId;
	float PhaseVoltage;
	float LineVoltage;
	float VoltageCrestFactor;
	float PhaseCurrent;
	float CurrentCrestFactor;
	float ActivePower;
	float ReactivePower;
	float PowerFactor;
	float Frequency;
	float ThdPhaseVoltage;
	float ThdPhaseCurrent;
	float Temperature;
	float VoltageHarmonics;
	float CurrentHarmonics;
	float ApparentPower;
	 
//	@Override
//	public String toString() {
//		return String.format("id=%d, LogicalId:%s, CreatedTs: %f, CreatedDate:%s, GroupId:%d, ModuleId:%d"
//				+ "PhaseVoltage: %f, LineVoltage: %f, VoltageCrestFactor: %f,"
//				+ "PhaseCurrent: %f, CurrentCrestFactor:%f, ActivePower:%f,"
//				+ "ReactivePower:%f, PowerFactor:%f, Frequency:%f,"
//				+ "ThdPhaseVoltage:%f, ThdPhaseCurrent:%f, Temperature:%f,"
//				+ "VoltageHarmonics:%f, CurrentHarmonics:%f,"
//				+ "ApparentPower:%f, ", id, LogicalId, CreatedTs, CreatedDate,GroupId,ModuleId,
//				PhaseVoltage,LineVoltage,VoltageCrestFactor,
//				PhaseCurrent,CurrentCrestFactor,ActivePower,
//				ReactivePower,PowerFactor,Frequency,
//				ThdPhaseVoltage,ThdPhaseCurrent,Temperature,
//				VoltageHarmonics,CurrentHarmonics,ApparentPower);
//	}
	
}
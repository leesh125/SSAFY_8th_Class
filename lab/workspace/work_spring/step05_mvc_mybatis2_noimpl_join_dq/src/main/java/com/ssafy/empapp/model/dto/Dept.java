package com.ssafy.empapp.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Model : DTO, DO, VO
//@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
public class Dept {
	
	@NonNull
	private int deptno;
	@NonNull
	private String dname;
	@NonNull
	private String loc;
	
	private List<Emp> emps;  // 1:n
	
	public Dept() {}
}

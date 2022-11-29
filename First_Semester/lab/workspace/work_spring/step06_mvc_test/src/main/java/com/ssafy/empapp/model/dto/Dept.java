package com.ssafy.empapp.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
// Model : DTO, DO, VO
public class Dept {
	@NonNull
	private int deptno;
	@NonNull
	private String dname;
	@NonNull
	private String loc;
	
	private List<Emp> emps;  // 1:n

	
}

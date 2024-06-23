package com.multicampus.biz.user;

import lombok.Data;

// value object
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Data
public class UserVO {
	// users 테이블의 컬럼 이름과 타입에 해당하는 멤버변수 선언
	private String id;
	private String password;
	private String name;
	private String role;
}

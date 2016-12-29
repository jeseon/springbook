package chapter01.lesson03.design_pattern;

import lombok.Data;


/**
 * 사용자 정보 저장
 * 
 * @author monos
 */
@Data
public class User {
	int id;
	String name;
	String email;
}

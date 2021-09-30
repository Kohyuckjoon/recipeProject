package com.kh.recipe.member.model.dto;

//Builder 패턴 공부용 클래스 사용 x
public class User {

	//객체 생성 패턴
	//1. 점층적 생성자 패턴
	// 생성자의 매개변수를 통해 객체의 속성을 초기화하고 생성하는 패턴
	// 단점 : 코드만 보고 생성자의 매개변수가 어떤 객체의 속성을 초기화하는 값인지 알기 어렵다.
	//		가독성이 좋지 않다.
	
	//2. 자바빈 패턴
	// getter/setter
	// 단점 : public 메서드인 setter를 사용해 속성을 초기화히기 떄문에, 변경불가능한(immutable) 객체를 만들 수 없다.
	
	//3. 빌더 패턴
	// 가독성과 변경불가능한 객체를 만들 수 없다는 단점을 극복한 디자인패턴
	// Effective Java에서 제시된 Builder 패턴
	private String userId;
	private String password;
	private String name;
	private String email;
	private String phone;
	
	//생성자는 private 처리하여 외부에서 직접 객체를 생성하는 것을 차단
	//객체의 생성은 오직 Factory Class인 Builder를 통해서 만 생성
	private User(UserBuilder builder) {
		this.userId = builder.userId;
		this.password = builder.password;
		this.name = builder.name;
		this.email = builder.email;
		this.phone = builder.phone;
		
	}
	
	public static UserBuilder builder() {
		return new UserBuilder();
	}
	
	//생성될 User객체의 속성을 초기화하기 위한 값을 전달 받고, User의 인스턴스를 생성해줄 inner class
	public static class UserBuilder{
		
		private String userId;
		private String password;
		private String name;
		private String email;
		private String phone;
		
		public UserBuilder id(String userId) {
			this.userId = userId;
			return this; //userId 속성이 초기화된 UserBuilder
		}
		
		public UserBuilder password(String password) {
			this.password = password;
			return this; 
		}
		
		public UserBuilder name(String name) {
			this.name = name;
			return this; 
		}
		
		public UserBuilder email(String email) {
			this.email = email;
			return this; 
		}
		
		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this; 
		}
		
		public User build() {
			return new User(this);
		}

		@Override
		public String toString() {
			return "UserBuilder [userId=" + userId + ", password=" + password + ", name =" + name + ", email=" + email + ", phone=" + phone + "]";
		}

		
		
	}
	
	
}

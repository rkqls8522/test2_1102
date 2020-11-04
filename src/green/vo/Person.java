package green.vo;


public class Person {
	protected int num;
	protected String name;
	protected String personId;
	protected String juso;
	protected String phone;
	protected int sibling;
	protected String dadName;
	
	protected int age;
	
	
	public int getAge() {
		return age;
	}
	public Person setAge(int age) {
		this.age = age;
		return this;
	}
	
	public int getNum() {
		return num;
	}
	public Person setNum(int num) {
		this.num = num;
		return this;
	}
	public String getName() {
		return name;
	}
	public Person setName(String name) {
		this.name = name;
		return this;
	}
	public String getPersonId() {
		return personId;
	}
	public Person setPersonId(String personId) {
		this.personId = personId;
		return this;
	}
	public String getJuso() {
		return juso;
	}
	public Person setJuso(String juso) {
		this.juso = juso;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public Person setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public int getSibling() {
		return sibling;
	}
	public Person setSibling(int sibling) {
		this.sibling = sibling;
		return this;
	}
	public String getDadName() {
		return dadName;
	}
	public Person setDadName(String dadName) {
		this.dadName = dadName;
		return this;
	}
	
	
}

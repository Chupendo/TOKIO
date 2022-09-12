package codes.exercicies.tokio.activies.three;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.regex.Pattern;

public class Job {
	private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; // email validation
																								// permitted by RFC 5322
	private String name;
	private String surName;
	private String dni;
	private String email;
	private Date birthday;
	private double salary;
	private boolean temp;
	private Date dateTemp;
	
	public Job(String name, String surName,int... numberDaysVisit) {
		this.name = name;
		this.surName = surName;
		if(numberDaysVisit.length==0) {
			this.temp = false;
			this.dateTemp = null;
		}else {
			this.temp = true;
			this.dateTemp = sumDays(numberDaysVisit[0]);
		}
	}

	public Job(String name, String surName, String dni, String email, Date birthday, double salary) {
		this(name, surName);
		this.dni = dni;
		this.email = email;
		this.birthday = birthday;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getSurName() {
		return surName;
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public boolean isTemp() {
		return temp;
	}


	public Date getNumberDaysVisti() {
		return dateTemp;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYY");
		if(temp) {
			return "Job temp [name=" + name + ", surName=" + surName + ", dateTemp=" + sdf.format(dateTemp) + "]";
		}else {
			return "Job fixed [name=" + name + ", surName=" + surName + ", dni=" + dni + ", email=" + email + ", birthday="
					+ sdf.format(birthday) + ", salary=" + salary + "]";
		}
		
	}

	public static boolean validEmail(String email) {
		//Pattern pattern = Pattern.compile(regex);
		return 	email.matches(regex);//pattern.matcher(email).matches();
	
	}
	
	public static Date sumDays(int numberDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, numberDay );
		return cal.getTime();
	}
	
	public void increSalaryFixed(double incre) {
		if(!temp)
			this.salary+=incre;
	}
	
	public void increSalaryPorcent(double incre) {
		if(!temp && incre>0 && incre<=100){
			this.salary=(this.salary*(1+incre/100));
		}
	}
}

package example;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Comparator;
public class Student
{
	private double mark;
	private String firstName;
	private String lastName;
	private int age;




	public double getMark()
	{
		return this.mark;
	}
	
	public void setMark( double mark )
	{
		this.mark = mark;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setAge( int age )
	{
		this.age = age;
	}
	@Override
	public String toString(){ return mark + " " + firstName + " " + lastName + " " + age;}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		
		result = prime * result + age;
		result = prime * result + ( ( firstName == null ) ? 0 : firstName.hashCode() );
		result = prime * result + ( ( lastName == null ) ? 0 : lastName.hashCode() );
		
		long temp;
		temp = Double.doubleToLongBits( mark );
		result = prime * result + (int) ( temp ^ ( temp >>> 32 ) );
		
		return result;
	}
	
	@Override
	public boolean equals( Object obj )
	{
		if ( this == obj )
			return true;
		
		if ( obj == null )
			return false;
		
		if ( getClass() != obj.getClass() )
			return false;
		
		Student other = (Student) obj;
		
		if ( age != other.age )
			return false;
		
		if ( firstName == null )
		{
			if ( other.firstName != null )
				return false;
		}
		else 
			if ( !firstName.equals( other.firstName ) )
				return false;
		
		if ( lastName == null )
		{
			if ( other.lastName != null )
				return false;
		}
		else 
			if ( !lastName.equals( other.lastName ) )
				return false;
		
		if ( Double.doubleToLongBits( mark ) != Double.doubleToLongBits( other.mark ) )
			return false;
		
		return true;
	}

	public static class Comparators{
		public static final Comparator<Student> AGE = (Student s1, Student s2) -> Integer.compare(s1.age, s2.age);
		public static final Comparator<Student> MARK = (Student s1, Student s2) -> Double.compare(s1.mark, s2.mark);
		public static final Comparator<Student> FIRST_NAME = (Student s1, Student s2) -> s1.firstName.compareTo(s2.firstName);
		public static final Comparator<Student> LAST_NAME = (Student s1, Student s2) -> s1.lastName.compareTo(s2.lastName);
	}



}

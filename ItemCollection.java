import java.util.ArrayList;
import java.util.Iterator;

public class ItemCollection {
	private ArrayList<Student> students;
	private ArrayList<Instructor> instructors;
	private ArrayList<Course> courses;

	public ItemCollection() {
		students = new ArrayList<>();
		instructors = new ArrayList<>();
		courses = new ArrayList<>();
	}
	
	public ArrayList<Instructor> getInstructorsById( String value ) {
		ArrayList<Instructor> tempL = new ArrayList<>();
		Iterator<Instructor> it = instructors.iterator();

		while( it.hasNext() ) {
			Instructor temp = it.next();
			
			if( temp.getId().equals( value ) )
				tempL.add(temp);
		}

		return tempL;
	}



	public Instructor getInstructor( String id ) {
		Iterator<Instructor> it = instructors.iterator();

		while( it.hasNext() ) {
			Instructor temp = it.next();
			if( temp.getId().equals(id) )
				return temp;
		}

		return null;
	}

	public boolean removeInstructor( String id ) {
		Iterator<Instructor> it = instructors.iterator();

		while( it.hasNext() ) {
			Instructor temp = it.next();
			if( temp.getId().equals(id) )
			{
				it.remove();
				return true;
			}
		}

		return false;
	}

	public boolean updateInstructor( String id, Instructor newInstructor ) {
		Instructor current = this.getInstructor( id );

		if( current != null && this.getInstructor( newInstructor.getId() ) == null ) {
			instructors.set(instructors.indexOf(current), newInstructor);
			return true;
		}

		return false;
	}

	public boolean addInstructor( Instructor newInstructor ) {
		if( this.getInstructor( newInstructor.getId() ) != null)
			return false;

		instructors.add(newInstructor);
		return true;
	}
}
import java.util.Iterator;

public class MyIterator implements java.util.Iterator {	
	
	Object arr[];
	 int counter=0;
	
	public MyIterator(Object[] arr)
	{					
		this.arr=arr;		
	}
	
	/**
	 * hasNext() This method checks if there is next element in the set
	 * @param :
	 * @return : Boolean
	 * 		returns true if there is next element and false otherwise.
	 */
	
	public boolean hasNext() {		
		
		boolean nextElem=false;	
		
		if(arr!=null && arr[counter]!=null)
		{				
			nextElem=true;			
		}
		
		return nextElem;
	}
	
	/**
	 * next() This method returns next object in the set
	 * @param :
	 * @return : Object
	 * 		returns next object in the set
	 */
	
	@Override
	public Object next() {
		
			return arr[counter++];		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}

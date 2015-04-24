package lesson_Generics;

public class DataArray<T> {
	private T[] array;
	

	public DataArray(T[] array) {
		this.array = array;
	}
	

	/**
	 * @return the array
	 */
	public T[] getArray() {
		return array;
	}

	/**
	 * @param dataarray the array to set
	 */
	public void setArray(T[] dataarray) {
		this.array = dataarray;
	}
	
	public T getElement(int index) {
		return array[index];
		
	}
	
}

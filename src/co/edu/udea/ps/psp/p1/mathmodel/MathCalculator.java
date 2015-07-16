package co.edu.udea.ps.psp.p1.mathmodel;

import java.util.LinkedList;

import co.edu.udea.ps.psp.p1.exception.MathModelException;

public class MathCalculator {

	public double calculateMean(LinkedList<Double> numbers) throws MathModelException{
		if (!this.validateListSize(numbers)) {
			throw new MathModelException("La lista de n�meros est� vac�a");
		}
		double sum=0;
		double count=0;
		for (Double number : numbers) {
			sum+=number;
			count+=1;
		}
		return sum/count;
	}
	
	public boolean validateListSize(LinkedList<Double> numbers){
		if (numbers==null || numbers.isEmpty()) {
			return false;
		}
		return true;
	}

	public double calculateStandarDesviation(LinkedList<Double> numbers) throws MathModelException{
		if (!this.validateListSize(numbers)) {
			throw new MathModelException("La lista de n�meros est� vac�a");
		}
		
		double mean = this.calculateMean(numbers);
		int numbercount=numbers.size();
		double sumOfSqrt = 0;
		
		for (Double number : numbers) {
			sumOfSqrt+= (number-mean)*(number-mean);
		}
		
		double sd = Math.sqrt((sumOfSqrt / (numbercount - 1)));
		
		return sd;
	}

}

// TODO Write a program to find the aliquot sum of a given number.
//Extend this program to check if given number is a perfect number or not.
		
public class AliquotSum {

	public static void main(String[] args) {
		//Print all perfect numbers between 1 and 100.
		
		System.out.print("Here are the perfect numbers between 1 and 100:  ");
		for (int x=1; x<101; x++ ){
			//We don't need the output of aliquot method so we don't have to save it.
			aliquot(x);
		}

	}
	
	//The aliquot divisors of a number are all its divisors except the number itself.
	//
	static int aliquot(int num){
		
		//every integer less than 2 is an exception to the following logic 
		if (num < 2)
			return 0;
						
		//sum will add up all the aliquot divisors.
		//since '1' is always included, sum starts as 1
		int sum = 1;
		//saving the given number because it will be modified later.
		int given_number = num;
		
		//To increase efficiency, code must stop at the highest possible aliquot divisor
		//which is num/i where i is the second aliquot divisor.
		//if 'num == 99', highest aliquot divisor will be '33', which will save 66 iterations
		int count =1;
		
		//loop finds the aliquot divisors of num, from 0 to num.
		//it starts by checking '2' since '1' is already accounted for
		for(int i=2; i<num; i++){
			if (given_number%i == 0){
				sum += i;
				if(count < 4)
					count++;	//This must only be executed until count is greater than 2 for efficiency and
								//without affecting the logic of next line of code.
				
				//when 'count' is '2', 'i' is the second aliquot divisor.
				//keeping this inside the if statement prevents unnecessary checks
				if (count==2)
					num = (num/i)+1; //this sets the upper bound of the loop to the next number after last divisor
			}			
			
		}
		
		//Extending this program to check if given number is a perfect number or not.
		//If a given_number is equals to its aliquot sum, then it is a perfect number.
		if(given_number == sum)
			//Printing out given_number because it's a perfect number
			System.out.print(given_number+".  ");
		
		return sum;
	}
	

}

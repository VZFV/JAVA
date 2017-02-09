package first;

import java.util.Stack;

public class evaluateInfix {
	public static double evaluateInfix(String infix, int size){
		Stack<Double> valueStack = new Stack<Double>();
		Stack<Character> operatorStack = new Stack<Character>();
		int charCount = infix.length();
		int index = 0;
		double result = 0;
		char nextCharacter = ' ',
			 topOperator = ' ';
		double operandTwo,operandOne = 0;
		for( ;index<charCount;index++){
			nextCharacter = infix.charAt(index);
			
			switch(nextCharacter){
			case '^': 
				operatorStack.push(nextCharacter);
				break;
				
			case '+':
			case '-':
			case '*':
			case '/':
				while(!operatorStack.isEmpty()&&
						precedence(nextCharacter)>=
						precedence(operatorStack.peek())){
					topOperator = operatorStack.pop();
					operandTwo = valueStack.pop();
					operandOne = valueStack.pop();
					if(topOperator == '+')
						result = operandOne+operandTwo;
					else if(topOperator == '-')
						result = operandOne-operandTwo;
					else if(topOperator == '*')
						result = operandOne*operandTwo;
					else if(topOperator == '/')
						result = operandOne/operandTwo;
					valueStack.push(result);
				}
				operatorStack.push(nextCharacter);
				break;
				
			case '(':
				operatorStack.push(nextCharacter);
				break;
				
			case ')' : 
				topOperator = operatorStack.pop();
				while (topOperator != '(')
				{
					operandTwo = valueStack.pop();
					operandOne = valueStack.pop();
					if(topOperator == '+')
						result = operandOne+operandTwo;
					else if(topOperator == '-')
						result = operandOne-operandTwo;
					else if(topOperator == '*')
						result = operandOne*operandTwo;
					else if(topOperator == '/')
						result = operandOne/operandTwo;
					valueStack.push(result);
					operatorStack.push(nextCharacter);					
			}
			break;			
			default: break;			
		}
	}
		while(!operatorStack.isEmpty()){
			topOperator = operatorStack.pop();
			operandTwo = valueStack.pop();
			operandOne = valueStack.pop();
			if(topOperator == '+')
				result = operandOne+operandTwo;
			else if(topOperator == '-')
				result = operandOne-operandTwo;
			else if(topOperator == '*')
				result = operandOne*operandTwo;
			else if(topOperator == '/')
				result = operandOne/operandTwo;
			valueStack.push(result);
		}	
		return valueStack.peek();
	}
	
	public static double precedence(char s){
		switch(s){
			case '^': 
				return 1;
			case '/':
			case '*': 
				return 2;
			case '+':
			case '-':
				return 3;
			default: return 0;
		}
	}
}

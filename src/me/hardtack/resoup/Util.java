package me.hardtack.resoup;

public class Util {
	public static boolean isInteger(String s) {
		try{
			Integer.parseInt(s);
			return true;
		} catch(Exception e){
			return false;
		}
	}
	
	public static boolean isDouble(String s){
		try{
			Double.parseDouble(s);
			return true;
		} catch(Exception e){
			return false;
		}
	}
	
	public static Number add(Number left, Number right){
		if (left instanceof Integer && right instanceof Integer){
			return new Integer(left.intValue() + right.intValue());
		}
		return new Double(left.doubleValue() + right.doubleValue());
	}
	
	public static Number sub(Number left, Number right){
		if (left instanceof Integer && right instanceof Integer){
			return new Integer(left.intValue() - right.intValue());
		}
		return new Double(left.doubleValue() - right.doubleValue());
	}
	public static Number multiply(Number left, Number right){
		if (left instanceof Integer && right instanceof Integer){
			return new Integer(left.intValue() * right.intValue());
		}
		return new Double(left.doubleValue() * right.doubleValue());
	}
	public static Number divide(Number left, Number right){
		if (left instanceof Integer && right instanceof Integer){
			return new Integer(left.intValue() / right.intValue());
		}
		return new Double(left.doubleValue() / right.doubleValue());
	}
	
	public static int compare(Number n1, Number n2) {
	    long l1 = n1.longValue();
	    long l2 = n2.longValue();
	    if (l1 != l2){
	        return (l1 < l2 ? -1 : 1);
	    }
	    return Double.compare(n1.doubleValue(), n2.doubleValue());
	}
	
}

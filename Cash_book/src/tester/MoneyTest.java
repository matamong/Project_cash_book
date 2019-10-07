package tester;

import static java.lang.System.out;

import com.cash_book.model.Money;

public class MoneyTest {
	public static void main(String[] args) {
		
		// plus method test
		Money val_1 = Money.wons(100);
		Money val_2 = Money.wons(200);
		Money val_3 = Money.wons(300);
		Money val_4 = Money.wons(400);
		Money result = Money.ZERO;
		
		result = result.plus(val_1, val_2, val_3, val_4);
		out.println("plus result(origin : 0) : " + result.toString());
		out.println(val_1);
		out.println(val_2);
		out.println(val_3);
		out.println(val_4);
		
		out.println();
		
		// minus method test
		result = result.minus(val_1, val_2, val_3, val_4);
		out.println("minus result(origin : 1000) : " + result.toString());
		out.println(val_1);
		out.println(val_2);
		out.println(val_3);
		out.println(val_4);
		
		System.out.println();
		
		// divide method test
		Money test_1 = Money.wons(100);
		Money testResult = test_1.divide(4);
		out.println("divide result(divisor : 4) : " + testResult.toString());
		out.println(test_1);
		
		System.out.println();
		
		// avg method test
		Money value_1 = Money.wons(100);
		Money value_2 = Money.wons(200);
		Money value_3 = Money.wons(300);
		Money value_4 = Money.wons(400);
		Money valueResult = Money.avg(value_1, value_2, value_3, value_4);
		out.println("avg result : " + valueResult);
		out.println(value_1);
		out.println(value_2);
		out.println(value_3);
		out.println(value_4);
	}
}

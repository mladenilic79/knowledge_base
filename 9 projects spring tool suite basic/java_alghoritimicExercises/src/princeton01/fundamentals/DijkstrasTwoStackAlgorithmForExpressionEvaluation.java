package princeton01.fundamentals;

import java.util.Stack;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/*
 *  Evaluates (fully parenthesized) arithmetic expressions
 *  ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 */

// ne naterah ga da radi
public class DijkstrasTwoStackAlgorithmForExpressionEvaluation {
	public static void main(String[] args) {
		
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();

		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if (s.equals("("))
				;
			else if (s.equals("+"))
				ops.push(s);
			else if (s.equals("-"))
				ops.push(s);
			else if (s.equals("*"))
				ops.push(s);
			else if (s.equals("/"))
				ops.push(s);
			else if (s.equals("sqrt"))
				ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+"))
					v = vals.pop() + v;
				else if (op.equals("-"))
					v = vals.pop() - v;
				else if (op.equals("*"))
					v = vals.pop() * v;
				else if (op.equals("/"))
					v = vals.pop() / v;
				else if (op.equals("sqrt"))
					v = Math.sqrt(v);
				vals.push(v);
			} else
				vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}
}

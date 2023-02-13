import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CodeNode {
    private final String routeName;
    private final String routeCode;

    private CodeNode right = null;
    private CodeNode left = null;

    public String getRouteName() {
        return routeName;
    }
    public String getRouteCode() {
        return routeCode;
    }

    public CodeNode getRight() {
        return right;
    }

    public void setRight(CodeNode right) {
        this.right = right;
    }

    public CodeNode getLeft() {
        return left;
    }

    public void setLeft(CodeNode left) {
        this.left = left;
    }

    public CodeNode(String routeName, String routeCode) {
        this.routeName = routeName;
        this.routeCode = routeCode;
    }

    // Returns whichever node is larger (to the right)
    public CodeNode compare(CodeNode other) throws UnsupportedEncodingException {
        int thisKey = numberfy(routeName);
        int otherKey = numberfy(other.getRouteName());

        return thisKey > otherKey ? this : other;
    }

    public static int numberfy(String input)
    {
        String bytes = Arrays.toString(input.getBytes(StandardCharsets.US_ASCII));
        bytes = bytes.substring(1, bytes.length()-1);
        String[] numParts = bytes.split(",");

        int sum = 0;
        for (String numPart : numParts) {
            String part = numPart.trim();
            sum += Integer.parseInt(part);
        }
        return sum;
    }
}

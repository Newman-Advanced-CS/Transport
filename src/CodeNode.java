import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public record CodeNode(String routeName, String routeCode) {
    @Override
    public String routeName() {
        return routeName;
    }

    @Override
    public String routeCode() {
        return routeCode;
    }

    // Returns whichever node is larger (to the right)
    public CodeNode compare(CodeNode other) throws UnsupportedEncodingException {
        int thisKey = numberfy(routeName);
        int otherKey = numberfy(other.routeName());

        return thisKey > otherKey ? this : other;
    }

    public int numberfy(String input)
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

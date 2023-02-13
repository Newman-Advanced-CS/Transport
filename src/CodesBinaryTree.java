// Binary Tree for all codes

import java.io.UnsupportedEncodingException;

public class CodesBinaryTree {
    private CodeNode codeValuesRoot;

    public CodesBinaryTree(CodeNode codeValuesRoot) {
        this.codeValuesRoot = codeValuesRoot;
    }

    public CodesBinaryTree() {}

    public String getCode(String routeName)
    {
        CodeNode searchPosition = codeValuesRoot;
        while (!searchPosition.getRouteName().equals(routeName))
        {
            if (CodeNode.numberfy(routeName) > CodeNode.numberfy(searchPosition.getRouteName())){
                // It is to the right
                searchPosition = searchPosition.getRight();
            }else{
                // It is to the left
                searchPosition = searchPosition.getLeft();
            }
        }
        return searchPosition.getRouteCode();
    }

    public void addCode(CodeNode node) throws UnsupportedEncodingException {
        // First case is when codeValuesRoot doesn't exist
        if (codeValuesRoot == null)
        {
            codeValuesRoot = node;
            return;
        }

        CodeNode nextNode = codeValuesRoot;
        boolean foundPosition = false;
        while (!foundPosition)
        {
            boolean isThisLarger = nextNode.compare(node) == node; // if the inputted node is larger than the next node
            CodeNode targetNode = isThisLarger ? nextNode.getRight() : nextNode.getLeft();
            if (targetNode == null)
            {
                // Insert at that position
                foundPosition = true;
                if (isThisLarger)
                {
                    nextNode.setRight(node);
                }else{
                    nextNode.setLeft(node);
                }
            }else{
                // Go to that node
                nextNode = targetNode;
            }
        }
    }
}

//reference: http://blog.csdn.net/linhuanmars/article/details/23972563

public class Solution {
    public String simplifyPath(String path) {
        if(path==null ||path.length()==0) return "";
        Stack<String> stack = new Stack<String>();
        String[] list = path.split("/");
        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            if(s.equals(".") ||s.equals("")) {
                continue;
            } else if(s.equals("..")) {
            	if(!stack.isEmpty()) {
                    stack.pop();
            	}
            } else {
                stack.push(new StringBuilder(s).reverse().toString());
            }
        }
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append("/");
        }
        return sb.reverse().toString();
    }
}

public class Solution {
    public String simplifyPath(String path) {
        if(path==null || path.length()==0) return "";
        
        Stack<String> store = new Stack<String>();
        StringBuilder res = new StringBuilder();
        int startIndex;
        for(int i=0; i<path.length(); i++) 
        {
            startIndex = i;
            while(i<path.length() && path.charAt(i)!='/') 
            {
                i++;
            }
            if(startIndex!=i) {
                String temp = path.substring(startIndex, i);
                if(temp.equals("..")) 
                {
                    if(!store.isEmpty())
                    {
                        store.pop();
                    }
                }
                else if(!temp.equals("."))
                {
                    store.push(temp);
                }
            } 
        }
        if(store.isEmpty()) return "/";
        String[] stackList = store.toArray(new String[store.size()]);
        for(int i=0; i<stackList.length; i++ )
        {
            res.append("/" + stackList[i]);
        }
        return res.toString();
    }
}

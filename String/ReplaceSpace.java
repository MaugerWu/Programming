package com.cqupt.interview.offer;

/**
 * 替换空格，将空格替换为 %20
 * @author Mauger
 * @date 2019年7月11日 下午7:58:12
 * @version V1.0
 */
public class ReplaceSpace
{
	public static void main(String[] args)
	{
		String string = "Running Man, We are  family !";
		String string1 = "  Running Man, We are  family!";
		String string2 = "       ";
		String string3 = "";
		String string4 = null;
		
		System.out.println(ReplaceSpace.repalceSpace(string));
		System.out.println(ReplaceSpace.reSpace(string));
		System.out.println(ReplaceSpace.reSpace(string1));
		System.out.println(ReplaceSpace.reSpace(string2));
		System.out.println(ReplaceSpace.reSpace(string3));
		System.out.println(ReplaceSpace.reSpace(string4));
	}
	
	static String repalceSpace(String string)
	{
		if (string == null)
		{
			return null;
		}
		
//		String temp = string.replace(" ", "%20");
		String temp = string.replaceAll(" ", "%20");
		return temp.toString();
	}
	
	static String reSpace(String string)
	{
		if (string == null)
		{
			return null;
		}
		
		int fromIndex = 0;
		int index = 0;
		StringBuffer sb = new StringBuffer();
		while (index <= string.length())
		{
			index = string.indexOf(" ", fromIndex);
			if (index >= 0)
			{
				sb.append(string.subSequence(fromIndex, index)).append("%20");
				index++;
				fromIndex = index;
			} else 
			{
				sb.append(string.substring(fromIndex, string.length()));
				break;
			}
		}
		return sb.toString();
	}
	
}

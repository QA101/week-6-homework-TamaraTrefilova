package src;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class SelfCoding {

	// Given a list of numbers, find the longest subsequence of consecutive positive integers.  
	public static int[] positiveInt(int [] arr) {
		int start = 0;
		int i = 0;
		int maxLength = 0;
		int maxSectionStart = 0;
		while(i<arr.length) {
			if(arr[i]<0) {
				start = i+1;
			} else {
				int currentLenght = i - start + 1;
				if(maxLength < currentLenght) {
					maxLength = currentLenght;
					maxSectionStart = start;
				}
			}
			i++;
		}
		return Arrays.copyOfRange(arr, maxSectionStart, maxSectionStart+maxLength);
	}
	
//	 Write a function to check if the given STRING is a palindrome or not.
	public static boolean checkIfPalindrom(String str) {
		int end = str.length()-1;
		int start = 0;
		while(end>start) {
			if(str.charAt(start)!=str.charAt(end)) 
				return false;
			start ++;
			end --;
		}	
		return true;
	}
	
//	Write a function that checks whether an INTEGER ARRAY is a palindrome or not
	
	public static boolean checkIfPalindrom(int[] arr) {
		int end = arr.length-1;
		int start = 0;
		while(end>start) {
			if(arr[start]!=arr[end]) 
				return false;
			start ++;
			end --;
		}	
		return true;
	}
	
//	Find duplicate characters in a String and count the number of occurrences of the duplicate characters
	public static void numberOfOccurrences(String str) {
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i = 0; i<str.length();i++ ) {
			char ch = str.charAt(i);
			Integer num = map.get(ch);
			if(num == null) {
				num=0;
			}
			map.put(ch, num+1);
		}
		for(Character ch : map.keySet()) {
			Integer i = map.get(ch);
			if(i>1) {
				System.out.println(ch+" occures "+ i+" times");
			}
		}
	}
	
	
//	Remove duplicate characters in a string: Given a string "banana", return unique string "ban"
	
	public static String removeDuplicateCharacters(String strA) {
		String str = "";
		Set<Character> set = new HashSet<>();
		for(int i = 0; i<strA.length();i++) {
			char ch = strA.charAt(i);
			if(set.add(ch))
				str+= ch;
		}
		return str;
	}
	
//	Given two strings "parachute" and "raphtueac", determine if 2 strings are anagrams of each other (both the strings have same set of characters)
	public static boolean ifAnagrams(String strA,String strB) {
		if(strA.length()!=strB.length()) {
			return false;
		}
		Map<Character,Integer> mapA = createMapFromString(strA);
		Map<Character,Integer> mapB = createMapFromString(strB);		
		Set<Character> set = mapA.keySet();
		for(Character ch : set) {
			if(mapA.get(ch)!=mapB.get(ch)) {
				return false;
			}
		}
		return true;
	}

private static Map<Character,Integer> createMapFromString(String str) {
	Map<Character,Integer> map = new HashMap<>();
	for(int i = 0; i<str.length();i++ ) {
		char ch = str.charAt(i);
		Integer num = map.get(ch);
		if(num == null) {
			num=0;
		}
		map.put(ch, num+1);
	}
	return map;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int [] {1,5,1,-1,1};
		System.out.print("[");
		for(int i :positiveInt(arr)) {
			
			System.out.print(i+" ");
		}
		System.out.println("]");
		arr = new int [] {1,5,1,-1,1,1,1,1};
		System.out.print("[");
		for(int i :positiveInt(arr)) {
			
			System.out.print(i+" ");
		}
		System.out.println("]");
//
//		System.out.println(checkIfPalindrom("civic"));
//		System.out.println(checkIfPalindrom(new int [] {1,5,1,5,1}));
//		System.out.println(checkIfPalindrom("civoic"));
//		System.out.println(checkIfPalindrom(new int [] {1,5,1,-5,1}));
//		numberOfOccurrences("qqqqwwwwreeddddfv");
		System.out.println(removeDuplicateCharacters("banana"));
		System.out.println(removeDuplicateCharacters("bananars"));
		
		System.out.println(ifAnagrams("abc" , "abcd"));
		
		
	}

}

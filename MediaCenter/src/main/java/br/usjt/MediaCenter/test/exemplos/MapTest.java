package br.usjt.MediaCenter.test.exemplos;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class MapTest {
	
	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("Instrumento", "Bateria");
		map.put("Computador", "Desktop");
		map.put("Carro", "BMW");

		System.out.println("----------key-----------");
		for(String key: map.keySet()) {
			System.out.println(key);
		}
		System.out.println("----------val-----------");
		for(String value: map.values()) {
			System.out.println(value);
		}
		System.out.println("----------all-----------");
		for(Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": "+ entry.getValue());
		}
		System.out.println("--------fim do linkedHash----------");
		Map<String, String> map1 = new HashMap<>();
		map1.put("Instrumento", "Bateria");
		map1.put("Carro", "BMW");
		map1.put("Computador", "Desktop");

		System.out.println("----------key-----------");
		for(String key: map1.keySet()) {
			System.out.println(key);
		}
		System.out.println("----------val-----------");
		for(String value: map1.values()) {
			System.out.println(value);
		}
		System.out.println("----------all-----------");
		for(Map.Entry<String, String> entry : map1.entrySet()) {
			System.out.println(entry.getKey() + ": "+ entry.getValue());
		}
		System.out.println("--------fim do hash----------");
	}
}

package com.zhang.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringJsonUtils {
	/**
	 * jsonstring 转换成map
	 * @param jsonString
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> jsonStringToMap(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = mapper.readValue(jsonString,
					new TypeReference<HashMap<String, Object>>() {
					});
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				String values = map.get(key).toString();
				values = values.trim();
				map.put(key, values);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}

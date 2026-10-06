package com.plug.ecommerce.genericutility;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {



private ObjectMapper objectMapper =
		new ObjectMapper();



public JsonNode readJsonFile(
		String jsonFilePath) throws IOException {

	return objectMapper.readTree(
			new File(jsonFilePath));
}



public String getStringData(
		String jsonFilePath,
		String key) throws IOException {

	JsonNode rootNode =
			readJsonFile(jsonFilePath);

	return rootNode
			.get(key)
			.asText();
}


public int getIntData(
		String jsonFilePath,
		String key) throws IOException {

	JsonNode rootNode =
			readJsonFile(jsonFilePath);

	return rootNode
			.get(key)
			.asInt();
}



public boolean getBooleanData(
		String jsonFilePath,
		String key) throws IOException {

	JsonNode rootNode =
			readJsonFile(jsonFilePath);

	return rootNode
			.get(key)
			.asBoolean();
}


public String getNestedStringData(
		String jsonFilePath,
		String parentKey,
		String childKey) throws IOException {

	JsonNode rootNode =
			readJsonFile(jsonFilePath);

	return rootNode
			.get(parentKey)
			.get(childKey)
			.asText();
}



public Map<String, Object> getJsonAsMap(
		String jsonFilePath) throws IOException {

	return objectMapper.readValue(
			new File(jsonFilePath),
			new TypeReference<Map<String, Object>>() {
			});
}



public List<Map<String, Object>> getJsonArray(
		String jsonFilePath,
		String arrayKey) throws IOException {

	JsonNode rootNode =
			readJsonFile(jsonFilePath);

	return objectMapper.convertValue(
			rootNode.get(arrayKey),
			new TypeReference<List<Map<String, Object>>>() {
			});
}



public boolean isKeyPresent(
		String jsonFilePath,
		String key) throws IOException {

	JsonNode rootNode =
			readJsonFile(jsonFilePath);

	return rootNode.has(key);
}


}
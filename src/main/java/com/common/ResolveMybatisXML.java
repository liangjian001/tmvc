package com.common;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.io.Resources;

import com.entities.share.ResultInfo;

public class ResolveMybatisXML {
	public ResolveMybatisXML() {

	}

	public static ResultInfo getMyBatisXMLInfo(String XMLName) {
		ResultInfo resultInfo = new ResultInfo();
		XMLConfiguration config = null;
		try {
			Reader inputStream = Resources.getResourceAsReader(XMLName);
			config = new XMLConfiguration();
			config.setEncoding("UTF-8");
			config.setDelimiterParsingDisabled(true);
			config.load(inputStream);
//			String root = config.getString("environments[@default]");
			String root = config.getString("environments");
			String rootPosition = null;
			if (StringUtils.endsWithIgnoreCase(root, "druid_dev")) {
				rootPosition = "0";
			} else if (StringUtils.endsWithIgnoreCase(root, "druid_test")) {
				rootPosition = "1";
			} else if (StringUtils.endsWithIgnoreCase(root, "druid_pro")) {
				rootPosition = "2";
			} else if (StringUtils.endsWithIgnoreCase(root, "druid_uat")) {
				rootPosition = "3";
			}else if (StringUtils.endsWithIgnoreCase(root, "dsistest")){
				rootPosition = "4";
			}
			resultInfo.setResultObject(makeResource(rootPosition, config));
		} catch (Exception e) {
			e.printStackTrace();
			resultInfo.setResultFlag(false);
			resultInfo.setResultText("加载spring-mybatis.xml文件失败！");
		}
		return resultInfo;
	}

	private static Map<String, String> makeResource(String rootPosition,
			XMLConfiguration config) {
		if (StringUtils.isBlank(rootPosition) || null == config) {
			return null;
		}
		Map<String, String> result = new HashMap<String, String>();
		String transactionManager = config
				.getString("environments.environment(" + rootPosition
						+ ").transactionManager[@type]");
		String dataSource = config.getString("environments.environment("
				+ rootPosition + ").dataSource[@type]");
		List<Object> propertyNames = config.getList("environments.environment("
				+ rootPosition + ").dataSource.property[@name]");
		List<Object> propertyvalues = config
				.getList("environments.environment(" + rootPosition
						+ ").dataSource.property[@value]");
		if (null != propertyNames && propertyNames.size() > 0) {
			for (int i = 0; i < propertyNames.size(); i++) {
				result.put((String) propertyNames.get(i),
						(String) propertyvalues.get(i));
			}
		}
		result.put("transactionManager", transactionManager);
		result.put("dataSource", dataSource);
		return result;
	}

	public static void main(String[] args) {
		ResolveMybatisXML.getMyBatisXMLInfo("spring-mybatis.xml");
	}
}

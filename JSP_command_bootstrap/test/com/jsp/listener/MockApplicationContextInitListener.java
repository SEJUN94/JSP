package com.jsp.listener;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.jsp.context.ApplicationContext;

public class MockApplicationContextInitListener {
	public void contextInitialized(String beanConfigXml) {

		if (beanConfigXml == null) 
			return;

			beanConfigXml = beanConfigXml.replace("classpath:", "res/")
					.replace("/", File.separator);

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(beanConfigXml);

			// 못읽었으면 root가 0으로 나옴
			Element root = document.getDocumentElement();
			// System.out.println(root.getTagName());

			if (root == null || !root.getTagName().equals("beans"))
				return;

			// bean들을 꺼내기
			NodeList beans = root.getElementsByTagName("bean");

			Map<String, Object> applicationContext = ApplicationContext.getApplicationContext();

			for (int i = 0; i < beans.getLength(); i++) {
				Node bean = beans.item(i);
				if (bean.getNodeType() == Node.ELEMENT_NODE) {
					Element ele = (Element) bean;
					String id = ele.getAttribute("id");
					String classType = ele.getAttribute("class");
					// System.out.printf("id : %s,class=%s\n",id,classType);

					// map instnace put
					Class<?> cls = Class.forName(classType);
					Object targetObj = cls.newInstance(); // single tone
					applicationContext.put(id, targetObj);

					// System.out.println("id : " + id + ", class : " + targetObj);
				}
			}

			// 의존주입 - bean 안에 property가 있는지 체크
			for (int i = 0; i < beans.getLength(); i++) {
				Node bean = beans.item(i);
				if (bean.getNodeType() == Node.ELEMENT_NODE) {
					Element eleBean = (Element) bean;

					NodeList properties = bean.getChildNodes();
					for (int j = 0; j < properties.getLength(); j++) {
						Node property = properties.item(j);
						if (!property.getNodeName().equals("property")) continue;
						
						if(property.getNodeType() == Node.ELEMENT_NODE) {
							Element ele = (Element)property;
							String name = ele.getAttribute("name");
							String ref = ele.getAttribute("ref-value");
							
							// System.out.printf("name = %s,ref-value=%s\n",name,ref);
							
							
							// 리플렉션 만들기
							// 리플렉션은 인스턴스를 만들 필요가 없음
							// 어떤 클래스에 있건 그 클래스 안에 있는 타입과 메소드 다 가져올 수 있음
							String setMethodName = "set"+name.substring(0,1).toUpperCase()+name.substring(1);
							String className = eleBean.getAttribute("class");
							Class<?> classType = Class.forName(className);
							
							// 메소드들이 객체화되어서 배열로 들어옴
							// 레퍼런스를 배열에 넣음. 배열에 들어간 레퍼런스를 가지고 메서드를 불러옴
							// property에 등록된 name과 동일한 set메서드를 찾음
							Method[] methods = classType.getMethods();
							if (methods!=null) for (Method method : methods) {
								// 의존성 여부 확인
								if(method.getName().equals(setMethodName)) {
									method.invoke(applicationContext.get(eleBean.getAttribute("id")), 
											applicationContext.get(ref));
									System.out.println("[invoke]"+applicationContext
											.get(eleBean.getAttribute("id"))+":"+applicationContext.get(ref));
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

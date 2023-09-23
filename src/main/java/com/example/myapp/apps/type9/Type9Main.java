package com.example.myapp.apps.type9;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.myapp.biz.type9.domain.User;
import com.example.myapp.biz.type9.repository.UserDao;

public class Type9Main {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/applicationContext.xml")) {
			// jdbcTemplateのBeanを取得
			UserDao userDao = context.getBean(UserDao.class);
			
			// 全検索
			System.out.println("=========全検索=========");
			userDao.findAll().forEach(u -> System.out.println(u));
			
			// 更新
			System.out.println("\n=========更新=========");
			User user = userDao.findById(2);
			user.setName("山田太郎");
			int result = userDao.update(user);
			if (0 < result) {
				System.out.println("更新成功");
			} else {
				System.out.println("更新失敗");
			}
			
			// 削除
			System.out.println("\n=========削除=========");
			result = userDao.delete(1);
			if (0 < result) {
				System.out.println("削除成功");
			} else {
				System.out.println("削除失敗");
			}
		}
	}
}

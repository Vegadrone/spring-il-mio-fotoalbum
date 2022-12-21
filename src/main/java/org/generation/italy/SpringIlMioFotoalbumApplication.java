package org.generation.italy;

import org.generation.italy.pojo.Category;
import org.generation.italy.pojo.Photo;
import org.generation.italy.pojo.Role;
import org.generation.italy.pojo.User;
import org.generation.italy.service.CategoryService;
import org.generation.italy.service.PhotoService;
import org.generation.italy.service.RoleService;
import org.generation.italy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {
	
	@Autowired
	private PhotoService pS;
	
	@Autowired
	private CategoryService cS;
	
	@Autowired
	private UserService uS;
	
	@Autowired
	private RoleService rS;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Photo p1 = new Photo ("Title1", "Description1","https://images.unsplash.com/photo-1517960413843-0aee8e2b3285?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHx8&w=1000&q=80", "#LOL", true);
		Photo p2 = new Photo ("Title2", "Description2","https://thumbs.dreamstime.com/b/beautiful-rain-forest-ang-ka-nature-trail-doi-inthanon-national-park-thailand-36703721.jpg", "#LOLLISSIMO", true);
		Photo p3 = new Photo ("Title3", "Description3","https://img.freepik.com/free-photo/portrait-amazed-pinup-woman-with-camera-charming-photographer-with-red-lips-taking-pictures_197531-15200.jpg?w=2000", "#LOLLONE", false);
		Photo p4 = new Photo ("Title4", "Description4","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAfHiaJaqzXDhv-mVG8J1M_UK-6PS8sdtZ4g&usqp=CAU", "#LOLLE", true);
		
		pS.save(p1);
		pS.save(p2);
		pS.save(p3);
		pS.save(p4);
		
		Category c1 = new Category ("Bella");
		Category c2 = new Category ("Bellissima");
		Category c3 = new Category ("Bellona");
		Category c4 = new Category ("Bellella");
		
		cS.save(c1);
		cS.save(c2);
		cS.save(c3);
		cS.save(c4);
		
		Role admin = new Role("ADMIN");
		rS.save(admin);
		
		User u1 = new User ("admin", "{noop}adminpsw", admin);
		uS.save(u1);
	}
}

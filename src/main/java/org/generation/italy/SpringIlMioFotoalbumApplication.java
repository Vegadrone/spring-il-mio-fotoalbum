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
		
		Category c1 = new Category ("Environment");
		Category c2 = new Category ("Nature");
		Category c3 = new Category ("Funny");
		Category c4 = new Category ("BestOf2022");
		Category c5 = new Category ("Photography");
		Category c6 = new Category ("Nature");
		
		cS.save(c1);
		cS.save(c2);
		cS.save(c3);
		cS.save(c4);
		cS.save(c5);
		cS.save(c6);
		
		Photo p1 = new Photo ("Man and Sunset", "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Repellat error accusamus at voluptas quo placeat iure hic ut nam eaque a ea dolor magnam et blanditiis ullam quia, quam similique.","https://images.unsplash.com/photo-1517960413843-0aee8e2b3285?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHx8&w=1000&q=80", "#Nature #Sport #Tricks", true );
		Photo p2 = new Photo ("Nature Revenge", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Hic consequuntur possimus illo ut. Voluptatem, quo ratione, quae totam quas sint assumenda facere eos deleniti, iusto vel. Pariatur impedit illo vel.","https://thumbs.dreamstime.com/b/beautiful-rain-forest-ang-ka-nature-trail-doi-inthanon-national-park-thailand-36703721.jpg", "#Wood #Leaf #Bridge", true);
		Photo p3 = new Photo ("Funny Pic", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Possimus iste non eos deserunt? Similique debitis totam expedita consequuntur. Facere ex hic iusto a voluptate enim vero eius? Hic, quos excepturi.","https://img.freepik.com/free-photo/portrait-amazed-pinup-woman-with-camera-charming-photographer-with-red-lips-taking-pictures_197531-15200.jpg?w=2000", "#LOL", false);
		Photo p4 = new Photo ("Sea side", "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eaque commodi illo dicta molestias placeat repudiandae odio iusto. Voluptatum excepturi reprehenderit maiores. Quas nemo voluptatum delectus id cum? Temporibus, enim vel!","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAfHiaJaqzXDhv-mVG8J1M_UK-6PS8sdtZ4g&usqp=CAU", "#Photography", true);
		Photo p5 = new Photo ("Sea side", "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eaque commodi illo dicta molestias placeat repudiandae odio iusto. Voluptatum excepturi reprehenderit maiores. Quas nemo voluptatum delectus id cum? Temporibus, enim vel!","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAfHiaJaqzXDhv-mVG8J1M_UK-6PS8sdtZ4g&usqp=CAU", "#Photography", true);
		Photo p6 = new Photo ("Sea side", "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eaque commodi illo dicta molestias placeat repudiandae odio iusto. Voluptatum excepturi reprehenderit maiores. Quas nemo voluptatum delectus id cum? Temporibus, enim vel!","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAfHiaJaqzXDhv-mVG8J1M_UK-6PS8sdtZ4g&usqp=CAU", "#Photography", true);
		Photo p7 = new Photo ("Sea side", "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eaque commodi illo dicta molestias placeat repudiandae odio iusto. Voluptatum excepturi reprehenderit maiores. Quas nemo voluptatum delectus id cum? Temporibus, enim vel!","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAfHiaJaqzXDhv-mVG8J1M_UK-6PS8sdtZ4g&usqp=CAU", "#Photography", true);
		
		
		pS.save(p1);
		pS.save(p2);
		pS.save(p3);
		pS.save(p4);
		pS.save(p5);
		pS.save(p6);
		pS.save(p7);
		
		
		
		Role admin = new Role("ADMIN");
		rS.save(admin);
		
		User u1 = new User ("admin", "{noop}adminpsw", admin);
		uS.save(u1);
	}
}

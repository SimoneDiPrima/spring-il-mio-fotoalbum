package org.foto.italy.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.foto.italy.demo.pojo.Category;
import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.pojo.Role;
import org.foto.italy.demo.pojo.User;
import org.foto.italy.demo.service.CategoryService;
import org.foto.italy.demo.service.FotoService;
import org.foto.italy.demo.service.RoleService;
import org.foto.italy.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbum2Application implements CommandLineRunner{
	
	@Autowired
	private UserService userServ;
	@Autowired
	private RoleService roleServ;
	
	@Autowired
	private FotoService fotoServ;
	
	@Autowired CategoryService categoryServ;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbum2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		Role adminRole = new Role("Admin");
		
		
		
		roleServ.save(adminRole);
		
		
	
		User adminUser = new User("admin","{noop}adminpassw",adminRole);
		
		
		userServ.save(adminUser);
		
		
		
		
		
		Foto f1 = new Foto("Foto di un Matrimonio","tu che sei mia anche quando vado via tu sei l unica donna per me","https://picsum.photos/200/300");
		Foto f2 = new Foto("Strage di Sarajevo","le tigri di arkan mettono a ferro e fuoco tutta la citta","https://picsum.photos/200/300");
		Foto f3 = new Foto("La nascita di una gazzella","si lo sappiamo tutti che ogni mattina una gazzella..","https://picsum.photos/200/300");
		Foto f4 = new Foto("Notte prima degli esami","Bomba o non bomba arriveremo a Roma malgrado voi","https://picsum.photos/200/300");
		fotoServ.save(f1);
		fotoServ.save(f2);
		fotoServ.save(f3);
		fotoServ.save(f4);
		
		Category c1 = new Category("Astratta");
		Category c2 = new Category("Boudoir");
		Category c3 = new Category("Arte");
		Category c4 = new Category("Guerra");
		Category c5 = new Category("Matrimonio");
		Category c6 = new Category("Moda");
		Category c7 = new Category("Nudo");
		Category c8 = new Category("Viaggio");
		Category c9 = new Category("Ritratti");
		Category c10 = new Category("Paesaggistica ");
	
		categoryServ.save(c1);
		categoryServ.save(c2);
		categoryServ.save(c3);
		categoryServ.save(c4);
		categoryServ.save(c5);
		categoryServ.save(c6);
		categoryServ.save(c7);
		categoryServ.save(c8);
		categoryServ.save(c9);
		categoryServ.save(c10);
		
		Foto fc1 = new Foto("Generale","Dietro la collina ci sta la notte buia ed assassina","https://picsum.photos/200/300",c1);
		Foto fc2 = new Foto("Ma dove vai","e intanto tu continui ad invecchiare si","https://picsum.photos/200/300",c2);
		Foto fc3 = new Foto("Gente di mare","Noi condottieri di questa citta per sempre fieri dei nostri colori","https://picsum.photos/200/300",c1);
		Foto fc4 = new Foto("Celebrities","la regina delle celebrita bella magnifica senza un eta","https://picsum.photos/200/300",c3);
		
		fotoServ.save(fc1);
		fotoServ.save(fc2);
		fotoServ.save(fc3);
		fotoServ.save(fc4);
		
		List<Category> catFoto = Arrays.asList();
		Foto catFoto1 = new Foto("una rotonda sul mare","voce mi apareceu","https://picsum.photos/200/300",c1);
		Foto catFoto2 = new Foto("Fred Bongusto","dragostea din tei","https://picsum.photos/200/300",c1,c2,c3,c4);
		Foto catFoto3 = new Foto("Niko Pandetta","dragostea din tei","https://picsum.photos/200/300",c1,c2,c3,c4,c6,c7,c8,c9,c10);
		
		fotoServ.save(catFoto1);
		fotoServ.save(catFoto2);
		fotoServ.save(catFoto3);
		
		
		
		
	}

}

package org.foto.italy.demo;

import org.foto.italy.demo.pojo.Category;
import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.service.CategoryService;
import org.foto.italy.demo.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbum2Application implements CommandLineRunner{

	
	@Autowired
	private FotoService fotoServ;
	
	@Autowired CategoryService categoryServ;
	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbum2Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Foto f1 = new Foto("la foto piu bella","la donna piu bella","https://picsum.photos/200/300");
		Foto f2 = new Foto("la foto piu brutta","la donna piu brutta","https://picsum.photos/200/300");
		Foto f3 = new Foto("la foto piu emozionante","la donna piu scarsa","https://picsum.photos/200/300");
		Foto f4 = new Foto("la foto piu grande","la donna piu magra","https://picsum.photos/200/300");
		fotoServ.save(f1);
		fotoServ.save(f2);
		fotoServ.save(f3);
		fotoServ.save(f4);
		
		Category c1 = new Category("paesaggi");
		Category c2 = new Category("selfie");
		Category c3 = new Category("mare");
		Category c4 = new Category("Ferragnez");
		Category c5 = new Category("photoshop");
		Category c6 = new Category("filtrata");
		Category c7 = new Category("moretti");
		Category c8 = new Category("chiaroscuro");
		Category c9 = new Category("sfuocata");
		Category c10 = new Category("panoramica");
		
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
	}

}

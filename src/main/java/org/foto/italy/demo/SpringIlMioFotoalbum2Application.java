package org.foto.italy.demo;

import org.foto.italy.demo.pojo.Foto;
import org.foto.italy.demo.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbum2Application implements CommandLineRunner{

	
	@Autowired
	private FotoService fotoServ;
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
	}

}

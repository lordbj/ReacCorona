package sn.covid19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.covid19.dao.ICas;
import sn.covid19.entities.Cas;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Covid19Application implements CommandLineRunner {

    @Autowired
    private ICas casdao;
	public static void main(String[] args){
		SpringApplication.run(Covid19Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cas cas = new Cas();
		cas.setVille("snt");
		cas.setQuartier("diaraf");
		Date date =null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date =sdf.parse("2020-04-28");
		cas.setDate(date);

		casdao.save(cas);
		casdao.findAll().forEach(c->System.out.println(c.getVille()));
	}
}

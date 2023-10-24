package com.scrapping.scrapping;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class ScrappingServeImpl implements ScrappingService {

    @Override
    public List<Helbidea> scrap(Helbidea helbidea) {
        Document doc = Jsoup.connect(url).get();
		
		doc.select("a")
			.forEach(a -> System.out.println(a.html() + ";" + a.attr("href")));
        return null;
    }

    @Override
    public void save(List<Helbidea> helbideak) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Helbidea> scrapAndSave(Helbidea helbidea) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'scrapAndSave'");
    }
}
